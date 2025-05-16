

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

    public Book() {
        title = "";
        author = "";
        publishYear = 0;
        expectedSales = 0;
        actualSales = 0;
        cost = 0.0;
        availableDigital = true;
        bookType = BookType.FICTION;
    }

    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.publishYear = other.publishYear;
        this.expectedSales = other.expectedSales;
        this.actualSales = other.actualSales;
        this.cost = other.cost;
        this.availableDigital = other.availableDigital;
        this.bookType = other.bookType; // Enum: safe to copy by reference
    }

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

    public String getTitle() {
        return title;
    }

    public int getActualSales() {
        return actualSales;
    }

    public int getExpectedSales() {
        return expectedSales;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getCost() {
        return cost;
    }

    public boolean isAvailableDigitally() {
        return availableDigital;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookType(BookType type) {
        this.bookType = type;
    }

    @Override
    public String toString() {
        return "{title=" + title + ", author=" + author + ", publishYear=" + publishYear + ", expectedSales="
                + expectedSales + ", actualSales=" + actualSales + ", cost=" + cost + ", availableDigital="
                + availableDigital + ", bookType=" + bookType + "}";
    }
}