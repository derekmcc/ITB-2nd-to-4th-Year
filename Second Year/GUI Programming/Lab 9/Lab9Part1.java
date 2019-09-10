import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lab9Part1 extends JFrame implements ActionListener{
	
	//global variables
	String surname;
	JFrame frame;
	JButton btnInput;
	Container contentPane;
	JPanel mainPanel=buildPanel(),panel = new JPanel();
	
    public Lab9Part1() {
    	//set the title
    	super("Input Dialog");
    	
    	//assign the contentPane to the variable
    	contentPane = getContentPane();
    	//add the buildPanel to the contentPane
    	contentPane.add(buildPanel());
    	//set the size & visibility
    	setSize(300,300);
    	setVisible(true);
    }//end constructor
    
    public JPanel buildPanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a new oanel
    	panel = new JPanel();
    	//create a button
    	btnInput = new JButton("Launch Input Dialog");
    	//add an action listener to the button
    	btnInput.addActionListener(this);
    	//add the button to the panel
    	panel.add(btnInput);
    	//return the panel
    	return panel;	
    }//emd buildPanel
    
    //event handler method
    public void actionPerformed(ActionEvent e){
    	//prompt the user to enter there surname
    	surname = (String)JOptionPane.showInputDialog(contentPane,
                                                  "Enter your surname",
                                                  "Change Title",
                                                  JOptionPane.INFORMATION_MESSAGE);
        //set the title of the frame to their surname                                            
        setTitle(surname);
    }//end handler
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab9Part1();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class