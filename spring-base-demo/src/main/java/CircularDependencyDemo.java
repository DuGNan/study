/**
 * @Author 杜广楠
 * @Description
 * @Date 3/4/2021 6:04 PM
 */
public class CircularDependencyDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(new C());
    }
}

class A {
    public A() {
        new D();
    }
}

class B {
    public B() {
        new C();
    }
}
