package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Books {
	public void readCsv() throws IOException {
	    File file = new File("filename.csv");
	    FileReader fileReader = new FileReader(file);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String line;
	    String[] tokenizedLine;

	    while ((line = bufferedReader.readLine()) != null) {
	        tokenizedLine = parse(line);
	        // do stuff with your array
	    }
	}
    
    private String[] parse(String line) { // use split or Scanner
        return line.split(",");
    }
}
