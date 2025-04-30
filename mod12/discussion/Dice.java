import java.util.Random;

public class Dice {
    private int num1;
    private int num2;
    private Random random;

    public Dice() {
        random = new Random();
    }

    public void roll() {
        num1 = 1 + random.nextInt(6);
        num2 = 1 + random.nextInt(6);
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
