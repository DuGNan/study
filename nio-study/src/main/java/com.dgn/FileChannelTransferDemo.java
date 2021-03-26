package com.dgn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/26/2021 6:15 PM
 */
public class FileChannelTransferDemo {

    public static void main(String[] args) throws IOException {
        //RandomAccessFile会主动创建文件，但是要有写权限，且文件路径存在
        RandomAccessFile file1 = new RandomAccessFile("F:\\nio1.txt", "r");
        RandomAccessFile file2 = new RandomAccessFile("F:\\nio2.txt", "rw");
        FileChannel fromChannel = file1.getChannel();
        FileChannel toChannel = file2.getChannel();

        long position = 7;
        long count = fromChannel.size();
//        toChannel.transferFrom(fromChannel, position, count);
        long i = fromChannel.transferTo(position, count, toChannel);

    }
}
