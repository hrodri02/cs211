public class BookListRunnable implements Runnable {
    public static enum BookListRunnableType { ADD, REMOVE };
    private BookList bookList;
    private Book book;
    private BookListRunnableType type;
    private int successfulRemovals;

    public BookListRunnable(BookList bookList, Book book, BookListRunnableType type) {
        this.bookList = bookList;
        this.book = book;
        this.type = type;
        this.successfulRemovals = 0;
    }

    public int getSuccessfulRemovals() {
		return successfulRemovals;
	}

    @Override
    public void run() {
        boolean done = false;
        // while(!done) {
            // synchronized (bookList) {
                switch (type) {
                    case BookListRunnableType.ADD:
                        bookList.addBook(book);
                        done = true;
                        break;
                    case BookListRunnableType.REMOVE:
                        boolean success = bookList.removeBook(book);
                        if(success) {
                            successfulRemovals++;
                        }
                        done = true;
                        break;
                }
            // }
        // }
    }
}
