package base;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/4/5 16:42
 */
class Father{
    static {
        System.out.println("Father static block");
    }

    public Father(){
        System.out.println("Father's constructor");
    }

    {
        System.out.println("Father's block");
    }
}

class Son extends Father{
    static {
        System.out.println("Son static block");
    }

    public Son(){
        System.out.println("Son's constructor");
    }

    {
        System.out.println("Son's block");
    }
}


public class ClassLoadSortDemo {
    public static void main(String[] args) {
        Son son = new Son();
    }
}
