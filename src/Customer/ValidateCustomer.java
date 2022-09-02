package Customer;

import Account.Account;
import Util.PrintHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidateCustomer {
    protected static ArrayList<String> customerList = new ArrayList<>();
    static ArrayList<String> userList = new ArrayList<>();
    static ArrayList<String> passwordList = new ArrayList<>();

    public  void validateCustomerDetails(String userName, String password)   {
        String name = userName;
        String enteredPassword = PrintHandler.messageDigest(password);
        getUserList();
        for (int i = 0; i < userList.size(); i++) {
            if  (name.contentEquals(userList.get(i).trim())){
                  if (validatePassword(enteredPassword,i)){
                      PrintHandler.clearScreen();
                      PrintHandler.showAppHeader();
                      System.out.println(" Welcome to our ATM banking services");
                      System.out.println("Customer Name is  Mr/Mrs : " + customerList.get(i));
                      Account.displayMenu();
                  }

            }
        }System.out.println("Kindly check the User Name you entered. Please try Login again.");


    }

    public ValidateCustomer() {
        getUserList();
    }


    public  boolean validatePassword(String enteredPassword , int i) {
        boolean value;
        if (enteredPassword.contentEquals((passwordList.get(i).trim()))) {
            value= true;
        }
        else{
            System.out.println("Kindly check the Password you entered ,Please try Login again. ");
           value = false;
        }
        return value ;
    }




    private void getUserList() {
        try{File file = new File("customers.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            setList(line);
        }
    }catch(FileNotFoundException e){
            System.out.println("File must be there");
        }
    }

    private void setList(String line) {
        String[] data = line.split(",");
        customerList.add(data[0]);
        userList.add(data[1]);
        passwordList.add(data[2]);

    }
}
