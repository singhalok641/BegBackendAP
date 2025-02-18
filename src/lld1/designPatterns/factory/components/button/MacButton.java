package lld1.designPatterns.factory.components.button;

public class MacButton implements Button{
    @Override
    public void displayButton() {
        System.out.println("Mac Button");
    }
}
