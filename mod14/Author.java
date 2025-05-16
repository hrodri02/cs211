import java.util.List;
import java.util.ArrayList;

public final class Author {
    private final String name;
    private final int firstYearPublished;
    private final double totalSales;
    private final List<Book> bookList;

    public Author(String name, List<Book> bookList) {
        this.name = name;
        this.bookList = copyBookList(bookList);;
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (Book book : this.bookList) {
            total += book.getActualSales();
            if (book.getPublishYear() < min) min = book.getPublishYear();
        }
        this.firstYearPublished = min;
        this.totalSales = total;
    }

    private List<Book> copyBookList(List<Book> bookList) {
        List<Book> copy = new ArrayList<>();
        for (Book book : bookList) {
            Book copyBook = new Book(book);
            copy.add(copyBook);
        }
        return copy;
    }

    public String getName() {
        return name;
    }

    public int getFirstYearPublished() {
        return firstYearPublished;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }

    public int getNumBooks() {
        return bookList.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
