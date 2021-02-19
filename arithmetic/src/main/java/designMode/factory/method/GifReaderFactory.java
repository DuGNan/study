package designMode.factory.method;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class GifReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new GifReader();
    }
}