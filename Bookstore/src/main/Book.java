package main;

public class Book {
	private String title;
    private String author;
    private String isbn;
    private String year;
    private String publisher;
    private String pages;
    private String genre;
    private String format;
    private String quantity;
    private String price;

    public Book(String title, String author, String isbn, String year, String publisher, String pages, String genre, String format, String quantity, String price) {
    	this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.publisher = publisher;
        this.pages = pages;
        this.genre = genre;
        this.format = format;
        this.quantity = quantity;
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
    
    public String getYear() {
    	return year;
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
    
    public String getQuantity() {
    	return quantity;
    }
    
    public String getPrice() {
    	return price;
    }
}
