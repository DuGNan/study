//package proxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
///**
// * @author dugn
// * @Date 2020/12/11
// * @Description
// */
//class DynamicProxyHandler implements InvocationHandler {
//
//    private Object proxied;
//
//    public DynamicProxyHandler(Object proxied) {
//        this.proxied = proxied;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("**** proxy: " + proxy.getClass() + ",method: " + method + ",args:" + args);
//        if (args != null) {
//            for (Object arg : args) {
//                System.out.println(" " + arg);
//            }
//        }
//        //调用被代理对象的方法
//        return method.invoke(proxied, args);
//    }
//}
//
//
//public class DynamicProxy {
//    public static void cusumer(Interface iface) {
//        iface.doSomeThing();
//        iface.somethingElse("Tom");
//    }
//
//    public static void main(String[] args) {
//        RealObject realObject = new RealObject();
//        cusumer(realObject);
//
//        System.out.println("------------------------------------------");
//
//        /**
//         * Proxy.newInstance(arg1, arg2, arg3):创建动态代理
//         * arg1:类加载器
//         * arg2:希望该代理实现的接口列表
//         * arg3:InvocationHandler接口的实现
//         */
//        Interface proxy = (Interface) Proxy.newProxyInstance(
//                Interface.class.getClassLoader(),
//                new Class[]{Interface.class},
//                new PeopleDynamicProxyHandler(realObject));
//        cusumer(proxy);
//    }
//}
