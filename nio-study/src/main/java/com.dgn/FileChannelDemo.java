package com.dgn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/26 21:12
 */
public class FileChannelDemo {


    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(System.getProperty("user.dir") +
                "\\nio-study\\file\\nio1.txt" , "rw");
        FileChannel channel = file.getChannel();

        System.out.println("channel.size():" + channel.size());
        System.out.println("channel.position():" + channel.position());
        System.out.println("set channel.position():" + channel.position(5));

        String str = "Java";
        ByteBuffer buffer = ByteBuffer.allocate(48);
        //buffer准备好写
        buffer.clear();
        //想buffer写入
        buffer.put(str.getBytes());
        //buffer准备好读
        buffer.flip();

        //想FileChannel写入数据，每次写入一字节
        while (buffer.hasRemaining()){
            channel.write(buffer);
        }
        System.out.println("after writen string into file, channel.size():" + channel.size());

        channel.force(true);
        channel.close();

    }
}
