import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author 杜广楠
 * @Description
 * CyclicBarrier，可循环使用的屏障，让一组线程到达屏障时被阻塞，直到最后一个线程到达屏障
 * 使用场景：多线程计算数据，最后合并计算结果的场景
 * CyclicBarrier可以使用reset()方法重置计数器
 * @Date 2021/3/2 20:12
 */
public class CyclicBarrierDemo1 {
    /**
     * parties参数表示需要到达同步点的线程数，如果我这里把parties设置为3，那么我下面代码里面的两个线程都不会继续执行
     */
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
