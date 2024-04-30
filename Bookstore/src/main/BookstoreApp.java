package main;

import java.util.ArrayList;
import java.util.List;

public class BookstoreApp implements BookstoreInterface {
    private List<Book> books;

    public BookstoreApp(List<Book> books) {
        this.books = books;
    }

    // show list of available books
    public List<String> browseBooks() {
    	List<String> availableBooks = new ArrayList<>();
    	String availableBook = "";
    	
    	for (Book book : books) {
    		System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getISBN() + " " + book.getYear() + " " + book.getPublisher() + " " + book.getPages() + " " + book.getGenre() + " " + book.getFormat() + " " + book.getQuantity() + " " + book.getPrice());	// print to console
    		availableBook = book.getTitle();
    		availableBooks.add(availableBook);
		}
    	return availableBooks;
    }
    
    // show book details
    public List<String> showBookDetails(String title) {
    	List<String> details = new ArrayList<>();
    	for (Book book : books) {
    		if (title.equals(book.getTitle())) {
        		details.add(book.getTitle());
        		details.add(book.getAuthor());
        		details.add(book.getISBN());
        		details.add(book.getYear());
        		details.add(book.getPublisher());
        		details.add(book.getPages());
        		details.add(book.getGenre());
        		details.add(book.getFormat());
        		details.add(book.getQuantity());
        		details.add(book.getPrice());
        		System.out.println(details);
    		}
    	}
    	return details;
    }

    
	/*
	 @Override
	 public void buyBook(Book book, int quantity, boolean delivery) { //
	 	button event listener }
	 */

    // show bestselling books
    @Override
    public String showBestsellers() {
    	String text = "This is an example of a bestseller!";
    	return text;
    }

    // show bookworm facts
    @Override
    public String showBookwormFacts() {
    	String text = "This is an example of a bookworm fact!";
    	return text;
    }
}
