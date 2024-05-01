package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	// application frame
	private JFrame bookstoreAppFrame;
	// sections
	private JPanel header;
	private JSplitPane body;
	private JPanel footer;
	// lists
	private List<String> availableBooks;
	private JList<String> bookList;
	// list model
	private DefaultListModel<String> availableBooksModel;
	// section titles
	private JLabel bestsellers, bookListLabel, bookwormFacts;
	// book details
	private JLabel title, bookTitle, bookAuthor, bookISBN, bookYear, bookPublisher, bookPages, bookGenre, bookFormat, bookQuantity, bookPrice;
	// button
	private JButton buyButton;
	// fields
	private JTextField FirstName, LastName, Quantity, Address;
	public int i = 0;
	
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
					window.bookstoreAppFrame.setVisible(true);
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
		// main application frame
		bookstoreAppFrame = new JFrame();
		bookstoreAppFrame.getContentPane().setBackground(new Color(255, 248, 189));
		bookstoreAppFrame.getContentPane().setLayout(null);
		
		// application title
		title = new JLabel("COMP 730/830 Book Store");
		title.setFont(new Font("Helvetica Neue", Font.PLAIN, 36));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(20, 20, 1205, 55);
		bookstoreAppFrame.getContentPane().add(title);
		
		// header section
		header = new JPanel();
		header.setBackground(new Color(204, 227, 246));
		header.setBounds(20, 87, 1205, 40);
		bookstoreAppFrame.getContentPane().add(header);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// bestsellers
		bestsellers = new JLabel();
		bestsellers.setText(bookStore.showBestsellers());
		header.add(bestsellers);
		
		// body label
		bookListLabel = new JLabel("Our Selection of Books");
		bookListLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		bookListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookListLabel.setBounds(20, 127, 1205, 55);
		bookstoreAppFrame.getContentPane().add(bookListLabel);
		
		// body section
		body = new JSplitPane();
		body.setBackground(new Color(204, 227, 246));
		body.setBounds(20, 183, 1205, 422);
		bookstoreAppFrame.getContentPane().add(body);
		
		// model for book list
		availableBooks = bookStore.browseBooks();
		// Create a DefaultListModel to store the strings
        availableBooksModel = new DefaultListModel<>();
        for (String availableBook : availableBooks) {
        	availableBooksModel.addElement(availableBook);
        }
        
        // initializing body.leftpanel components
		bookList = new JList<String>(availableBooksModel);
		bookTitle = new JLabel();
		bookAuthor = new JLabel();
		bookISBN = new JLabel();
		bookYear = new JLabel();
		bookPublisher = new JLabel();
		bookPages = new JLabel();
		bookGenre = new JLabel();
		bookFormat = new JLabel();
		bookQuantity = new JLabel();
		bookPrice = new JLabel();
		buyButton = new JButton("Buy");
		buyButton.setVisible(false);
		
		// initializing center book components
		FirstName = new JTextField(20);
		LastName = new JTextField(20);
		Quantity = new JTextField(20);
		Address = new JTextField(80);
		
		
		
		// fonts
		bookList.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
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
		buyButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		FirstName.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		LastName.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		Quantity.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		Address.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// left book details
		bookTitle.setHorizontalAlignment(SwingConstants.LEFT);
		bookAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		bookISBN.setHorizontalAlignment(SwingConstants.LEFT);
		bookYear.setHorizontalAlignment(SwingConstants.LEFT);
		bookPublisher.setHorizontalAlignment(SwingConstants.LEFT);
		bookPages.setHorizontalAlignment(SwingConstants.LEFT);
		bookGenre.setHorizontalAlignment(SwingConstants.LEFT);
		bookFormat.setHorizontalAlignment(SwingConstants.LEFT);
		bookQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		bookPrice.setHorizontalAlignment(SwingConstants.LEFT);
		
		// additional bookList attributes
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookList.setBackground(new Color(204, 227, 246));
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
		
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	JButton saveButton = new JButton("Save Order");
            	JFrame buyFrame = new JFrame("Buy Book");
                buyFrame.getContentPane().setBackground(new Color(255, 248, 189));
        		buyFrame.getContentPane().setLayout(null);
        		
        		
        		// application title
        		title = new JLabel("CHECK OUT");
        		title.setFont(new Font("Helvetica Neue", Font.PLAIN, 36));
        		title.setHorizontalAlignment(SwingConstants.LEFT);
        		title.setBounds(20, 20, 1205, 55);
        		buyFrame.getContentPane().add(title);
        		
        		// name section
        		JPanel namepanel = new JPanel();
                namepanel.setLayout(new FlowLayout());
        		namepanel.setBackground(new Color(204, 227, 246));
        		namepanel.setBounds(20, 87, 1205, 40);
        		bookstoreAppFrame.getContentPane().add(header);
        		namepanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        		
        		//****String name = bookTitle.getText();
        		JLabel Name1 = new JLabel("First Name:");
        		JTextField FirstName = new JTextField(20); // Create text field
        		namepanel.add(Name1);
                namepanel.add(FirstName);
                
                namepanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
                JLabel Name2 = new JLabel("Last Name:");
        		JTextField LastName = new JTextField(20); // Create text field
        		namepanel.add(Name2);
                namepanel.add(LastName);
                
                JPanel addresspanel = new JPanel();
        		addresspanel.setBackground(new Color(204, 227, 246));
        		addresspanel.setBounds(20, 183, 1205, 422);
        		bookstoreAppFrame.getContentPane().add(body);
        		addresspanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        		
                
                JLabel Locality = new JLabel("Address: ");
        		JTextField Address = new JTextField(80); // Create text field
        		addresspanel.add(Locality);
                addresspanel.add(Address);
                
        	
                JLabel Quantity = new JLabel("Quantity: ");
                JTextField Books = new JTextField(5);
                addresspanel.add(Quantity);
                addresspanel.add(Books);
                addresspanel.add(saveButton);
        		
                // Set the size, position, and other properties of the buy window
                buyFrame.setSize(1205, 600);
                buyFrame.setLocationRelativeTo(null); // Center the buy window on the screen
                buyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Adjust this according to your requirements
                
                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Read user input
                        String bookname = bookTitle.getText();
                        String firstName = FirstName.getText();
                        String lastName = LastName.getText();
                        String address = Address.getText();
                        String quantity = Books.getText();
                        

                        // Path to the CSV file
                        String filePath = "C:/Users/HP/Java_Output/output"+i+".csv";

                        // Write user input to the CSV file
                        try (FileWriter writer = new FileWriter(filePath)) {
                            // Write headers
                            writer.append("Book Title");
                            writer.append(",");
                            writer.append("First Name");
                            writer.append(",");
                            writer.append("Last Name");
                            writer.append(",");
                            writer.append("Address");
                            writer.append(",");
                            writer.append("Quantity");
                            writer.append("\n");

                            // Write user input
                            writer.append(bookname);
                            writer.append(",");
                            writer.append(firstName);
                            writer.append(",");
                            writer.append(lastName);
                            writer.append(",");
                            writer.append(address);
                            writer.append(",");
                            writer.append(quantity);
                            writer.append("\n");
                            System.out.println("Data has been written to " + filePath);
                            i += 1;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                // Add components to the buy window
                // For example:
                //buyFrame.getContentPane().add(new JLabel("JayCee"));

                // Set the visibility of the current JFrame to false
                bookstoreAppFrame.setVisible(false);

                // Set the visibility of the buy window to true
                buyFrame.add(namepanel); // Add panel to frame
                buyFrame.add(addresspanel);
                buyFrame.setVisible(true);
                buyFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Make the previous window visible again
                        bookstoreAppFrame.setVisible(true);
                    }
                });
            }
        });
		
		// body.rightpanel component (details)
		JPanel detailPane = new JPanel();
		detailPane.setBackground(new Color(204, 227, 246));
		detailPane.setBounds(0, 0, 4, 4);
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
		
		// setting split pane components
		body.setLeftComponent(bookList);
		body.setRightComponent(detailPane);
		
		// footer section
		footer = new JPanel();
		footer.setBackground(new Color(204, 227, 246));
		footer.setBounds(20, 626, 1205, 124);
		bookstoreAppFrame.getContentPane().add(footer);
		
		// book worm facts
		bookwormFacts = new JLabel();
		bookwormFacts.setText(bookStore.showBookwormFacts());
		footer.add(bookwormFacts);
		bookstoreAppFrame.setBounds(100, 100, 1246, 800);
		bookstoreAppFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
}
