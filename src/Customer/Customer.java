package Customer;

import Util.PrintHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerFullName;
    private String userName;
    private String password;
    private String iD_AccountNo;
    private static List<String> customerDetail;
    private static List<String> customerDetailsDB;


    public void createList() {
        customerDetail = new ArrayList<>();
        customerDetail.add(getCustomerFullName());
        customerDetail.add(getUserName());
        customerDetail.add(getPassword());
        customerDetail.add(getID_AccountNo());
        customerDB();

    }

    private void customerDB() {
        customerDetailsDB = new ArrayList<>();
        customerDetailsDB.add(String.valueOf(customerDetail));
        storeCustomerDetailsDB();

    }

    private void storeCustomerDetailsDB() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("customerbd.txt", true));
            bw.write(String.valueOf(customerDetail));
            bw.newLine();
            bw.write(String.valueOf(customerDetailsDB));
            bw.newLine();
            bw.close();
        } catch(IOException e) {
            System.out.println("File not found");
        }

    }

    public void validateCustomer(String userName, String password) {
        String enteredPassword = PrintHandler.messageDigest(password);
        // validate with txt file reading method to make it work on so many customers
         for (int i = 0; i < customerDetail.size(); i++) {
            if (userName.equals(customerDetail.get(1))) {
                if (enteredPassword.equals(customerDetail.get(2))) {
                    System.out.println("Valid user");
                    System.out.println(customerDetail);
                    System.out.println(customerDetailsDB);
                    System.out.println("can work next process");
                    // to go to other next functions in ATM
                }
            }
        }
    }



    public  String getCustomerFullName() {
        return this.customerFullName;
    }

   public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
       this.password = PrintHandler.messageDigest(password);
    }

    public  String getID_AccountNo() {
       return iD_AccountNo= "12345";
    }


    @Override
    public String toString() {
        return "Customer{}";
    }


}
