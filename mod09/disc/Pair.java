// T must be a type that can be compared with objects of type T or 
// any of its supertypes (including T itself).
public class Pair<T extends Comparable<? super T>> {
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