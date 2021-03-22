package base;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/5/2021 5:44 PM
 */
public class DefaultKeyWordDemo implements T2{
    @Override
    public void test1() {

    }

    public static void main(String[] args) {
        DefaultKeyWordDemo defaultKeyWordDemo = new DefaultKeyWordDemo();
        defaultKeyWordDemo.test2();
    }
}

interface T1 {
    void test1();

    default void test2(){
        System.out.println("T1 test2");
    }
}

interface T2 extends T1 {

    @Override
    default void test2(){
        System.out.println("T2 test2");
    }
}

