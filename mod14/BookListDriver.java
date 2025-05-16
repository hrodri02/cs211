import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class BookListDriver {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 1000;
		BookList bookList = new BookList();
		Random generator = new Random();
		int ideThreadCount = Thread.activeCount();
        System.out.println("thread count: " + ideThreadCount);

		AtomicInteger numberOfAdds = new AtomicInteger();
		AtomicInteger numberOfRemoves = new AtomicInteger();
		
		for(int i=0; i<numberOfThreads; i++) {
			Book book = new Book();
			book.setTitle(Integer.toString(i));
			if(generator.nextBoolean()) {
				book.setBookType(BookType.FICTION);
			} else {
				book.setBookType(BookType.NONFICTION);
			}
			BookListRunnable.BookListRunnableType threadType;
			if(generator.nextBoolean()) {
				threadType = BookListRunnable.BookListRunnableType.ADD;
				numberOfAdds.incrementAndGet();
			} else {
				threadType = BookListRunnable.BookListRunnableType.REMOVE;
			}
			BookListRunnable runnable =  new BookListRunnable(bookList, book, threadType);
			Thread thread = new Thread(runnable);
			
			thread.start();
			if(runnable.getSuccessfulRemovals()==1) {
				numberOfRemoves.incrementAndGet();
			}
		}
		while(Thread.activeCount()>ideThreadCount) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {}
		}
        System.out.println("Number of removes: " + numberOfRemoves.get());
		int booksOnTheList = numberOfAdds.get() - numberOfRemoves.get();
		System.out.println("There should be " + booksOnTheList + " books on the list.");
		int bookListSize = bookList.size();
		System.out.println("There are " + bookListSize + " books on the list.");
    }

    public static void fillBooks(List<Book> books) {
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

        books.add(new Book("Whispers of the Wind", "Samantha Rhodes", 2020, 42000, 41000, 15.99, true, BookType.FICTION));
        books.add(new Book("Digital Frontiers", "Aaron Patel", 2021, 30000, 27500, 22.50, true, BookType.NONFICTION));
        books.add(new Book("Shadows in the Fog", "Elena Brooks", 2018, 27000, 29000, 13.75, false, BookType.FICTION));
        books.add(new Book("Economic Uprising", "David Lin", 2022, 38000, 36000, 18.90, true, BookType.NONFICTION));
        books.add(new Book("The Forgotten Garden", "Isabel Green", 2017, 25000, 31000, 14.99, false, BookType.FICTION));
        books.add(new Book("AI and the Future", "Nora Bennett", 2023, 60000, 61000, 24.00, true, BookType.NONFICTION));
        books.add(new Book("Crimson Legacy", "Tom Hastings", 2016, 19000, 22000, 12.50, false, BookType.FICTION));
        books.add(new Book("Cultural Currents", "Fatima Al-Karim", 2020, 41000, 39500, 21.75, true, BookType.NONFICTION));
        books.add(new Book("Beneath the Ice", "Julian Voss", 2019, 23000, 24000, 13.25, false, BookType.FICTION));
        books.add(new Book("Neuroscience Today", "Dr. Lisa Howell", 2021, 50000, 52000, 26.99, true, BookType.NONFICTION));
        books.add(new Book("Echoes of the Past", "Margaret Rowe", 2022, 34000, 33000, 15.40, true, BookType.FICTION));
        books.add(new Book("The Green Agenda", "Leo Park", 2019, 29000, 31000, 19.85, true, BookType.NONFICTION));
        books.add(new Book("The Lost Expedition", "Rachel Cruz", 2018, 22000, 25000, 14.60, false, BookType.FICTION));
        books.add(new Book("Smart Cities Rising", "Carlos Mendoza", 2023, 47000, 46000, 23.75, true, BookType.NONFICTION));
        books.add(new Book("The Light Within", "Talia Emerson", 2020, 31000, 32000, 16.30, true, BookType.FICTION));
        books.add(new Book("Market Mechanics", "Oliver Kent", 2021, 36000, 37000, 20.00, true, BookType.NONFICTION));
        books.add(new Book("Winds of Arendale", "Jay Harper", 2022, 33000, 34500, 15.20, true, BookType.FICTION));
        books.add(new Book("The Science of Sleep", "Dr. Anita Ray", 2017, 25000, 25500, 18.40, false, BookType.NONFICTION));
        books.add(new Book("Mystic Waters", "Lena Foster", 2021, 40000, 39000, 14.90, true, BookType.FICTION));
        books.add(new Book("Leadership Evolved", "Greg Thompson", 2018, 27000, 29000, 22.60, true, BookType.NONFICTION));
        books.add(new Book("The Painter’s Muse", "Claire Hwang", 2016, 20000, 19500, 13.80, false, BookType.FICTION));
        books.add(new Book("Space Beyond Earth", "Ravi Srinivasan", 2020, 49000, 51000, 25.40, true, BookType.NONFICTION));
        books.add(new Book("Desert Flame", "Ava Leone", 2023, 44000, 43000, 16.10, true, BookType.FICTION));
        books.add(new Book("Urban Myths Decoded", "Jorge Alvarez", 2019, 31000, 30000, 19.25, true, BookType.NONFICTION));
        books.add(new Book("Silent Voyage", "Mira Choudhury", 2018, 21000, 22000, 14.20, false, BookType.FICTION));
        books.add(new Book("Cracking the Code", "Elliot Barnes", 2021, 53000, 52000, 27.30, true, BookType.NONFICTION));
        books.add(new Book("The Mirror’s Edge", "Nina Talbot", 2020, 35000, 34500, 15.50, true, BookType.FICTION));
        books.add(new Book("Planetary Health", "Dr. Fiona Yates", 2022, 40000, 41000, 24.10, true, BookType.NONFICTION));
        books.add(new Book("The Last Ember", "Lucas DeWitt", 2017, 26000, 25500, 13.60, false, BookType.FICTION));
        books.add(new Book("Politics of Progress", "Sandra Koenig", 2019, 29000, 29500, 20.85, true, BookType.NONFICTION));
        books.add(new Book("Voices in the Storm", "Harriet Monroe", 2021, 36000, 37000, 16.25, true, BookType.FICTION));
        books.add(new Book("Climate Realities", "Omar D'Souza", 2023, 48000, 49000, 22.99, true, BookType.NONFICTION));
        books.add(new Book("Glass Kingdom", "Danielle Fox", 2016, 18000, 19500, 12.45, false, BookType.FICTION));
        books.add(new Book("Quantum Leap", "Henry Zhao", 2020, 52000, 53000, 26.75, true, BookType.NONFICTION));
        books.add(new Book("Through the Portal", "Aisha Khan", 2022, 34000, 33500, 15.70, true, BookType.FICTION));
        books.add(new Book("Society Rewired", "Marcus Ng", 2019, 30000, 32000, 21.50, true, BookType.NONFICTION));
        books.add(new Book("The Winter Rose", "Emily Novak", 2018, 24000, 23000, 13.95, false, BookType.FICTION));
        books.add(new Book("Mindful Leadership", "Peter Gold", 2021, 37000, 39000, 23.10, true, BookType.NONFICTION));
        books.add(new Book("Riders of the Dusk", "Noah Graves", 2020, 31000, 30500, 14.80, true, BookType.FICTION));
        books.add(new Book("Genetics Unlocked", "Tess Romero", 2023, 55000, 54000, 25.85, true, BookType.NONFICTION));
        books.add(new Book("The Hidden Fortress", "Owen Briggs", 2017, 22000, 21000, 13.30, false, BookType.FICTION));
        books.add(new Book("Tech Humanity", "Abigail Tran", 2020, 43000, 45000, 24.50, true, BookType.NONFICTION));
        books.add(new Book("Phoenix Rising", "Serena West", 2021, 39000, 40000, 16.70, true, BookType.FICTION));
        books.add(new Book("Ethics in Innovation", "Jordan Wells", 2022, 36000, 35000, 20.20, true, BookType.NONFICTION));
    }
}
