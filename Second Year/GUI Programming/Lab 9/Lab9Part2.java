import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lab9Part2 extends JFrame implements ActionListener{
	
	//global variables
	JFrame frame;
	JButton btnInput;
	JPanel mainPanel=buildPanel(),panel = new JPanel();
	ImageIcon irelandIcon = createImageIcon("images/ireland.png");
	ImageIcon englandIcon = createImageIcon("images/eng.png");
	ImageIcon usaIcon = createImageIcon("images/usa.jpg");
	Container contentPane = getContentPane();
		
    public Lab9Part2() {
    	//set the title of the frame
    	super("JDialog Launcher");
    	//create a panel
    	JPanel panel = new JPanel();
    	//add the panel to the contentPane
    	contentPane.add(mainPanel);
    	//set the size & visibility of the frame
    	setSize(400,400);
    	setVisible(true);
    }//end constructor
    
    public JPanel buildPanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a panel
    	panel = new JPanel();
    	//create a button
    	btnInput = new JButton("Launch JDialog");
    	//add an action listener to the button
    	btnInput.addActionListener(this);
    	//add the button to the panel
    	panel.add(btnInput);
    	//return the panel
    	return panel;	
    }//emd buildPanel
    
    //event handler method
    public void actionPerformed(ActionEvent e){
		//create a string array to hold country names
    	String choices[] = {"Ireland", "England", "USA"};
    	//prompt the user to choose their country
    	String input = (String) JOptionPane.showInputDialog(contentPane, "Choose Country",
        "Country Flags", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
  		//if the user selects X cancel
  		if(input == null){
  			//show message 
  			JOptionPane.showMessageDialog(contentPane,
		            	"You chose to cancel the request",
		                "Action Canceled",
		                JOptionPane.WARNING_MESSAGE);
  		}//end if
  		else{
  			//if the user chooses ireland
  			if (input.equals("Ireland")){
  				//show the user the irish flag
		        JOptionPane.showMessageDialog(contentPane,
		            	"",
		                "Ireland Flag",
		                JOptionPane.INFORMATION_MESSAGE,irelandIcon);
		        }//end if
		        //else if the user chooses england 
		        else if (input.equals("England")){
		        	//show the user the english flag
		        	JOptionPane.showMessageDialog(contentPane,
		            	"",
		                "England Flag",
		                JOptionPane.INFORMATION_MESSAGE,englandIcon);
		        }//end if
		        //else if the user chooses usa 
		        else if (input.equals("USA")){
		        	//show the user the usa flag
		        	JOptionPane.showMessageDialog(contentPane,
		            	"",
		                "USA Flag",
		                JOptionPane.INFORMATION_MESSAGE,usaIcon);
		        }//end if
  		}//end else	
    }//end handler
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Lab9Part2.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        }//end if 
        else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }//end else
    }//end method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab9Part2();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class