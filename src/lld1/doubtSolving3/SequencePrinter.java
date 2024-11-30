package lld1.doubtSolving3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Write a java program to print a sequence of
numbers upto 10 using 3 threads. ???
 */
public class SequencePrinter {
    private static final int MAX = 10;
    private static int number = 1; // tracks the current number to be printed
    private static final Lock lock = new ReentrantLock(); //lock for synchronization


    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask(1));
        Thread t2 = new Thread(new PrintTask(2));
        Thread t3 = new Thread(new PrintTask(0));

        t1.start();
        t2.start();
        t3.start();
    }

    static class PrintTask implements Runnable {
        private final int threadId;

        public PrintTask(int threadId){
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if (number > MAX) {
                        break;
                    }

                    // 3 threads are created with different thread ids: (1, 2, 0)
                    // number % 3 == threadId

                    if (number % 3 == threadId) {
                        System.out.println("Thread-" + threadId + ": " + number);
                        number++;
                        lock.notifyAll();
                    } else {
                        // Wait if not this thread's turn
                        try {
                            /*
                            When a thread calls wait(), it:
                            1. Releases the lock it holds on the lock object
                            2. Goes into a waiting state until another thread calls
                            notify() or notifyAll() on the same lock object.
                             */
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

}
