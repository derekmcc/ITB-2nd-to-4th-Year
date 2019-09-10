import javax.swing.*;
import java.awt.*;

public class Lab5Part1 extends JFrame{

    public Lab5Part1() {
    	//set the title
    	super("Lab 5 Part 1");
    	
    	//create the menu
    	JMenuBar mb = new JMenuBar(); 
		JMenu Functions = new JMenu("Functions",false);
		JMenu Languages = new JMenu("Languages",false);
		JMenuItem irishItem, engItem;
		
		//add the items to the menu
		Functions.add("Rename");
		Functions.add("Delete");
		Languages.add(irishItem = new JMenuItem("Irish"));
		Languages.add(engItem = new JMenuItem("English"));
		
		//add the flags
		irishItem.setIcon(new ImageIcon("irish.jpg"));
		engItem.setIcon(new ImageIcon("gb.png"));
		
		//add the items to the menu
		mb.add(Functions);
		mb.add(Languages);
		setJMenuBar(mb);
		
		//set the size and visibility
		setSize(320, 200);
		setVisible(true);

    }//end constructor
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab5Part1();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class