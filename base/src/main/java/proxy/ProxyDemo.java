package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dugn
 * @Date 2020/12/11
 * @Description demo来自《Thinking in Java》，一个简单的代理设计模式
 */
interface Interface {
    void doSomeThing();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomeThing() {
        System.out.println("realObject say hi");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("realObject say " + arg);
    }
}

class SimpleProxy implements Interface {

    private Interface proxied;


    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomeThing() {
        System.out.println("I'm realObject’s Proxy");
        proxied.doSomeThing();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("I'm realObject’s Proxy, " + arg);
        proxied.somethingElse(arg);
    }
}

public class ProxyDemo {

    public static void cusumer(Interface iface) {
        iface.doSomeThing();
        iface.somethingElse("Tom");
    }

    public static void main(String[] args) {
        cusumer(new RealObject());
        cusumer(new SimpleProxy(new RealObject()));
    }

}
