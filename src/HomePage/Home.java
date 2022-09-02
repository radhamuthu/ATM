package HomePage;
import java.io.Console;
import java.util.Scanner;
import Customer.Customer;
import Customer.ValidateCustomer;
import Util.PrintHandler;

public class Home {
       public Home() {
        HomeModel model = new HomeModel();
        HomeView view = new HomeView(model.getMenuOptions());
        HomeController controller = new HomeController(model,view);
        controller.requestUserInput();
    }
}
