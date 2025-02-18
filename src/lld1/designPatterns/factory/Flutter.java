package lld1.designPatterns.factory;

public class Flutter {
    // Non-factory methods

    void refreshUi(){
        System.out.println("Refreshing UI");
    }

    void setTheme(){
        System.out.println("Theme set");
    }

    public UiFactory getUiFactory(Platform platform){
        return UiFactoryFactory.getUiFactory(platform);
    }
}
