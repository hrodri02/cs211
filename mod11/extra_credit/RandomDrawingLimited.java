import java.util.function.Predicate;

public class RandomDrawingLimited<T> extends RandomDrawing<T> {
    private Predicate<? super T> filter;
    
    public RandomDrawingLimited(boolean allowsDuplicates, Predicate<? super T> filter) {
        super(allowsDuplicates);
        this.filter = filter;
    }

    @Override
    public boolean addEntry(T entry) {
        if (filter.test(entry)) {
            return super.addEntry(entry);            
        }
        return false;
    }
}