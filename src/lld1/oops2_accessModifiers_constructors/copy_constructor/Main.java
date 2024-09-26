package lld1.oops2_accessModifiers_constructors.copy_constructor;

public class Main {
    public static void main(String[] args) {
        Iphone iphone11 = new Iphone();
        Iphone iphone12 = new Iphone(12, 13, 65000,
                5000, 6, 3,
                12, 64, "OLED",
                "6 * 4 * 2");


        Iphone iphone13 = new Iphone(iphone12);

        System.out.println(iphone11.toString());
        System.out.println(iphone12.toString());
        System.out.println(iphone13.toString());
    }
}
