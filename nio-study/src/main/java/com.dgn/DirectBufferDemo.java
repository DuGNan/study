package com.dgn;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/30/2021 3:28 PM
 */
public class DirectBufferDemo {

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "\\nio-study\\file";
        FileChannel inChannel = FileChannel.open(Paths.get(filePath + "\\nio1.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(filePath + "\\nio3.txt"),StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        MappedByteBuffer inByteBuffer = inChannel.map(MapMode.READ_ONLY,0, inChannel.size());
        MappedByteBuffer outByteBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

        byte[] bytes = new byte[inByteBuffer.limit()];
        inByteBuffer.get(bytes);
        outByteBuffer.put(bytes);
    }
}
