package HomePage;
import Customer.ValidateCustomer;

import Util.PrintHandler;
import java.io.Console;
import java.util.Scanner;

public class LoginPage extends ValidateCustomer {
    public LoginPage(){
        Scanner sc = new Scanner(System.in);
        String userName,pass;
        System.out.println("Welcome to our LoginPage - Inorder to help you in your banking services please login ");
        System.out.println("");
        System.out.print("Enter user name : ");
        userName =PrintHandler.scanUserInput(sc.nextLine());
        System.out.print("Enter password : ");
        // switch to console while working this code
        //Console console = System.console();
        //char[] password = console.readPassword();
        //String password2 = String.valueOf(password);
        pass =PrintHandler.scanUserInput(sc.nextLine());
        validateCustomerDetails(userName, pass);
    }

}
