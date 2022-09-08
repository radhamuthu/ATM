package homePage;

import Util.PrintHandler;
import customer.Customer;
import customer.CustomerValidation;
import java.math.BigDecimal;


public class SignupPage extends CustomerValidation {
    public SignupPage() {

        System.out.println("Welcome to Create account with our banking application.. ");
        String fullName, userName, pass;
        BigDecimal balance;
        boolean value = false;
        System.out.print("Enter the Customer Full Name :");
        fullName = PrintHandler.scanUserStringInput();
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
        // for console use
        //   Console console = System.console();
        //   char[] password = console.readPassword();
        // String password2 = String.valueOf(password);
        pass = PrintHandler.messageDigest(PrintHandler.scanUserStringInput());
        balance = BigDecimal.valueOf(0.0);


        //customer.setPassword(password2);
        System.out.println(" The Customer account is created Successfully for you ");
        Customer customer = new Customer(fullName,userName,pass,balance);
        System.out.println("You can hereafter choose login option for further process....");
        System.out.println("Wishing you a Safe banking ");
    }
}
