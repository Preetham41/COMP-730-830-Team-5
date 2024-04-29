package main;

import java.util.ArrayList;
import java.util.List;

public class BookstoreApp implements BookstoreInterface {
    private List<Book> books;

    public BookstoreApp(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<String> browseBooks() {
    	List<String> availableBooks = new ArrayList<>();
    	String availableBook = "";
    	
    	for (Book book : books) {
    		System.out.println(book.getTitle() + "    " + book.getAuthor());	// print to console
    		availableBook = book.getTitle();
    		availableBooks.add(availableBook);
		}
    	
    	return availableBooks;
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
