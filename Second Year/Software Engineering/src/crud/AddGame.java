/**
 * In this class we add games to the database 
 */
package crud;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbController.dbConnect;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class AddGame extends JFrame implements ActionListener {
	
	/**
	 *Default serial 
	 */
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String ID, password, Role;
	private float account;
	
	//Database engine for creating DB connection, making queries
	dbConnect dbEngine = new dbConnect(); //database engine 
	
	//global scope components
	JLabel lblName, lblPrice, lblCategory;
	JButton btnEnter, btnCancel;
	JTextField txtName, txtPrice;
	JComboBox<String>cboCategory;
	
	/**
	 * This is the GUI constructor which gets passed the users credentials
	 * 
	 * @param ID String value of the users studentID
	 * @param password String value of the users password
	 * @param Role String value to keep track of the users role eg.(Admin or regular user)
	 * @param account Float value of the amount the user has in there account
	 */
	public AddGame(String ID, String password, String Role, Float account) {
		//set the title of the frame
		super("Add new Game");
		
		//assign the value from the passed variables to the global scope variables 
		this.ID = ID;
		this.password = password;
		this.Role = Role;
		this.account = account;
		
		//call the init method
		init();
		
		//string array to hold the game categories
		String gameCategory[] = {"Action", "Sport", "RPG", "Simulation"};
		
		//create the labels
		lblName = new JLabel("Enter Game Name");
		lblCategory = new JLabel("Choose a category");
		lblPrice = new JLabel("Enter Price €");
		
		//create the text fields and combo box
		txtName = new JTextField(10);
		cboCategory = new JComboBox<String>(gameCategory);
		txtPrice = new JTextField(10);
		cboCategory.addActionListener(this);
		
		//create the buttons and add the listeners
		btnEnter = new JButton("Enter");
		btnCancel = new JButton("Cancel");
		btnEnter.addActionListener(this);
		btnCancel.addActionListener(this);
		
		//create the panels to hold the components
		JPanel lblPanel = new JPanel();
		JPanel txtPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel wrapper = new JPanel();
		
		//set the layout of the panels
		lblPanel.setLayout(new GridLayout(3, 1, 5, 5));
		txtPanel.setLayout(new GridLayout(3, 1, 5, 5));
		btnPanel.setLayout(new GridLayout(1, 2, 5, 5));
		inputPanel.setLayout(new GridLayout(1, 2, 5, 10));
		
		//add the labels to the labelPanel
		lblPanel.add(lblName);
		lblPanel.add(lblCategory);
		lblPanel.add(lblPrice);
		
		//add the text fields to the textFieldPanel 
		txtPanel.add(txtName);
		txtPanel.add(cboCategory);
		txtPanel.add(txtPrice);
		
		//add the buttons to the buttonPanel
		btnPanel.add(btnEnter);
		btnPanel.add(btnCancel);
		
		//add the panels to the inputPanel
		inputPanel.add(lblPanel);
		inputPanel.add(txtPanel);
		
		//set the layout and add the panels to the wrapper
		wrapper.setLayout(new BorderLayout());
		wrapper.add(inputPanel, "North");
		wrapper.add(btnPanel, "South");
		
		//create the content pane and add the wrapper panel
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		contentPane.add(wrapper);
		
		//set the size, visibility, resizability & position of the frame
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * Method to call and create a database connection
	 */
	public void init() {
	     dbEngine.connect();
	}//end method
	
	/**
	 * Action performed method to handle users responses 
	 * 
	 * @param e Action event variable to listen for action events
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//if the user press's enter 
		if (e.getSource() == btnEnter) {
			//if the text fields equals an empty string
			if (txtName.getText().equals("") || txtPrice.getText().equals("")) {
				//creates a beep
				java.awt.Toolkit.getDefaultToolkit().beep();
				//display error message
				JOptionPane.showMessageDialog(this,"All fields need data entered",
						"ERROR",JOptionPane.WARNING_MESSAGE);
			}//end if
			//else if the price entered is not numeric digits in the format x.xx 
			else if (!txtPrice.getText().matches("\\d+\\.\\d{2}")){
				//creates a beep
				java.awt.Toolkit.getDefaultToolkit().beep();
				//display error message
				JOptionPane.showMessageDialog(this, "Price needs to be in this format x.xx e.g.(9.99 or 10.50 etc)",
					"ERROR",JOptionPane.WARNING_MESSAGE);
			}//end else if
			else {
				//add the inputed data to temp variables
				String gName = txtName.getText();
				String gCategory = (String) cboCategory.getSelectedItem();
				String gPrice = txtPrice.getText();
				Float gFloatPrice = Float.parseFloat(gPrice);
				
				//call insert method while passing the newly entered variables 
				sqlInsertGame(gName, gCategory, gFloatPrice);
				
				//display message 
				JOptionPane.showMessageDialog(this, "Game Successfully Added to Database",
						"Game Inserted",JOptionPane.INFORMATION_MESSAGE);
				
				//close this class and call the admin options class
				this.dispose();
				new AdminOptions(ID, password, Role, account);
			}//end else
		}//end if
		
		//else if the user press's cancel 
		else if (e.getSource() == btnCancel) {
			//close this class and call the admin options class
			this.dispose();
			new AdminOptions(ID, password, Role, account);
		}//end else if
	}//end actionPerformed
	
	/**
	 * This is the insert game method which insert a new game into the database
	 * 
	 * @param gName String value of the game name 
	 * @param gCategory String value of the game category
	 * @param gPrice Float value of the game price
	 */
	public void sqlInsertGame(String gName, String gCategory, Float gPrice) { 
		try {
			//try and execute query 
			dbEngine.executeQuery("INSERT INTO Games VALUES (null,'"+gName+"','"+ gCategory + "',"+ gPrice+")");
		} catch (SQLException e) {
			//catch any exception and print error message and the stack trace
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
	}//end method
}//end class
