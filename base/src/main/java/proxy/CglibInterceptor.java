package proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/2/2021 5:06 PM
 */
public class CglibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是美女");
        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
