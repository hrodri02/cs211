public class Driver {
    public static void main(String[] args) throws InterruptedException {
        int NUM_THREADS = 2;
        int NUM_ROLLS = 3;

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

        for (DiceRollerRunnable runnable : runnables) {
            System.out.println(runnable.getDoubles());
        }

        /* 
        DiceRollerThread[] threads = new DiceRollerThread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new DiceRollerThread(NUM_ROLLS);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (DiceRollerThread thread : threads) {
            System.out.println(thread.getDoubles());
        }
        */
    }    
}
