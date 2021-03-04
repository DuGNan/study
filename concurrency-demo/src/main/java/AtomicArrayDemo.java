import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/3 21:16
 */
public class AtomicArrayDemo {
    static int[] value = new int[] {1, 2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(ai.get(0));
        //AtomicIntegerArray的getAndSet返回新值
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
