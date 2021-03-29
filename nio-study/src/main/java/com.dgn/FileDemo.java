package com.dgn;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/26 22:43
 */
public class FileDemo {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir") + "\\nio-study\\file\\nio1.txt");
        System.out.println("path:" + path);
        System.out.println(Files.exists(path));
    }
}
