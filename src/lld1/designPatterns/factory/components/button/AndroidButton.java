package lld1.designPatterns.factory.components.button;

public class AndroidButton implements Button{
    @Override
    public void displayButton() {
        System.out.println("Android Button");
    }
}
