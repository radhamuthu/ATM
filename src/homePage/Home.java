package homePage;

public class Home {
    public Home() {
        HomeModel model = new HomeModel();
        HomeView view = new HomeView(model.getMenuOptions());
        HomeController controller = new HomeController(model, view);
        controller.requestUserInput();
    }
}
