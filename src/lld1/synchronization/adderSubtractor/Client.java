package lld1.synchronization.adderSubtractor;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        // This waits for thread t1 and t2 to finish execution
        t1.join();
        t2.join();

        System.out.println(count.value);


    }
}
