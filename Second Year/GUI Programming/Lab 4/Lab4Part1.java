import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lab4Part1 extends JFrame implements ActionListener{
	//global variables
   	private JLabel lblHello = new JLabel("Hello");
   	
    public Lab4Part1() {
    	//set the title
    	super("Lab Sheet 4 Part 1");
    	
    	//create the content pane and panel
    	Container contentPane = getContentPane();
    	JPanel panel = new JPanel();
    	
    	//create a button
    	JButton btnChangeLabel = new JButton("Change Label");
    	//add an action listener to the button
    	btnChangeLabel.addActionListener(this);
    	
    	//add the label and button to the panel
    	panel.add(lblHello);
    	panel.add(btnChangeLabel);
    	//add the panel to the content pane
    	contentPane.add(panel);
    	//set the size and visibility
    	setSize(400,200);
    	setVisible(true);
    }//end constructor
    
    public void actionPerformed(ActionEvent e) {
    	//set the text of the label
    	lblHello.setText("Hello World!, my	listener works!");	
	}//end actionPerformed

    public static void main (String args[]){
    	//create a frame
    	JFrame frame = new Lab4Part1();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class