import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> fictionBooks;
    private List<Book> nonfictionBooks;
    
    public BookList() {
        this.fictionBooks = new ArrayList<>();
        this.nonfictionBooks = new ArrayList<>();
    }

    public synchronized void addBook(Book b) {
        if (b.getBookType() == BookType.FICTION) {
            fictionBooks.add(b);
        }
        else if (b.getBookType() == BookType.NONFICTION) {
            nonfictionBooks.add(b);
        }
    }

    public synchronized boolean removeBook(Book b) {
        if (b.getBookType() == BookType.FICTION) {
            return fictionBooks.remove(b);
        }
        else if (b.getBookType() == BookType.NONFICTION) {
            return nonfictionBooks.remove(b);
        }
        return false;
    }

    public int size() {
        return fictionBooks.size() + nonfictionBooks.size();
    }

    public void printBooks() {
        System.out.println("fiction books\n" + fictionBooks);
        System.out.println("nonfiction books\n" + nonfictionBooks);
    }
}
