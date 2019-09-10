import java.io.*; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class Lab8Part1 extends JFrame implements ActionListener {
	
	//global component
	JLabel fileInfoLabel;
	JButton btnLoad;
	JFileChooser fc;
	
    public Lab8Part1() {
    	//set the text
    	super("File Chooser");
    	
    	//create button & label
    	fileInfoLabel = new JLabel();
    	btnLoad = new JButton("Load file",createImageIcon("images/Open16.gif"));
    	//add an action listener
    	btnLoad.addActionListener(this);
    	//create a file chooser
        fc = new JFileChooser();
        
   		//set the type of file chooser
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        //create panels
    	JPanel panel1 = new JPanel();
    	JPanel panel2 = new JPanel();
    	
    	//add the components to the panels
    	panel2.add(btnLoad);
    	panel1.setLayout(new BorderLayout());
    	panel1.add(fileInfoLabel, BorderLayout.CENTER);
    	panel1.add(panel2,BorderLayout.PAGE_END);
    	
    	//create contentPane
    	Container contentPane = getContentPane();
    	//add the panel to the contentPane
    	contentPane.add(panel1);
    	//set the size and visibility
    	setSize(300,300);
    	setVisible(true);
    }//end constructor
    
    public void actionPerformed(ActionEvent e){
   		//create a temp variable of the file chooser selection
        int returnVal = fc.showOpenDialog(Lab8Part1.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //set the text of the label
            fileInfoLabel.setText(file.getName());
        }//end if 
        else {
        	//set the text of the label
            fileInfoLabel.setText("Open command cancelled by user.");
        }//end else
        
    }//end handler method 
    
    //method to add image to JButton
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Lab8Part1.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        }//end if
        else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }//end else
    }//end createImageIcon method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab8Part1();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class