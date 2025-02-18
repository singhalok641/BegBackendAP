package lld1.designPatterns.factory;

// This is kind of a helper class
public class UiFactoryFactory {

    // Factory method to get the object of the corresponding UIFactory
    public static UiFactory getUiFactory(Platform platform){
        if(platform.equals(Platform.IOS)){
            return new IosUiFactory();
        }
        else if(platform.equals(Platform.WINDOWS)){
            return new WindowsUiFactory();
        }
        else if(platform.equals(Platform.ANDROID)){
            return new AndroidUiFactory();
        }
        return null;
    }
}
