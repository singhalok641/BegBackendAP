package lld1.oops2_polymorphism_interfaces.interfaces;

public class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("cat is eating");
    }

    @Override
    public void walk() {
        System.out.println("Cat is walking");
    }

    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    public void meow(){
        System.out.println("Meow, meow :)");
    }
}
