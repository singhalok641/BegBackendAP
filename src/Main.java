import lld1.I1;
import lld1.semaphores.producerConsumerFinal.Producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

//        double a = I1.getValue(56);
//        System.out.println(a);
//
//        String s = new String("Af");
//        System.out.println(I1.getValue(56));
//
//        System.out.println("Hello world!");

        String date = LocalDateTime.now().minusDays(10)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(date);

    }
}