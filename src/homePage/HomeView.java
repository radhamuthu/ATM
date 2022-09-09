package homePage;

import Util.PrintHandler;

import java.util.List;
/*
HomeView to print the menu options of home
 */
public class HomeView extends PrintHandler {
    public HomeView(List<String> menuOptions) {
        clearScreen();
        showAppHeader();
        System.out.println("Welcome to our HomePage ");
        showEmptyLine();
        System.out.println("The Menu options are ");
        showMenuOptions(menuOptions);
        showAskUserForInput();

    }
}

