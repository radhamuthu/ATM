package Account;
import HomePage.Home;
import Util.PrintHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {

    public Account(ArrayList<String> customerSelected) {
        AccountModel model = new AccountModel(customerSelected);
        AccountView view = new AccountView(model.getMenuOptions());
        AccountController controller = new AccountController(model, view);
        controller.requestUserInput();
    }
}
