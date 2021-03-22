package collection;

import java.util.*;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/6/2021 5:28 PM
 */
public class SubListDemo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<String>();
        list.add("Tom");
        list.add("Cindy");
        list.add("Marry");

        Map<String, String> map = new HashMap<>(16);
        map.put("张三", "18");
        map.put("李四", "25");
        map.put("王五", "30");

        System.out.println(map.entrySet());
        System.out.println(map.keySet());

    }
}
