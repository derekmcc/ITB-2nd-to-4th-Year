import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Lab9Part3 extends JFrame implements ActionListener{
	
	//global variables
	JMenuItem subjectChoices;
	JFrame frame;
	Container contentPane = getContentPane();
		
    public Lab9Part3() {
    	//set the title
    	super("Lab 9 Part 3");
    	
    	//set the menuBar  	
		setJMenuBar(buildMenu());
		
		//set the size & visibility
		setSize(300,300);
		setVisible(true);
    }//end constructor
   	
   	public JMenuBar buildMenu(){
    	//create the menu bar & menu 
    	JMenuBar mb = new JMenuBar();
    	JMenu choices = new JMenu("Choices",false);
    	
    	
    	//create the menu items
    	choices.add(subjectChoices = new JMenuItem("Subject Choices"));
    	
    	//add action listeners to the menu items
    	subjectChoices.addActionListener(this);
    	
    	//add accelerators to the menu item
    	subjectChoices.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
    	
    	//add the mnemonics
    	subjectChoices.setMnemonic('S');

    	//add the menu to the menu bar
    	mb.add(choices);
    	//return the menu bar
    	return mb;
    }//end menu method
    
    //event handler method
    public void actionPerformed(ActionEvent e){
    	//array of objects
    	Object options[] = {"Networks", "Databases", "Web Dev"};
    	//prompt the user to choose their favourite subject
    	int choice = JOptionPane.showOptionDialog(contentPane,
	        "Choose your favourite subject",
	        "Choose Subject",
	        JOptionPane.YES_NO_CANCEL_OPTION,
	        JOptionPane.QUESTION_MESSAGE,
	        null,
	        options,
	        options[0]);  
	    //if the final static variable final Choice is 0     
		if (choice == JOptionPane.YES_OPTION){
			//display the chosen subject
			JOptionPane.showMessageDialog(contentPane,
		        "Your favourite subject is " + options[0],
		        "Favourit Subject",
		        JOptionPane.PLAIN_MESSAGE);
		}//end if
		//else if the final static variable final Choice is 1 
		else if (choice == JOptionPane.NO_OPTION){
			//display the chosen subject
			JOptionPane.showMessageDialog(contentPane,
		        "Your favourite subject is " + options[1],
		        "Favourit Subject",
		        JOptionPane.PLAIN_MESSAGE);
		}//end else if
		//else if the final static variable final Choice is 2  
		else if (choice == JOptionPane.CANCEL_OPTION){
			JOptionPane.showMessageDialog(contentPane,
		        "Your favourite subject is " + options[2],
		        "Favourit Subject",
		        JOptionPane.PLAIN_MESSAGE);
		}//end else if		
    }//end handler 
     
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab9Part3();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class


		