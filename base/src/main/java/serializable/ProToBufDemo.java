package serializable;

import com.google.protobuf.InvalidProtocolBufferException;
import proto.Student;

/**
 * @author dugn
 * @Date 2020/12/1
 * @Description
 */
public class ProToBufDemo {
    public static void main(String[] args) {
        //创建builder
        Student.student.Builder studentBuilder = Student.student.newBuilder();
        studentBuilder.setName("Protoc");
        studentBuilder.setNo(1);

        //创建student
        Student.student student = studentBuilder.build();
        System.out.println(student.toString());

        try {
            //将二进制转为
            Student.student st = Student.student.parseFrom(student.toByteArray());
            System.out.print(st.toString());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}