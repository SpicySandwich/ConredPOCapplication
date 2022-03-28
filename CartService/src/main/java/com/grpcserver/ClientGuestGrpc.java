package com.grpcserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: GuestClientServer.proto")
public final class ClientGuestGrpc {

  private ClientGuestGrpc() {}

  public static final String SERVICE_NAME = "ClientGuest";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest,
      com.grpcserver.GuestClientServer.APIResponse> getClientGuestDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientGuestData",
      requestType = com.grpcserver.GuestClientServer.ClientGuestRequest.class,
      responseType = com.grpcserver.GuestClientServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest,
      com.grpcserver.GuestClientServer.APIResponse> getClientGuestDataMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse> getClientGuestDataMethod;
    if ((getClientGuestDataMethod = ClientGuestGrpc.getClientGuestDataMethod) == null) {
      synchronized (ClientGuestGrpc.class) {
        if ((getClientGuestDataMethod = ClientGuestGrpc.getClientGuestDataMethod) == null) {
          ClientGuestGrpc.getClientGuestDataMethod = getClientGuestDataMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuest", "ClientGuestData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestMethodDescriptorSupplier("ClientGuestData"))
                  .build();
          }
        }
     }
     return getClientGuestDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientGuestStub newStub(io.grpc.Channel channel) {
    return new ClientGuestStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientGuestBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientGuestBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientGuestFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientGuestFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientGuestImplBase implements io.grpc.BindableService {

    /**
     */
    public void clientGuestData(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getClientGuestDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getClientGuestDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuestRequest,
                com.grpcserver.GuestClientServer.APIResponse>(
                  this, METHODID_CLIENT_GUEST_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class ClientGuestStub extends io.grpc.stub.AbstractStub<ClientGuestStub> {
    private ClientGuestStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientGuestStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGuestStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientGuestStub(channel, callOptions);
    }

    /**
     */
    public void clientGuestData(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getClientGuestDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientGuestBlockingStub extends io.grpc.stub.AbstractStub<ClientGuestBlockingStub> {
    private ClientGuestBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientGuestBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGuestBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientGuestBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.APIResponse clientGuestData(com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return blockingUnaryCall(
          getChannel(), getClientGuestDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientGuestFutureStub extends io.grpc.stub.AbstractStub<ClientGuestFutureStub> {
    private ClientGuestFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientGuestFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGuestFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientGuestFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.APIResponse> clientGuestData(
        com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getClientGuestDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CLIENT_GUEST_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientGuestImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientGuestImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLIENT_GUEST_DATA:
          serviceImpl.clientGuestData((com.grpcserver.GuestClientServer.ClientGuestRequest) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ClientGuestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientGuestBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpcserver.GuestClientServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientGuest");
    }
  }

  private static final class ClientGuestFileDescriptorSupplier
      extends ClientGuestBaseDescriptorSupplier {
    ClientGuestFileDescriptorSupplier() {}
  }

  private static final class ClientGuestMethodDescriptorSupplier
      extends ClientGuestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientGuestMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ClientGuestGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientGuestFileDescriptorSupplier())
              .addMethod(getClientGuestDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
