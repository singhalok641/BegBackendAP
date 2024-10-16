package lld1.synchronization.adderSubtractorSynchronizedMethod;

// This is a third party service
public class Count {
    private int value = 0;

    public synchronized void incrementValue(int offset){
        this.value += offset; // count.value += i;
    }

    public int getValue(){
        return this.value;
    }
}
