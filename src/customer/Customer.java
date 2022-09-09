package customer;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String customerFullName;
    private static String userName;
    private static String password;
    private static BigDecimal balance;
    protected static List<String> customerDetail;


    public Customer(String customerFullName, String userName, String password, BigDecimal balance) {
        this.customerFullName = customerFullName;
        Customer.userName = userName;
        this.password = password;
        this.balance = balance;
        createList();
    }


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


    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }



    public static String getBalance() {
        return String.valueOf(balance);
    }

    public static void setBalance(BigDecimal balance) {
        if (balance.doubleValue() > 0.0) {
           Customer.balance = balance;
        } else Customer.balance = BigDecimal.valueOf(0.0);
    }

    public static void updatefile(int number, String newLine) throws IOException {
        int line = 0;
        String currentLine;
        String oldLine ="";
        File file = new File("customers.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (number == line) {
                    oldLine = currentLine;
                    Path path = Paths.get("customers.txt");
                    Charset charset = StandardCharsets.UTF_8;

                    String content = Files.readString(path, charset);
                    content = content.replace(oldLine, newLine);
                    Files.writeString(path, content, charset);
                }
                line++;
            }bufferedReader.close();



    }
}
