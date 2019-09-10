import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This is a program that gets the length of a string. It uses 
 * a try catch block to deal with the likely event of a null pointer exception.
 * And re-prompts the user if their is an exception.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class Lab3Part2GUI extends JFrame implements ActionListener{
	//serial version
	private static final long serialVersionUID = 1L;
	JButton stringLengthButton;
	JTextField inputField;
	JLabel outputLabel;
	Container contentPane = getContentPane();
	
	/**
	 * Constructor for GUI
	 */
	public Lab3Part2GUI(){
		//set the title
		super("Fix Error");
		
		//create the components
		inputField = new JTextField(10);
		outputLabel = new JLabel("String lenght = ");
		stringLengthButton = new JButton("Get String Length");
		//add an action listener
		stringLengthButton.addActionListener(this);
		
		//create a panel
		JPanel panel = new JPanel();
		
		//add the components to the panel
		panel.add(inputField);
		panel.add(outputLabel);
		panel.add(stringLengthButton);
		//add the panel to the content pane
		contentPane.add(panel);
		
		//set the size and visibility
		setSize(200,250);
		setVisible(true);
	}//end constructor
	
	/**
	 * @param e Used to listen for user events
	 */
	public void actionPerformed(ActionEvent e){
		//variable to hold length of string
		int length = 0;
		//try get the length of the inputed string
		try{
			inputField.getText();
			length = inputField.getText().length();
			//if the length of the string is 0 
			if (length == 0){
				//set length to null
				length = (Integer) null;
			}//end if
			//set the text on the label
			outputLabel.setText("String lenght = " + length);	
		} catch (NullPointerException npe) {
			//print the stack trace
			npe.printStackTrace();
			//get the lenght of the string from the JOptionPane
			String lengths = (String)JOptionPane.showInputDialog(contentPane,
                    "ERROR, Please Enter a Valid String",
                    "ERROR,Enter String",
                    JOptionPane.INFORMATION_MESSAGE);
			//update the length variable with the new lenght
			length = lengths.length();
			//set the text on the label
			outputLabel.setText("String lenght = " + length);	
		}//end catch
	}//end action event method
	
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String args[]) {
		JFrame frame = new Lab3Part2GUI();
	}//end main method
}//end class
