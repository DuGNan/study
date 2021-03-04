/**
 * @Author 杜广楠
 * @Description
 * @Date 2/20/2021 3:18 PM
 */
public class MethodLockDemo implements Runnable{
    static MethodLockDemo instence = new MethodLockDemo();

    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instence);
        Thread thread2 = new Thread(instence);
        thread1.start();
        thread2.start();
    }
}
