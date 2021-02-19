package designMode.factory.method;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class GifReader implements Reader {
    @Override
    public void read() {
        System.out.print("read gif");
    }
}
