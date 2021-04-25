package com.dgn;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/6/2021 2:30 PM
 */
public class Test2 {
    public static final String A = "Hello World";

    public static void main(String[] args) {
        String b = "Hello";
        String c = new String("Hello World");
        String d = "Hello";
        System.out.println("Test2.A.hashCode():" + Test2.A.hashCode());
//        System.out.println("Test2 b.hashCode():" + b.hashCode());
        System.out.println("Test2 c hashCode():" + c.hashCode());
//        System.out.println("Test1.A.hashCode():" + Test1.A.hashCode());
//        System.out.println("Test2.A == b ? " + (Test2.A == b));
        System.out.println("Test2.A == c ? " + (Test2.A == c));
        System.out.println("Test2.A == c ? " + (Test2.A.equals(c)));

//        System.out.println("b == c ?" + (b == c));
//        System.out.println("b == d ? " + (b == d));
//        System.out.println("Test1.A == Test2.A ? " + (Test1.A == Test2.A));
    }
}
