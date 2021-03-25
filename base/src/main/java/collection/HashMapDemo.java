package collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/21 16:05
 */
public class HashMapDemo {
    static HashMap map = new HashMap();

    public static void main(String[] args) {
        ConcurrentHashMap
        Thread thread1 = new Thread(new ClassA(), "ClassA ");
        Thread thread2 = new Thread(new ClassB(), "ClassB");
        thread1.start();
        thread2.start();
    }

    static class ClassA implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(5 * 1000);
                System.out.println("HashMap contains null key? " + map.containsKey(null));
                System.out.println(map.containsKey(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ClassB implements Runnable{

        @Override
        public void run() {
            System.out.println("HashMap contains null key? " + map.containsKey(null));
            map.put(null, null);
            System.out.println("HashMap put null into map");
        }
    }
}
