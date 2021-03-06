package proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.4.0)",
        comments = "Source: order.proto")
public final class OrderServiceGrpc {

    private OrderServiceGrpc() {
    }

    public static final String SERVICE_NAME = "OrderService";

    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<OrderRequest,
            OrderRespone> METHOD_GET_ORDER =
            io.grpc.MethodDescriptor.<OrderRequest, OrderRespone>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "OrderService", "getOrder"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            OrderRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            OrderRespone.getDefaultInstance()))
                    .build();

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static OrderServiceStub newStub(io.grpc.Channel channel) {
        return new OrderServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static OrderServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new OrderServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static OrderServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new OrderServiceFutureStub(channel);
    }

    /**
     *
     */
    public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public void getOrder(OrderRequest request,
                             io.grpc.stub.StreamObserver<OrderRespone> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_ORDER, responseObserver);
        }

        @Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            METHOD_GET_ORDER,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            OrderRequest,
                                            OrderRespone>(
                                            this, METHODID_GET_ORDER)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class OrderServiceStub extends io.grpc.stub.AbstractStub<OrderServiceStub> {
        private OrderServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private OrderServiceStub(io.grpc.Channel channel,
                                 io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected OrderServiceStub build(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            return new OrderServiceStub(channel, callOptions);
        }

        /**
         *
         */
        public void getOrder(OrderRequest request,
                             io.grpc.stub.StreamObserver<OrderRespone> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_ORDER, getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractStub<OrderServiceBlockingStub> {
        private OrderServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private OrderServiceBlockingStub(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected OrderServiceBlockingStub build(io.grpc.Channel channel,
                                                 io.grpc.CallOptions callOptions) {
            return new OrderServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public OrderRespone getOrder(OrderRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_ORDER, getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractStub<OrderServiceFutureStub> {
        private OrderServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private OrderServiceFutureStub(io.grpc.Channel channel,
                                       io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @Override
        protected OrderServiceFutureStub build(io.grpc.Channel channel,
                                               io.grpc.CallOptions callOptions) {
            return new OrderServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<OrderRespone> getOrder(
                OrderRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_ORDER, getCallOptions()), request);
        }
    }

    private static final int METHODID_GET_ORDER = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final OrderServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GET_ORDER:
                    serviceImpl.getOrder((OrderRequest) request,
                            (io.grpc.stub.StreamObserver<OrderRespone>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static final class OrderServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
        @Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Order.getDescriptor();
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (OrderServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new OrderServiceDescriptorSupplier())
                            .addMethod(METHOD_GET_ORDER)
                            .build();
                }
            }
        }
        return result;
    }
}
