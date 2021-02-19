package hook;


/**
 * @author dugn
 * @Date 2020/12/31
 * @Description
 * 钩子函数：Java提供注册钩子线程，在JVM进程关闭之前，会自动执行这个钩子线程。
 * 运用这个技巧，可以再JVM关闭之前，释放一些系统资源。
 * 这个功能利用的是Runtime类来实现。
 */
public class HookDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main 开始执行");

        Thread.sleep(1000 * 2);

        Runtime.getRuntime().addShutdownHook(new Thread( ()->{
            System.out.println("启动钩子函数");
        }));

        System.out.println("main 执行完毕");
    }
}
