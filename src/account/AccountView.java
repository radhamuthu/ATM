package account;

import Util.PrintHandler;

import java.util.List;

public class AccountView extends PrintHandler {
    public AccountView(List<String> menuOptions) {
        showEmptyLine();
        System.out.println("The Menu options are ");
        showMenuOptions(menuOptions);
        showAskUserForInput();

    }
}
