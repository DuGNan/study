package service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto.OrderRequest;
import proto.OrderRespone;
import proto.OrderServiceGrpc;

/**
 * @author dugn
 * @Date 2020/12/23
 * @Description
 */
public class PkslowClient {
    public static void main(String[] args) {
        //生成连接通道，连接本地9999（即服务端端口号）
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext()
                .build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        callWithOrderId(stub, 511);
        callWithOrderId(stub, 824);
        callWithOrderId(stub, 805);

        channel.shutdown();
    }

    private static void callWithOrderId(OrderServiceGrpc.OrderServiceBlockingStub stub, int orderId) {
        //生成请求消息
        OrderRequest request = OrderRequest.newBuilder()
                .setOrderId(orderId)
                .build();
        //调用服务
        OrderRespone respone = stub.getOrder(request);

        System.out.println("Respone from Server: " + respone);
    }
}
