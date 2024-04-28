package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main {

	private JFrame bookstore_app;
	private JPanel header;
	private JPanel body;
	private JPanel footer;
	private JLabel bestsellers;
	private JLabel book_list_label;
	private JList<String> book_list;
	private JLabel bookworm_facts;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		List<Book> books = CSVReader.readBooksFromCSV("Files/BookstoreList.csv");
        BookstoreInterface bookStore = new BookstoreApp(books);
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main(bookStore);
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
	public Main(BookstoreInterface bookStore) {
		initialize(bookStore);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(BookstoreInterface bookStore) {
		bookstore_app = new JFrame();
		bookstore_app.getContentPane().setBackground(new Color(255, 248, 189));
		bookstore_app.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMP 730/830 Book Store");
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 20, 1205, 55);
		bookstore_app.getContentPane().add(lblNewLabel);
		
		header = new JPanel();
		header.setBackground(new Color(204, 227, 246));
		header.setBounds(20, 87, 1205, 40);
		bookstore_app.getContentPane().add(header);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		bestsellers = new JLabel();
		bestsellers.setText(bookStore.showBestsellers());
		header.add(bestsellers);
		
		body = new JPanel();
		body.setBackground(new Color(204, 227, 246));
		body.setBounds(20, 153, 1205, 441);
		bookstore_app.getContentPane().add(body);
		
		book_list_label = new JLabel("Our Selection of Books");
		body.add(book_list_label);
		
		List<Book> bookstore_arraylist = bookStore.browseBooks();
		book_list = new JList<>(bookstore_arraylist.toArray(new String[0]));
		body.add(book_list);
		
		footer = new JPanel();
		footer.setBackground(new Color(204, 227, 246));
		footer.setBounds(20, 626, 1205, 124);
		bookstore_app.getContentPane().add(footer);
		
		bookworm_facts = new JLabel();
		bookworm_facts.setText(bookStore.showBookwormFacts());
		footer.add(bookworm_facts);
		bookstore_app.setBounds(100, 100, 1246, 800);
		bookstore_app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// bookStore.showBookwormFacts();
		
	}
}
