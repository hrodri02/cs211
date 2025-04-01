public class Cat extends Animal {
    private boolean canGoOutside;

    public Cat(String name, int age, boolean canGoOutside) {
        super(name, age);
        this.canGoOutside = canGoOutside;
    }

    public boolean isIndoorOnly() {
        return !canGoOutside;
    }
}
