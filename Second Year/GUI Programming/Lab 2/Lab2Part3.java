//import the swing & awtcomponent directory
import javax.swing.*;
import java.awt.*;

//start class
public class Lab2Part3 extends JFrame{

	//start constructor
    public Lab2Part3() {
    	//set the title
    	super("Lab2 Part 3");
    	//create label
    	JLabel loginLabel = new JLabel("Login");

    	//create button
    	JButton loginButton = new JButton("Login");

    	//create a panel
    	JPanel loginPanel = new JPanel();
    	
    	//add the labels to the panel
    	loginPanel.add(loginLabel);
    	loginPanel.add(loginButton);
    	
    	//create a contentPane
    	Container contentPane = getContentPane(); 
    	
    	//add the panel to the content pane
    	contentPane.add(loginPanel);
    	
    	//set the size
    	setSize(350,200);
    	//set the visibility to true
     	setVisible(true);
    }//end constructor
    
    //start the main method
    public static void main (String args[]){
    	//create the frame 
     	JFrame frame = new Lab2Part3();
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
    
}//end class