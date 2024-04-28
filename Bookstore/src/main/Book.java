package main;
public class Book {
    private String title;
    private String author;
    private String isbn;
    private String datePublished;
    private String publisher;
    private String pages;
    private String genre;
    private String description;
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
        this.description = description;
        this.format = format;
        this.price = price;
    }

    // Getters and setters
}
