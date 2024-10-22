package lld1.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pair p1 = new Pair(1L, "Alok"); // Long, String
        Pair p2 = new Pair(1.4, 1.5); // Double, Double
        Pair p3 = new Pair(1L, false);// Long, Boolean

        List<Pair> pairs = List.of(p1,p2,p3);

//        for(Pair p: pairs){
//            String first = (String)p.getFirst();
//            String second = (String)p.getSecond();
//        }

        Pair1<Integer, String> pair1 = new Pair1<>(1, "Alok");
        Pair1<Double, Double> pair2 = new Pair1<>(1.4, 1.8);
        Pair1<Long, Boolean> pair3 = new Pair1<>(1L, true);

        // Raw type
//        Pair1 pair4 = new Pair1(1, 2);
//        pair4.get

//        List<Pair1> pair1List = new ArrayList<>();
//        pair1List.add(pair1);
//        pair1List.add(pair2);
//        pair1List.add(pair3);

        Integer first = pair1.getFirst();

//        for(Pair1 p: pair1List){
//            String first = (String)p.getFirst();
//            String second = (String)p.getSecond();
//        }

        Demo<Integer, String> demo1 = new Demo<>();
        demo1.doSomething(1, "Alok");

        String s = Demo.<String, Integer>getValue("Leela", 123);
        System.out.println(s);

    }
}

// Pro: You get to store generics
// Cons: There is no compile time safety
