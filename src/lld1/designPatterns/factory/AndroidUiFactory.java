package lld1.designPatterns.factory;

import lld1.designPatterns.factory.components.button.AndroidButton;
import lld1.designPatterns.factory.components.button.Button;
import lld1.designPatterns.factory.components.menu.AndroidMenu;
import lld1.designPatterns.factory.components.menu.Menu;

public class AndroidUiFactory implements UiFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
