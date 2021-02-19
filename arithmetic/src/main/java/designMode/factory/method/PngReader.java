package designMode.factory.method;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class PngReader implements Reader {
    @Override
    public void read() {
        System.out.print("read png");
    }
}
