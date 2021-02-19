package com.dgn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2/7/2021 3:25 PM
 */
@RestController
public class TestController {

    @GetMapping
    public String getString(){
        return "hello";
    }


    @GetMapping
    public void testInterceptor(){
        LinkedTransferQueue queue = new LinkedTransferQueue<>();
    }
}
