package service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author dugn
 * @Date 2020/12/23
 * @Description 处理请求
 */
public class PkslowServer {
    public static void main(String[] args) {
        //服务监听的接口
        Server server = ServerBuilder.forPort(9999)
                .addService(new OrderServiceImpl())
                .build();

        try {
            System.out.println("Start server...");
            server.start();
            System.out.println("Started");
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
