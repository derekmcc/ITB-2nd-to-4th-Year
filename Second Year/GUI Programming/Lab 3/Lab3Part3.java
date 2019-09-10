import javax.swing.*;
import java.awt.*;

public class Lab3Part3 extends JFrame{

    public Lab3Part3() {
    	//set the title
    	super("Combo Boxes"); 
    		
    	//cars & music arrays
	    String car[] = {"Opel","Ford","Nissan","BMW","Kia"};
	    String artist[] = {"Eminem","Taylor Swift","U2","Slipknot","Rita Ora"};
		
		//create the comboboxes and add the array to them
	    JComboBox<String>cbCar = new JComboBox<String>(car); 
	    JComboBox<String>cbArtist = new JComboBox<String>(artist); 
	    
	    //set bounds and the editable areas of the comboboxes	
	    cbArtist.setEditable(true);	
	    cbCar.setBounds(50,50,200,30); 
	    cbArtist.setBounds(50,90,200,30); 	 
	   	
	   	//create the content pane and panel
	   	Container contentPane = getContentPane();
	   	JPanel panel = new JPanel();
	   	JPanel carPanel = new JPanel();
	   	JPanel artistPanel = new JPanel();
		
		//set the layout of the panel
		panel.setLayout(new BorderLayout());
		
	   	//add the comboboxes to the panel
	   	carPanel.add(cbCar);
	   	artistPanel.add(cbArtist);
	   	
	   	//add the car/music panels to the panel
	    panel.add(carPanel, BorderLayout.NORTH);
	    panel.add(artistPanel, BorderLayout.SOUTH);  
	    	
	    //add the panel to the content pane
	    contentPane.add(panel);	
		
		//set the size of the frame 
	    setSize(350,200);   
    	//set the visibility to true
     	setVisible(true);
    }//end constructor
    
    //start the main method
    public static void main (String args[]){
    	//create the frame 
     	JFrame frame = new Lab3Part3();	
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class