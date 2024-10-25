package lld1.generics.tripletExample;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
//        Triplet t1 = new Triplet(1.0, 2.0, 3.0);

        Triplet<String> idNameEmail = new Triplet<>(
                "1",
                "Alok Singh",
                "singh.alok_1@scaler.com"
        );

        Triplet<Integer> idAgeRollno = new Triplet<>(
                1,
                27,
                21
        );

        Triplet<Long> idAgeRollnoLong = new Triplet<>(
                1L,
                27L,
                21L
        );

        print(idNameEmail);

        // This is not accepted because of compile time type-safety
        // print(idAgeRollno);

        print(idAgeRollno);
        print(idAgeRollnoLong);


        List<Triplet<String>> triplets = List.of(idNameEmail, idNameEmail);
        printList(triplets);
        List<Triplet<Long>> tripletsLong = List.of(idAgeRollnoLong, idAgeRollnoLong);
        printList(tripletsLong);

        System.out.println("Average Value: " + getAverage(idAgeRollno));
        System.out.println("Average Value: " + getAverage(idAgeRollnoLong));
//        System.out.println("Average Value: " + getAverage(idNameEmail));
    }


    // Write another method to find the average of the three attributes in a
    // Triplet object and return
    // Is this generic?
    // ? - is a wildcard
    // we calculate avg of Numbers
    // Integer, Long, Double, Short, Byte, Float

    // Number class is the parent of all the classes allowing numeric values
    // getAverage should be allowing Triplet of type Number or child classes of Number
    private static double getAverage(Triplet<? extends Number> triplet){
        return (triplet.getLeft().doubleValue() +
                triplet.getRight().doubleValue() +
                triplet.getMiddle().doubleValue()) / 3;
    }

    private static <E> void printList(List<Triplet<E>> triplets){
        for(Triplet<E> triplet: triplets){
            System.out.println(triplet.getLeft() + "------" +
                    triplet.getMiddle() + "------" +
                    triplet.getRight());
            }
    }

    private static <TYPE> void print(Triplet<TYPE> triplet){
//        for(Triplet<String> triplet: triplets){
            System.out.println(triplet.getLeft() + "------" +
                    triplet.getMiddle() + "------" +
                    triplet.getRight());
//        }
    }
}
