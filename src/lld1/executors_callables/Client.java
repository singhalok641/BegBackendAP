package lld1.executors_callables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i=1; i<=100; i++){

            if(i == 5 || i == 11 || i == 20){
                System.out.println("DEBUG");
            }

            NumberPrinter numberPrinter = new NumberPrinter(i);
            executor.execute(numberPrinter);
        }

        executor.shutdown();
    }
}
