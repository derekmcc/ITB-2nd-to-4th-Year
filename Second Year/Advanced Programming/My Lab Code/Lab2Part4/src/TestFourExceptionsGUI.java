import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

/**
 * This is a program that will cause 4 types of exceptions
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class TestFourExceptionsGUI extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JButton btn1, btn2, btn3, btn4;
	Container contentPane = getContentPane();
	
	/**
	 * Constructor GUI
	 */
	public TestFourExceptionsGUI() {
		super("Lab2Part4");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		//create buttons
		btn1 = new JButton("Test IO Exception");
		btn2 = new JButton("Test URL Exception");
		btn3 = new JButton("Test Null Pointer Exception");
		btn4 = new JButton("Test General Exception");
		
		//add action listeners
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		//add the buttons to the panel
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		
		contentPane.add(panel);
		
		setSize(350,350);
		setVisible(true);
	}//end constructor
	
	/**
	 * 
	 * @param string To pass sting variable
	 * @param filename To pass name of file
	 * @param url To pass url 
	 * @param generalExceptionActivated Boolean to check for general errors
	 */
	public void testException(String string, String filename, String url, boolean generalExceptionActivated){
		try {
			string.toCharArray(); //Null string potential error
			new FileReader(filename); //Unknown filename potential error
			new URL(url); //Badly written URL potential error
			if(generalExceptionActivated) { //Potential error
				this.clone(); //Will be caught as a general error!
			}//end if
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(contentPane, "A URL has been badly written " + e.getMessage());
		} catch (IOException  e) {
			JOptionPane.showMessageDialog(contentPane, "An IO Exception has been caught " + e.getMessage());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(contentPane, "A Null Pointer Exception has been caught " + e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Some general unidentified Exception has been caught " + e.getMessage());
		} finally {
			JOptionPane.showMessageDialog(contentPane, "The finally block has been called");
		}//end finally
	}//end testException method
	
	/**
	 * ActionPerformed Method
	 * @param e To listen for events from user
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1){
			testException("Hi","Whatever.txt","http://www.itb.ie",false);
		}//end if
		else if (e.getSource() == btn2){
			testException("Hi","Real.txt","ht//www.itb.ie",false);
		}//end else if
		else if (e.getSource() == btn3){
			testException(null,"Real.txt","http://www.itb.ie",false);
			
		}//end else if
		else if (e.getSource() == btn4){
			testException("Hi","Real.txt","http://www.itb.ie",true);
		}//end else if
	}//end actionPerformed method

	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		JFrame frame = new TestFourExceptionsGUI();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method	
}//end class