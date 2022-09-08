package homePage;

import Util.PrintHandler;

import java.util.List;

public class HomeModel {
    private static final List<String> menuOptions = List.of("SignUp (To become our customer)", "Login (Already our customer)", "Exit");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> new SignupPage();
            case 2 -> new LoginPage();
            case 3 -> PrintHandler.exit();
            default -> throw new IndexOutOfBoundsException();
        }
        new Home();
    }

}

