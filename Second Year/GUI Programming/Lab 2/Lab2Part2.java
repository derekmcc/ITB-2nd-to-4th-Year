//import the swing & awt component directory
import javax.swing.*;
import java.awt.*;

public class Lab2Part2 extends JFrame{
	
	//start constructor
    public Lab2Part2() {
    	//set the title of the frame
    	setTitle("Frame With Labels");
    	//create JLabel
    	JLabel nameLabel = new JLabel("Derek McCarthy");
    	//create JLabel
    	JLabel homeTownLabel = new JLabel("Dublin");
    	
    	//create JPanel
    	JPanel labelPanel = new JPanel();
    	
    	//add the labels to the panel
    	labelPanel.add(nameLabel);
    	labelPanel.add(homeTownLabel);
    	
    	//create a container 
    	Container contentPane = getContentPane();
    	
    	//add the panel to the content pane
    	contentPane.add(labelPanel);
    	
    	//set the size
    	setSize(450,300);
    	//set the visibility to true
     	setVisible(true);
    }//end constructor
    
    //start the main method
    public static void main (String args[]){
    	//create the frame 
     	JFrame frame = new Lab2Part2();
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class