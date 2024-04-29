package main;

import java.util.List;

public interface BookstoreInterface {
	List<String> browseBooks();
    void buyBook(Book book, int quantity, boolean delivery);
    String showBestsellers();
    String showBookwormFacts();
}
