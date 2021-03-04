/**
 * @Author 杜广楠
 * @Description
 * @Date 2/20/2021 5:04 PM
 */
public class ClassLockDemo implements Runnable{
    static ClassLockDemo instence1 = new ClassLockDemo();
    static ClassLockDemo instence2 = new ClassLockDemo();

    @Override
    public void run() {
        // 所有线程需要的锁都是同一把
        synchronized(ClassLockDemo.class){
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instence1);
        Thread t2 = new Thread(instence2);
        t1.start();
        t2.start();
    }
}
