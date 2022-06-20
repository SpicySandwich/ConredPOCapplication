package com.cartservice.Interceptor;


import com.cartservice.ModelExceptionGRPC.DATE_EXCEPTION_GRPC;
import com.cartservice.ModelExceptionGRPC.ID_NOT_FOUND_GRPC;
import com.cartservice.ModelExceptionGRPC.INTERNAL_ERROR_GRPC;
import com.cartservice.ModelExceptionGRPC.NOT_NULL_GRPC;

import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;

public class GrpcExceptionInterceptor implements ServerInterceptor{
	
	  

	 @Override
	   public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
	         Metadata requestHeaders, ServerCallHandler<ReqT, RespT> next) {
	      ServerCall.Listener<ReqT> delegate = next.startCall(call, requestHeaders);
	      return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(delegate) {
	    	  
	         @Override
	         public void onHalfClose() {
	            try {
	               super.onHalfClose();
	            } catch (NOT_NULL_GRPC e) {
	               call.close(Status.INVALID_ARGUMENT
	                .withCause (e)
	                .withDescription(e.getMessage()), new Metadata());
	            }catch (ID_NOT_FOUND_GRPC e) {
		               call.close(Status.NOT_FOUND
		   	                .withCause (e)
		   	                .withDescription(e.getMessage()), new Metadata());
		   	            }catch (DATE_EXCEPTION_GRPC e) {
		 	               call.close(Status.INVALID_ARGUMENT
		 	  	                .withCause (e)
		 	  	                .withDescription(e.getMessage()), new Metadata());
		 	  	            }catch (INTERNAL_ERROR_GRPC e) {
		 		               call.close(Status.INTERNAL
		 		  	                .withCause (e)
		 		  	                .withDescription(e.getMessage()), new Metadata());
		 		  	            }catch (Throwable e) {
				 		               call.close(Status.INTERNAL
					 		  	                .withCause (e)
					 		  	                .withDescription(e.getMessage()), new Metadata());
					 		  	            }
				         }
	         
	      };
	   }

}
