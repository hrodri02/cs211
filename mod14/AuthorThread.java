public class AuthorThread implements Runnable {
    private AuthorsMap map;
    private Author author;

    public AuthorThread(AuthorsMap map, Author author) {
        this.map = map;
        this.author = author;
    }

    @Override
    public void run() {
        map.addAuthor(author);
    }
}
