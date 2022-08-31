package Util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import java.io.IOException;
import java.util.InputMismatchException;

public class PrintHandler {
    public static void clearScreen() {
        String OperatingSystem = System.getProperty("os.name");

        if (OperatingSystem.toLowerCase().contains("windows")) {
            clearScreenWindows();
        } else {
            clearScreenUnix();
        }
    }

    private static void clearScreenUnix() {
        String clearScreenASCIICode = "\033[H\033[2J";

        System.out.print(clearScreenASCIICode);
        System.out.flush();
    }

    private static void clearScreenWindows() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException error) {
            System.out.println("");
        }
    }

    public static String scanUserInput(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new InputMismatchException();
        } else {
            return userInput;
        }
    }
    public static void printOptions(List<String> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;
            String label = options.get(index);

            System.out.println("[" + number + "] " + label);
        }
    }
    public static String messageDigest(String password) {
        String result ="";
        try{
            MessageDigest md =MessageDigest.getInstance("SHA-256");
            byte[] mdRet =md.digest(password.getBytes());
            result = Base64.getEncoder().encodeToString(mdRet);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void printBannerTitle() {
        System.out.println(" ====The ATM === ");
    }

}
