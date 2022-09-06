package account;

import Util.PrintHandler;
import customer.Customer;
import customer.CustomerValidation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class AccountOperation extends CustomerValidation {
     static String customerFullName,customerUserName,customerPassword,customerBalance;
     static BigDecimal accountBalance;
     static BigDecimal bigDecimalUserInputAmount;
    private static  final Scanner sc = new Scanner(System.in);
    HashMap<String ,BigDecimal > customerMap = new HashMap<String, BigDecimal>();

    public AccountOperation() {
        int number = getCustomerNumber();
        customerFullName=customerNameList.get(number);
        customerUserName = userNameList.get(number);
        customerPassword = passwordList.get(number);
        customerBalance =balanceList.get(number);
        accountBalance =  new BigDecimal(customerBalance);
        customerMap.put("customerFullName",accountBalance);
    }

    public  void withdrawAmount() {
        accountBalance = customerMap.get("customerFullName");
        System.out.print("Please enter the amount you want to withdraw from  your account : ");
        bigDecimalUserInputAmount =new BigDecimal(PrintHandler.scanUserInput(String.valueOf(sc.nextLine())));
       if (accountBalance.compareTo(bigDecimalUserInputAmount) >= 0){
            accountBalance = accountBalance.subtract(bigDecimalUserInputAmount);
       }else{
           System.out.println("The balance is less than withdraw amount");
       }
       System.out.println(" new available balance "+ accountBalance);
        customerMap.put("customerFullName",accountBalance);

    }

    public  void depositAmount() {
        accountBalance = customerMap.get("customerFullName");
        System.out.print("Please enter the amount you want to deposit to your account :");
        bigDecimalUserInputAmount =new BigDecimal(PrintHandler.scanUserInput(String.valueOf(sc.nextLine())));
        accountBalance = accountBalance.add(bigDecimalUserInputAmount);
        System.out.println(" new available balance "+ accountBalance);
        customerMap.put("customerFullName",accountBalance);


    }

    public  void transferAmount() {
        accountBalance = customerMap.get("customerFullName");
        System.out.print("Enter the Unique user name  :");
        String transferUsername= PrintHandler.scanUserInput(sc.nextLine());
        System.out.print("Enter transfer amount  :");
        BigDecimal tranferAmount = new BigDecimal(PrintHandler.scanUserInput(sc.nextLine()));
       if (accountBalance.compareTo(tranferAmount) >= 0){
            accountBalance = accountBalance.subtract(tranferAmount);
        }else{
            System.out.println("The balance is less then transfer amount");
        }
        System.out.println(" new available balance "+ accountBalance);
        customerMap.put("customerFullName",accountBalance);
        }



}
