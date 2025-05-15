

public class DigitalBook extends Book {
    private String format;
    public DigitalBook(String title, String author, int publishYear, int expectedSales, int actualSales, double cost,
            boolean availableDigital, BookType bookType) {
        super(title, author, publishYear, expectedSales, 
            actualSales, cost, availableDigital, bookType);
        this.format = "PDF";
    }
    @Override
    public String toString() {
        return "DigitalBook [format=" + format + " " + super.toString() + "]";
    }
}
