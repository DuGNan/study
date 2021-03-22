import java.util.concurrent.*;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/21 21:28
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,
                2,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>() );
    }
}
