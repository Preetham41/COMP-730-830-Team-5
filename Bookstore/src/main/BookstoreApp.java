package main;
import java.util.List;

public class BookstoreApp implements BookstoreInterface {
    private List<Book> books;

    public BookstoreApp(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> browseBooks() {
        return books;
    }

    @Override
    public void buyBook(Book book, int quantity, boolean delivery) {
        // Implement buying functionality
    }

    @Override
    public String showBestsellers() {
    	String text = "This is an example of a bestseller!";
    	return text;
    }

    @Override
    public String showBookwormFacts() {
    	String text = "This is an example of a bookworm fact!";
    	return text;
    }
}
