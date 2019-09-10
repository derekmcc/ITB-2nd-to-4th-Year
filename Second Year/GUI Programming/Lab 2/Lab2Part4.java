//import the swing & awt component directory
import javax.swing.*;
import java.awt.*;

//start class
public class Lab2Part4 extends JFrame{
	
	//start constructor
    public Lab2Part4() {
    	//set the title
    	super("My Pics");
    	
    	//create label
    	JLabel lblJayden = new JLabel("Jayden");
    	JLabel lblManU = new JLabel("Man Utd");
    	JLabel lblFootball = new JLabel("Football");
    	
    	JTextArea txtJayden = new JTextArea();
    	JTextArea txtManU = new JTextArea();
    	JTextArea txtFootball = new JTextArea();
    	
    	//create a panels
    	JPanel panel = new JPanel();
    	JPanel jaydenPanel = new JPanel();
		JPanel footballPanel = new JPanel();
		JPanel manUtdPanel = new JPanel();
		
		//create the image icons
  		Icon jaydenIcon = new ImageIcon("jayden.jpg");
  		Icon footballIcon = new ImageIcon("football.jpg");
  		Icon manUtdIcon = new ImageIcon("manUtd.jpg");
		
		//creat labels to add the images to
		JLabel lblJaydenIcon = new JLabel(jaydenIcon);
		JLabel lblFootballIcon = new JLabel(footballIcon);
		JLabel lblManUtdIcon = new JLabel(manUtdIcon);  
		
		//set the text of text areas
		txtJayden.setText("This is a picture of my nephew and godson Jayden");
		txtFootball.setText("This is a picture of a Football my favourite sport");
		txtManU.setText("This is the crest of Manchester United");
		
		//add the jayden components to the panel
		jaydenPanel.add(lblJayden);
		jaydenPanel.add(lblJaydenIcon);
		jaydenPanel.add(txtJayden);
		
		//add the football components to the panel
		footballPanel.add(lblFootball);
		footballPanel.add(lblFootballIcon);
		footballPanel.add(txtFootball);
		
		//add the man utd components to the panel
		manUtdPanel.add(lblManU);
		manUtdPanel.add(lblManUtdIcon);
		manUtdPanel.add(txtManU);
		
		//add the panels to the main panel
		panel.add(jaydenPanel);
		panel.add(footballPanel);
		panel.add(manUtdPanel); 	  	
    	
    	//create a contentPane
    	Container contentPane = getContentPane(); 
    	
    	//add the panel to the content pane
    	contentPane.add(panel);
    	//set the size
    	setSize(600,600);
    	//set the visibility to true
     	setVisible(true);
    }//end constructor
    
    //start the main method
    public static void main (String args[]){
    	//create the frame 
     	JFrame frame = new Lab2Part4();
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
    
}//end class