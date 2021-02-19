package designMode.factory.abstractfactory;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class AndroidOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("AndroidOperationController");
    }
}