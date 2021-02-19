package designMode.factory.abstractfactory;

/**
 * @author dugn
 * @Date
 * @Description
 */
public class IosUIController implements UIController {
    @Override
    public void display() {
        System.out.println("IosInterfaceController");
    }
}