import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab5Part2 extends JFrame implements ActionListener {
	
	//global variables
	JMenuItem appleItem, orangeItem, sBerryItem;
	JLabel lblFruits;
	JPanel panel;
	ImageIcon appleIcon, orangeIcon, sBerryIcon;
	
    public Lab5Part2() {
    	
    	//set the title
    	super("Lab 5 Part 2");
    	
    	//create the menu
    	JMenuBar mb = new JMenuBar();
    	JMenu fruitMenu = new JMenu("Fruits",false);
    	fruitMenu.add(appleItem = new JMenuItem("Apple"));
    	fruitMenu.add(orangeItem = new JMenuItem("Orange"));
    	fruitMenu.add(sBerryItem = new JMenuItem("Strawberry"));
    	
    	//add the action listeners to the sub-menu 
    	appleItem.addActionListener(this);
    	orangeItem.addActionListener(this);
    	sBerryItem.addActionListener(this);
    	
    	//add the menu to the frame
    	mb.add(fruitMenu);
    	setJMenuBar(mb);
    	
    	//create the container for the panel and the label for the icons
    	Container contentPane = getContentPane();
    	panel = new JPanel();
    	lblFruits = new JLabel();
    	panel.add(lblFruits);
    	contentPane.add(panel);
    	
    	//set the size and visibility
    	setSize(400, 330);
		setVisible(true);
    }//end constructor
    
    //event handler method
    public void actionPerformed(ActionEvent e){
    	//if the apple submenu is selected 
    	if (e.getSource() == appleItem){
    		//create the apple icon
    		appleIcon = new ImageIcon("apple.png");
    		//set the label to the apple icon
    		lblFruits.setIcon(appleIcon);
    	}//end if
    	
    	//else if the orange submenu is selected 
    	else if (e.getSource() == orangeItem){
    		//create the apple icon
    		orangeIcon = new ImageIcon("orange.png");
    		//set the label to the orange icon
    		lblFruits.setIcon(orangeIcon);
    	}//end else if
    	
    	//else if the strawberry submenu is selected 
    	else if (e.getSource() == sBerryItem){
    		//create the strawberry icon
    		sBerryIcon = new ImageIcon("sBerry.png");
    		//set the label to the strawberry icon
    		lblFruits.setIcon(sBerryIcon);
    	}//end else if
	}//end action listener 
 
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab5Part2();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class