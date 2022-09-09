package account;

import Util.PrintHandler;
import customer.Customer;

import java.io.Console;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AccountDetails extends AccountOperation {
    private static final List<String> menuOptions = List.of("View Balance", "Change User Name", "Change Password");
    Scanner sc = new Scanner(System.in);

    public AccountDetails() {

        PrintHandler.showMenuOptions(menuOptions);
        PrintHandler.showAskUserForInput();

        try {
            int input = Integer.parseInt(PrintHandler.scanUserInput(sc.nextLine()));
            switch (input) {
                case 1 -> viewBalance();
                case 2 -> changeUserName();
                case 3 -> changePassword();

            }
        } catch (NumberFormatException | IndexOutOfBoundsException | InputMismatchException | IOException exception) {
            System.out.print("Enter a valid input");
            new AccountDetails();
        }
    }

    private static boolean validPassword(String enteredPassword, int i) {
        boolean value;
        if (enteredPassword.contentEquals((passwordList.get(i)))) {
            value = true;
        } else {
            System.out.println("Kindly check the Password you entered. Please try Login again.");
            value = false;
        }
        return value;
    }

    private void changeUserName() throws IOException {
        if (changeUserDetails()) {
            boolean value = false;
            String newUserName;
            do {
                System.out.print("Enter user name :");
                newUserName = PrintHandler.scanUserInput(sc.nextLine());
                for (String s : customerNameList) {
                    if (newUserName.equalsIgnoreCase(s.trim())) {
                        System.out.println(" Sorry the User Name already exists. Please try with different Name .");
                        value = true;
                    }
                }
            } while (value);

            String newLine = (customerFullName + "," + newUserName + "," + customerPassword + "," + accountBalance);
            try {
                Customer.updatefile(number, newLine);
                System.out.println("Updated Successfully");
            } catch (IOException e) {
                System.out.println("error in updating user name");
            }
        }
    }

    private void changePassword() throws IOException {
        if (changeUserDetails()) {
            System.out.print(" Enter new password : ");
            String newPassword = PrintHandler.messageDigest(PrintHandler.scanUserInput(sc.nextLine()));
            String newLine = (customerFullName + "," + customerUserName + "," + newPassword + "," + accountBalance);
            try {
                Customer.updatefile(number, newLine);
                System.out.println("Updated Successfully");
            } catch (IOException e) {
                System.out.println("error in updating password");
            }
        } else {
            System.out.println("CAnt perform the operation since the credits entered were wrong");
        }
    }


    private void viewBalance() {

        System.out.println("The account User name is Mr/Mrs :" + customerFullName);
        System.out.println("The account balance in SEK" + accountBalance);
    }

    private boolean changeUserDetails() {
        System.out.print("Enter your old User name :");
        String enteredUserName = PrintHandler.scanUserInput(sc.nextLine());
        System.out.print("Enter your old password : ");
        // for terminal use  - uncomment next code and comment scanner input and change parameters in validateCustomer details
        Console console = System.console();
        char[] password = console.readPassword();
        String password2 = String.valueOf(password);
        String enteredPasswordHashValue = PrintHandler.messageDigest(password2);
        // for IDE
        //String enteredPassword = PrintHandler.scanUserInput(sc.nextLine());
        //String enteredPasswordHashValue = PrintHandler.messageDigest(enteredPassword);

        readCustomerList("customers.txt");
        boolean value = false;
        for (int i = 0; i < userNameList.size(); i++) {
            if (enteredUserName.contentEquals(userNameList.get(i))) {
                if (validPassword(enteredPasswordHashValue, i)) {
                    return true;
                }
            }
        }
        return value;
    }
}
