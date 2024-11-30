package lld1.doubtSolving3;


import java.util.List;
import java.util.stream.Collectors;

/*
Problem Statement
You are given a list of strings having different fruit names.
You need to filter out the names of the fruits whose name starts from the character A.

Use streams to execute the operations and return a
List of String containing the fruit names whose name starts with A.

Instructions
Implement the filterFruitsStartingWithA method inside the FruitFilter class
You need to use Java Streams for doing the operation.
Return the answer in the same order as they appear in the input.
If no name satisfies the criteria then return an empty list.


 */
public class FruitFilter {

    public static List<String> filterFruitsStartingWithA(List<String> fruits) {
        return fruits.stream()
                .filter(fruit -> fruit.startsWith("A"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Avocado", "Grapes");
        List<String> res = filterFruitsStartingWithA(fruits);
        System.out.println(res);
    }
}
