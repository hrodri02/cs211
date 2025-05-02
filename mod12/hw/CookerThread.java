import java.util.Random;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CookerThread implements Runnable {
    private BlockingQueue<Food> spots;
    private List<Food> orders;
    private static final int MS_IN_SEC = 1000;

    public CookerThread(BlockingQueue<Food> spots, List<Food> orders) {
        this.spots = spots;
        this.orders = orders;
    }

    @Override
    public void run() {
        for (Food order : orders) {
            try {
                System.out.println("COOK READY");
                System.out.println("COOK STARTING: " + order);
                int seconds = order.getCookTime();
                Thread.sleep((new Random()).nextInt(seconds * MS_IN_SEC));
                spots.put(order);
                System.out.println("COOK ENDING: " + order);
            }
            catch (InterruptedException ex) { }
        }
    }
}
