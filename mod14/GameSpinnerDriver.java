public class GameSpinnerDriver
{
    public static void main(String[] args) throws InterruptedException  {
        int NUM_SECTIONS = 8;
        int NUM_THREADS = 2;
        int NUM_ROLLS = 3;
        
        Thread[] threads = new Thread[NUM_THREADS];
        GameSpinner[] runnables = new GameSpinner[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            GameSpinner runnable = new GameSpinner(NUM_SECTIONS, NUM_ROLLS);
            runnables[i] = runnable;
            threads[i] = new Thread(runnable);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}