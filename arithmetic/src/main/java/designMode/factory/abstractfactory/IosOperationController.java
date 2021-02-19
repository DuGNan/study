package designMode.factory.abstractfactory;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class IosOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("IosOperationController");
    }
}
