import java.util.Random;

public class DiceRollerThread extends Thread {
    private int times;
    private int doubles;
    private Random random;

    public DiceRollerThread(int times) {
        this.times = times;
        this.doubles = 0;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            int num1 = 1 + random.nextInt(6);
            int num2 = 1 + random.nextInt(6);
            if (num1 == num2) doubles++;
            System.out.println("(" + super.getName() + "): " + num1 + " " + num2);
        }
    }

    public int getDoubles() {
        return this.doubles;
    }
}