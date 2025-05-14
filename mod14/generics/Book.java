public class Book
{
    private String title;
    private String author;
    private int publishYear;
    private int expectedSales;
    private int actualSales;
    private double cost;
    private boolean availableDigital;
    private BookType bookType;

    public Book(String title, String author, int publishYear, int expectedSales, int actualSales, double cost,
            boolean availableDigital, BookType bookType) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.expectedSales = expectedSales;
        this.actualSales = actualSales;
        this.cost = cost;
        this.availableDigital = availableDigital;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "title=" + title + ", author=" + author + ", publishYear=" + publishYear + ", expectedSales="
                + expectedSales + ", actualSales=" + actualSales + ", cost=" + cost + ", availableDigital="
                + availableDigital + ", bookType=" + bookType;
    }
}