package main;

public class Book {
	private float price;
	private String genre; // Fiction, Non-Fiction, Romance, Adventure, Horror
	private String description;

	public Book (float price, String genre, String description) {
		this.price = price;
		this.genre = genre;
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}
	
	public String getGenre() {
		return genre;
	}

	public String getDescription() {
		return description;
	}
}

