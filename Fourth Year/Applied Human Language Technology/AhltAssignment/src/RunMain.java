import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * A parser for regular expressions 
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class RunMain extends JFrame {

	/**
	 * Default constructor to create a frame from the UI class
	 */
	public RunMain() {
		JFrame frame = new UserInterface();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end constructor
	
	/*
	 * Main method
	 */
	public static void main(String[] args) {
		try {
            //set the look and feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(RunMain.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (InstantiationException e) {
            java.util.logging.Logger.getLogger(RunMain.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (IllegalAccessException e) {
            java.util.logging.Logger.getLogger(RunMain.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
            java.util.logging.Logger.getLogger(RunMain.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }//end catch
		//create an instance of the RunMain constructor
		new RunMain();
	}//end main method
}//end class
