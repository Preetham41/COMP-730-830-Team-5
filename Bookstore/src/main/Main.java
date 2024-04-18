package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
		
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
		System.out.println(fileReader);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    System.out.println(bufferedReader);
	    String line;
	    String[] tokenizedLine;

	    while ((line = bufferedReader.readLine()) != null) {
	    	System.out.println(line + "\n");
	    	tokenizedLine = line.split(",");
	        // tokenizedLine = parse(line);
	        
	        System.out.println(tokenizedLine);
	    }
	}
	
	private static String[] parse(String line) { // use split or Scanner
        return line.split(",");
    }
    
}
