/**
 * This is a class in which the user can purchase games from the database. The most recent purchase is added 
 * to the database for example, if the user buys game1 then this is added to the database but if he then buys a second 
 * game game2 then this will overwrite the first game in the DB.
 */
package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import dbController.dbConnect;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class BuyGames extends JFrame implements ListSelectionListener, ActionListener {
	
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String studentID, studentPassword, userRole;
	private Float studentAccount;
	public float price;
	private int intGameID;
	
	//global scope components
	JTable gameTable = null;
	JScrollPane scrollPane;
	JButton btnBack;
	
	//Database engine for creating DB connection, making queries
	dbConnect dbEngine = new dbConnect(); //database engine
	
	/**
	 * Constructor to build GUI
	 * 
	 * @param title String value to set the title of the frame
	 */
	public BuyGames(String title) {
		//set the title
		super(title);
		
		//call the init method to establish a DB connection
		init();
		
		//set the visibility, resizability, location and pack the component’s to the frames preferred sizes
		setVisible(true);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * Method to establish a DB connection
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
		//object to get information from the results set
		ResultSetMetaData rsmd = null;
		//counter to keep track of the number of columns
		int colCount=0;
		//array to hold column names
		String [] colNames = null;
		
		//get the column names from the ResultSet metadata
		try {
			//add everything from the DB table to the result set
			rs = dbEngine.executeQuery("select * from Games");
			//add everything from the resultsSet to the metaData object 'rsmd'
			rsmd = rs.getMetaData();
			//get the column count from the metaData and assign it to the variable 'colCount'
			colCount = rsmd.getColumnCount();
			//create an array the length of the number of columns
			colNames = new String[colCount];
			//loop through the columns
	        for(int i=1;i<=colCount;i++) {
	        	//add the metaData column names to the string array 'colNames'
	        	colNames[i-1] = rsmd.getColumnName(i);
	        }//end for
	        
			//Create a table model 
			DefaultTableModel model = new DefaultTableModel(colNames,0);
			//create a table
			gameTable = new JTable(model);
			
			//Similarly a ListSelectionModel represents the current state of the selection
			//for components (like JTables) 
			DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
			//allow single selection only from game table
			dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			//add the selection model to the table
			gameTable.setSelectionModel(dlsm);
			//add listener to the table
			dlsm.addListSelectionListener(this); 
			
			//array to hold the row data
			String [] currentRow = new String[colCount];
			//move the rs pointer on to the next record (starts before the 1st)
			while(rs.next()) { 
				for(int i=1;i<=colCount;i++) {
					//add the resultSet data rows to the array
					currentRow[i-1] = rs.getString(i);
				}//end for
				//add the row to the table through the table model
				model.addRow(currentRow); 
			}//end while
		} catch (SQLException e) {
			//catch exception and print error message and stack trace
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
		
		//add the table to a scroll pane
		scrollPane = new JScrollPane(gameTable);
		
		//create panels
		JPanel panScroll = new JPanel();
		JPanel panBtn = new JPanel();
		JPanel wrapper = new JPanel();
		
		//create a button & add a listener
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		
		//add the components to the panels
		panScroll.add(scrollPane);
		panBtn.add(btnBack);
		
		//set the layout of the wrapper and add the panels to it
		wrapper.setLayout(new BorderLayout());
		wrapper.add(panScroll, BorderLayout.NORTH);
		wrapper.add(panBtn, BorderLayout.SOUTH);
		
		//add the wrapper to the content pane
		this.getContentPane().add(wrapper);
	}//end method
	
	/**
	 * Method to handle the list selection listeners from the table
	 */
	public void valueChanged(ListSelectionEvent e) {
		//get the id and price from the selected game
		String gameID = (String) gameTable.getValueAt(gameTable.getSelectedRow(), gameTable.getColumnCount()-4);
		String gamePrice = (String) gameTable.getValueAt(gameTable.getSelectedRow(), gameTable.getColumnCount()-1);
		
		//parse the string value of game id to an integer value 'intGameID'
		intGameID = Integer.parseInt(gameID);
		
		//call the game dialog method and pass the game ID & price
		showGameDialog(gameID, gamePrice);
	}//end method
	
	/**
	 * Method to show all the games in the database and give the user the option to 
	 * buy one.
	 * 
	 * @param ID String value of the selected games id
	 * @param gamePrice String value of the selected games price
	 */
	public void showGameDialog(String ID, String gamePrice) {
		//parse the string value of ID to a float value 'price'
		price = Float.parseFloat(gamePrice);
		
		//object to get information from the results set
		ResultSetMetaData rsmd = null;
		//counter to keep track of the number of columns
		int colCount=0;
		//sting message 
		String message = "Game Details:\n";
		
		//get the column names from the ResultSet metadata
		try {
			//add everything from the DB table to the result set
			ResultSet rs = dbEngine.executeQuery("select * from Games where GameID='"+ID+"'");
			//add everything from the resultsSet to the metaData object 'rsmd'
			rsmd = rs.getMetaData();
			//move result set pointer to first and only row
			rs.next();
			//get number of columns
			colCount = rsmd.getColumnCount();
			
			//create a game details message string
	        for(int i=1;i<=colCount;i++) {
	        	//add the game details to the message string
	        	message = message + rsmd.getColumnName(i)+": "+rs.getString(i)+"\n"; 
	        }//end for
		} catch (SQLException e) {
			//catch exception and print error message and stack trace
			System.err.println("SQLException: " + e.getMessage());
		}//end catch
		
		//prompt the user if they want to purchase the selected game
		int n = JOptionPane.showConfirmDialog(
			    this,
			    "Confirm purchase?\n\n" + message + "\n\n",
			    "Buy Game",
			    JOptionPane.YES_NO_OPTION);
		//if the user choose's yes
		if(n == JOptionPane.YES_OPTION) {
			//and have not got the required funds
			if(studentAccount - price < 0) {
				//display error message
				JOptionPane.showMessageDialog(this,"Not enough funds to purchase game","Error",JOptionPane.ERROR_MESSAGE);
			}//end if
			else {
				//else take the game value from the users account balance
				studentAccount -= price;
				//call the SQL update account method
				sqlUpdateAccount();
				//display message
				JOptionPane.showMessageDialog(this,"Congratulations your purchase has been successful");
			}//end else
		}//end if
	}//end method
	
	/**
	 * Method to execute an SQL statement to update the users account balance 
	 */
	public void sqlUpdateAccount() {		
		try {
			//try to execute an SQL update statement 
			dbEngine.executeQuery("UPDATE Users SET StudentAccount='"+ studentAccount + "',GameID= " +intGameID +" WHERE StudentID='" + studentID + "'");
		} catch (SQLException e) {
			//catch exception and print error message and stack trace
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
	}//end method
	
	/**
	 * Method to handle the users interaction from the listeners
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//close this class and call the MainMenu class
		this.dispose();
		new MainMenu(studentID,studentPassword,userRole,studentAccount);
	}//end actionPerformed method

	/**
	 * Method to receive the logged in users details
	 * 
	 * @param studentID String value of the user ID
	 * @param studentPassword String value of the users password
	 * @param userRole string value of the users role (Admin or regular user)
	 * @param studentAccount Float value of the users account
	 */
	public void details(String studentID, String studentPassword, String userRole, float studentAccount) {
		this.studentID = studentID;
		this.studentPassword = studentPassword;
		this.userRole = userRole;
		this.studentAccount = studentAccount;
	}//end details
}//end class