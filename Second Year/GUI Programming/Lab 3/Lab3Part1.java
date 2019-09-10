import javax.swing.*;
import java.awt.*;

//extend jframe
public class Lab3Part1 extends JFrame{
	
    public Lab3Part1() {
    	//set the title
    	super("Lab 3 Part 4");
    	
    	//create labels
    	JLabel nameLabel = new JLabel("Name");
    	JLabel passwordLabel = new JLabel("Password");
    	JLabel emailLabel = new JLabel("Email");
    	
    	//create text fields
    	JTextField nameField = new JTextField("",30);
    	JTextField passwordField = new JTextField("",30);
    	JTextField emailField = new JTextField("",30);
    	
    	//create button
    	JButton joinButton = new JButton("Join");
    	
    	//create panels
    	JPanel panel1 = new JPanel();
    	JPanel panel2 = new JPanel();
    	JPanel panel3 = new JPanel();
    	JPanel panel4 = new JPanel();
    	
    	//add components to the panels
    	panel1.add(nameLabel);
    	panel2.add(passwordLabel);
    	panel3.add(emailLabel);
    	panel1.add(nameField);
    	panel2.add(passwordField);
    	panel3.add(emailField);
    	panel4.add(joinButton);
    	
    	//create a contentPane
    	Container contentPane = getContentPane(); 
    	
    	//add the panels to the contentPane
    	contentPane.add(panel1);
    	contentPane.add(panel2);
    	contentPane.add(panel3);
    	contentPane.add(panel4);	
    	contentPane.setLayout(new GridLayout(4,0));	
    	setSize(500,200);
    }//end constructor
    
    public static void main(String args[]){
    	//create the frame 
     	JFrame frame = new Lab3Part1();
     	//set the visibility to true
     	frame.setVisible(true);
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class