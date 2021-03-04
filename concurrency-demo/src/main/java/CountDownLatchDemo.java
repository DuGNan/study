import java.util.concurrent.CountDownLatch;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/2 20:09
 */
public class CountDownLatchDemo {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println(3);
    }
}
