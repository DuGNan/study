package com.dgn;

import org.junit.Test;

import java.io.*;

/**
 * @Author 杜广楠
 * @Description
 * @Date 3/31/2021 10:09 PM
 */
public class ObjectStreamDemo {

    @Test
    public void ObjectOutputStream() throws IOException {
        People people = new People("Marry", 20);
        String filePath = System.getProperty("user.dir") + "\\file\\2.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
        oos.writeObject(people);
        oos.close();
    }

    @Test
    public void ObjectInputStream() throws IOException, ClassNotFoundException {
        String filePath = System.getProperty("user.dir") + "\\file\\2.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
        People people = (People) ois.readObject();
        System.out.println(people.toString());
    }
}
