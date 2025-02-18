package lld1.designPatterns.factory;

import lld1.designPatterns.factory.components.button.Button;
import lld1.designPatterns.factory.components.menu.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();

        // From flutter, we are able to get the object of the corresponding Ui factory based on the platform
        UiFactory uiFactory = flutter.getUiFactory(Platform.ANDROID);

        Button button = uiFactory.createButton();
        button.displayButton();

        Menu menu = uiFactory.createMenu();
        menu.displayMenu();

    }
}
