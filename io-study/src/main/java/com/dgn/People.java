package com.dgn;

import java.io.Serializable;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/31/2021 10:08 PM
 */
public class People implements Serializable {

    private static final long serialVersionUID = -8824089534143049233L;

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
