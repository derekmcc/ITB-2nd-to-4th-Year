package gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * This is a program that converts a number entered into a text field to a string
 * then setting the text of another text field to that string using a method 
 * from an imported jar file.  
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class StringNumberConversionFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	//global variables
	JTextField txt1, txt2;
	
	/**
	 * GUI builder constructor
	 */
	public StringNumberConversionFrame() {
		super("Lab1Part4");
		
		JLabel lbl1 = new JLabel("Enter an integer to convert to string");
		JLabel lbl2 = new JLabel("The text version of the number entered is:");
		txt1 = new JTextField(10);
		txt2 = new JTextField(10);
		
		JButton btn1 = new JButton("Convert");
		btn1.addActionListener(this);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setLayout(new GridLayout(2,2));
		panel1.add(lbl1);
		panel1.add(txt1);
		panel1.add(lbl2);
		panel1.add(txt2);
		panel3.add(btn1);
		
		panel2.setLayout(new BorderLayout());
		panel2.add(panel1, BorderLayout.NORTH);
		panel2.add(panel3, BorderLayout.SOUTH);
		
		Container contentPane = getContentPane();
		contentPane.add(panel2);
		
		setSize(500,150);
		setVisible(true);
	}//end constructor 
	
	/**
	 * Method to get the number from one text field and converter it to a String before 
	 * setting the text of the second text field to a string version of the number
	 * @param e To get users responses from listeners
	 */
	public void actionPerformed(ActionEvent e) {
		int num = Integer.parseInt(txt1.getText());
		String temp = numbersAndStrings.NumberToStringConvertor.convertToString(num);
		txt2.setText(temp);
	}//end actionEvent method
	
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		JFrame frame = new StringNumberConversionFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method
}//end class
