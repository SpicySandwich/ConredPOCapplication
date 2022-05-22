package com.grpcserver.product;

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
    comments = "Source: ProductServer.proto")
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final String SERVICE_NAME = "product.service.ProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.ProductList> getFindAllRepeatedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findAllRepeated",
      requestType = com.grpcserver.product.ProductServer.Product.class,
      responseType = com.grpcserver.product.ProductServer.ProductList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.ProductList> getFindAllRepeatedMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.ProductList> getFindAllRepeatedMethod;
    if ((getFindAllRepeatedMethod = ProductServiceGrpc.getFindAllRepeatedMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getFindAllRepeatedMethod = ProductServiceGrpc.getFindAllRepeatedMethod) == null) {
          ProductServiceGrpc.getFindAllRepeatedMethod = getFindAllRepeatedMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.ProductList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "product.service.ProductService", "findAllRepeated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.ProductList.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("findAllRepeated"))
                  .build();
          }
        }
     }
     return getFindAllRepeatedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.APIResponse> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insert",
      requestType = com.grpcserver.product.ProductServer.Product.class,
      responseType = com.grpcserver.product.ProductServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.APIResponse> getInsertMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.APIResponse> getInsertMethod;
    if ((getInsertMethod = ProductServiceGrpc.getInsertMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getInsertMethod = ProductServiceGrpc.getInsertMethod) == null) {
          ProductServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "product.service.ProductService", "insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.APIResponse> getDeleteByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteById",
      requestType = com.grpcserver.product.ProductServer.Product.class,
      responseType = com.grpcserver.product.ProductServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.APIResponse> getDeleteByIdMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.APIResponse> getDeleteByIdMethod;
    if ((getDeleteByIdMethod = ProductServiceGrpc.getDeleteByIdMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getDeleteByIdMethod = ProductServiceGrpc.getDeleteByIdMethod) == null) {
          ProductServiceGrpc.getDeleteByIdMethod = getDeleteByIdMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "product.service.ProductService", "deleteById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("deleteById"))
                  .build();
          }
        }
     }
     return getDeleteByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.grpcserver.product.ProductServer.Product> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findById",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = com.grpcserver.product.ProductServer.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.grpcserver.product.ProductServer.Product> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.grpcserver.product.ProductServer.Product> getFindByIdMethod;
    if ((getFindByIdMethod = ProductServiceGrpc.getFindByIdMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getFindByIdMethod = ProductServiceGrpc.getFindByIdMethod) == null) {
          ProductServiceGrpc.getFindByIdMethod = getFindByIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, com.grpcserver.product.ProductServer.Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "product.service.ProductService", "findById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.Product.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("findById"))
                  .build();
          }
        }
     }
     return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.APIResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = com.grpcserver.product.ProductServer.Product.class,
      responseType = com.grpcserver.product.ProductServer.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product,
      com.grpcserver.product.ProductServer.APIResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.APIResponse> getUpdateMethod;
    if ((getUpdateMethod = ProductServiceGrpc.getUpdateMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getUpdateMethod = ProductServiceGrpc.getUpdateMethod) == null) {
          ProductServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.grpcserver.product.ProductServer.Product, com.grpcserver.product.ProductServer.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "product.service.ProductService", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpcserver.product.ProductServer.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    return new ProductServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProductServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProductServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProductServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAllRepeated(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.ProductList> responseObserver) {
      asyncUnimplementedUnaryCall(getFindAllRepeatedMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void deleteById(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteByIdMethod(), responseObserver);
    }

    /**
     */
    public void findById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void update(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllRepeatedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.product.ProductServer.Product,
                com.grpcserver.product.ProductServer.ProductList>(
                  this, METHODID_FIND_ALL_REPEATED)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.product.ProductServer.Product,
                com.grpcserver.product.ProductServer.APIResponse>(
                  this, METHODID_INSERT)))
          .addMethod(
            getDeleteByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.product.ProductServer.Product,
                com.grpcserver.product.ProductServer.APIResponse>(
                  this, METHODID_DELETE_BY_ID)))
          .addMethod(
            getFindByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                com.grpcserver.product.ProductServer.Product>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpcserver.product.ProductServer.Product,
                com.grpcserver.product.ProductServer.APIResponse>(
                  this, METHODID_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class ProductServiceStub extends io.grpc.stub.AbstractStub<ProductServiceStub> {
    private ProductServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAllRepeated(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.ProductList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindAllRepeatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteById(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.Product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.grpcserver.product.ProductServer.Product request,
        io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductServiceBlockingStub extends io.grpc.stub.AbstractStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpcserver.product.ProductServer.ProductList findAllRepeated(com.grpcserver.product.ProductServer.Product request) {
      return blockingUnaryCall(
          getChannel(), getFindAllRepeatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.product.ProductServer.APIResponse insert(com.grpcserver.product.ProductServer.Product request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.product.ProductServer.APIResponse deleteById(com.grpcserver.product.ProductServer.Product request) {
      return blockingUnaryCall(
          getChannel(), getDeleteByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.product.ProductServer.Product findById(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpcserver.product.ProductServer.APIResponse update(com.grpcserver.product.ProductServer.Product request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductServiceFutureStub extends io.grpc.stub.AbstractStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.product.ProductServer.ProductList> findAllRepeated(
        com.grpcserver.product.ProductServer.Product request) {
      return futureUnaryCall(
          getChannel().newCall(getFindAllRepeatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.product.ProductServer.APIResponse> insert(
        com.grpcserver.product.ProductServer.Product request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.product.ProductServer.APIResponse> deleteById(
        com.grpcserver.product.ProductServer.Product request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.product.ProductServer.Product> findById(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpcserver.product.ProductServer.APIResponse> update(
        com.grpcserver.product.ProductServer.Product request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL_REPEATED = 0;
  private static final int METHODID_INSERT = 1;
  private static final int METHODID_DELETE_BY_ID = 2;
  private static final int METHODID_FIND_BY_ID = 3;
  private static final int METHODID_UPDATE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL_REPEATED:
          serviceImpl.findAllRepeated((com.grpcserver.product.ProductServer.Product) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.ProductList>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.grpcserver.product.ProductServer.Product) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse>) responseObserver);
          break;
        case METHODID_DELETE_BY_ID:
          serviceImpl.deleteById((com.grpcserver.product.ProductServer.Product) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.Product>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.grpcserver.product.ProductServer.Product) request,
              (io.grpc.stub.StreamObserver<com.grpcserver.product.ProductServer.APIResponse>) responseObserver);
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

  private static abstract class ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpcserver.product.ProductServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductService");
    }
  }

  private static final class ProductServiceFileDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier {
    ProductServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceMethodDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServiceFileDescriptorSupplier())
              .addMethod(getFindAllRepeatedMethod())
              .addMethod(getInsertMethod())
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
