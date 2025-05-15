import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class Java8Driver {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Stars Within", 
                        "Alice Monroe", 
                        2020,
                        50000, 
                        52000, 
                        12.99, 
                        true, 
                        BookType.FICTION));
        books.add(new Book("World History: A New Perspective", 
                        "Dr. Neil Carter", 
                        2020, 
                        30000, 
                        28000, 
                        18.75, 
                        true, 
                        BookType.NONFICTION));
        books.add(new Book("Legacy of Time", 
                        "Sandra Lee", 
                        2015, 
                        40000, 
                        45000, 
                        14.50, 
                        true, 
                        BookType.FICTION));
        books.add(new Book("Digital Economy Explained", 
                            "Raj Patel", 
                            2023, 
                            60000, 
                            61000, 
                            22.00, 
                            true, 
                            BookType.NONFICTION));
        books.add(new Book("Nature’s Whisper", 
                        "Lena Brooks", 
                        2020, 
                        20000, 
                        15000, 
                        9.99, 
                        false, 
                        BookType.FICTION));
        books.add(new Book("The Innovator’s Path", 
                        "Michael Chen", 
                        2019, 
                        35000, 
                        39000, 
                        17.25, 
                        true, 
                        BookType.NONFICTION));
        books.add(new Book("The Innovator’s Path", 
                        "Michael Chen", 
                        2019, 
                        35000, 
                        39000, 
                        17.25, 
                        true, 
                        BookType.NONFICTION));
        
        // Collections.sort(books, (book1, book2) -> {
        //     if (book1.getActualSales() == book2.getActualSales()) {
        //         return Integer.compare(book1.getExpectedSales(), book2.getExpectedSales());
        //     }
        //     return Integer.compare(book1.getActualSales(), book2.getActualSales());
        // });
        
        // the number of unique authors in the list
        long uniqueAuthors = books.stream()
                                .map(Book::getAuthor)
                                .distinct()
                                .count();
        System.out.println("There are " + uniqueAuthors + " unique authors.");

        // print the title of every book available digitally, sorted by title
        books.stream()
            .filter(Book::isAvailableDigitally)
            .map(Book::getTitle)
            .sorted()
            .forEach(System.out::println);

        // the average cost of all fiction books published in 2020
        double avgCost = books.stream()
            .filter(book -> book.getBookType() == BookType.FICTION && book.getPublishYear() == 2020)
            .collect(Collectors.averagingDouble(Book::getCost));
        System.out.println(avgCost);


        // the most expensive book published in 2020
        Book mostExpensiveBook = books.stream()
                                        .filter(book -> book.getPublishYear() == 2020)
                                        .max((b1, b2) -> Double.compare(b1.getCost(), b2.getCost()))
                                        .get();
        System.out.println("Most expensive book published in 2020 " + mostExpensiveBook);

        // whether or not there are any digital, non-fiction books published in 2020
        boolean isThereANonfictionBookPublishedIn2020 = books.stream()
            .filter(book -> book.isAvailableDigitally() && book.getBookType() == BookType.NONFICTION && book.getPublishYear() == 2020)
            .findFirst()
            .isPresent();
        System.out.println("Is there a nonfiction book published in 2020: " + isThereANonfictionBookPublishedIn2020);
        // generate a list of authors (not books!) for all books whose expected sales were higher than their actual sales
        List<String> authors = books.stream()
                                    .filter(book -> book.getExpectedSales() > book.getActualSales())
                                    .map(Book::getAuthor)
                                    .collect(Collectors.toList());
        System.out.println(authors);
        // generate a map of books by author (key = author, value = list of books)
        Map<String, List<Book>> map = books.stream()
                                        .collect(Collectors.groupingBy(Book::getAuthor));
        System.out.println(map);
    }       
    
    public static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book + "\n");
        }
    }
}
