package com.dgn;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEvent;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/4/3 14:23
 */
public class BeanFactoryPostProcesserDemo extends ApplicationEvent implements BeanPostProcessor{

    public BeanFactoryPostProcesserDemo(Object source) {
        super(source);
    }

    public static void main(String[] args) {

    }

}
