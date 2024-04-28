package main;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame bookstore_app;
	private JPanel header;
	private JPanel body;
	private JPanel footer;
	private JLabel bestsellers;
	private JLabel book_list_label;
	private JList book_list;
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
		
		header = new JPanel();
		header.setBackground(new Color(204, 227, 246));
		header.setBounds(20, 20, 410, 40);
		bookstore_app.getContentPane().add(header);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		bestsellers = new JLabel();
		bestsellers.setText(bookStore.showBestsellers());
		header.add(bestsellers);
		
		body = new JPanel();
		body.setBackground(new Color(204, 227, 246));
		body.setBounds(20, 70, 410, 130);
		bookstore_app.getContentPane().add(body);
		
		book_list_label = new JLabel("Our Selection of Books");
		body.add(book_list_label);
		
		book_list = new JList();
		body.add(book_list);
		// bookStore.browseBooks();
		
		footer = new JPanel();
		footer.setBackground(new Color(204, 227, 246));
		footer.setBounds(20, 210, 410, 40);
		bookstore_app.getContentPane().add(footer);
		
		bookworm_facts = new JLabel();
		bookworm_facts.setText(bookStore.showBookwormFacts());
		footer.add(bookworm_facts);
		bookstore_app.setBounds(100, 100, 450, 300);
		bookstore_app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// bookStore.showBookwormFacts();
		
	}
}
