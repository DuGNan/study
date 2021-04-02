package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/31/2021 10:43 PM
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(Dog.class);
        //设置回调函数
        enhancer.setCallback(new MethodInterceptor());

        //这里的creat方法就是正式创建代理类
        Dog proxyDog = (Dog)enhancer.create();
        //调用代理类的eat方法
        proxyDog.eat();
    }
}

class Dog{
    final public void run(String name) {
        System.out.println("狗"+name+"----run");
    }

    public void eat() {
        System.out.println("狗----eat");
    }
}

class MethodInterceptor implements net.sf.cglib.proxy.MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("这里是对目标类进行增强！！！");
        //注意这里的方法调用，不是用反射哦！！！
        Object object = proxy.invokeSuper(o, objects);
        return object;
    }
}
