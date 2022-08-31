package Login;
import java.util.Scanner;
import Customer.Customer;
import Util.PrintHandler;
import java.util.List;

public class Login {
    Scanner sc = new Scanner(System.in);
    private static final List<String> menuOption = List.of("SignUp (To become a customer)", "Login (Already a customer)", "Exit");

    public Login() {

        PrintHandler.clearScreen();
        PrintHandler.printBannerTitle();
        PrintHandler.printOptions(menuOption);
        System.out.print("Choose your option :");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1 -> getCustomerDetails();

            case 2 -> getLoginDetails();
            case 3 -> exit();
            default -> new Login();
        }
        new Login();
    }

    private void exit() {
        sc.close();
        System.exit(1);
    }

    private void getLoginDetails(){
        PrintHandler.clearScreen();
        PrintHandler.printBannerTitle();
        String userName,password;
        Customer customer = new Customer();
        System.out.print("Enter user name :");
        userName=PrintHandler.scanUserInput(sc.nextLine());
        System.out.print("Enter password : ");
        password =PrintHandler.scanUserInput(sc.nextLine());
        customer.validateCustomer(userName,password);
    }

    private void getCustomerDetails(){
        PrintHandler.clearScreen();
        PrintHandler.printBannerTitle();
        Customer customer = new Customer();
        String fullName,userName,password;
        System.out.print("Enter Full Name of the Customer :");
        fullName = PrintHandler.scanUserInput(sc.nextLine());
        customer.setCustomerFullName(fullName);
        System.out.print("Enter user name :");
        userName=PrintHandler.scanUserInput(sc.nextLine());
        customer.setUserName(userName);
        System.out.print("Enter password : ");
        password =PrintHandler.scanUserInput(sc.nextLine());
        customer.setPassword(password);
        System.out.println(" The account  is created ");
        customer.createList();
        //getLoginDetails();

    }
}
