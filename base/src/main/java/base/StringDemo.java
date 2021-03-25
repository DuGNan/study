package base;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/22/2021 2:59 PM
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println("a hashcode = " + a.hashCode());
        System.out.println("b hashcode = " + b.hashCode());
        System.out.println("abc hashcode = " + "abc".hashCode());

    }
}
