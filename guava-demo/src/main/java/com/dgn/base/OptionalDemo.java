package com.dgn.base;


import com.dgn.common.User;
import com.google.common.base.Optional;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/5 20:09
 */
public class OptionalDemo {

    public static void main(String[] args) {
//        Optional<Integer> a = Optional.of(5);
//        System.out.println(a.isPresent());
//        System.out.println(a.get());

        User user = null;
//        Optional userOptional1 = Optional.of(user);
//        System.out.println(userOptional1.isPresent());
//        System.out.println(userOptional1.get());

//        Optional userOptional2 = Optional.fromNullable(user);
//        System.out.println(userOptional2.isPresent());
//        System.out.println(userOptional2.or("userOptional2.or is null"));
//        System.out.println(userOptional2.orNull());
//        System.out.println(userOptional2.asSet());
//        System.out.println(userOptional2.get());

        Optional userOptional3 = Optional.absent();
        System.out.println(userOptional3);


    }
}
