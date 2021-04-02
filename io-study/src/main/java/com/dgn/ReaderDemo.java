package com.dgn;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/31/2021 9:01 PM
 */
public class ReaderDemo {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(System.getProperty("user.dir") + "\\io-study\\file\\1.txt");

        int read = reader.read();
        while (read != -1){
            System.out.println((char) read);
            read = reader.read();
        }

        reader.close();
    }


    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
    }
}
