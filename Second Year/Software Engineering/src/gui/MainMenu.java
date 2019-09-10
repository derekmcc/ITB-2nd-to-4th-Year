/**
 * This is the main menu of program which lets the user View, Buy, Trade games as well as CRUD options for the DB
 */
package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import crud.AdminOptions;
import dbController.dbConnect;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.1
 */
public class MainMenu extends JFrame implements ActionListener{
	//default serial
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String ID, password, Role;
	private float account;
	//Database engine for creating DB connection, making queries
	dbConnect dbEngine = new dbConnect(); //database engine
	
	//create a font for the labels
	Font welcomeFont = new Font("Serif", Font.BOLD, 18);
	
	//global scope components
	JButton btnViewGames, btnBuyGames, btnTradeGames, btnAddFunds, btnAdmin;
	JLabel lblAccount;
	
	//create an instance of the AddFunds class
	AddFunds af = new AddFunds();
	
	/**
	 * Constructor for the GUI
	 * 
	 * @param ID String value of the users ID
	 * @param password String value for the users password
	 * @param Role String value for the user role
	 * @param account Float value of the users account
	 */
	public MainMenu(String ID, String password, String Role, Float account) {
		//set title of the frame
		super("3's Company Main Menu");
		
		//assign the value from the passed variables to the global scope variables 
		this.ID = ID;
		this.password = password;
		this.Role = Role;
		this.account = account;

		//create labels
		JLabel lblWelcome = new JLabel("Welcome " + ID);
		lblAccount = new JLabel("Account Balance: €" + String.format("%.2f", getAccount()));
		//set the font colour for the label
		lblAccount.setForeground(Color.RED);
		
		//set the font on the label
		lblWelcome.setFont(welcomeFont);
		
		//create the panels
		JPanel btnPanel1 = new JPanel();
		JPanel btnPanel2 = new JPanel();
		JPanel btnPanel3 = new JPanel();
		JPanel lblPanel1 = new JPanel();
		JPanel lblPanel2 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel wrapper = new JPanel();
		
		//create the buttons
		btnViewGames = new JButton("View Games");
		btnBuyGames = new JButton("Buy Games");
		btnTradeGames = new JButton("Trade Games");
		btnAddFunds = new JButton("Add Funds");
		btnAdmin = new JButton("Admin Options");
		
		//set the size of the buttons
		btnViewGames.setPreferredSize(new Dimension(40, 60));
		
		//add the listeners to the buttons
		btnViewGames.addActionListener(this);
		btnBuyGames.addActionListener(this);
		btnTradeGames.addActionListener(this);
		btnAddFunds.addActionListener(this);
		btnAdmin.addActionListener(this);
		
		//create a container for the panels
		Container contentPane = getContentPane();
		
		//add the labels to the panels
		lblPanel1.add(lblWelcome);
		lblPanel2.add(lblAccount);
		//add the buttons to the panels
		btnPanel1.add(btnViewGames);
		btnPanel1.add(btnBuyGames);
		btnPanel1.add(btnTradeGames);
		btnPanel1.add(btnAddFunds);
		
		//if the user is an admin add the admin button to the panel
		if(Role.equals("ADMIN")) {
			//add the admin button to the panel
			btnPanel2.add(btnAdmin);
		}//end if
		
		//add the button panels to the panel
		btnPanel3.add(btnPanel1);
		
		//set the layout of the panels
		btnPanel1.setLayout(new GridLayout(2,2,10,10));
		panel1.setLayout(new BorderLayout());
		
		//add the components to the inner wrapper
		panel1.add(lblPanel1, BorderLayout.NORTH);
		panel1.add(btnPanel3, BorderLayout.CENTER);
		panel1.add(btnPanel2, BorderLayout.SOUTH);
		
		//set the layout of the outer wrapper and add the components 
		wrapper.setLayout(new BorderLayout());
		wrapper.add(panel1, BorderLayout.NORTH);
		wrapper.add(lblPanel2, BorderLayout.SOUTH);
		
		//set the layout of the contentPane and add the wrapper
		contentPane.setLayout(new GridBagLayout());
		contentPane.add(wrapper);
		 
		//set the size, visibility, resizability & position of the frame
		setSize(320,300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * Method to get the account
	 * 
	 * @return The users account
	 */
	public float getAccount() {
		return account;
	}//end getAccount
	
	/**
	 * Method to set the users account
	 * 
	 * @param account Float value of the users account
	 */
	public void setAccount(float account) {
		//set the global scope account to that of the passed variables value
		this.account = account;
		//create a string
		String a = "" + account;
		//set the label to show the amount the user has in their account
		lblAccount.setText(a);
	}//end setAccount
	
	/**
	 * Method to handle the users interaction from the listeners
	 * 
	 * @param e Event object
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//if the user clicks the view games button
		if(e.getSource() == btnViewGames) {
			//close this class
			this.dispose();
			//create an instance of the view games class
			ViewGames vg = new ViewGames("View Games");
			//call the details method in the view games class
			vg.details(ID, password,Role,account);
		}//end if
		
		//else if the user clicks the buy games button
		else if(e.getSource() == btnBuyGames) {
			//close this class
			this.dispose();
			//create an instance of the buy games class
			BuyGames bg = new BuyGames("Buy Games");
			//call the details method in the buy games class
			bg.details(ID, password,Role,account);
		}//end else if
		
		//else if the user clicks the trade games button
		else if(e.getSource() == btnTradeGames) {
			//close this class
			this.dispose();
			//call the trade games class
			new TradeGames(ID, password, Role,account);
		}//end else if
		
		//else if the user clicks the add funds button
		else if(e.getSource() == btnAddFunds) {
			//call the details method in the add funds class
			af.details(ID, password,Role,account);
			//assign the value to account from the add funds method in the add funds class
			account = af.addFundsToAccount();
			//update the label to show the new account balance
			lblAccount.setText("Account Balance: €" + String.format("%.2f", account));
		}//end else if
		
		//else if the user clicks the admin options button
		else if(e.getSource() == btnAdmin) {
			//close this class
			this.dispose();
			//call the admin options class
			new AdminOptions(ID, password, Role, account);
		}//end else if	
	}//end actionPerformed method
}//end class
