package Account;
import Customer.Customer;
import Login.Login;
import Util.PrintHandler;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account extends Customer {
    static BigDecimal accountBalance;
    static BigDecimal bigDecimalUserInputAmount;
    static List<String>  accountList = new ArrayList<>();
    private static final List<String>  menuOptions =List.of("Account Details","Withdraw Money","Deposit Money","Transfer Money","Logout");
    private static  final Scanner sc = new Scanner(System.in);




    public static void displayMenu() {
        PrintHandler.printOptions(menuOptions);
        addAccountList();
        System.out.print("Choose your option :");//handle input mismatch error since it showing in screen!!!!!!!!!!!!!!!!
        switch (Integer.parseInt(PrintHandler.scanUserInput(sc.nextLine()))) {
            case 1 -> displayAccountDetails();
            case 2 -> withdrawAmount();
            case 3 -> depositAmount();
            case 4 -> transferAmount();
            case 5 -> logout();
            default -> displayMenu();
        }
        displayMenu();
    }

    private static void logout() {
      new  Login();
    }

    private static void transferAmount() {
        PrintHandler.clearScreen();
        PrintHandler.printBannerTitle();
    }

    private static void depositAmount() {
        PrintHandler.clearScreen();
        PrintHandler.printBannerTitle();
        // read from file DB to  take the line which customer we dealing with customer fullname  get balance
        System.out.print("Please enter the amount you want to deposit to your account :");
        bigDecimalUserInputAmount =new BigDecimal(PrintHandler.scanUserInput(String.valueOf(sc.nextLine())));
        accountBalance = accountBalance.add(bigDecimalUserInputAmount);
        // update the file using write option
    }

    private static void withdrawAmount() {
        PrintHandler.clearScreen();
        PrintHandler.printBannerTitle();
        // read from file DB to  take the line which customer we dealing with customer fullname  get balance
        System.out.print("Please enter the amount you want to withdraw from  your account :");
        bigDecimalUserInputAmount =new BigDecimal(PrintHandler.scanUserInput(String.valueOf(sc.nextLine())));
        accountBalance = accountBalance.subtract(bigDecimalUserInputAmount);
        // update the file using write option

    }

    private static void displayAccountDetails() {
        PrintHandler.clearScreen();
        PrintHandler.printBannerTitle();

        // read from file DB to  take the line which customer we dealing with customer fullname  get balance
        System.out.print("The account details are :");

        // update the file using write option
    }
    private static void addAccountList(){
       // read from file write in customerd

        accountList.add(String.valueOf(customerDetail));

    }
}
