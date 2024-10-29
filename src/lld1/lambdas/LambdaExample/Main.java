package lld1.lambdas.LambdaExample;

public class Main {
    public static void main(String[] args) {
        // V1
        // I have to create a separate class SomethingDoer for this
        SomethingDoer somethingDoer = new SomethingDoer();
        Thread t1 = new Thread(somethingDoer);
        t1.start();

        // V2
        Runnable runnable = () -> {
            System.out.println("Do something v1");
        };
        Thread t2 = new Thread(runnable);
        t2.start();

        // V3
        Thread t3 = new Thread(
                () -> {
                    System.out.println("Do something v1");
                }
        );
        t3.start();
    }
}
