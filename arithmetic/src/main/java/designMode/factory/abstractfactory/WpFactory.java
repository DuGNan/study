package designMode.factory.abstractfactory;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class WpFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new WpOperationController();
    }

    @Override
    public UIController createInterfaceController() {
        return new WpUIController();
    }
}
