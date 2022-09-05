package Account;

import Util.PrintHandler;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction  {
    static BigDecimal accountBalance;
    static BigDecimal bigDecimalUserInputAmount;


    private static  final Scanner sc = new Scanner(System.in);

    public Transaction(ArrayList<String> customer) {
        String customerFullName=customer.get(0);
        String customerUserName = customer.get(1);
        String customerPassword = customer.get(2);
        String customerBalance =customer.get(3);
        accountBalance = BigDecimal.valueOf(Double.parseDouble(customerBalance));
    }

    public static void withdrawAmount() {
        PrintHandler.clearScreen();
        PrintHandler.showAppHeader();

        System.out.print("Please enter the amount you want to withdraw from  your account : ");
        bigDecimalUserInputAmount =new BigDecimal(PrintHandler.scanUserInput(String.valueOf(sc.nextLine())));
       // if (accountBalance >= bigDecimalUserInputAmount) {import java.math.BigDecimal;fix this
            accountBalance = accountBalance.subtract(bigDecimalUserInputAmount);
        //}else
       // System.out.println("Not enough balance to withdraw..");
    }

    public static void depositAmount() {
        PrintHandler.clearScreen();
        PrintHandler.showAppHeader();
        // read from file DB to  take the line which customer we dealing with customer fullname  get balance
        System.out.print("Please enter the amount you want to deposit to your account :");
        bigDecimalUserInputAmount =new BigDecimal(PrintHandler.scanUserInput(String.valueOf(sc.nextLine())));
        accountBalance = accountBalance.add(bigDecimalUserInputAmount);
        // update the file using write option
    }

    public static void transferAmount() {
    }

    public static void displayAccountDetails(){

    }
}
