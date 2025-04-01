public class Pair<T extends Comparable<T>> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public void orderPair() {
        if (first.compareTo(second) > 0) {
            T temp = first;
            first = second;
            second = temp;
        }
    }

    @Override
    public String toString() {
        return this.first + ", " + this.second;
    }
}