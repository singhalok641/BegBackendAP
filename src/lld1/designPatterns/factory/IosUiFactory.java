package lld1.designPatterns.factory;

import lld1.designPatterns.factory.components.button.Button;
import lld1.designPatterns.factory.components.button.IosButton;
import lld1.designPatterns.factory.components.menu.IosMenu;
import lld1.designPatterns.factory.components.menu.Menu;

public class IosUiFactory implements UiFactory{
    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public Menu createMenu() {
        return new IosMenu();
    }
}
