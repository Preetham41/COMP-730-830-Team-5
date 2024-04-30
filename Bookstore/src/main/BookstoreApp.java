package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookstoreApp implements BookstoreInterface {
    private List<Book> books;
    private String[] bookwormFacts = {
            "Reading reduces stress levels by 68%.",
            "The longest novel ever written is 'In Search of Lost Time' by Marcel Proust, containing around 1.2 million words.",
            "The word 'bookworm' originally referred to insects that would bore through books.",
            "The average person reads about 12 books a year.",
            "The most expensive book ever purchased was the Codex Leicester by Leonardo da Vinci, bought by Bill Gates for $30.8 million.",
            "The first book ever printed with movable type was the Gutenberg Bible, printed by Johannes Gutenberg in the 1450s.",
            "The longest sentence ever printed is 823 words long, found in the novel 'The Rotter's Club' by Jonathan Coe.",
            "The first novel ever written on a typewriter was 'Tom Sawyer' by Mark Twain.",
            "The world's largest library is the Library of Congress, with over 170 million items in its collections.",
            "The first comic book ever published was 'The Adventures of Obadiah Oldbuck' in 1837.",
            "The most shoplifted book in the United States is the Bible.",
            "The most sold book of all time is the Bible.",
            "The most translated book is the Bible.",
            "The Harry Potter series has been translated into 80 languages.",
            "The most expensive book ever purchased was sold for $14.2 million and it was Codex Leicester by Leonardo da Vinci.",
            "The longest sentence in literature is found in the novel Absalom, Absalom! by William Faulkner, with a total of 1,287 words.",
            "The shortest novel ever written is 'Spiderweb' by Robert Bloch, containing just 101 words.",
            "The first book ever published in the English language was 'Recuyell of the Historyes of Troye' by William Caxton.",
            "The most read book in the world is the Quran.",
            "The Hobbit was initially intended to be a standalone book, but its success led to the creation of The Lord of the Rings trilogy.",
            "A group of books is called a 'library'.",
            "The world's largest bookstore is the Barnes & Noble Bookstore in New York City, USA.",
            "The most checked-out book of all time from a public library is 'The Cat in the Hat' by Dr. Seuss.",
            "The first book ever written using a typewriter was 'The Adventures of Tom Sawyer' by Mark Twain.",
            "The most expensive book ever purchased was the Codex Leicester by Leonardo da Vinci, bought by Bill Gates for $30.8 million."
        };
    
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
    	List<String> TopBooks = new ArrayList<>();
    	for (Book book : books) {
    		TopBooks.add(book.getTitle());
    	}
    }

    // show book worm facts
    @Override
    public String showBookwormFacts() {
    	Random random = new Random();
        int randomIndex = random.nextInt(bookwormFacts.length);

        return bookwormFacts[randomIndex];
    }
}
