package base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/23/2021 9:07 AM
 */
public class HashDemo {

    public static void main(String[] args) {
        String key = "hello";
        int h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println("h: " + h);

        List<String> list = new ArrayList<>();

        Object[] test = {};
        System.out.println("test.class " + test.getClass());


    }
}
