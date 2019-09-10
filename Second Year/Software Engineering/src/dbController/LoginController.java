/**
 * This is a login controller class used to check the users entered ID & password 
 * to those stored in the DB. 
 */
package dbController;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class LoginController {
	
	//global scope variables
	private String studentID, studentPassword, userRole;
	private Float studentAccount;
	static String url = "jdbc:mysql://localhost/threescompany";
	static String dbUser = "root";
	static String dbPass= "root";
	
	/**
	 * Default constructor
	 */
	public LoginController() {
	}//end constructor
	
	
	/**
	 * Second overloaded constructor to receive the user ID and password 
	 * 
	 * @param id String value of the users ID
	 * @param pass String value of the users password
	 */
	public LoginController(String id, String pass) {
		//call the userLogin method and pass the users ID & password 
		userLogin(id,pass);
	}//end constructor
	
	/**
	 * Method to retrieve the users details from the DB and assign the data to the 
	 * setters.
	 * 
	 * @param userID String value of the users ID
	 * @param password String value of the users password
	 */
	public void userDetails(String userID, String password) {
		try {
			//register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//get a connection to the database
			Connection conn = (Connection) DriverManager.getConnection(url,dbUser,dbPass);
			//create a statement 
			PreparedStatement stmt = conn.prepareStatement("select * from Users where StudentID = '" + userID + "'and StudentPassword = '" + password + "'");				
			//execute a Query
			ResultSet rs = stmt.executeQuery();
			//move the rs pointer on to the next record (starts before the 1st)
			while(rs.next()){
			    //retrieve the data from the DB and assign it to the variables
			    String studentID  = rs.getString("StudentID");
			    String studentPass = rs.getString("StudentPassword");
			    String role = rs.getString("UserRole");
			    Float account = rs.getFloat("StudentAccount");
			    
			    //set the variables using the setters
			    setStudentID(studentID);
			    setStudentPassword(studentPass);
			    setUserRole(role);
			    setStudentAccount(account);
			 }//end while
		//close connections	
		rs.close();
	    stmt.close();
	    conn.close();
	    //display message to the console
	    System.out.println("Database connection closed");
		} catch(Exception e){
			//catch exception and print stack trace
			e.printStackTrace();
		}//end catch
	}//end userDetails
	
	/**
	 * Method to check the DB for the ID and password that was passed 
	 * 
	 * @param userID String value of the ID the user entered in the login class
	 * @param password String value of the password the user entered in the login class
	 * @return login Boolean true if the ID and password are found in the DB or false if they are not
	 */
	public boolean userLogin(String userID, String password) {
		//variables 
        String query;
        String dbID, dbPassword;
        //boolean to check if the the ID & password are stored in the DB  
        boolean login = false;

        try {
        	//try register the Driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //get a connection to the database
            Connection con = (Connection) DriverManager.getConnection(url, dbUser, dbPass);
            //print message
            System.out.println ("Database connection established");
            //create a statement
            Statement stmt = (Statement) con.createStatement();
            //create a query
            query = "SELECT StudentID, StudentPassword FROM Users;";
            //execute the query
            stmt.executeQuery(query);
            //add the query results to the result set
            ResultSet rs = stmt.getResultSet();
            
            //move the rs pointer on to the next record (starts before the 1st)
            while(rs.next()) {
            	//assign the ID's & password's from the DB to the variables 'dbID' and 'dbPassword'
                dbID= rs.getString("StudentID");
                dbPassword = rs.getString("StudentPassword");
                
                //if the ID & password that were entered match any of those stored in the DB  
                if(dbID.equals(userID) && dbPassword.equals(password)) {
                	//pass the ID & password toe the userDetails method
                	userDetails(userID,password);
                	//set the login variable to true 
                    login = true;
                }//end if     
            }//end while
            //close the connection
            con.close();
            stmt.close();
            rs.close();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }//end catch
        
        //return the login variable
        return login;
	}//end userLogin method
	
	/**
	 * Method to get the users ID
	 * 
	 * @return The users ID
	 */
	public String getStudentID() {
		return studentID;
	}//end getStudentID

	/**
	 * Method to set the ID
	 * 
	 * @param studentID String value of the ID
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}//end setStudentID

	/**
	 * Method to get the users password
	 * 
	 * @return The users password
	 */
	public String getStudentPassword() {
		return studentPassword;
	}//getStudentPassword

	/**
	 * Method to set the password
	 * 
	 * @param studentPassword String value of the password
	 */
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}//end setStudentPassword

	/**
	 * Method to get the users Role
	 * 
	 * @return The users Role
	 */
	public String getUserRole() {
		return userRole;
	}//end getUSerRole

	/**
	 * Method to set the user Role (Admin or regular user)
	 * 
	 * @param userRole String value or the user role
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}//end setUserRole

	/**
	 * Method to get the users account
	 * 
	 * @return The users account
	 */
	public Float getStudentAccount() {
		return studentAccount;
	}//end getStudentAccount

	/**
	 * Method to set the users account
	 * 
	 * @param studentAccount Float value of the users account
	 */
	public void setStudentAccount(Float studentAccount) {
		this.studentAccount = studentAccount;
	}//end setStudentAccount
}//end class
