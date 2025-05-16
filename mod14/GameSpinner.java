import java.util.Random;

public class GameSpinner implements Runnable {
    private int times;
    private int sections;
    private Random random;

    public GameSpinner(int sections, int times) {
        this.times = times;
        this.sections = sections;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            int section = 1 + random.nextInt(sections);
            System.out.println(Thread.currentThread() + ": " + section);
        }
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public int getTimes() {
        return times;
    }

    public int getSections() {
        return sections;
    }
}
