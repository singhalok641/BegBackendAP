package lld1.streams;

import java.util.ArrayList;
import java.util.List;

public class LazyEvaluationSecondExample {
    public static void main(String[] args) {
        // We want to understand the effect if lazy evaluation on performance

        List<Integer> largeNumbers = new ArrayList<>();

        for(int i=1;i<=100 ;i++){
            largeNumbers.add(i);
        }

        largeNumbers.stream()
                .filter(n->{
                    try {
                        System.out.println(n);
                        Thread.sleep(50); // simulating a expensive operation
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return n % 2 == 0;
                })
                .limit(5) //limit output to first 5 matches
                .forEach(System.out::println);
    }
}
