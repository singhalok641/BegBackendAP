package lld1.semaphores.producerConsumerFinal;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        // Store
        Queue<Object> store = new ConcurrentLinkedDeque<>();

        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);


        Producer p1 = new Producer(store, 6, "p1", producerSemaphore, consumerSemaphore);
        Producer p2 = new Producer(store, 6, "p2", producerSemaphore, consumerSemaphore);
        Producer p3 = new Producer(store, 6, "p3", producerSemaphore, consumerSemaphore);

        Consumer c1 = new Consumer(store, 6, "c1", producerSemaphore, consumerSemaphore);
        Consumer c2 = new Consumer(store, 6, "c2", producerSemaphore, consumerSemaphore);
        Consumer c3 = new Consumer(store, 6, "c3", producerSemaphore, consumerSemaphore);
        Consumer c4 = new Consumer(store, 6, "c4", producerSemaphore, consumerSemaphore);
        Consumer c5 = new Consumer(store, 6, "c5", producerSemaphore, consumerSemaphore);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        Thread t4 = new Thread(c1);
        t4.start();
        Thread t5 = new Thread(c2);
        t5.start();
        Thread t6 = new Thread(c3);
        t6.start();
        Thread t7 = new Thread(c4);
        t7.start();
        Thread t8 = new Thread(c5);
        t8.start();






    }

}
