import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lab4Part2 extends JFrame implements ActionListener{
	//global variables 
	String colours[] = {"Green","White","Orange"};
	JPanel panel;
	JButton changeColour;
	JComboBox <String>colourSelector;
	
    public Lab4Part2() {
    	super("Colour Changer");
    	//create content pane & panel
    	Container contentPane = getContentPane();
    	panel = new JPanel();
    	
    	//comboBox components
  		colourSelector = new JComboBox<String>(colours);  	
   		panel.add(colourSelector);

   		//button components
   		changeColour = new JButton("Change Colour");
		//add button to the panel
   		panel.add(changeColour);
		//add action listeners to the components
   		colourSelector.addActionListener(this);
   		changeColour.addActionListener(this);
   		//add the panel to the content pane
   		contentPane.add(panel);
   		//set the size & visibility
   		setSize(400,400);
   		setVisible(true);		
    }//end constructor
    
    public void actionPerformed(ActionEvent e) {
    	//if the user clicks the button
    	if (e.getSource()== changeColour){
    		//and if the user has chosen green
    		if (colourSelector.getSelectedIndex()==0){
    			//set the panel colour to green
    			panel.setBackground(Color.GREEN);
    		}//end if
    		//and else if the user has chosen white
    		else if (colourSelector.getSelectedIndex()==1){
    			//set the panel colour to white
    			panel.setBackground(Color.WHITE);
    		}//end else if
    		//and else if the user has chosen orange
    		else if (colourSelector.getSelectedIndex()==2){
    			//set the panel colour to orange
    			panel.setBackground(Color.ORANGE);
    		}//end else if
    	}//end if 
	}//end actionPerformed
	
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab4Part2();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class