package designMode.factory.abstractfactory;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class IosFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new IosOperationController();
    }

    @Override
    public UIController createInterfaceController() {
        return new IosUIController();
    }
}
