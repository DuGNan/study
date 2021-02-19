package designMode.factory.abstractfactory;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class AndroidFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }

    @Override
    public UIController createInterfaceController() {
        return new AndroidUIController();
    }
}
