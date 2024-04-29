package main;

import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	public static List<Book> readBooksFromCSV(String fileName) {
		String row = null;  
		String splitBy = ",";
		
		List<Book> books = new ArrayList<>();
		
		try {
			//parsing a CSV file into BufferedReader class constructor
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			// Skip the header line
			reader.readLine();
			
			while ((row = reader.readLine()) != null) {   //returns a Boolean value
				String[] line = row.split(splitBy);    // use comma as separator
				// Title,Author,ISBN,Date Published,Publisher,Pages,Genre,Description,Format,Price
				String title = line[0];
                String author = line[1];
                String isbn = line[2];
                String datePublished = line[3];
                String publisher = line[4];
                String pages = line[5];
                String genre = line[6];
                // String description = line[7];
                String format = line[8];
                String price = line[9];
                books.add(new Book(title, author, isbn, datePublished, publisher, pages, genre, /* description,*/ format, price));
            }
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return books;
	}
}