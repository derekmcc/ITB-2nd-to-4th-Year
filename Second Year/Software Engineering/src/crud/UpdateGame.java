/**
 * This is a class to update the games database
 */
package crud;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dbController.LoginController;
import dbController.dbConnect;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class UpdateGame extends JFrame implements ActionListener, ListSelectionListener {
	
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String gameID, ID, password, Role;
	private Float account;
	public float price;
	
	//Database engine for creating DB connection, making queries
	dbConnect dbEngine = new dbConnect(); //database engine
	//create an instance of the login controller
	LoginController lg = new LoginController();
	
	//global scope components
	JLabel lblName, lblPrice, lblCategory;
	JButton btnEnter, btnCancel;
	JTextField txtName, txtPrice;
	JComboBox<String>cboCategory;
	JTable gameTable = null;
	JScrollPane scrollPane;
	JButton btnBack;
	
	/**
	 * This is a constructor to show the games in a table, which the user can choose 
	 * to update or not.
	 * 
	 * @param ID String value of the users studentID
	 * @param password String value of the users password
	 * @param Role String value to keep track of the users role eg.(Admin or regular user)
	 * @param account Float value of the amount the user has in there account
	 */
	public UpdateGame(String ID, String password, String Role, Float account) {
		//set the title of the frame
		super("Update Game");
		
		//assign the value from the passed variables to the global scope variables 
		this.ID = ID;
		this.password = password;
		this.Role = Role;
		this.account = account;
		
		//call the init method to create a database connection
		init();
		
		//set the visibility, resizability, location and  pack the component’s to the frames preferred sizes
		setVisible(true);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * This is the second overloaded constructor to create a GUI for the user to be able to 
	 * enter the new values for the selected game.
	 * 
	 * @param gameID String value of the gameID
	 * @param ID String value of the users studentID
	 * @param password String value of the users password
	 * @param Role String value to keep track of the users role eg.(Admin or regular user)
	 * @param account Float value of the amount the user has in there account
	 */
	public UpdateGame(String gameID, String ID, String password, String Role, Float account) {
		//set the title of the constructor
		super("Update Game");	
		
		//assign the value from the passed variables to the global scope variables 
		this.gameID = gameID;
		this.ID = ID;
		this.password = password;
		this.Role = Role;
		this.account = account;
		
		//string array to hold the game categories 
		String gameCategory[] = {"Action", "Sport", "RPG", "Simulation"};
		
		//create the labels
		lblName = new JLabel("Enter Game Name");
		lblCategory = new JLabel("Choose a category");
		lblPrice = new JLabel("Enter Price €");
		
		//create the text fields and combo box & add a listener
		txtName = new JTextField(10);
		cboCategory = new JComboBox<String>(gameCategory);
		txtPrice = new JTextField(10);
		cboCategory.addActionListener(this);
		
		//create the buttons and add listeners to them
		btnEnter = new JButton("Enter");
		btnCancel = new JButton("Cancel");
		btnEnter.addActionListener(this);
		btnCancel.addActionListener(this);
		
		//create the panels
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
		
		//add the labels to the label panel
		lblPanel.add(lblName);
		lblPanel.add(lblCategory);
		lblPanel.add(lblPrice);
		
		//add the text fields to the text field panel
		txtPanel.add(txtName);
		txtPanel.add(cboCategory);
		txtPanel.add(txtPrice);
		
		//add the buttons to the button panel
		btnPanel.add(btnEnter);
		btnPanel.add(btnCancel);
		
		//add the label & text field panels to the input panel
		inputPanel.add(lblPanel);
		inputPanel.add(txtPanel);
		
		//set the layout of the wrapper and add the panels to it
		wrapper.setLayout(new BorderLayout());
		wrapper.add(inputPanel, "North");
		wrapper.add(btnPanel, "South");
		
		//create a container 'contentPane', set the layout and add the wrapper
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
	 * Method to create a database connection and call the getGameDetails method
	 */
	public void init() {
	     dbEngine.connect();
	     getGameDetail();
	}//end method
	
	/**
	 * Method to get all the games in the database and add them to a table
	 */
	public void getGameDetail() {
		//select everything from games table
		ResultSet rs;
		ResultSetMetaData rsmd = null;
		int colCount=0;
		String [] colNames = null;
		
		try {
			rs = dbEngine.executeQuery("select * from Games");
			rsmd = rs.getMetaData();
			colCount = rsmd.getColumnCount();
	        colNames = new String[colCount];
	        for(int i=1;i<=colCount;i++) {
	        	colNames[i-1] = rsmd.getColumnName(i);
	        }//end for
	        
			//Create a table model (used for controlling a JTable)
			DefaultTableModel model = new DefaultTableModel(colNames,0);
			gameTable = new JTable(model);
			
			//Similarly a ListSelectionModel represents the current state of the selection
			//for components (like JTables) 
			DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
			//allow single selection only from game table
			dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			gameTable.setSelectionModel(dlsm);
			dlsm.addListSelectionListener(this);
													
			//array to hold the row data
			String [] currentRow = new String[colCount];
			while(rs.next()) { //move the rs pointer on to the next record (starts before the 1st)
				for(int i=1;i<=colCount;i++) {
					currentRow[i-1] = rs.getString(i);
				}//end for
				//add the row to the table through the table model
				model.addRow(currentRow); 
			}//end while
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
		//add the table to a scroll pane
		scrollPane = new JScrollPane(gameTable);
		
		//create the panels
		JPanel panScroll = new JPanel();
		JPanel panBtn = new JPanel();
		JPanel wrapper = new JPanel();
		
		//create a button and add an action listener 
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		
		//add the components to the panels
		panScroll.add(scrollPane);
		panBtn.add(btnBack);
		
		//set the layout of the wrapper & add the panels to it
		wrapper.setLayout(new BorderLayout());
		wrapper.add(panScroll, BorderLayout.NORTH);
		wrapper.add(panBtn, BorderLayout.SOUTH);
		//add the wrapper to the content pane
		this.getContentPane().add(wrapper);
	}//end method
	
	/**
	 * Method to show all the games in the database and give the user the option to 
	 * update them.
	 * 
	 * @param gID String value of the selected games id
	 * @param gamePrice String value of the selected games price
	 */
	public void showGameDialog(String gID, String gamePrice) {
		//parse the string value of the games price to a float value 'price'
		price = Float.parseFloat(gamePrice);
		ResultSetMetaData rsmd = null;
		int colCount=0;
		String message = "Game Details:\n";
		try {
			ResultSet rs = dbEngine.executeQuery("select * from Games where GameID='" + ID + "'");
			rsmd = rs.getMetaData();
			rs.next();//move result set pointer to first and only row
			colCount = rsmd.getColumnCount();//get number of columns
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
		//prompt the user if they want to edit the selected game
		int n = JOptionPane.showConfirmDialog(
			    this,
			    "Are you sure you want to update game?\n\n",
			    "Update Game",
			    JOptionPane.YES_NO_OPTION);
		//if the user choose yes (update game)
		if (n == JOptionPane.YES_OPTION) {
			//close this method and call the update game method 
			this.dispose();
			new UpdateGame(gID, ID,  password,  Role,  account);
		}//end if
	}//end method
	
	/**
	 * Method to update the games database with the new passed variables
	 * 
	 * @param gameName String value of the game name
	 * @param Category String value of the games category
	 * @param GamePrice Float value of the games price
	 */
	public void sqlUpdateGame(String gameName, String Category, Float GamePrice) {
		try {
			//try execute the update query
			dbEngine.executeQuery("UPDATE Games SET GameName='"+gameName+"',GameCategory='"+Category+"',GamePrice="+GamePrice+ " WHERE GameID='" + getGameID() + "';");
		} catch (SQLException e) {
			//catch exceptions and print error message and stack trace
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
	}//end sqlUpdate method
	
	/**
	 * Method to handle the users interaction from the listeners
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//if the user selects the enter button 
		if (e.getSource() == btnEnter) {
			//if the text fields equals an empty string 
			if (txtName.getText().equals("") || txtPrice.getText().equals("")) {
				//creates a beep
				java.awt.Toolkit.getDefaultToolkit().beep();
				//display error message
				JOptionPane.showMessageDialog(this,"All fields need data entered","ERROR",JOptionPane.WARNING_MESSAGE);
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
				System.out.println("Before Instantiation\t"+gameID +" "+gName + " " + gCategory + " "+gFloatPrice);
				
				//call the init method
				init();
				
				//call update method while passing the newly entered variables
				sqlUpdateGame(gName, gCategory, gFloatPrice);
				
				//display message 
				JOptionPane.showMessageDialog(this, "Game Successfully Updated in Database",
						"Game Updated",JOptionPane.INFORMATION_MESSAGE);		
				
				//close this class and call the admin options class
				this.dispose();	
				new AdminOptions(ID, password, Role, account);	
			}//end else
		}//end if
		//else if the user selects the cancel button
		else if (e.getSource() == btnCancel) {
			//close this class and call the admin options class
			this.dispose();
			new AdminOptions(ID, password, Role, account);
		}//end else if
		else if (e.getSource() == btnBack) {
			//close this class and call the admin options class
			this.dispose();
			new AdminOptions(ID, password, Role, account);	
		}//end else if
	}//end actionPerformed
	
	/**
	 * Method to handle the list selection listeners from the table
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//get the id and price from the selected game
		String gameID = (String) gameTable.getValueAt(gameTable.getSelectedRow(), gameTable.getColumnCount()-4);
		String gamePrice = (String) gameTable.getValueAt(gameTable.getSelectedRow(), gameTable.getColumnCount()-1);
		
		//set the game ID
		setGameID(gameID);
		
		//call the showGameDialog method and pass the game id & price
		showGameDialog(gameID, gamePrice);	
	}//end method
	
	/**
	 * Method to get the game ID
	 * 
	 * @return The game id
	 */
	public String getGameID() {
		return gameID;
	}//end getGameID

	/**
	 * Method to set the game ID
	 * 
	 * @param gameID String value of gameID
	 */
	public void setGameID(String gameID) {
		//assign the value of the passed variable to the global scope variable 
		this.gameID = gameID;
	}//end setGameID
}//end class
