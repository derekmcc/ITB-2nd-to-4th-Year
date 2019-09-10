import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Lab4Part3 extends JFrame implements ListSelectionListener{
	//declare globale variables
	JList <String>list;
	String subjects[] = {"GUI Programming","LAN Wireless","Databases","Maths","Web Development","OOAD","Business Management","Operating Systems","Software Engineering & Testing","WAN Technologies"};
    JTextArea txtArea;
    boolean flag = false;
    JScrollPane pane;
    JPanel panel, panCenter;
    
    public Lab4Part3() {
    	//set the title
    	super("Lab4Part3");
    	//creat the content pane and panels
    	Container contentPane = getContentPane();
    	panel = new JPanel();
    	panCenter = new JPanel();
    	//create the text area and label
    	txtArea = new JTextArea("Response will appear here");
    	JLabel lblChoice = new JLabel("Please choose your favourite subjects");
    	
    	//create thee JList
    	list = new JList<String>(subjects);
    	//add an action listener
    	list.addListSelectionListener(this);
    	//add the list to a scroll pane
    	pane = new JScrollPane(list);
    	
    	//add the components to the panel & contentPane
    	panel.add(lblChoice);
    	panel.add(list);
    	panel.add(pane);
    	panel.add(txtArea);
    	panCenter.add(panel);
    	panCenter.setLayout(new GridLayout(1,3));
    	contentPane.add(panCenter);
    	
    	//set the size & visibility
    	setSize(260,500);
    	setVisible(true);
    }//end constructor
    
    public static void main(String args[]){
    	//create the JFrame
    	JFrame frame = new Lab4Part3();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);    	
    }//end main method
    
    public void valueChanged(ListSelectionEvent e){
    	//add teh user list item index in the array to an int variable
    	int selectionNum = list.getSelectedIndex();
    	
    	//check if the the textArea is the in the default state 
    	if (flag == false){
    		//set the testArea to the empty string
	    	txtArea.setText("");
	    	//set the flag to true
	    	flag = true;
	    }//end if flag check
	   
	   	//needed to stop duplicated selections
    	if (!e.getValueIsAdjusting()) {
	   		//append the selected subjects to the textArea
	    	txtArea.append(subjects[selectionNum] + "\n");
		}//end if
    }//end eventHandler
}//end class