package service;

import io.grpc.stub.StreamObserver;
import proto.OrderRequest;
import proto.OrderRespone;
import proto.OrderServiceGrpc;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * @author dugn
 * @Date 2020/12/15
 * @Description
 */
public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

    @Override
    public void getOrder(OrderRequest request, StreamObserver<OrderRespone> responseObserver) {
        System.out.println("Request from Client: " + request);
        int orderId = request.getOrderId();
        responseObserver.onNext(getOrder(request));
        responseObserver.onCompleted();
    }

    public OrderRespone getOrder(OrderRequest request) {
        System.out.println("获取订单");
        return OrderRespone.newBuilder()
                .setOrderId(request.getOrderId())
                .setPrice(100 + request.getOrderId())
                .setName("Pumpkin")
                .build();
    }
}
