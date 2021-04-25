package com.dgn.controller;

import com.dgn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/4/23 16:58
 */
@RestController
public class TestController {
    @Value("${test:默认值}")
    private String test;
    @Value("${test1:默认值}")
    private String test1;
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String test(){
        System.out.println("test:" + test);
        System.out.println("test1:" + test1);
        return "test的值为:" + test;
    }

    @GetMapping("/test1")
    public void tes1(){
        testService.test();
    }
}
