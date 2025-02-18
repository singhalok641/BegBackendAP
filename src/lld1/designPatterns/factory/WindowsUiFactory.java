package lld1.designPatterns.factory;

import lld1.designPatterns.factory.components.button.Button;
import lld1.designPatterns.factory.components.button.WindowsButton;
import lld1.designPatterns.factory.components.menu.Menu;
import lld1.designPatterns.factory.components.menu.WindowsMenu;

import javax.swing.*;

public class WindowsUiFactory implements UiFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }


}
