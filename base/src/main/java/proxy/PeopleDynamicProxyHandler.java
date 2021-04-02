package proxy;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/1/2021 6:07 PM
 */
public class PeopleDynamicProxyHandler implements InvocationHandler {
    private People proxyed;

    public PeopleDynamicProxyHandler(People proxyed) {
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("People start speak");
        return method.invoke(proxyed, args);
    }
}
