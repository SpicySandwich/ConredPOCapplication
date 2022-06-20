package com.cartgatewayservice.Interceptor;

import org.springframework.stereotype.Component;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GrpcClientInterceptor implements ClientInterceptor{

	
	 @Override
	    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
	            final MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
		 
	        return new ForwardingClientCall<ReqT, RespT>(method,
	                next.newCall(method, callOptions)) {

	            @Override
	            public void sendMessage(ReqT message) {
	                log.info("Method: {}, Message: {}", methodName, message);
	                super.sendMessage(message);
	            }

	            @Override
	            public void start(Listener<RespT> responseListener, Metadata headers) {
	
	                BackendListener<RespT> backendListener = new BackendListener<>(methodName, responseListener);
	                super.start(backendListener, headers);
	            }
	        };
	    }

	    private class BackendListener<RespT> extends ClientCall.Listener<RespT> {

	        String methodName;
	        ClientCall.Listener<RespT> responseListener;

	        protected BackendListener(String methodName, ClientCall.Listener<RespT> responseListener) {
	            super();
	            this.methodName = methodName;
	            this.responseListener = responseListener;
	        }

	        @Override
	        public void onMessage(RespT message) {
	            log.info("Method: {}, Response: {}", methodName, message);
	            responseListener.onMessage(message);
	        }

	        @Override
	        public void onHeaders(Metadata headers) {
	            responseListener.onHeaders(headers);
	        }

	        @Override
	        public void onClose(Status status, Metadata trailers) {
	            responseListener.onClose(status, trailers);
	        }

	        @Override
	        public void onReady() {
	            responseListener.onReady();
	        }
	    }

	    private class ForwardingClientCall<ReqT, RespT> extends io.grpc.ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {

	        String methodName;

	        protected ForwardingClientCall(MethodDescriptor<ReqT, RespT> method, ClientCall delegate) {
	            super(delegate);
	            methodName = method.getFullMethodName();
	        }
	    }

}
