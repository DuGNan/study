package com.dgn;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/31/2021 5:59 PM
 */
public class PipeStudy {

    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream(inputStream);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    outputStream.write("Hello World!".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int read = inputStream.read();
                    while (read != -1){
                        System.out.println((char)read);
                        read = inputStream.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });


        thread1.start();
        thread2.start();


    }
}
