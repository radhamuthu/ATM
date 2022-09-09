package homePage;

import Util.PrintHandler;
import customer.CustomerValidation;

import java.util.Scanner;

public class LoginPage extends CustomerValidation {
    public LoginPage() {
        Scanner sc = new Scanner(System.in);
        String userName, pass;
        System.out.println();
        System.out.println("*** Welcome *** ");
        System.out.println("Please login ");
        System.out.println();
        System.out.print("Enter user name : ");
        userName = PrintHandler.scanUserInput(sc.nextLine());
        System.out.print("Enter password : ");

        // switch to terminal while working this code
        //Console console = System.console();
        //char[] password = console.readPassword();
        //String password2 = String.valueOf(password);
        //validateCustomerDetails(userName, password2);
        // for IDE uncomment the below
        pass = PrintHandler.scanUserInput(sc.nextLine());
        validateCustomerDetails(userName, pass);
    }

}
