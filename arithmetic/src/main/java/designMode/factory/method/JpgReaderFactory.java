package designMode.factory.method;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class JpgReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new JpgReader();
    }
}