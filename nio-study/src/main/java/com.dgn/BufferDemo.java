package com.dgn;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/25/2021 8:56 PM
 */
public class BufferDemo {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(111);
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

        ByteBuffer.allocateDirect(1024);
    }
}
