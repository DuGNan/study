package com.dgn.collection;

import com.google.common.collect.*;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/5 22:49
 */
public class MultiDemo {

    public void multiSetTest(){
        Multiset multiset = HashMultiset.create();
        multiset.add("Tom");
        multiset.add("Marry");
        multiset.add("Tom");
        System.out.println("multiset:" + multiset);
        System.out.println("multiset.count():" + multiset.count("Tom"));
        System.out.println(multiset.elementSet());

        Iterator iterator = multiset.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void multiMap(){
        Multimap multimap = HashMultimap.create();
        multimap.putAll("Tom", Arrays.asList("18","man"));
        multimap.put("Marry", Arrays.asList("18","woman"));
        multimap.put("Cindy", 18);
        System.out.println(multimap);
        System.out.println("multimap.get('Tom'):" + multimap.get("Tom"));
        System.out.println("multimap.get('Marry')" + multimap.get("Marry"));

        //所有”键-值集合映射”
        System.out.println("multimap.asMap():" + multimap.asMap());

        //Multimap.entries()返回Multimap中所有”键-单个值映射”——包括重复键
        System.out.println("multimap.entries():" + multimap.entries());

        //Multimap.get(key)总是返回非null、但是可能空的集合
        System.out.println("multimap.get():" + multimap.get("Eric"));

        //为Multimap中没有的键返回null，请使用asMap()视图获取一个Map<K, Collection<V>>
        System.out.println("multimap.asMap().get():" + multimap.asMap().get("Eric"));

    }

    public void tableTest(){
        Table<String, String, String> aTable = HashBasedTable.create();
        aTable.put("成都","双流","张三");
        aTable.put("成都","双流","李四");
        aTable.put("昆明","五华","王五");
        System.out.println(aTable.get("成都","双流"));
        System.out.println("aTable.rowMap():" + aTable.rowMap());
        System.out.println("aTable.row():" + aTable.row("成都"));
        System.out.println("aTable.cellSet():" + aTable.cellSet());

    }

    public static void main(String[] args) {
        MultiDemo multiDemo = new MultiDemo();
//        multiDemo.multiSetTest();
//        multiDemo.multiMap();
        multiDemo.tableTest();
    }
}
