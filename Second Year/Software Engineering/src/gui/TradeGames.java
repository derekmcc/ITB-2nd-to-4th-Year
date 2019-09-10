/**
 *  This is the trade games class where the user can trade a purchased game for 20% less than the
 * price they paid.
 */
package gui;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dbController.dbConnect;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class TradeGames extends JFrame {
	
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String studentID, studentPassword, strTrade;
	private Float studentAccount, gamePrice, tradePrice, floAccount, newAccount;
	private String strGameID, dbGameName, strAccount, Role;
	private int intGameID;
	boolean hasGameToTrade = false;
	
	//Database engine for creating DB connection, making queries
	dbConnect dbEngine = new dbConnect(); //database engine
	static String url = "jdbc:mysql://localhost/threescompany";
	static String dbUser = "root";
	static String dbPass= "root";
	
	/**
	 * Constructor for GUI
	 * 
	 * @param studentID String value of the users ID
	 * @param studentPassword String value for the users password
	 * @param Role String value for the user role
	 * @param studentAccount Float value of the users account
	 */
	public TradeGames(String studentID, String studentPassword, String Role, Float studentAccount) {
		super("Trade Games");
		
		//assign the value from the passed variables to the global scope variables 
		this.studentID = studentID;
		this.studentPassword = studentPassword;
		this.Role = Role;
		this.studentAccount = studentAccount;
		
		//call the init method
		init();
		
		//check if the user has a game to trade set the 'hasGame' variable to true of false
		boolean hasGame = sqlCheckUserHasGameToTrade();
		//if true the user has a game to trade 
		if(hasGame) {
			//call the getGamePrice method
			getGamePrice();
			//assign the game price to the trade price variable
			tradePrice = gamePrice;
			//prompt the user if they want to trade there game for 20% less than the cost price
			int n = JOptionPane.showConfirmDialog(
				    this,
				    "For " + dbGameName +" we will give you €"+String.format("%.2f",(tradePrice - gamePrice*20/100))+"\n\nWould you like to accept?\n",
				    "Trade Game",
				    JOptionPane.YES_NO_OPTION);
			//if the users chooses yes
			if (n == JOptionPane.YES_OPTION) {
				//add the trade in value to the users account
				studentAccount = studentAccount + (tradePrice - gamePrice*20/100);
				//call the update account balance method to update the DB
				sqlUpdateAccountBalance(floAccount); 
				//display message
				JOptionPane.showMessageDialog(getContentPane(),
					    "Your game has successfully been traded and the trad-in value added to your account", "Game Successfully Traded",JOptionPane.INFORMATION_MESSAGE);
			}//end if
			//close this class
			this.dispose();
			//call the main menu class
			new MainMenu(studentID,studentPassword,Role,studentAccount);
		}//end if
		else {
			//else if the user doesn't have a game to trade display message
			JOptionPane.showMessageDialog(getContentPane(),
				    "Sorry You Dont Have Any Game To Trade", "Error",JOptionPane.ERROR_MESSAGE);
			//close this class
			this.dispose();
			//call the main menu class
			new MainMenu(studentID,studentPassword,Role,studentAccount);
		}//end else
	}//end constructor
	
	/**
	 * Method to establish a DB connection
	 */
	public void init() {
		//establish a connection with the DB
	    dbEngine.connect(); 
	}//end method
	
	/**
	 * Method to check if the user has a game to trade
	 * 
	 * @return Boolean value true if the user has a game to trade or else false if they don't
	 */
	public boolean sqlCheckUserHasGameToTrade() {		
		//variables to hold query data
		String query;
        String dbHasGame;
       
        try {
        	//register the driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //get a connection to the database
            Connection con = (Connection) DriverManager.getConnection(url, dbPass, dbUser);
            //print message
            System.out.println ("Database connection established");
            //create a statement 
            Statement stmt = (Statement) con.createStatement();
            //create a query
            query = "select * from Users where StudentID = '" + studentID + "'and StudentPassword = '" + studentPassword + "'";
            //execute the query
            stmt.executeQuery(query);
            //add the query results to the result set
            ResultSet rs = stmt.getResultSet();
            
            //move the rs pointer on to the next record (starts before the 1st)
            while(rs.next()) {
            	//retrieve the data from the DB and assign it to the variables
            	strGameID = rs.getString("GameID");
                dbHasGame = rs.getString("GameID");
                strAccount = rs.getString("StudentAccount");
                floAccount = Float.parseFloat(strAccount);
                
                //if the user has a game to trade
                if(dbHasGame != null) {
                	//parse the string value of game ID to an integer value 'intGameID'
                	intGameID = Integer.parseInt(strGameID);
                	//set the boolean variable to true
                    hasGameToTrade = true;
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
        //return the boolean value
        return hasGameToTrade;
	}//end method
	
	/**
	 * Method to get the game price
	 */
	public void getGamePrice() {
		try {
			//register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//get a connection to the database
			Connection conn = (Connection) DriverManager.getConnection(url,dbUser,dbPass);
			//create a statement 
			PreparedStatement stmt = conn.prepareStatement("select * from Games where GameID = " + intGameID + ";");		
			//execute a Query
			ResultSet rs = stmt.executeQuery();
			//move the rs pointer on to the next record (starts before the 1st)
			while(rs.next()){
				//retrieve the data from the DB and assign it to the variables
			    String gPrice  = rs.getString("GamePrice");
			    dbGameName = rs.getString("GameName");
			    //parse the string value of game price to a float value 'gamePrice'
			    gamePrice = Float.parseFloat(gPrice);
			 }//end while		
		//close the connections	
		rs.close();
	    stmt.close();
	    conn.close();
	    System.out.println("Database connection closed");
		} catch(Exception e){
			e.printStackTrace();
		}//end catch
	}//end userDetails
	
	/**
	 * Method to update the users account in the DB
	 * 
	 * @param account Float value of the users account
	 */
	public void sqlUpdateAccountBalance(Float account){
		try {
			//try to execute update query
			dbEngine.executeQuery("UPDATE Users SET StudentAccount="+account+", GameID=null WHERE StudentID='" + studentID + "'");
		} catch (SQLException e) {
			//catch exception and print error message & stack trace
			System.err.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}//end catch
	}//end sqlUpdate method
}//end class
