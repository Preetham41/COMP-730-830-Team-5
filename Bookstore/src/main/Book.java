package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Book {
	
	public Book() {
		try {
			readCsv();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readCsv() throws IOException {
		// Title, Author, ISBN, Date Published, Publisher, Pages, Genre, Description, Format, Price
		File file = new File("Files/BookstoreList.csv");
	    System.out.println(file);
	    
		FileReader fileReader = new FileReader(file);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String line;
	    String[] tokenizedLine;

	    while ((line = bufferedReader.readLine()) != null) {
	        tokenizedLine = parse(line);
	        System.out.println(tokenizedLine);
	    }
	}
	
	private static String[] parse(String line) { // use split or Scanner
        return line.split(",");
    }
	
	
}
