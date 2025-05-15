

public class AudioBook extends Book {
    private int length;
    public AudioBook(String title, String author, int publishYear, int expectedSales, int actualSales, double cost,
            boolean availableDigital, BookType bookType) {
        super(title, author, publishYear, expectedSales, 
            actualSales, cost, availableDigital, bookType);
        this.length = 0;
    }
    @Override
    public String toString() {
        return "AudioBook [length=" + length + " " + super.toString() + " ]";
    }
}
