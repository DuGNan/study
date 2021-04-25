package com.dgn;

import org.junit.Test;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/6/2021 3:24 PM
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "abc";
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str == str1);
        System.out.println(str1 == "abc");
        System.out.println(str2 == "abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2.intern());
        System.out.println(str2 == str2.intern());
        System.out.println(str1.hashCode() == str2.hashCode());
    }

    @Test
    public void testIntern1(){
        String a = new String("1") + new String("1");
        a.intern();
        String b = "11";
        System.out.println(a == b);
    }

    @Test
    public void testIntern2(){
        String a = new String("1") + new String("1");
        String b = "11";
        a.intern();
        System.out.println(a == b);
    }

    @Test
    public void test3(){
        String str = "abc";
        String str2 = "abc";
        String str3 = "abcabc";
        String str4 = str + str2;
        System.out.println(str3.equals(str4));
        System.out.println(str3 == str4);
        String str5 = "abc" + "abc";
        System.out.println(str3.equals(str5));
        System.out.println(str3 == str5);

    }
}
