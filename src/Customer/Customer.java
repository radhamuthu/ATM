package Customer;

import Account.*;
import Util.PrintHandler;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private  String customerFullName;
    private  String userName;
    private  String password;
    private  final static String balance = "0.00";
    protected static List<String> customerDetail;

    public void createList() {
        customerDetail = new ArrayList<>();
        customerDetail.add(getCustomerFullName());
        customerDetail.add(getUserName());
        customerDetail.add(getPassword());
        customerDetail.add(balance);
        storeCustomerDetailsDB();
    }

    private void storeCustomerDetailsDB() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("customers.txt", true));
            bw.write(String.valueOf(customerDetail));
            bw.newLine();
            bw.close();
            } catch(IOException e) {
            System.out.println("File not found");
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

}
