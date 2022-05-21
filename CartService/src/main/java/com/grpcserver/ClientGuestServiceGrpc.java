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
public final class ClientGuestServiceGrpc {

  private ClientGuestServiceGrpc() {}

  public static final String SERVICE_NAME = "ClientGuestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.APIResponse> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insert",
      requestType = com.grpcserver.GuestClientServer.ClientGuest.class,
      responseType = com.grpcserver.GuestClientServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.APIResponse> getInsertMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.APIResponse> getInsertMethod;
    if ((getInsertMethod = ClientGuestServiceGrpc.getInsertMethod) == null) {
      synchronized (ClientGuestServiceGrpc.class) {
        if ((getInsertMethod = ClientGuestServiceGrpc.getInsertMethod) == null) {
          ClientGuestServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuestService", "insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestServiceMethodDescriptorSupplier("insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.ClientGuestrList> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAll",
      requestType = com.grpcserver.GuestClientServer.ClientGuest.class,
      responseType = com.grpcserver.GuestClientServer.ClientGuestrList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.ClientGuestrList> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.ClientGuestrList> getFindAllMethod;
    if ((getFindAllMethod = ClientGuestServiceGrpc.getFindAllMethod) == null) {
      synchronized (ClientGuestServiceGrpc.class) {
        if ((getFindAllMethod = ClientGuestServiceGrpc.getFindAllMethod) == null) {
          ClientGuestServiceGrpc.getFindAllMethod = getFindAllMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.ClientGuestrList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuestService", "findAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuestrList.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestServiceMethodDescriptorSupplier("findAll"))
                  .build();
          }
        }
     }
     return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.APIResponse> getDeleteByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteById",
      requestType = com.grpcserver.GuestClientServer.ClientGuest.class,
      responseType = com.grpcserver.GuestClientServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.APIResponse> getDeleteByIdMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.APIResponse> getDeleteByIdMethod;
    if ((getDeleteByIdMethod = ClientGuestServiceGrpc.getDeleteByIdMethod) == null) {
      synchronized (ClientGuestServiceGrpc.class) {
        if ((getDeleteByIdMethod = ClientGuestServiceGrpc.getDeleteByIdMethod) == null) {
          ClientGuestServiceGrpc.getDeleteByIdMethod = getDeleteByIdMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuestService", "deleteById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestServiceMethodDescriptorSupplier("deleteById"))
                  .build();
          }
        }
     }
     return getDeleteByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.grpcserver.GuestClientServer.ClientGuest> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findById",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = com.grpcserver.GuestClientServer.ClientGuest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.grpcserver.GuestClientServer.ClientGuest> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.grpcserver.GuestClientServer.ClientGuest> getFindByIdMethod;
    if ((getFindByIdMethod = ClientGuestServiceGrpc.getFindByIdMethod) == null) {
      synchronized (ClientGuestServiceGrpc.class) {
        if ((getFindByIdMethod = ClientGuestServiceGrpc.getFindByIdMethod) == null) {
          ClientGuestServiceGrpc.getFindByIdMethod = getFindByIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, com.grpcserver.GuestClientServer.ClientGuest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuestService", "findById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuest.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestServiceMethodDescriptorSupplier("findById"))
                  .build();
          }
        }
     }
     return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.APIResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = com.grpcserver.GuestClientServer.ClientGuest.class,
      responseType = com.grpcserver.GuestClientServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest,
      com.grpcserver.GuestClientServer.APIResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.APIResponse> getUpdateMethod;
    if ((getUpdateMethod = ClientGuestServiceGrpc.getUpdateMethod) == null) {
      synchronized (ClientGuestServiceGrpc.class) {
        if ((getUpdateMethod = ClientGuestServiceGrpc.getUpdateMethod) == null) {
          ClientGuestServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.GuestClientServer.ClientGuest, com.grpcserver.GuestClientServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientGuestService", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.ClientGuest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.GuestClientServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientGuestServiceMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientGuestServiceStub newStub(io.grpc.Channel channel) {
    return new ClientGuestServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientGuestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientGuestServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientGuestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientGuestServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientGuestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void insert(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void findAll(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestrList> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void deleteById(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteByIdMethod(), responseObserver);
    }

    /**
     */
    public void findById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuest> responseObserver) {
      asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void update(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuest,
                com.grpcserver.GuestClientServer.APIResponse>(
                  this, METHODID_INSERT)))
          .addMethod(
            getFindAllMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuest,
                com.grpcserver.GuestClientServer.ClientGuestrList>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getDeleteByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuest,
                com.grpcserver.GuestClientServer.APIResponse>(
                  this, METHODID_DELETE_BY_ID)))
          .addMethod(
            getFindByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                com.grpcserver.GuestClientServer.ClientGuest>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.GuestClientServer.ClientGuest,
                com.grpcserver.GuestClientServer.APIResponse>(
                  this, METHODID_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class ClientGuestServiceStub extends io.grpc.stub.AbstractStub<ClientGuestServiceStub> {
    private ClientGuestServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientGuestServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGuestServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientGuestServiceStub(channel, callOptions);
    }

    /**
     */
    public void insert(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestrList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteById(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuest> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.grpcserver.GuestClientServer.ClientGuest request,
        io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientGuestServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientGuestServiceBlockingStub> {
    private ClientGuestServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientGuestServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGuestServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientGuestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.APIResponse insert(com.grpcserver.GuestClientServer.ClientGuest request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.ClientGuestrList findAll(com.grpcserver.GuestClientServer.ClientGuest request) {
      return blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.APIResponse deleteById(com.grpcserver.GuestClientServer.ClientGuest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.ClientGuest findById(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.GuestClientServer.APIResponse update(com.grpcserver.GuestClientServer.ClientGuest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientGuestServiceFutureStub extends io.grpc.stub.AbstractStub<ClientGuestServiceFutureStub> {
    private ClientGuestServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientGuestServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientGuestServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientGuestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.APIResponse> insert(
        com.grpcserver.GuestClientServer.ClientGuest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.ClientGuestrList> findAll(
        com.grpcserver.GuestClientServer.ClientGuest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.APIResponse> deleteById(
        com.grpcserver.GuestClientServer.ClientGuest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.ClientGuest> findById(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.GuestClientServer.APIResponse> update(
        com.grpcserver.GuestClientServer.ClientGuest request) {
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
    private final ClientGuestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientGuestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSERT:
          serviceImpl.insert((com.grpcserver.GuestClientServer.ClientGuest) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.grpcserver.GuestClientServer.ClientGuest) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuestrList>) responseObserver);
          break;
        case METHODID_DELETE_BY_ID:
          serviceImpl.deleteById((com.grpcserver.GuestClientServer.ClientGuest) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.APIResponse>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.GuestClientServer.ClientGuest>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.grpcserver.GuestClientServer.ClientGuest) request,
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

  private static abstract class ClientGuestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientGuestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpcserver.GuestClientServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientGuestService");
    }
  }

  private static final class ClientGuestServiceFileDescriptorSupplier
      extends ClientGuestServiceBaseDescriptorSupplier {
    ClientGuestServiceFileDescriptorSupplier() {}
  }

  private static final class ClientGuestServiceMethodDescriptorSupplier
      extends ClientGuestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientGuestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientGuestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientGuestServiceFileDescriptorSupplier())
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
