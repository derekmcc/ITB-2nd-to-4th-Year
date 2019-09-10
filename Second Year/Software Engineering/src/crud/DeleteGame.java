/**
 * This is the delete game class which deletes games from the database
 */
package crud;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
public class DeleteGame extends JFrame implements ActionListener, ListSelectionListener {
	
	/**
	 * Default serial 
	 */
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String studentID, studentPassword, userRole;
	private Float studentAccount;
	public float price;
	
	//global scope components
	JTable gameTable = null;
	JScrollPane scrollPane;
	JButton btnBack;

	//Database engine for creating DB connection, making queries
	dbConnect dbEngine = new dbConnect(); //database engine 
	
	//create an instance of the LoginControlle
	LoginController lg = new LoginController();
	
	/**
	 * This is the GUI constructor which gets passed the users credentials
	 * 
	 * @param studentID String value of the users studentID
	 * @param studentPassword String value of the users password
	 * @param userRole String value to keep track of the users role eg.(Admin or regular user)
	 * @param studentAccount Float value of the amount the user has in there account
	 */
	public DeleteGame(String studentID, String studentPassword, String userRole, Float studentAccount) {
		//set the title of the frame
		super("Delete Game");
		
		//assign the value from the passed variables to the global scope variables 
		this.studentID = studentID;
		this.studentPassword = studentPassword;
		this.userRole = userRole;
		this.studentAccount = studentAccount;
		
		//call the init method to create a database connection
		init();
		
		//set the size, visibility, resizability & position of the frame
		setVisible(true);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * Method to call and create a database connection
	 */
	public void init() {
	     dbEngine.connect();
	     getGameDetail();
	}//end method
	
	/**
	 * Method to to retrieve all the games from the database and add them to a table
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
			//allow single selection only from empTable
			dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			gameTable.setSelectionModel(dlsm);
			dlsm.addListSelectionListener(this); 
			//array to hold the row data
			String [] currentRow = new String[colCount];
			while(rs.next()) { //move the rs pointer on to the next record (starts before the 1st)
				for(int i=1;i<=colCount;i++) {
					currentRow[i-1] = rs.getString(i);
				}//end for
				model.addRow(currentRow); //add the row to the table through the table model
			}//end while
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
		//add the table to a scroll pane
		scrollPane = new JScrollPane(gameTable);
		
		//create panels to hold the components
		JPanel panScroll = new JPanel();
		JPanel panBtn = new JPanel();
		JPanel wrapper = new JPanel();
		
		//create a button
		btnBack = new JButton("Back");
		
		//add the components to the panel
		panScroll.add(scrollPane);
		panBtn.add(btnBack);
		
		//add an action listener to the button
		btnBack.addActionListener(this);
		
		//set the layout of the wrapper and add the panels
		wrapper.setLayout(new BorderLayout());
		wrapper.add(panScroll, BorderLayout.NORTH);
		wrapper.add(panBtn, BorderLayout.SOUTH);
		
		//add the wrapper to the contentPane
		this.getContentPane().add(wrapper);
	}//end method
	
	/**
	 * Method to handle list selection items from the user
	 */
	public void valueChanged(ListSelectionEvent e) {
		//get the id and price from the selected game
		String gameID = (String) gameTable.getValueAt(gameTable.getSelectedRow(), gameTable.getColumnCount()-4);
		String gamePrice = (String) gameTable.getValueAt(gameTable.getSelectedRow(), gameTable.getColumnCount()-1);
		showGameDialog(gameID, gamePrice);
	}//end method
	
	/**
	 * This is a method to show the selected games details to the user in a JOptionPane 
	 * 
	 * @param ID String value of the game id
	 * @param gamePrice String value of the game price
	 */
	public void showGameDialog(String ID, String gamePrice) {
		//parse the string value of the price to a float value 'price'
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
		//prompt the user if they want to delete the selected game
		int n = JOptionPane.showConfirmDialog(
			    this,
			    "Are you sure you want to delete game?\n\n",
			    "Delete Game",
			    JOptionPane.YES_NO_OPTION);
		//if the user chooses yes 'Delete game'
		if (n == JOptionPane.YES_OPTION) {
			//call the delete game method and pass the selected games id
			sqlDeletGame(ID);
			//prompt the user the game has been deleted
			JOptionPane.showMessageDialog(this,"Game deleted successfully");
			//close this class and call the AdminOptions class
			this.dispose();
			new AdminOptions(studentID, studentPassword, userRole, studentAccount);
		}//end if
	}//end method
	
	/**
	 * Method to delete the selected game from the database
	 * 
	 * @param ID String value of the selected games id to be deleted             
	 */
	public void sqlDeletGame(String ID) {	
		try {
			//try and execute the delete query
			dbEngine.executeQuery("DELETE FROM Games WHERE GameID='" + ID + "'");
		} catch (SQLException e) {
			//catch and print error message and stack trace
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
	}//end method
	
	/**
	 * Method to handle the back button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//close this class and call the AdminOptions class
		this.dispose();
		new AdminOptions(studentID, studentPassword, userRole, studentAccount);
	}//end ActionPerformed
}//end class
