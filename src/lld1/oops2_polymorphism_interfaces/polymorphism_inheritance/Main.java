package lld1.oops2_polymorphism_interfaces.polymorphism_inheritance;

import java.util.Random;

public class Main {

    public static A getObject(){
        Random random = new Random(10);

        // random.nextInt() generates random numbers b\w 1 to 10
        // 1 to 10  || 5 even numbers || 5 odd numbers
        int number = random.nextInt(10);
        if(number % 2 == 0) {
            // even number
            return new C();
        }

        // odd number
        return new B();
    }

    public static void main(String[] args) {

        // an object of type C
        // storing it in a variable of type A
//        A a1 = new C();

         A a1 = getObject();

        /// compiler only allows you to access the
        // variables of the data type of the object
        a1.age = 21;
        a1.name = "Alok";
//        a1.companyName = "Google";

        // will the object C be created at compile time or at run-time?


        A a2 = new B();
        C c = new C();




    }
}
