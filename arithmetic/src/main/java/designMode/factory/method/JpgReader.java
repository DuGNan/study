package designMode.factory.method;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class JpgReader implements Reader {
    @Override
    public void read() {
        System.out.print("read jpg");
    }
}
