package Account;

import Util.PrintHandler;

import java.util.List;

public class AccountView extends PrintHandler {
    public AccountView(List<String> menuOptions) {
        clearScreen();
        showAppHeader();
        System.out.println("Welcome to our ATM services ") ;
        showEmptyLine();
        System.out.println("The Menu options are ");
        showMenuOptions(menuOptions);
        showAskUserForInput();
       // addAccountList(); addAccountList(); addAccountList();
    }
}
