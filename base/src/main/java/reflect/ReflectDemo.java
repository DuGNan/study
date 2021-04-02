package reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/1/2021 8:10 PM
 */
public class ReflectDemo {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Animals dog = new Animals("Pet");

        Class clazz = dog.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }

        Field field = clazz.getDeclaredField("name");
        System.out.println("field.getName()：" + field.getName());
        System.out.println("field.getType()：" + field.getType());
        System.out.println("field.getModifiers()：" + field.getModifiers());

        System.out.println("---------------------------------------");

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields){
            f.setAccessible(true);
            Object o = f.get(dog);
            System.out.println(clazz.getSimpleName() + "的属性" + f.getName() + "为" + o.toString());
        }

        System.out.println("---------------------------------------------");
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        Animals cat = (Animals) constructor.newInstance("猫");
        System.out.println(cat.name);

        System.out.println("-----------------------------------------------");
        Class clazz2 = Panda.class;
        Class clazz3 = clazz2.getSuperclass();
        System.out.println(clazz2.getSimpleName() + "的父类是" + clazz3.getSimpleName());

    }
}
