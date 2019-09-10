/**
 * This is the main method for the entire project
 */
package frontController;
import javax.swing.JFrame;
import javax.swing.UIManager;

import gui.Login;
import gui.MainMenu;



/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class Run extends JFrame{
	
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor to create a frame from the login class
	 */
	public Run() {
		JFrame frame = new Login();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end constructor
	
	/**
	 * Main Method
	 * @param args The default arguments if any
	 */
	public static void main(String[] args) {
		//try set the look & feel 
		try {
            //set the look and feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (InstantiationException e) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (IllegalAccessException e) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }//end catch
		
		//instantiate the run class
		new Run();
	}//end main method
}//end class
