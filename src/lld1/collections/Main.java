package lld1.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.addAll(
                List.of(
                        new Student(1, 27, "Alok", 90),
                        new Student(2, 26, "Karthikeyan", 88),
                        new Student(3, 35, "Malideedu", 93),
                        new Student(4, 22, "Bhanu", 99)
                )
        );

        List<String> strings = new ArrayList<>();
        strings.addAll(List.of("Alok", "Bhanu", "Anup"));
        Collections.sort(strings);

        // using the natural ordering defined in Student class(desc order of psp)
        Collections.sort(students);

        // custom ordering defined in asc order of name
        Collections.sort(students, new StudentOrderingByName());
    }
}
