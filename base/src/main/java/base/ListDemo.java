package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/23/2021 7:01 PM
 */
public class ListDemo {

    public static void main(String[] args) {
//        List list = new ArrayList();
//        list.add("北京");
//        list.add("上海");
//        list.add("昆明");
//        List subList = list.subList(0,1);
//        System.out.println("subList : " + subList);
//        subList.add("重庆");
//        System.out.println("after add subList : " + subList);
//        System.out.println("after add list : " + list);

        List list = Arrays.asList("北京", "上海", "昆明", "成都");
        System.out.println("list : " + list);
        list.set(0, "重庆");
        System.out.println("after set list : " + list);
    }
}
