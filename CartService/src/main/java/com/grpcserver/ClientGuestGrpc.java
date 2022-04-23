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
      com.grpcserver.GuestClientServer.APIResponse> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insert",
      requestType = com.grpcserver.GuestClientServer.ClientGuestRequest.class,
      responseType = com.grpcserver.GuestClientServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest,
      com.grpcserver.GuestClientServer.APIResponse> getInsertMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse> getInsertMethod;
    if ((getInsertMethod = ClientGuestGrpc.getInsertMethod) == null) {
      synchronized (ClientGuestGrpc.class) {
        if ((getInsertMethod = ClientGuestGrpc.getInsertMethod) == null) {
          ClientGuestGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuest", "insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestMethodDescriptorSupplier("insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.Empty,
      com.grpcserver.GuestClientServer.ClientGuestRequest> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAll",
      requestType = com.grpcserver.GuestClientServer.Empty.class,
      responseType = com.grpcserver.GuestClientServer.ClientGuestRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.Empty,
      com.grpcserver.GuestClientServer.ClientGuestRequest> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.Empty, com.grpcserver.GuestClientServer.ClientGuestRequest> getFindAllMethod;
    if ((getFindAllMethod = ClientGuestGrpc.getFindAllMethod) == null) {
      synchronized (ClientGuestGrpc.class) {
        if ((getFindAllMethod = ClientGuestGrpc.getFindAllMethod) == null) {
          ClientGuestGrpc.getFindAllMethod = getFindAllMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.Empty, com.grpcserver.GuestClientServer.ClientGuestRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuest", "findAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuestRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestMethodDescriptorSupplier("findAll"))
                  .build();
          }
        }
     }
     return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest,
      com.grpcserver.GuestClientServer.APIResponse> getDeleteByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteById",
      requestType = com.grpcserver.GuestClientServer.ClientGuestRequest.class,
      responseType = com.grpcserver.GuestClientServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest,
      com.grpcserver.GuestClientServer.APIResponse> getDeleteByIdMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse> getDeleteByIdMethod;
    if ((getDeleteByIdMethod = ClientGuestGrpc.getDeleteByIdMethod) == null) {
      synchronized (ClientGuestGrpc.class) {
        if ((getDeleteByIdMethod = ClientGuestGrpc.getDeleteByIdMethod) == null) {
          ClientGuestGrpc.getDeleteByIdMethod = getDeleteByIdMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuest", "deleteById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestMethodDescriptorSupplier("deleteById"))
                  .build();
          }
        }
     }
     return getDeleteByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.grpcserver.GuestClientServer.ClientGuestRequest> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findById",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = com.grpcserver.GuestClientServer.ClientGuestRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.grpcserver.GuestClientServer.ClientGuestRequest> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.grpcserver.GuestClientServer.ClientGuestRequest> getFindByIdMethod;
    if ((getFindByIdMethod = ClientGuestGrpc.getFindByIdMethod) == null) {
      synchronized (ClientGuestGrpc.class) {
        if ((getFindByIdMethod = ClientGuestGrpc.getFindByIdMethod) == null) {
          ClientGuestGrpc.getFindByIdMethod = getFindByIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, com.grpcserver.GuestClientServer.ClientGuestRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuest", "findById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuestRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestMethodDescriptorSupplier("findById"))
                  .build();
          }
        }
     }
     return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest,
      com.grpcserver.GuestClientServer.APIResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = com.grpcserver.GuestClientServer.ClientGuestRequest.class,
      responseType = com.grpcserver.GuestClientServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest,
      com.grpcserver.GuestClientServer.APIResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse> getUpdateMethod;
    if ((getUpdateMethod = ClientGuestGrpc.getUpdateMethod) == null) {
      synchronized (ClientGuestGrpc.class) {
        if ((getUpdateMethod = ClientGuestGrpc.getUpdateMethod) == null) {
          ClientGuestGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuestRequest, com.grpcserver.GuestClientServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuest", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
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
    public void insert(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void findAll(com.grpcserver.GuestClientServer.Empty request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void deleteById(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteByIdMethod(), responseObserver);
    }

    /**
     */
    public void findById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestRequest> responseObserver) {
      asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void update(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuestRequest,
                com.grpcserver.GuestClientServer.APIResponse>(
                  this, METHODID_INSERT)))
          .addMethod(
            getFindAllMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.Empty,
                com.grpcserver.GuestClientServer.ClientGuestRequest>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getDeleteByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuestRequest,
                com.grpcserver.GuestClientServer.APIResponse>(
                  this, METHODID_DELETE_BY_ID)))
          .addMethod(
            getFindByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                com.grpcserver.GuestClientServer.ClientGuestRequest>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuestRequest,
                com.grpcserver.GuestClientServer.APIResponse>(
                  this, METHODID_UPDATE)))
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
    public void insert(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(com.grpcserver.GuestClientServer.Empty request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestRequest> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteById(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestRequest> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.grpcserver.GuestClientServer.ClientGuestRequest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
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
    public com.grpcserver.GuestClientServer.APIResponse insert(com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.grpcserver.GuestClientServer.ClientGuestRequest> findAll(
        com.grpcserver.GuestClientServer.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.APIResponse deleteById(com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.ClientGuestRequest findById(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.APIResponse update(com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.APIResponse> insert(
        com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.APIResponse> deleteById(
        com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.ClientGuestRequest> findById(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.APIResponse> update(
        com.grpcserver.GuestClientServer.ClientGuestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT = 0;
  private static final int METHODID_FIND_ALL = 1;
  private static final int METHODID_DELETE_BY_ID = 2;
  private static final int METHODID_FIND_BY_ID = 3;
  private static final int METHODID_UPDATE = 4;

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
        case METHODID_INSERT:
          serviceImpl.insert((com.grpcserver.GuestClientServer.ClientGuestRequest) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.grpcserver.GuestClientServer.Empty) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestRequest>) responseObserver);
          break;
        case METHODID_DELETE_BY_ID:
          serviceImpl.deleteById((com.grpcserver.GuestClientServer.ClientGuestRequest) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestRequest>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.grpcserver.GuestClientServer.ClientGuestRequest) request,
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
              .addMethod(getInsertMethod())
              .addMethod(getFindAllMethod())
              .addMethod(getDeleteByIdMethod())
              .addMethod(getFindByIdMethod())
              .addMethod(getUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
