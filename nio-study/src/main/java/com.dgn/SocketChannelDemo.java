package com.dgn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/26 21:58
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int byteRead = socketChannel.write(byteBuffer);

        byteBuffer.flip();

        while (byteRead != -1){
            System.out.println("Read:" + byteRead);
            while (byteBuffer.hasRemaining()){
                System.out.println(byteBuffer.get());
            }

            byteBuffer.clear();
            byteRead = socketChannel.read(byteBuffer);
            System.out.println("Read " + byteRead);
        }

    }
}
