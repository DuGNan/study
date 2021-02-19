package designMode.factory.abstractfactory;

/**
 * @author dugn
 * @Date
 * @Description
 */
public interface SystemFactory {
    public OperationController createOperationController();

    public UIController createInterfaceController();
}
