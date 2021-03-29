package com.dgn;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/26 22:40
 */
public class PathDemo {
    public static void main(String[] args) {
        Path currentPath = Paths.get(".");
        System.out.println("currentPath:" + currentPath.toAbsolutePath());
    }
}
