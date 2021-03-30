package com.dgn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/30/2021 9:23 PM
 */
public class InputStreamStudy {

    @Test
    public void createInputStream(){
        String fileName = StudyConstant.FILE_PATH + "1.txt";
        try {
            InputStream inputStream = new FileInputStream(new File(fileName));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
