import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class Main {

	private JFrame bookstore_app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		List<Book> books = CSVReader.readBooksFromCSV("Files/Bookstore_List.csv");
        BookStoreInterface bookStore = new BookStoreApp(books);

        // Example usage:
        bookStore.browseBooks();
        // bookStore.showBestsellers();
        // bookStore.showBookwormFacts();
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.bookstore_app.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bookstore_app = new JFrame();
		bookstore_app.getContentPane().setBackground(new Color(255, 248, 189));
		
		JPanel header = new JPanel();
		header.setBackground(new Color(182, 221, 249));
		bookstore_app.getContentPane().add(header, BorderLayout.NORTH);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel bestsellers = new JPanel();
		header.add(bestsellers);
		
		JLabel bestsellers_list = new JLabel("BESTSELLERS");
		bestsellers.add(bestsellers_list);
		
		JPanel title = new JPanel();
		header.add(title);
		
		JLabel title_text = new JLabel("TITLE");
		title.add(title_text);
		
		JPanel body = new JPanel();
		body.setBackground(new Color(215, 226, 246));
		bookstore_app.getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JList book_list = new JList();
		body.add(book_list);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(182, 221, 249));
		bookstore_app.getContentPane().add(footer, BorderLayout.SOUTH);
		footer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel bookworm_facts = new JLabel("BOOKWORM FACTS");
		footer.add(bookworm_facts);
		bookstore_app.setBounds(100, 100, 450, 300);
		bookstore_app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
