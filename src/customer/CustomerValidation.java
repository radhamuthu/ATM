package customer;

import Util.PrintHandler;
import account.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
CustomerValidation to validate with username and password with  each other using reading from saved text file
with the help of arraylist CustomerName,UserName,Password and balance and using their position by using their index number where
it happened in  the list
 */
public class CustomerValidation {

    public static ArrayList<String> customerNameList = new ArrayList<>();
    public static ArrayList<String> userNameList = new ArrayList<>();
    public static ArrayList<String> passwordList = new ArrayList<>();
    public static ArrayList<String> balanceList = new ArrayList<>();
    static int customerNumber;

    private static boolean validatePassword(String enteredPassword, int i) {
        boolean value;
        if (enteredPassword.contentEquals((passwordList.get(i)))) {
            value = true;
        } else {
            System.out.println("Kindly check the Password you entered. Please try Login again.");
            value = false;
        }
        return value;
    }

    public void readCustomerList(String name) {
        customerNameList.clear();
        userNameList.clear();
        passwordList.clear();
        balanceList.clear();
        try {
            String file_path = name;
            File file = new File(file_path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                setList(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File must be there");
        }
    }

    void setList(String line) {
        String[] data = line.split(",");
        customerNameList.add(data[0].replace("[", ""));
        userNameList.add(data[1].trim());
        passwordList.add(data[2].trim());
        balanceList.add(data[3].replace("]", "").trim());

    }

    public void validateCustomerDetails(String userName, String password) {
        String name = userName;
        String enteredPassword = PrintHandler.messageDigest(password);
        readCustomerList("customers.txt");
        boolean value = true;
        for (int i = 0; i < userNameList.size(); i++) {
            if (name.contentEquals(userNameList.get(i))) {
                if (validatePassword(enteredPassword, i)) {
                    do {
                        customerNumber = i;
                        PrintHandler.clearScreen();
                        PrintHandler.showAppHeader();
                        System.out.println("Welcome to our ATM banking services");
                        System.out.println("Customer Name is  Mr/Mrs : " + customerNameList.get(i));
                        readCustomerList("customers.txt");
                        new Account();
                    }
                    while (value);
                }
            }
        }
        System.out.println("Kindly check the User Name and Password you entered. Please try Login again.");
    }

    public int getCustomerNumber() {
        return customerNumber;
    }


}
