package serializable;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entity.Student;

/**
 * @author dugn
 * @Date 2020/12/2
 * @Description
 */
public class JsonDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("JSON序列化");
        student.setNo(100);

        //序列化
        String studentStr = JSON.toJSONString(student);
        System.out.println(studentStr);

        //反序列化
        Student student1 = JSON.parseObject(studentStr, Student.class);
        System.out.println(student1);
    }
}
