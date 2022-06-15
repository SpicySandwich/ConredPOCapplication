//package com.cartservice.Interceptor;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import io.grpc.ForwardingServerCallListener;
//import io.grpc.Metadata;
//import io.grpc.ServerCall;
//import io.grpc.ServerCall.Listener;
//import io.grpc.ServerCallHandler;
//import io.grpc.ServerInterceptor;
//
//
//public class GrpcInterceptor implements ServerInterceptor {
//	
//	private final Logger log = LoggerFactory.getLogger(GrpcInterceptor.class);
//
//	@Override
//	public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
//			ServerCallHandler<ReqT, RespT> next) {
//		
//		log.info("HEaders: " +headers.toString(), next.toString(),call.getAuthority(),call.getAttributes()
//	
//				);
//		 ServerCall.Listener<ReqT> listener = next.startCall(call, headers);
//		
//		 return new ExceptionHandlingServerCallListener<>(listener, call, headers);
//	}
//	
//	  private class ExceptionHandlingServerCallListener<ReqT, RespT>
//      extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {
//  private ServerCall<ReqT, RespT> serverCall;
//  private Metadata metadata;
//
//  ExceptionHandlingServerCallListener(ServerCall.Listener<ReqT> listener, ServerCall<ReqT, RespT> serverCall,
//                                      Metadata metadata) {
//      super(listener);
//      this.serverCall = serverCall;
//      this.metadata = metadata;
//  }
//  
//  
//  
//  
//
//}
//	  
//}
//
//
