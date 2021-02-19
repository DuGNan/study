package designMode.factory.method;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class PngReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new PngReader();
    }
}
