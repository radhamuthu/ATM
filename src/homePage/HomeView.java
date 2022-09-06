package homePage;

import Util.PrintHandler;

import java.util.List;

public class HomeView extends PrintHandler {
    public HomeView(List<String> menuOptions) {
        clearScreen();
        showAppHeader();
        System.out.println("Welcome to our HomePage ") ;
        showEmptyLine();
        System.out.println("The Menu options are ");
        showMenuOptions(menuOptions);
        showAskUserForInput();

    }
}

