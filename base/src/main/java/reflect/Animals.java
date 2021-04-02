package reflect;

/**
 * @Author 杜广楠
 * @Description
 * @Date 4/1/2021 8:12 PM
 */
public class Animals {

    public String name;

    private String age = "20";

    public void eat(){
        System.out.println(name + "can eat");
    }

    private void run(){
        System.out.println(name + "can run");
    }

    public Animals(String name) {
        this.name = name;
    }

    public Animals() {
    }

}
