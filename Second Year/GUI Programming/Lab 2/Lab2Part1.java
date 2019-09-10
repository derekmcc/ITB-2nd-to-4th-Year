//import the swing component directory
import javax.swing.*;

//start class
public class Lab2Part1 extends JFrame{
	
	//start constructor
    public Lab2Part1() {
    	//set the title of the frame
    	super("Derek McCarthy");
    	//set the size of the frame
    	setSize(500,300);
    	//set the visibility to true
     	setVisible(true);	
    }//end constructor
    
    //start main method
     public static void main(String args[]){	
     	//create the frame 
     	JFrame frame = new Lab2Part1();
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }//end main method
    
}//end class