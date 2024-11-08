package lld1.streams;

import lld1.collections.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // forEach in Streams

        List<Integer> numbers = List.of(1,2,3,4,5);

        // normally this is how we traverse a list
        for(Integer i: numbers){
            System.out.println(i);
        }

        // Using streams
        Stream stream = numbers.stream();
//        stream.forEach(System.out::println);

        // This fails because the stream is already exhausted
//        stream.forEach(System.out::println);

        // 1, 2, 3, 4, 5

        // Two types of operations we can do on streams
        // 1. Terminal operation - End
        // 2. Intermediate Operation -

        // forEach is a terminal operation and it is called in the end
        // and it completes the Stream

        // it consumes the Stream and does an action with each and every element(e.g printing the element)

        // Filter - Intermediate operation
        numbers.stream() // 1, 2, 3, 4, 5
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println); // 2, 4

        // Try filtering numbers greater than 2 or odd numbers and print them using forEach
        List<Integer> numbers2 = List.of(7, 8, 10, 12, 15, 20);

        System.out.println("Try filtering numbers greater than 2 and odd numbers and print them using forEach");
        numbers2.stream()
                .filter(n -> n > 2 && n % 2 != 0)
                .forEach(System.out::println);

        System.out.println("Double every element in the stream and print");
        // map -> Transform each element
        numbers2.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);

        // Write a stream code to turn a list of words into uppercase
        List<String> words = List.of("apple", "banana", "cherry");
        System.out.println("Words in uppercase");
        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<Student> students = new ArrayList<>();
        students.addAll(
                List.of(
                        new Student(1, 27, "Alok", 90),
                        new Student(2, 26, "Karthikeyan", 88),
                        new Student(3, 35, "Malideedu", 93),
                        new Student(4, 22, "Bhanu", 99)
                )
        );

        students.stream()
                .filter(s -> s.getPsp() > 90)
                .forEach(s -> System.out.println(s.getName()));

        // Chaining the Operations
        numbers.stream()
                .filter(n -> n % 2 == 0) // select even numbers
                .map(n -> n * 3)
                .forEach(System.out::println);

    }
}
