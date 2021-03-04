import org.omg.CORBA.PERSIST_STORE;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/2 20:39
 */
public class SemaphoreDemo {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i =0; i < THREAD_COUNT; i++){
            threadPool.execute(()->{
                try {
                    s.acquire();
                    System.out.println("save data");
                    Thread.sleep(1000);
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

}
