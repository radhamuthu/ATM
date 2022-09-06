package homePage;
import customer.CustomerValidation;
import Util.PrintHandler;

import java.util.Scanner;

public class LoginPage extends CustomerValidation {
    public LoginPage(){
        Scanner sc = new Scanner(System.in);
        String userName,pass;
        System.out.println("");
        System.out.println("*** Welcome *** ");
        System.out.println("Please login ");
        System.out.println("");
        System.out.print("Enter user name : ");
        userName =PrintHandler.scanUserInput(sc.nextLine());
        System.out.print("Enter password : ");
        //PrintHandler.showEmptyLine();
        // switch to console while working this code
        //Console console = System.console();
        //char[] password = console.readPassword();
        //String password2 = String.valueOf(password);
        pass =PrintHandler.scanUserInput(sc.nextLine());
        validateCustomerDetails(userName, pass);
    }

}
