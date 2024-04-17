import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Book> readBooksFromCSV(String fileName) {
        List<Book> books = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            // Skip the header line
            reader.readNext();
            
            String[] line;
            while ((line = reader.readNext()) != null) {
                String title = line[0];
                String author = line[1];
                String isbn = line[2];
                String datePublished = line[3];
                String publisher = line[4];
                int pages = Integer.parseInt(line[5]);
                String genre = line[6];
                String description = line[7];
                String format = line[8];
                double price = Double.parseDouble(line[9]);
                books.add(new Book(title, author, isbn, datePublished, publisher, pages, genre, description, format, price));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return books;
    }
}
