package lld1.designPatterns.factory;

import lld1.designPatterns.factory.components.button.Button;
import lld1.designPatterns.factory.components.menu.Menu;

public interface UiFactory {
    // Factory methods

    Button createButton();
    Menu createMenu();
}
