package customer;

import account.Account;
import Util.PrintHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerValidation {
    protected static ArrayList<String> customerNameList = new ArrayList<>();
     protected static ArrayList<String> userNameList = new ArrayList<>();
     protected static  ArrayList<String> passwordList = new ArrayList<>();
     protected static  ArrayList<String> balanceList = new ArrayList<>();
    protected static ArrayList<String> customerList = new ArrayList<>();
    static int customerNumber;

    protected static int getCustomerNumber() {
        return customerNumber;
    }

    public  void validateCustomerDetails(String userName, String password)   {
        String name = userName;
        String enteredPassword = PrintHandler.messageDigest(password);
        readCustomerList();
        for (int i = 0; i < userNameList.size(); i++) {
            if  (name.contentEquals(userNameList.get(i))){
                  if (validatePassword(enteredPassword,i)){
                      customerNumber = i;
                      PrintHandler.clearScreen();
                      PrintHandler.showAppHeader();
                      System.out.println("Welcome to our ATM banking services");
                      System.out.println("Customer Name is  Mr/Mrs : " + customerNameList.get(i));
                      new Account();
                  }

            }
        }System.out.println("Kindly check the User Name you entered. Please try Login again.");


    }

    private  boolean validatePassword(String enteredPassword , int i) {
        boolean value;
        if (enteredPassword.contentEquals((passwordList.get(i)))) {
            value= true;
        }
        else{
            System.out.println("Kindly check the Password you entered ,Please try Login again. ");
           value = false;
        }
        return value ;
    }

    private static void readCustomerList() {
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

    private static void setList(String line) {
        String[] data = line.split(",");
        customerNameList.add(data[0].replace("[",""));
        userNameList.add(data[1].trim());
        passwordList.add(data[2].trim());
        balanceList.add(data[3].replace("]","").trim());
        //customerList.add();
    }
}
