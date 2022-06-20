package com.cartservice.Interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.MethodDescriptor;

import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

import org.lognet.springboot.grpc.GRpcGlobalInterceptor;

@Slf4j
@GRpcGlobalInterceptor
public class GrpcServerInterceptor implements ServerInterceptor{
	
	
	    @Override
	    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
	            ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {


	        GrpcServerCall<ReqT, RespT> grpcServerCall = new GrpcServerCall<ReqT, RespT>(call);

	        Listener<ReqT> listener = next.startCall(grpcServerCall, headers);
	        

	        return new ForwardServerCallListener<ReqT>(call.getMethodDescriptor(), listener) {
	        	
	            @Override
	            public void onMessage(ReqT message) {
	            	log.info("\nMethod: {}, \nMessage Request:\n {}", methodName, message);
	                super.onMessage(message);
	            }
	        };
	    }

	    private class GrpcServerCall<ReqT, RespT> extends ServerCall<ReqT, RespT> {

	        ServerCall<ReqT, RespT> serverCall;

	        protected GrpcServerCall(ServerCall<ReqT,RespT> serverCall) {
	            this.serverCall = serverCall;
	        }

	        @Override
	        public void request(int numMessages) {
	        	log.info("numMessages: {}",numMessages);
	            serverCall.request(numMessages);
	        }

	        @Override
	        public void sendHeaders(Metadata headers) {
	            serverCall.sendHeaders(headers);
	        }

	        @Override
	        public void sendMessage(RespT message) {
	        	log.info(" Response: {}", message);
	            serverCall.sendMessage(message);
	        }

	        @Override
	        public void close(Status status, Metadata trailers) {
	        	log.info(" Response: {}", status.asRuntimeException().toString());
	            serverCall.close(status, trailers);
	        }

	        @Override
	        public boolean isCancelled() {
	            return serverCall.isCancelled();
	        }

	        @Override
	        public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
	            return serverCall.getMethodDescriptor();
	        }
	        
	        
	    }

	    private class ForwardServerCallListener<ReqT> extends io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {

	        String methodName;

	        protected ForwardServerCallListener(MethodDescriptor<?, ?> method, ServerCall.Listener<ReqT> listener) {
	            super(listener);
	            methodName = method.getFullMethodName();
	        }
	    }
	    
	}
