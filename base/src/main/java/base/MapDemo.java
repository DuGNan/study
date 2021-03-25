package base;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/23/2021 6:54 PM
 */
public class MapDemo {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Mary", "Beijing");
//        Set set = map.keySet();
//        set.add("hello");

        Collection collection = map.values();
        System.out.println("map.values():" + collection + " and collection class = " + collection.getClass());

    }
}
