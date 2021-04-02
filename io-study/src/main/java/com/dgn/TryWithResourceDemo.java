package com.dgn;

import org.junit.Test;

import java.io.*;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/31/2021 9:13 PM
 */
public class TryWithResourceDemo {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "\\io-study\\file\\1.txt");
        try (InputStream inputStream = new FileInputStream(file);){
            int read = inputStream.read();
            while (read != -1){
                System.out.println((char) read);
                read = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testReadWithBytes(){
        File file = new File(System.getProperty("user.dir") + "\\file\\1.txt");
        try (InputStream inputStream = new FileInputStream(file);) {
            byte[] buffer = new byte[1024];
            inputStream.read(buffer, 10 , 30);
            System.out.println(new String(buffer));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
