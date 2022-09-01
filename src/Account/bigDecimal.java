package Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class bigDecimal {

    public static void main(String[] args){

        String h= "radha";
        ArrayList<String> name= new ArrayList<>();
        name.add(" radha");
        if (h.equals(name.get(0).trim())){
            System.out.println("true");
        }
        if (h.contentEquals((name.get(0).trim()))){
            System.out.println("222true");
        }
    }
}
