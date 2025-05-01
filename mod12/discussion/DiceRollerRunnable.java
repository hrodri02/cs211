public class DiceRollerRunnable implements Runnable {
    private int times;
    private int doubles;
    private Dice dice;

    public DiceRollerRunnable(Dice dice, int times) {
        this.doubles = 0;
        this.times = times;
        this.dice = dice;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            dice.roll();
            int num1 = dice.getNum1();
            int num2 = dice.getNum2();
            if (num1 == num2) doubles++;
        }
    }

    public int getDoubles() {
        return doubles;
    }
}
