package com.dgn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/24 20:05
 */
public class ChannelDemo {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(System.getProperty("user.dir") +
                    "\\nio-study\\file\\nio1.txt" , "rw");
            FileChannel inChannel = randomAccessFile.getChannel();

            //创建缓冲区
            //缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，
            // 并提供了一组方法，用来方便的访问该块内存。
            ByteBuffer buf = ByteBuffer.allocate(48);

            //将文件读入buffer
            int byteRead = inChannel.read(buf);

            while (byteRead != -1 ){
                System.out.println("Read " + byteRead);

                //将buffer从写模式切换到读模式
                buf.flip();

                while (buf.hasRemaining()){
                    // 每次读一字节
                    System.out.println((char) buf.get());
                }

                //读完了所有的数据，就需要清空缓冲区，让它可以再次被写入
                //调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。
                // 任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面
                buf.clear();
                byteRead = inChannel.read(buf);
                System.out.println("Read " + byteRead);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
