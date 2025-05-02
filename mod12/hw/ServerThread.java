import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ServerThread implements Runnable {
    private BlockingQueue<Food> spots;
    private int numOrders;
    private static final int MS_IN_SEC = 1000;

    public ServerThread(BlockingQueue<Food> spots, int numOrders) {
        this.spots = spots;
        this.numOrders = numOrders;
    }

    @Override
    public void run() {
        for (int i = 0; i < numOrders; i++) {
            try {
                System.out.println("SERVER READY");
                Food order = spots.take();
                System.out.println("SERVER STARTING: " + order);
                int seconds = order.getServeTime();
                Thread.sleep((new Random()).nextInt(seconds * MS_IN_SEC));
                System.out.println("SERVER ENDING: " + order);
            }
            catch (InterruptedException ex) { }
        }
    }
}