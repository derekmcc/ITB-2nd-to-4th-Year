/**
 * This is the add funds class which the user can add funds to there account
 */
package gui;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dbController.dbConnect;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class AddFunds extends JFrame {
	
	//default serial number 
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String studentID, studentPassword, userRole;
	private Float studentAccount;
	
	//global scope components
	JTextField txtAccount;
	
	//Database engine for creating DB connection, making queries
	dbConnect dbEngine = new dbConnect(); //database engine
	
	/**
	 * Method to add add funds to the users account
	 * 
	 * @return The new account balance 
	 */
	public float addFundsToAccount(){
		//local variables
		String strAddFunds="";
		float addFunds=0;
		
		//prompt the user to enter the amount to enter
		strAddFunds = JOptionPane.showInputDialog(this,"Enter the amount to add € ","Add Funds"
				,JOptionPane.INFORMATION_MESSAGE);
		//if the user selects cancel or the 'X' 
		if(strAddFunds == null){
			//set strAddFunds to zero to avoid causing a null pointer exception
			strAddFunds = "0";
		}//end if
		
		//try to validate user input to a float
		try {
			//parse the string value strAddFunds to a float value addFunds
		    addFunds = Float.parseFloat(strAddFunds.replace(',', '.'));    
		} catch (NumberFormatException e) {
			//print stack trace
			e.printStackTrace();
			//creates a beep
			java.awt.Toolkit.getDefaultToolkit().beep();
			//display error message
			JOptionPane.showMessageDialog(this, "Funds needs to be in this format x.xx e.g.(9.99 or 10.50 etc)",
				"ERROR",JOptionPane.WARNING_MESSAGE);	
		}//end catch
		
		//add the new funds to the users account
		studentAccount += addFunds;
		
		//create a connection to the database
		dbEngine.connect();
		
		//call the addFunds method and pass the new account balance
		sqlAddFunds(studentAccount);
		
		//close the database connection
		dbEngine.closeConnection();
		
		//return the account balance
		return studentAccount;
	}//end method
	
	/**
	 * Method add funds to the database
	 * 
	 * @param studentAccount String value of the users account balance
	 */
	public void sqlAddFunds(float studentAccount) {					   
		try {
			//try to execute the update sql query
			dbEngine.executeQuery("UPDATE Users SET StudentAccount='" + studentAccount + "' WHERE StudentID='" + studentID + "'");	
		} catch (SQLException e) {
			//catch exception & print error message and stack trace
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
	}//end sqlAddFunds
	
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
