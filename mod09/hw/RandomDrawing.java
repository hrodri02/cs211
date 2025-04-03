import java.util.*;

public class RandomDrawing<T> implements RandomDrawingInterface<T> 
{
    private boolean allowsDuplicates;
    private Map<T, Integer> entries;
    private Integer numEntries;
    private Random random;

    public RandomDrawing(boolean allowsDuplicates) {
        this.allowsDuplicates = allowsDuplicates;
        this.entries = new HashMap<>();
        this.numEntries = 0;
        this.random = new Random();
    }

    public boolean addEntry(T entry) {
        if (allowsDuplicates) {
            if (!entries.containsKey(entry)) {
                entries.put(entry, 0);
            }
            int newFreq = entries.get(entry) + 1;
            entries.put(entry, newFreq);

            numEntries += 1;
            return true;
        }
        else if (!entries.containsKey(entry)) {
            entries.put(entry, 1);
            numEntries += 1;
            return true;
        }

        return false;
    }

    public T selectWinner(boolean removeWinner) {
        Set<T> keys = entries.keySet();
        List<T>  listOfKeys = new ArrayList<>(keys);
        int max = listOfKeys.size() - 1;
        if (max < 0 ) return null;

        int min = 0;
        int index = random.nextInt(max - min + 1) + min;
        T entry = listOfKeys.get(index);
        if (removeWinner) {
            int newFreq = entries.get(entry) - 1;
            if (newFreq == 0)
                entries.remove(entry);
            else 
                entries.put(entry, newFreq);
            
            numEntries -= 1;
            return entry;
        }

        return entry;
    }

    public int size() {
        return numEntries;
    }

    public boolean allowsDuplicates() {
        return allowsDuplicates;
    }

    public void displayEntries() {
        System.out.println("Entrants:");
        for (T entry : entries.keySet()) {
            System.out.println("\t" + entry);
        }
    }
}
