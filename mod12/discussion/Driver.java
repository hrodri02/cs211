import java.util.*;
import java.util.stream.IntStream;

public class Driver {
    /*   
     * A = getting a double on a rolling dice.
     * P(A) = 6 / 36 = 1/6
     * For 36,000 rolls we should expect about 6,000 to be doubles.
    */
    public static void main(String[] args) throws InterruptedException {
        int NUM_THREADS = 50;
        int NUM_ROLLS = 36_000;
        
        Thread[] threads = new Thread[NUM_THREADS];
        DiceRollerRunnable[] runnables = new DiceRollerRunnable[NUM_THREADS];
        Dice dice = new Dice();
        for (int i = 0; i < NUM_THREADS; i++) {
            DiceRollerRunnable runnable = new DiceRollerRunnable(dice, NUM_ROLLS);
            runnables[i] = runnable;
            threads[i] = new Thread(runnable);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        IntStream stream1 = Arrays.stream(runnables)
                                .mapToInt(DiceRollerRunnable::getDoubles);
        printStats("Runnables Stats", stream1);
        
        DiceRollerThread[] diceRollerThreads = new DiceRollerThread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            diceRollerThreads[i] = new DiceRollerThread(NUM_ROLLS);
        }

        for (Thread thread : diceRollerThreads) {
            thread.start();
        }

        for (Thread thread : diceRollerThreads) {
            thread.join();
        }

        IntStream stream2 = Arrays.stream(diceRollerThreads)
                                .mapToInt(DiceRollerThread::getDoubles);        
        printStats("Dice Roller Stats", stream2);
    }

    private static void printStats(String header, IntStream stream) {
        IntSummaryStatistics stats = stream.summaryStatistics();
        System.out.println(header);
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }
}
