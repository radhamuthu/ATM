package homePage;

import customer.*;
import Util.PrintHandler;

import java.util.Scanner;

public class SignupPage extends CustomerValidation {
    public SignupPage (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Create account with our banking application.. ");
        Customer customer = new Customer();
        String fullName,userName,pass; boolean value= false;
                System.out.print("Enter the Customer Full Name :");
                fullName = PrintHandler.scanUserInput(sc.nextLine());
                customer.setCustomerFullName(fullName);
        do{
                System.out.print("Enter user name :");
                userName=PrintHandler.scanUserInput(sc.nextLine());
                for (String s : customerNameList) {
                    if (fullName.equalsIgnoreCase(s.trim())) {
                        System.out.println(" Sorry the User Name already exists. Please try with different Name .");
                        value = true;
                    }
                }
                }while(value);

            customer.setUserName(userName);
            System.out.print("Enter password : ");
            // for console use
            //   Console console = System.console();
            //   char[] password = console.readPassword();
            // String password2 = String.valueOf(password);
            pass = PrintHandler.scanUserInput(sc.nextLine());
            customer.setPassword(pass);

            //customer.setPassword(password2);
            System.out.println(" The Customer account is created Successfully for you ");
            customer.createList();
            System.out.println("You can hereafter choose login option for further process....");
            System.out.println("Wishing you a Safe banking ");
        }
}