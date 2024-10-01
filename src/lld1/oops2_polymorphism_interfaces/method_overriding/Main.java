package lld1.oops2_polymorphism_interfaces.method_overriding;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.doSomething("anything");

        a = new B();
        a.doSomething("anything");
    }
}