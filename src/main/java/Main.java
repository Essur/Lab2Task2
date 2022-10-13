import services.MainService;

public class Main {
    private final MainService mainService = new MainService();
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        mainService.mainMenu();
    }
}
