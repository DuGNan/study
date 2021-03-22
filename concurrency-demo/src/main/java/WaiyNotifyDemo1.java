import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/3/21 15:05
 */
public class WaiyNotifyDemo1 {
    static Object lock = new Object();
    static boolean flag = true;


    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        Thread.sleep(1 * 1000);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ "
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                        System.out.println(Thread.currentThread() + "release Lock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            System.out.println("Notify start at " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    lock.notifyAll();
                    flag = false;
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    try {
                        System.out.println(Thread.currentThread() + " hold lock again. sleep @ "
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
