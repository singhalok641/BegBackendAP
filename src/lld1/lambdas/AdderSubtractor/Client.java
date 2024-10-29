package lld1.lambdas.AdderSubtractor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

//        Adder adder = new Adder(count);
//        Subtractor subtractor = new Subtractor(count);

        // Lambda
        /*
        1. Creates an anonymous class -> adderLambdaAnonymous
        2. It will implement the interface Runnable in the Anonymous class it created
        3. It will pass all the variables being shared.
        4. It will copy the code from the lambda body into the method we implement in the
        anonymous class.
        * */

        Runnable adderLambda = () -> {
            for(int i=1; i<=10000 ; i++){
                synchronized (count) {
                    count.value += i;
                }
            }
        };

        // Animal
        // Dog implements Animal
        // Animal a = new Dog();

        Runnable subtractorLambda = () -> {
            for(int i=1; i<=10000 ; i++){
                synchronized (count) {
                    count.value -= i;
                }
            }
        };

        Thread t1 = new Thread(adderLambda);
        Thread t2 = new Thread(subtractorLambda);

        t1.start();
        t2.start();

        // This waits for thread t1 and t2 to finish execution
        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
