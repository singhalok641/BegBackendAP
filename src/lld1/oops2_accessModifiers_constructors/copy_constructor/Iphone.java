package lld1.oops2_accessModifiers_constructors.copy_constructor;

public class Iphone {
    public int number; // increases by 1
    public int processorVersion; // increases by 1
    public int price; // price increases by 10k

    // all below attributes remain the same
    public int batterySize;
    public int screenSize;
    public int numberOfCameras;
    public int megapixels;
    public int memory;
    public String displayType;
    public String dimensions;

    public Iphone(){ // no-args constructor

    }

    // parameterised constructor
    public Iphone(int inumber, int iprocessorVersion, int iprice, int ibatterySize, int iscreenSize,
                  int inumberOfCameras, int imegapixels, int imemory,
                  String idisplayType, String idimensions) {
        number = inumber;
        processorVersion = iprocessorVersion;
        price = iprice;
        batterySize = ibatterySize;
        screenSize = iscreenSize;
        numberOfCameras = inumberOfCameras;
        megapixels = imegapixels;
        memory = imemory;
        displayType = idisplayType;
        dimensions = idimensions;
    }


    // copy constructor
    public Iphone(Iphone iphone){
        number = iphone.number + 1;
        processorVersion = iphone.processorVersion + 1;
        price = iphone.price + 10000;
        batterySize = iphone.batterySize;
        screenSize = iphone.screenSize;
        numberOfCameras = iphone.numberOfCameras;
        megapixels = iphone.megapixels;
        memory = iphone.memory;
        displayType = iphone.displayType;
        dimensions = iphone.dimensions;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "number=" + number +
                ", processorVersion=" + processorVersion +
                ", price=" + price +
                ", batterySize=" + batterySize +
                ", screenSize=" + screenSize +
                ", numberOfCameras=" + numberOfCameras +
                ", megapixels=" + megapixels +
                ", memory=" + memory +
                ", displayType='" + displayType + '\'' +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }
}
