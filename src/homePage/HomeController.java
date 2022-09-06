package homePage;

import Util.PrintHandler;

import java.util.Scanner;

public class HomeController extends PrintHandler {
    private final HomeModel model;
    private final HomeView view;
     Scanner scanner = new Scanner(System.in);
    public HomeController(HomeModel model, HomeView view) {
             this.model = model;
             this.view = view;
    }

    public void requestUserInput() {
            String input = scanner.nextLine();
            try {
                int selectedOption = Integer.parseInt(scanUserInput((input)));
                model.handleOption(selectedOption);
            }
            catch (NumberFormatException | IndexOutOfBoundsException exception) {
                onInvalidInput();
                requestUserInput();
            }
        }
    }

