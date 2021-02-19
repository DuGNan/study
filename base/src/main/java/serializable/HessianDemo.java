package serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import entity.Student;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author dugn
 * @Date 2020/12/1
 * @Description
 */
public class HessianDemo {
    public static void main(String[] args) throws IOException {

        Student student = new Student();
        student.setNo(101);
        student.setName("HESSIAN");

        //把student对象转化为byte数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(bos);
        output.writeObject(student);
        output.flushBuffer();
        byte[] data = bos.toByteArray();
        bos.close();

        //把刚才序列化出来的byte数组转化为student对象
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(bis);
        Student deStudent = (Student) input.readObject();
        input.close();

        System.out.println(deStudent);
    }
}
