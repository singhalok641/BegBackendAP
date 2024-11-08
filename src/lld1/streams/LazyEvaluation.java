package lld1.streams;

import java.util.List;

public class LazyEvaluation {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        numbers.stream()
                .map(n -> {
                    System.out.println("Doubling " + n);
                    return n * 2;
                })
                .filter(n -> {
                    System.out.println("Filtering " + n);
                    return n > 5;
                })
                .forEach(System.out::println);

        System.out.println("order of map and filter reversed");
        numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering " + n);
                    return n > 5;
                })
                .map(n -> {
                    System.out.println("Doubling " + n);
                    return n * 2;
                })
                .forEach(System.out::println);
    }

    // Doubling 1
    // Doubling 2
    // Doubling 3
    // ..
    // Doubling 6

    // Filtering 2
    // Filtering 4
    //
}
