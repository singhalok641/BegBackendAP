package lld1.designPatterns.factory.components.button;

public class WindowsButton implements Button{
    @Override
    public void displayButton() {
        System.out.println("Windows Button");
    }
}
