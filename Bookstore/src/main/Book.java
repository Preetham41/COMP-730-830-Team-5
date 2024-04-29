package main;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String title;
    private String author;
    private String isbn;
    private String datePublished;
    private String publisher;
    private String pages;
    private String genre;
    private String format;
    private String price;

    public Book(String title, String author, String isbn, String datePublished, String publisher, String pages, String genre, /*String description,*/ String format, String price) {
    	this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.datePublished = datePublished;
        this.publisher = publisher;
        this.pages = pages;
        this.genre = genre;
        this.format = format;
        this.price = price;
    }
    
    // Getters and setters
    
    public String getTitle() {
    	return title;
    }
    
    public String getAuthor() {
    	return author;
    }
    
    public String getISBN() {
    	return isbn;
    }
    
    public String getDatePublished() {
    	return datePublished;
    }
    
    public String getPublisher() {
    	return publisher;
    }
    
    public String getPages() {
    	return pages;
    }
    
    public String getGenre() {
    	return genre;
    }
    
    public String getFormat() {
    	return format;
    }
    
    public String getPrice() {
    	return price;
    }
    
    /*
    public List<String> getDetails() {
    	List<String> details = new ArrayList<>();
    	details.add(getTitle(), getAuthor(), getISBN(), getDatePublished());
		String details = title + "\n" + author + "\n" + isbn + "\n" + datePublished + "\n" + publisher + "\n" + pages + "\n" + genre + "\n" + format + "\n" + price;
		
		return details;
	}
	*/
}
