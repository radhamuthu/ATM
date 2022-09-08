package account;

import Util.PrintHandler;

import java.util.List;

public class AccountView  {
    public AccountView(List<String> menuOptions) {
        PrintHandler.showEmptyLine();
        System.out.println("The Menu options are ");
        PrintHandler.showMenuOptions(menuOptions);
        PrintHandler.showAskUserForInput();

    }
}
