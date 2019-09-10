/**
 * NOT finished with testing
 */
package tests;

import org.junit.Before;
import org.junit.Test;

import dbController.LoginController;
import gui.Help;
import gui.Login;
import junit.framework.TestCase;

/**
 * @author Derek McCarthy B00007439
 *
 */
public class LoginTest extends TestCase {
	
	//global scope variables 
	Login lg;
	LoginController lc; 
	Help help;
	
	/**
	 * Method for the setup for the test's
	 * @throws java.lang.Exception Method that can throw an exception
	 */
	@Before
	public void setUp() throws Exception {
		lg = new Login();
		lc = new LoginController();
	}//end method
	
	/*
	 * Method to test case's 1-4
	 */
	@Test
	public void test() {
		String id,pass;
		boolean login1, login2;
		
		//Test Case Path 1
		lg.txtID.setText("B00007439");
		lg.txtPassword.setText("derek");
		id = lg.txtID.getText();
		pass = String.valueOf(lg.txtPassword.getPassword());
		login1 = lc.userLogin(id, pass);
		assertTrue(login1);
				
		//Test Case Path 2
		lg.txtID.setText("BlahBlahBlah");
		lg.txtPassword.setText("derek");
		id = lg.txtID.getText();
		pass = String.valueOf(lg.txtPassword.getPassword());
		login2 = lc.userLogin(id, pass);
		assertFalse(login2);
		
		//Test Case Path 3
		lg.dispose();
		
		//Test Case Path 4
		help = new Help();
	}//end test
	
	/*
	 * Method to test the cases from the black-box cases
	 */
	@Test
	public void blackBoxTest(){
		String id,pass;
		boolean login1;
		
		//Black-Box Test Case 1
		lg.txtID.setText("B00007439");
		lg.txtPassword.setText("derek");
		id = lg.txtID.getText();
		pass = String.valueOf(lg.txtPassword.getPassword());
		login1 = lc.userLogin(id, pass);
		assertTrue(login1);
		
		//Black-Box Test Case 2
		lg.txtID.setText("B74390000");
		lg.txtPassword.setText("derek");
		id = lg.txtID.getText();
		pass = String.valueOf(lg.txtPassword.getPassword());
		login1 = lc.userLogin(id, pass);
		assertFalse(login1);
		
		//Black-Box Test Case 3
		lg.txtID.setText("B00007439");
		lg.txtPassword.setText("der");
		id = lg.txtID.getText();
		pass = String.valueOf(lg.txtPassword.getPassword());
		login1 = lc.userLogin(id, pass);
		assertFalse(login1);
		
		//Black-Box Test Case 4
		lg.txtID.setText("B74390000");
		lg.txtPassword.setText("der");
		id = lg.txtID.getText();
		pass = String.valueOf(lg.txtPassword.getPassword());
		login1 = lc.userLogin(id, pass);
		assertFalse(login1);
	}//end test
}//end testLogin
