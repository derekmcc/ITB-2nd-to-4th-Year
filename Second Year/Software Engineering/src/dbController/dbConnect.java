/**
 * Class to manage connections to the database
 */
package dbController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/** 
* @author Derek McCarthy B00007439
* @author Matthew Reilly  B00092951 
* @author Christopher Slattery B00092939
* @version 1.0
*/
public class dbConnect {
		
	//global scope variables
	private Connection conn;
	private String url;
	private String userName;
	private String password;
	
	/**
	 * Default constructor
	 */
	public dbConnect() {
		conn = null;
	}//end method
	
	/**
	 * Method to establish a database connection, reads the database URL and
	 * port number from a properties file to prevent having to recompile code.
	 */
	public void connect() {
		//read in the properties
		InputStream is = getClass().getResourceAsStream("mySQLEngine.properties");
	    //create an insatnce of the properties
		Properties p = new Properties();
	    try {
	    	p.load(is);
	        url = p.getProperty("connectionURL");
	        userName = p.getProperty("username");
	        password = p.getProperty("password");
	    }
	    catch (IOException e) {
	        System.err.println("error loading properties...");
	    }
		try {
			//register the mySQL driver with the DriverManager
			//by creating a new instance of the jdbc Driver class
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			
			//try to connect to the database
			conn = DriverManager.getConnection (url, userName, password);
		
			System.out.println ("Database connection established");
	      } catch (Exception e) {
	          System.err.println ("Cannot connect to database server");
	          e.printStackTrace();
	      }//end catch
	}//end connect method
	
	/**
	 * Method to close connection to a Database
	 */
	public void closeConnection() {
		try {
				conn.close();
				System.out.println("Database connection closed");
			} catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
				e.printStackTrace();
			}//end catch
	}//end closeConnection
		
	/**
	 * Method to execute an SQL query and return results as an object.
	 * @param sqlStatement The statement or query string to be executed.
	 * @return The <code>ResultSet</code> of the query, i.e. the rows of data and related metadata.
	 * @throws SQLException SQLExceptions maybe generated within by communicating with the DB, these
	 * are caught and thrown to the calling class.
	 */
		
	public ResultSet executeQuery(String sqlStatement) throws SQLException {
		ResultSet rs = null;
		
		//A Statement is the object used for executing an SQL statement 
		//and returning the results it produces.
		try {
			Statement stmt = conn.createStatement();
			//the execute method below executes the sql query
			//if the sql query is a select query it will 
			//return true, if it is update,insert,delete it will
			//return false.
			if(stmt.execute(sqlStatement))
				//we can get the result set if it was a select query.
				rs = stmt.getResultSet();			
		} catch (SQLException e) {
			throw e;
		}//end catch
		return rs;
	}//end executeQuery method
}//end class
