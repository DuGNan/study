import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/3 21:16
 */
public class AtomicIntegerDemo {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai);
        //AtomicInteger的getAndSet返回旧值
        System.out.println(ai.getAndSet(3));
        System.out.println(ai.get());
    }
}
