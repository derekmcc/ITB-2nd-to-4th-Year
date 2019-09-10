import java.io.*; 
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.filechooser.*;


public class Lab8Part4 extends JFrame implements MouseInputListener{
	
	//global components
	Border panelBorder = new LineBorder(Color.BLACK,2);
	JPanel panClick=buildPanel1(),panEnter=buildPanel2(),paneDrag=buildPanel3(),panExit=buildPanel4(), panel = new JPanel();
  	JLabel infoLabel, locationLabel, imageLabel;
  	JFileChooser fc;
  	
    public Lab8Part4() {
    	//set the title
    	super("4 Panels");
    	//create contentPane
    	Container contentPane = getContentPane();
    	//add the GUI to the content pane
    	contentPane.add(buildGUI());
    	//set the size and visibility
    	setSize(600,600);
    	setVisible(true);
    }//end constructor
    
    public JPanel buildPanel1(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a panel
    	panel = new JPanel();
  		
  		//create a label
  		imageLabel = new JLabel();
  		
  		//create a file chooser
        fc = new JFileChooser();
  		
  		//set the type of file chooser
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //set the layout of the panel
    	panel.setLayout(new BorderLayout());
    	//center the label 
    	imageLabel.setHorizontalAlignment(JLabel.CENTER);
		imageLabel.setVerticalAlignment(JLabel.CENTER);
    	//add the label to the panel
    	panel.add(imageLabel,BorderLayout.CENTER);
    	//add the mouse listener to the panel
    	panel.addMouseListener(this);
		
    	//return the panel
    	return panel;	
    }//end buildPanel method
    
    public JPanel buildPanel2(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a panel
    	panel = new JPanel();
  		//add the mouse listener to the panel
    	panel.addMouseListener(this);
    	//return the panel
    	return panel;	
   	}//end buildPanel method
    
    public JPanel buildPanel3(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a panel
    	panel = new JPanel();
  
  		//create a label
  		locationLabel = new JLabel();
  		//set the layout of the panel
    	panel.setLayout(new BorderLayout());
    	//center the label 
    	locationLabel.setHorizontalAlignment(JLabel.CENTER);
		locationLabel.setVerticalAlignment(JLabel.CENTER);
  		//add the mouse listener to the panel
		panel.addMouseMotionListener(this);
  		//add the label to the panel
  		panel.add(locationLabel,BorderLayout.CENTER);
    	//return the panel
    	return panel;	
    }//end buildPanel method
    
    public JPanel buildPanel4(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a panel
    	panel = new JPanel();
  		//create a label
  		infoLabel = new JLabel();
  		//set the layout of the panel
    	panel.setLayout(new BorderLayout());
    	//center the label 
    	infoLabel.setHorizontalAlignment(JLabel.CENTER);
		infoLabel.setVerticalAlignment(JLabel.CENTER);
  		//add the mouse listener to the panel
    	panel.addMouseListener(this);
  		//add the label to the panel
  		panel.add(infoLabel,BorderLayout.CENTER);
    	//return the panel
    	return panel;	
    }//end buildPanel method
    
    public JPanel buildGUI(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a panel
    	panel = new JPanel();
  		//set the layout of the panel
  		panel. setLayout(new GridLayout(2,2));
  		//add the panel to the main panel
    	panel.add(panClick);
    	//add a border to each panel
    	panClick.setBorder(panelBorder);
    	//add the panel to the main panel
    	panel.add(panEnter);
    	//add a border to each panel
    	panEnter.setBorder(panelBorder);
    	//add the panel to the main panel
    	panel.add(paneDrag);
    	//add a border to each panel
    	paneDrag.setBorder(panelBorder);
    	//add the panel to the main panel
    	panel.add(panExit);
    	//add a border to each panel
    	panExit.setBorder(panelBorder);
    	//return the panel
    	return panel;	
    }//end buildGUI method
    
    public void mouseClicked(MouseEvent e) {
    	if (e.getSource() == panClick){
    		//create a temp variable of the file chooser selection
	        int returnVal = fc.showOpenDialog(Lab8Part4.this);
		
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File files = fc.getSelectedFile();
	            //create an image icon of the chosen image
	            ImageIcon image = new ImageIcon("images/" + files.getName());
	            
	            //add the image icon to the label
	            imageLabel.setIcon(image);
	        }//end if 
	        else {
	        	//set the text of the label
	            imageLabel.setText("Open command cancelled by user.");
	        }//end else
    	}//end if
	}//end mouseClicked method

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == panEnter){
			//set the initial colour
	    	Color colour = Color.DARK_GRAY;  
	    	//create the colour chooser	
			Color color = JColorChooser.showDialog(this,"Select a color",colour);
			//set the colour of the panel to the users chosen colour  
			panEnter.setBackground(color);
		}//end if
			
	}//end mouseEntered method

	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panExit){
			//set the text on the label
			infoLabel.setText("Bye bye mouse!!!");
		}//end if		
	}//end mouseExited method

	public void mousePressed(MouseEvent e) {		
	}//end mousePressed method

	public void mouseReleased(MouseEvent e) {		
	}//end mouseReleased method

	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == paneDrag){
			//set the text on the label	
			locationLabel.setText("Co-ordinates  X  " + e.getX() + "    Y  " + e.getY());
		}//end if		
	}//end mouseDragged method

	public void mouseMoved(MouseEvent e) {		
	}//end mouseMoved method
	
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab8Part4();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class