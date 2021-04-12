package base;


import java.util.*;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/4/11 19:10
 */
// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
public class ShowMeBug {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("微信红包算法：");
        dealRedPackage(20000,20);
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    //请补充下列函数内容
    public static void dealRedPackage(double money,int n){
        //将金额转为分为单位
        int balance = (int) (money * 100);
        int[] readPackets = new int[n];


        //红包赋初值
        Arrays.fill(readPackets, 1);
        balance -= n;

        while (balance > 0){
            int index = getRandom(n-1, 0);
            readPackets[index]++;
            balance--;
        }

        int total = 0;
        for (int i=0; i<n ; i++){
            System.out.println("第"+ i + "个红包为:" + readPackets[i] + "分");
            total += readPackets[i];
        }
        System.out.println("total:" + total);
    }



    public static int getRandom(int max, int min){
        return min + (int)(Math.random() * (max-min+1));
    }


}