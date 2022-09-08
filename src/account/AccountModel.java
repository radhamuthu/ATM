package account;

import homePage.Home;

import java.io.IOException;
import java.util.List;

public class AccountModel  {

    private static final List<String> menuOptions = List.of("Account Settings", "Withdraw Money", "Deposit Money", "Transfer Money", "Logout");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException, IOException {
        AccountOperation accountOperation = new AccountOperation();

        switch (selectedOption) {
            case 1 -> accountOperation.accountSettings();
            case 2 -> accountOperation.withdrawAmount();
            case 3 -> accountOperation.depositAmount();
            case 4 -> accountOperation.transferAmount();
            case 5 -> logout();
        }

    }

    public void logout() {
        new Home();
    }

}
