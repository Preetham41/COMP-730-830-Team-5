package main;

import java.util.List;

public interface BookstoreInterface {
	List<String> browseBooks();
	List<String> showBookDetails(String title);
    void buyBook(Book book, int quantity, boolean delivery);
    String showBestsellers();
    String showBookwormFacts();
}
