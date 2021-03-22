package com.dgn.base;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 杜广楠
 * @Description
 * PreCondition的几个方法，checkArgument，checkNotNull，checkState，checkElementIndex，
 * checkPositionIndex，checkPositionIndexes都有三种参数
 * 1.没有额外参数：抛出的异常中没有错误消息；
 * 2.有一个Object对象作为额外参数：抛出的异常使用Object.toString() 作为错误消息；
 * 3.有一个String对象作为额外参数，并且有一组任意数量的附加Object对象：这个变种处理异常消息的方式有点类似printf，但考虑GWT的兼容性和效率，只支持%s指示符。例如：
 * @Date 2021/3/5 20:47
 */
public class PreConditionsDemo {
    public static void main(String[] args) {
        String name = "hello";
        String nullName = null;
        String emptyName = null;

        try {
            //检查boolean是否为true，用来检查传递给方法的参数。
            Preconditions.checkArgument(name.equals("hell"),"name不为hello ");
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }

        try {
            //检查value是否为null，该方法直接返回value，因此可以内嵌使用checkNotNull。
            Preconditions.checkNotNull(nullName);
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }

        try {
            //用来检查对象的某些状态。和checkAragument类似，抛出一场不一样
            Preconditions.checkState(name.equals("hell"),"name不为hello ");
        }catch (IllegalStateException e){
            System.out.println(e.toString());
        }


        List<String> a = Arrays.asList("a","b","c");
        try {
            //检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size *
            Preconditions.checkElementIndex(3, a.size());
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }

        try {
            //检查index作为位置值对某个列表、字符串或数组是否有效。index>=0 && index<=size *
            Preconditions.checkPositionIndex(3, a.size());
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }

        try {
            //检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效*
            Preconditions.checkPositionIndexes(3,4, a.size());
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }

    }
}
