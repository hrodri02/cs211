public class RandomDrawingCapped<T> extends RandomDrawing<T> {
    private Integer cap;
    public static final Integer DEFUALT_CAP = 10;

    public RandomDrawingCapped(boolean allowsDuplicates, Integer cap) {
        super(allowsDuplicates);
        this.cap = cap;
    }

    public RandomDrawingCapped(boolean allowsDuplicates) {
        super(allowsDuplicates);
        this.cap = DEFUALT_CAP;
    }

    public boolean addEntry(T entry) {
        if (size() >= cap) {
            return false;
        }
        return super.addEntry(entry);
    }
}
