package serializable;

import entity.Student;

import java.io.*;

/**
 * @author dugn
 * @Date 2020/12/1
 * @Description
 */
public class JdkSerializableDemo implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.setNo(1);
        student.setName("NormalSerializable");

        //序列化
        String home = System.getProperty("user.dir");
        //字节流文件存储地址
        String fileName = home + "\\file\\student.dat";
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.flush();
        oos.close();

        //反序列化
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student deStudent = (Student) ois.readObject();
        ois.close();
        System.out.println(deStudent);
    }
}
