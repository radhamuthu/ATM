package customer;

import Util.PrintHandler;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerFullName;
    private String userName;
    private String password;
    private  static String balance;
    protected static List<String> customerDetail;
    protected static List<String> customerDetailUpdate;

    public void createList() {
        customerDetail = new ArrayList<>();
        customerDetail.add(getCustomerFullName());
        customerDetail.add(getUserName());
        customerDetail.add(getPassword());
        customerDetail.add(getBalance());
        storeCustomerDetailsDB();
    }


    private void storeCustomerDetailsDB() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("customers.txt", true));
            bw.write(String.valueOf(customerDetail));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public String getCustomerFullName() {
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

    public String getBalance() {
        return this.balance = String.valueOf(0);
    }

    public static void setBalance(Double balance) {
        if (balance > 0) {
            Customer.balance = String.valueOf(balance);
        } else {
            Customer.balance = String.valueOf(0);
        }
    }
/*
    public static void updatelist() {
        customerDetailUpdate = new ArrayList<>();
        customerDetailUpdate.add(getCustomerFullName());
        customerDetailUpdate.add(getUserName());
        customerDetailUpdate.add(getPassword());
        customerDetailUpdate.add(getBalance());
        updateCustomerDetailsDB();
    }

    private void updateCustomerDetailsDB() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("customers.txt", true));

            bw.write(String.valueOf(customerDetailUpdate));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    } */
}
