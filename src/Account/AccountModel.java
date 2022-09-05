package Account;

import HomePage.Home;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {

    private static final List<String>  menuOptions =List.of("Account Details","Withdraw Money","Deposit Money","Transfer Money","Logout");
    private static final ArrayList<String> customer = new ArrayList<>();
    public AccountModel(ArrayList<String> customerSelected) {
        for (String s : customerSelected) {
            customer.add(String.valueOf(s));
        }

    }

    public List<String> getMenuOptions() {
        return menuOptions;
    }
    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
             new Transaction(customer);
            case 1 -> Transaction.displayAccountDetails();
            case 2 -> Transaction.withdrawAmount();
            case 3 -> Transaction.depositAmount();
            case 4 -> Transaction.transferAmount();
            case 5 -> logout();
        }

    } public void logout(){
        new Home();
    }

}
