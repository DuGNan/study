package com.dgn.collection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/5 21:37
 */
public class ImmutableDemo {

    public void immutableSet(List list){
        ImmutableSet immutableSet1 = ImmutableSet.copyOf(list);
        System.out.println("ImmutableSet.copyOf() :" + immutableSet1);

        ImmutableSet immutableSet2 = ImmutableSet.of("Hello","World","Hello");
        System.out.println("ImmutableSet.of():" + immutableSet2);

        ImmutableSet immutableSet3 = ImmutableSet.builder()
                .add("AAA")
                .add("BBB")
                .add("aaA")
                .build();
        System.out.println("ImmutableSet.builder():" + immutableSet3);

    }

    public void immutableList(){
        ImmutableList immutableList = ImmutableList.of("Hello","World","Hello");
        System.out.println("ImmutableList.of():" + immutableList);
    }

    public void immutableMap(){
        ImmutableMap immutableMap = ImmutableMap.of("Hello","World","22","33");
        System.out.println("ImmutableMap.of():" + immutableMap);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Tom","Cindy","Marry");
        ImmutableDemo demo = new ImmutableDemo();

        demo.immutableSet(list);

        demo.immutableList();

        demo.immutableMap();
    }

}
