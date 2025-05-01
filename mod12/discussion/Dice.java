import java.util.Random;

public class Dice {
    private int num1;
    private int num2;
    private Random random;

    public Dice() {
        random = new Random();
    }

    public synchronized void roll() {
        num1 = 1 + random.nextInt(6);
        num2 = 1 + random.nextInt(6);
    }

    public synchronized int getNum1() {
        return num1;
    }

    public synchronized int getNum2() {
        return num2;
    }
}
