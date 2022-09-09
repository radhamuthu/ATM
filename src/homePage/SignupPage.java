package homePage;

import Util.PrintHandler;
import customer.Customer;
import customer.CustomerValidation;

import java.io.Console;
import java.math.BigDecimal;
/*
SignupPage get customer full and customer name and password to set in Customers, while it also check
the entered  Customer name as well as username  is already there in the Customers list and ask for new input
 */

public class SignupPage extends CustomerValidation {
    public SignupPage() {

        System.out.println("Welcome to Create account with our banking application.. ");
        String fullName, userName, pass;
        BigDecimal balance;
        readCustomerList("customers.txt");
        boolean value = false;
        do {
            System.out.print("Enter the Customer Full Name :");
            fullName = PrintHandler.scanUserStringInput();
            for (String s : customerNameList) {
                if (fullName.equalsIgnoreCase(s.trim())) {
                    System.out.println(" Sorry the Customer Name already exists. Please try with different Name .");
                    value = true;
                }
            }
        } while (value);

        do {
            System.out.print("Enter user name :");
            userName = PrintHandler.scanUserStringInput();

            for (String s : customerNameList) {
                if (fullName.equalsIgnoreCase(s.trim())) {
                    System.out.println(" Sorry the User Name already exists. Please try with different Name .");
                    value = true;
                }
            }
        } while (value);
        System.out.print("Enter password : ");
        /*
         to run in terminal this below code is written
        for IDE there are lines next to it which are commented
         */

        Console console = System.console();
        char[] password = console.readPassword();
        String password2 = String.valueOf(password);
        pass =PrintHandler.messageDigest(password2);
        //pass = PrintHandler.messageDigest(PrintHandler.scanUserStringInput());
        balance = BigDecimal.valueOf(0.0);
        System.out.println(" The Customer account is created Successfully for you ");
        Customer customer = new Customer(fullName, userName, pass, balance);
        System.out.println("You can hereafter choose login option for further process....");
        System.out.println("Wishing you a Safe banking ");
    }
}
