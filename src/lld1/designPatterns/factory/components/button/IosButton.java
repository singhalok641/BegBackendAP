package lld1.designPatterns.factory.components.button;

public class IosButton implements Button{
    @Override
    public void displayButton() {
        System.out.println("Ios Button");
    }
}
