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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class Main {

	private JFrame bookstore_app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		List<Book> books = CSVReader.readBooksFromCSV("Files/Bookstore_List.csv");
        BookstoreInterface bookStore = new BookStoreApp(books);

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
		bookstore_app.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		bookstore_app.getContentPane().add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		JLabel bestsellers = new JLabel("New label");
		header.add(bestsellers, BorderLayout.NORTH);
		
		JPanel body = new JPanel();
		bookstore_app.getContentPane().add(body, BorderLayout.CENTER);
		
		JLabel book_list_label = new JLabel("Our Selection of Books");
		body.add(book_list_label);
		
		JList book_list = new JList();
		body.add(book_list);
		
		JPanel footer = new JPanel();
		bookstore_app.getContentPane().add(footer, BorderLayout.SOUTH);
		
		JLabel bookworm_facts = new JLabel("Bookworm Facts");
		footer.add(bookworm_facts);
		bookstore_app.setBounds(100, 100, 450, 300);
		bookstore_app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
