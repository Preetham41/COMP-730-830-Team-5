import java.util.List;

public class BookStoreApp implements BookstoreInterface {
    private List<Book> books;

    public BookStoreApp(List<Book> books) {
        this.books = books;
    }

    @Override
    public void browseBooks() {
        // Implement browsing functionality
    }

    @Override
    public void buyBook(Book book, int quantity, boolean delivery) {
        // Implement buying functionality
    }

    @Override
    public void showBestsellers() {
        // Implement showing bestsellers functionality
    }

    @Override
    public void showBookwormFacts() {
        // Implement showing bookworm facts functionality
    }
}
