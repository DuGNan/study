package proxy;

import java.lang.reflect.Proxy;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/1/2021 6:06 PM
 */
public class Man implements People{
    @Override
    public void speak() {
        System.out.println("I'm Man！");
    }

    public static void main(String[] args) {
        PeopleDynamicProxyHandler handler = new PeopleDynamicProxyHandler(new Man());
        People people = (People) Proxy.newProxyInstance(
                People.class.getClassLoader(),
                new Class[]{People.class},
                handler);
        people.speak();
    }
}
