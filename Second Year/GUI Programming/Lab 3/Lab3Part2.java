import javax.swing.*;
import java.awt.*;

//start class
public class Lab3Part2 extends JFrame{
	
    public Lab3Part2() {
    	//set the title
    	super("Shop List");
    	
    	//create an array of shops
    	String shops[] = {"Next","River Island","Tesco","Supervalue","JD Sports","Top Man","FootLocker","LifeStyle Sports","B&Q"};
    	//keep the list centered instead of left
    	setLayout(new FlowLayout());
  
    	//create the JList and add the shop array
    	JList<String>list = new JList<String>(shops);
    	//set the number of rows
    	list.setVisibleRowCount(9);
    	//set the amount of items that can be selected
    	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	//add the list to a scroll pane
    	add(new JScrollPane(list));
    	
    	//create a panel and the content pane
    	JPanel panel = new JPanel();
    	Container contentPane = getContentPane();
    	
    	//set the layout of the panel
    	panel.setLayout(new BorderLayout());
    	panel.add(list,BorderLayout.NORTH);
    	
    	//add the panel to the content pane
    	contentPane.add(panel);
    	//set the size of the frame
    	setSize(300,230);
    }//end constructor
    
    //start the main method
    public static void main (String args[]){
    	//create the frame 
     	JFrame frame = new Lab3Part2();
     	//set the visibility to true
     	frame.setVisible(true);
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class