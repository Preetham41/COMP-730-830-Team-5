import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = CSVReader.readBooksFromCSV("Bookstore_List.csv");
        BookStoreInterface bookStore = new BookStoreApp(books);

        // Example usage:
        bookStore.browseBooks();
        // bookStore.showBestsellers();
        // bookStore.showBookwormFacts();
    }
}
