package com.dgn;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/30/2021 9:13 PM
 */
public class FileStudy {

    @Test
    public void fileCreate(){
        File file = new File(StudyConstant.FILE_PATH + "1.txt");

        if(file.isDirectory()){
            System.out.println(file.getName() + "is a directory");
        }
        if(file.isFile()){
            System.out.println(file.getName() + "is a file");
        }
        if(file.exists()){
            System.out.println("create " + file.getName());
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void createDir(){
        File file = new File(StudyConstant.FILE_PATH + "\\child1\\child2");
        if(!file.exists()){
            file.mkdir();
        }
    }
}
