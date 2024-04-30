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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame bookstore_app;
	private JPanel header;
	private JPanel footer;
	private JLabel bestsellers;
	private JLabel book_list_label;
	private JList<String> bookList;
	private JLabel bookworm_facts;
	private JSplitPane body;
	
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
		
		book_list_label = new JLabel("Our Selection of Books");
		book_list_label.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		book_list_label.setHorizontalAlignment(SwingConstants.CENTER);
		book_list_label.setBounds(20, 127, 1205, 55);
		bookstore_app.getContentPane().add(book_list_label);
		
		body = new JSplitPane();
		body.setBackground(new Color(204, 227, 246));
		body.setBounds(20, 183, 1205, 422);
		bookstore_app.getContentPane().add(body);
		
		
		
		List<String> availableBooks = bookStore.browseBooks();
		// Create a DefaultListModel to store the strings
        DefaultListModel<String> availableBooksModel = new DefaultListModel<>();
        for (String availableBook : availableBooks) {
        	availableBooksModel.addElement(availableBook);
        }
		bookList = new JList<String>(availableBooksModel);
		JLabel bookTitle = new JLabel();
		JLabel bookAuthor = new JLabel();
		JLabel bookISBN = new JLabel();
		JLabel bookYear = new JLabel();
		JLabel bookPublisher = new JLabel();
		JLabel bookPages = new JLabel();
		JLabel bookGenre = new JLabel();
		JLabel bookFormat = new JLabel();
		JLabel bookQuantity = new JLabel();
		JLabel bookPrice = new JLabel();
		
		JButton buyButton = new JButton("Buy");
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
			}
		});
		
		buyButton.setVisible(false);
		
		bookTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		bookAuthor.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookISBN.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookYear.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookPublisher.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookPages.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookGenre.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookFormat.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookQuantity.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		bookPrice.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		bookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bookAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		bookISBN.setHorizontalAlignment(SwingConstants.CENTER);
		bookYear.setHorizontalAlignment(SwingConstants.CENTER);
		bookPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		bookPages.setHorizontalAlignment(SwingConstants.CENTER);
		bookGenre.setHorizontalAlignment(SwingConstants.CENTER);
		bookFormat.setHorizontalAlignment(SwingConstants.CENTER);
		bookQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		bookPrice.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		bookList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent value) {
                if (!value.getValueIsAdjusting()) {
                	String selectedTitle = bookList.getSelectedValue().toString();
                	List<String> selectedTitleDetails = bookStore.showBookDetails(selectedTitle);
                	bookTitle.setText(selectedTitleDetails.get(0));
                	bookAuthor.setText("by " + selectedTitleDetails.get(1));
                	bookISBN.setText("ISBN-10: " + selectedTitleDetails.get(2));
                	bookYear.setText(selectedTitleDetails.get(3));
                	bookPublisher.setText(selectedTitleDetails.get(4));
                	bookPages.setText(selectedTitleDetails.get(5) + " pages");
                	bookGenre.setText(selectedTitleDetails.get(6));
                	bookFormat.setText(selectedTitleDetails.get(7));
                	bookQuantity.setText("Quantity: " + selectedTitleDetails.get(8));
                	bookPrice.setText("$" + selectedTitleDetails.get(9));
                	buyButton.setVisible(true);
                	
                }
            }
        });
		
		bookList.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookList.setBackground(new Color(204, 227, 246));
		body.setLeftComponent(bookList);
		//body.setRightComponent(bookDetails);
		
		JPanel detailPane = new JPanel();
		detailPane.setBackground(new Color(204, 227, 246));
		detailPane.setBounds(0, 0, 4, 4);
		body.setRightComponent(detailPane);
		detailPane.setLayout(new GridLayout(11, 0, 0, 0));
		detailPane.add(bookTitle);
		detailPane.add(bookAuthor);
		detailPane.add(bookISBN);
		detailPane.add(bookYear);
		detailPane.add(bookPublisher);
		detailPane.add(bookPages);
		detailPane.add(bookGenre);
		detailPane.add(bookFormat);
		detailPane.add(bookQuantity);
		detailPane.add(bookPrice);
		detailPane.add(buyButton);
		
		
		footer = new JPanel();
		footer.setBackground(new Color(204, 227, 246));
		footer.setBounds(20, 626, 1205, 124);
		bookstore_app.getContentPane().add(footer);
		
		bookworm_facts = new JLabel();
		bookworm_facts.setText(bookStore.showBookwormFacts());
		footer.add(bookworm_facts);
		bookstore_app.setBounds(100, 100, 1246, 800);
		bookstore_app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
