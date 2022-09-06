package account;

import customer.CustomerDetailsUpdation;
import homePage.Home;

import java.util.List;

public class AccountModel  extends AccountOperation {

    private static final List<String>  menuOptions =List.of("Account Details","Withdraw Money","Deposit Money","Transfer Money","Logout");
    public List<String> getMenuOptions() {
        return menuOptions;
    }
    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
           switch (selectedOption) {
                case 1 -> new CustomerDetailsUpdation();
                case 2 -> withdrawAmount();
                case 3 -> depositAmount();
                case 4 -> transferAmount();
                case 5 -> logout();
            }
        new Account();
    } public void logout(){
        new Home();
    }

}
