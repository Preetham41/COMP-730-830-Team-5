import java.util.List;

public interface BookstoreInterface {
    void browseBooks();
    void buyBook(Book book, int quantity, boolean delivery);
    void showBestsellers();
    void showBookwormFacts();
}
