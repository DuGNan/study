import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/2 20:49
 */
public class ExchangerDemo {
    private static final Exchanger<String> exchanger = new Exchanger<String>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(()->{
            try {
                String A = "银行流水A";
                String B = exchanger.exchange(A);
                System.out.println("111:" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(()->{
            try {
                String B = "银行流水B";
                String A = exchanger.exchange(B);
                System.out.println("A和B数据是否一致：" + A.equals(B) + ",A录入的是：" + A + ",B录入的是：" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
    }
}
