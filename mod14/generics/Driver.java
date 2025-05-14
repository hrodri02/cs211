/*

Determine what kind of lists can be used to invoke each of the methods: a List<Book>, List<AudioBook>, and/or List<ElectronicBook>
 */

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Stars Within", 
                        "Alice Monroe", 
                        2018,
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
                        false, 
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
                        2010, 
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

        List<AudioBook> audioBooks = new ArrayList<>();

        audioBooks.add(new AudioBook("The Stars Within", 
                        "Alice Monroe", 
                        2018,
                        50000, 
                        52000, 
                        12.99, 
                    false, 
                        BookType.FICTION));
        audioBooks.add(new AudioBook("World History: A New Perspective", 
                        "Dr. Neil Carter", 
                        2020, 
                        30000, 
                        28000, 
                        18.75, 
                        false, 
                        BookType.NONFICTION));
        audioBooks.add(new AudioBook("Legacy of Time", 
                        "Sandra Lee", 
                        2015, 
                        40000, 
                        45000, 
                        14.50, 
                        false, 
                        BookType.FICTION));
        audioBooks.add(new AudioBook("Digital Economy Explained", 
                            "Raj Patel", 
                            2023, 
                            60000, 
                            61000, 
                            22.00, 
                            false, 
                            BookType.NONFICTION));
        audioBooks.add(new AudioBook("Nature’s Whisper", 
                        "Lena Brooks", 
                        2010, 
                        20000, 
                        15000, 
                        9.99, 
                        false, 
                        BookType.FICTION));
        audioBooks.add(new AudioBook("The Innovator’s Path", 
                        "Michael Chen", 
                        2019, 
                        35000, 
                        39000, 
                        17.25, 
                        false, 
                        BookType.NONFICTION)); 
                        
        List<DigitalBook> digitalBooks = new ArrayList<>();

        digitalBooks.add(new DigitalBook("The Stars Within", 
                        "Alice Monroe", 
                        2018,
                        50000, 
                        52000, 
                        12.99, 
                    false, 
                        BookType.FICTION));
        digitalBooks.add(new DigitalBook("World History: A New Perspective", 
                        "Dr. Neil Carter", 
                        2020, 
                        30000, 
                        28000, 
                        18.75, 
                        false, 
                        BookType.NONFICTION));
        digitalBooks.add(new DigitalBook("Legacy of Time", 
                        "Sandra Lee", 
                        2015, 
                        40000, 
                        45000, 
                        14.50, 
                        false, 
                        BookType.FICTION));
        digitalBooks.add(new DigitalBook("Digital Economy Explained", 
                            "Raj Patel", 
                            2023, 
                            60000, 
                            61000, 
                            22.00, 
                            false, 
                            BookType.NONFICTION));
        digitalBooks.add(new DigitalBook("Nature’s Whisper", 
                        "Lena Brooks", 
                        2010, 
                        20000, 
                        15000, 
                        9.99, 
                        false, 
                        BookType.FICTION));
        digitalBooks.add(new DigitalBook("The Innovator’s Path", 
                        "Michael Chen", 
                        2019, 
                        35000, 
                        39000, 
                        17.25, 
                        false, 
                        BookType.NONFICTION));

        // printListOfBooks(books);
        
        // printListOfDigitalBooks(digitalBooks);

        // printListOfBooksOrLower(books);
        // printListOfBooksOrLower(digitalBooks);
        // printListOfBooksOrLower(audioBooks);

        // printListOfAudioBooksOrHigher(books);
        // printListOfAudioBooksOrHigher(audioBooks);

        // printListOfAnything(books);
        // printListOfAnything(digitalBooks);
        // printListOfAnything(audioBooks);
        printListOfAnything(List.of(1,2,3));
    }
    /* 
    Write methods that take various kinds of parameters that use generics, including:
    List<? extends Book>
    List<? super AudioBook>
    List<?>
    */

    // allows List<Book> only
    public static void printListOfBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // allows List<DigitalBook> only
    public static void printListOfDigitalBooks(List<DigitalBook> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // allows List<Book>, List<AudioBook>, and List<DigitalBook>
    public static void printListOfBooksOrLower(List<? extends Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // allows List<Book>, List<AudioBook>
    public static void printListOfAudioBooksOrHigher(List<? super AudioBook> books) {
        for (Object book : books) {
            System.out.println(book);
        }
    }

    public static void printListOfAnything(List<?> objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }
}
