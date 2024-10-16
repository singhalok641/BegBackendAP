package lld1.synchronization.adderSubtractorMutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{

    private Count count;
    Lock lock;

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=1; i<=10000 ; i++){
            System.out.println("Hello");
            lock.lock();
            count.value += i;
            lock.unlock();
            System.out.println("bye");
        }
    }
}
