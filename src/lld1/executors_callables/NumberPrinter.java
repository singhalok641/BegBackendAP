package lld1.executors_callables;

public class NumberPrinter implements Runnable{
    private final int numberToPrint;

    public NumberPrinter(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println("Printing " + this.numberToPrint +
                ". Printed by thread: " + Thread.currentThread().getName());
    }
}
