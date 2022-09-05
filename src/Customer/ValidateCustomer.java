package Customer;

import Account.Account;
import Util.PrintHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidateCustomer {
    protected static ArrayList<String> customerNameList = new ArrayList<>();
    private static ArrayList<String> userNameList = new ArrayList<>();
    private static ArrayList<String> passwordList = new ArrayList<>();
    private static ArrayList<String> balanceList = new ArrayList<>();
    private static ArrayList<String> customerList = new ArrayList<>();

    public  void validateCustomerDetails(String userName, String password)   {
        String name = userName;
        String enteredPassword = PrintHandler.messageDigest(password);
        readCustomerList();
        for (int i = 0; i < userNameList.size(); i++) {
            if  (name.contentEquals(userNameList.get(i))){
                  if (validatePassword(enteredPassword,i)){
                      PrintHandler.clearScreen();
                      PrintHandler.showAppHeader();
                      System.out.println("Welcome to our ATM banking services");
                      System.out.println("Customer Name is  Mr/Mrs : " + customerList.get(i));
                      ArrayList<String> customerSelected = new ArrayList();
                      customerSelected.add(customerNameList.get(i));
                      customerSelected.add(userNameList.get(i));
                      customerSelected.add(passwordList.get(i));
                      customerSelected.add(balanceList.get(i));
                      new Account(customerSelected);
                  }

            }
        }System.out.println("Kindly check the User Name you entered. Please try Login again.");


    }

    public ValidateCustomer() {
        readCustomerList();
    }


    public  boolean validatePassword(String enteredPassword , int i) {
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




    private void readCustomerList() {
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
        customerNameList.add(data[0].replace("[",""));
        userNameList.add(data[1].trim());
        passwordList.add(data[2].trim());
        balanceList.add(data[3].replace("]","").trim());

    }
}
