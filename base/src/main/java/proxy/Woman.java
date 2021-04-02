package proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/2/2021 5:11 PM
 */
public class Woman {

    void speak(){
        System.out.println("我是女人!");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Woman.class);
        enhancer.setCallback(new CglibInterceptor());
        Woman proxy = (Woman) enhancer.create();
        proxy.speak();
    }
}
