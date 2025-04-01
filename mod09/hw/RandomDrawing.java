import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomDrawing<T> implements RandomDrawingInterface<T> 
{
    private boolean allowsDuplicates;
    private List<T> entrants;
    private Set<T> seen;
    private Random random;

    public RandomDrawing(boolean allowsDuplicates) {
        this.allowsDuplicates = allowsDuplicates;
        this.entrants = new ArrayList<>();
        this.seen = new HashSet<>();
        this.random = new Random();
    }

    public boolean addEntry(T entry) {
        if (allowsDuplicates) {
            entrants.add(entry);
            return true;
        }
        else if (!seen.contains(entry)) {
            entrants.add(entry);
            seen.add(entry);
            return true;
        }
        return false;
    }

    public T selectWinner(boolean removeWinner) {
        int max = entrants.size() - 1;
        if (max < 0 ) return null;
        
        int min = 0;
        int index = random.nextInt(max - min + 1) + min;
        return (removeWinner) ? entrants.remove(index) : entrants.get(index);
    }

    public int size() {
        return entrants.size();
    }

    public boolean allowsDuplicates() {
        return allowsDuplicates;
    }

    public void displayEntries() {
        System.out.println("Entrants:");
        for (T entry : entrants) {
            System.out.println("\t" + entry);
        }
    }
}
