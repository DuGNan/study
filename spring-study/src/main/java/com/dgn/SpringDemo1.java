package com.dgn;

import com.dgn.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/28 21:24
 */
public class SpringDemo1 {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:applicationfile.xml");

        MessageService messageService = applicationContext.getBean(MessageService.class);

        System.out.println(messageService.getMessage());
    }
}
