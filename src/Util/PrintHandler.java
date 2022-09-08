package Util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
            System.out.println();
        }
    }

    public static String scanUserInput(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new InputMismatchException();
        } else {
            return userInput;
        }

    }

    public static String scanUserStringInput() {
        String userInput;
        try {
            Scanner sc = new Scanner(System.in);
            userInput = sc.nextLine();
            if (userInput.trim().isEmpty()) {
                throw new InputMismatchException();
            } else {
                return userInput;
            }

        } catch (InputMismatchException e) {
            showInvalidInput();
            System.out.print("Enter a valid input: ");
            scanUserStringInput();
        }
        return null;
    }

    public static void showMenuOptions(List<String> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;
            String label = options.get(index);

            System.out.println("[" + number + "] " + label);
        }
    }

    public static String messageDigest(String password) {
        String result ;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] mdRet = md.digest(password.getBytes());
            result = Base64.getEncoder().encodeToString(mdRet);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void showAppHeader() {
        System.out.println("The ATM  Banking service ");
        System.out.println();
    }

    public static void showEmptyLine() {
        System.out.println();
    }

    public static void exit() {
        System.out.println("Thanks for using our ATM Banking service.");
        System.exit(1);
    }

    public static void showAskUserForInput() {
        System.out.print("Choose an option and press enter: ");
    }

    public static void showInvalidInput() {
        System.out.println("⚠️ Invalid option");
    }

    protected static void onInvalidInput() {
        showInvalidInput();
        showAskUserForInput();
    }

    public static double scanUserNumberInput() {

        try {
            Scanner sc = new Scanner(System.in);
             String userInput = ((sc.nextLine()));
            if (userInput.trim().isEmpty()) {
                throw new InputMismatchException();
            } else {
                return Double.parseDouble(userInput);
            }

        } catch (InputMismatchException| NumberFormatException e) {
            showInvalidInput();
            System.out.print("Enter a valid input: ");
            scanUserNumberInput();
        }
        return 0;
    }
}
