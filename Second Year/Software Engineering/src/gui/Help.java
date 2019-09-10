/**
 * This is a class to display all the users & their details listed in the DB from a text file and
 * can be accessed from the help menu bar in the login class.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class Help extends JFrame implements ActionListener{
	
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	
	//global scope component
	JButton btn1;
	//create a font for the text area
	Font font = new Font("Ariel", Font.BOLD, 16);
	
	/**
	 * GUI constructor
	 */
	public Help() {
		//set the title of the GUI
		super("Help");
		
		//create a text area
		JTextArea area = new JTextArea();
		
		//set the font & colour in the text area and make it non editable 
		area.setFont(font);
		area.setForeground(Color.MAGENTA);
		area.setEditable(false);
		
		//create a button & add a listener
		btn1 = new JButton("Back");
		btn1.addActionListener(this);
		
		//create a file reader to read in from the text file
		FileReader reader;
		
		try {
			//try read in from the text file
			reader = new FileReader("UserNames&Passwords.txt");
			try {
				//try add the contents of the text file to the text area
				area.read(reader,"UserNames&Passwords.txt");
			} catch (IOException e) {
				//catch exception and print stack trace
				e.printStackTrace();
			}//end catch
		} catch (FileNotFoundException e) {
			//catch exception and print stack trace
			e.printStackTrace();
		}//end catch
        
		//create panels
		JPanel wrapper = new JPanel();
		JPanel btnPanel = new JPanel();
		
		//add the button to the panel
		btnPanel.add(btn1);
		//set the layout of the panel and add the components
		wrapper.setLayout(new BorderLayout());
		wrapper.add(area,BorderLayout.NORTH);
		wrapper.add(btnPanel,BorderLayout.SOUTH);
		
		//add the wrapper to the content pane
		getContentPane().add(wrapper);
		
		//set the size, visibility, resizability & position of the frame
		setSize(450,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}//end help method
	
	/**
	 * Method to handle the users interaction from the listeners
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//close this class
		this.dispose();
	}//end actionEvent
}//end class
