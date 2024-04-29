package main;

import java.util.ArrayList;
import java.util.List;

public class BookstoreApp implements BookstoreInterface {
    private List<Book> books;

    public BookstoreApp(List<Book> books) {
        this.books = books;
    }

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
    
    public List<String> showBookDetails(String title) {
    	List<String> details = new ArrayList<>();
    	for (Book book : books) {
    		if (title.equals(book.getTitle())) {
        		details.add(book.getTitle());
        		details.add(book.getAuthor());
        		details.add(book.getISBN());
        		details.add(book.getDatePublished());
        		details.add(book.getPublisher());
        		details.add(book.getPages());
        		details.add(book.getGenre());
        		details.add(book.getFormat());
        		details.add(book.getPrice());
        		System.out.println(details);
    		}
    	}
    	return details;
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
