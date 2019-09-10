import javax.swing.*;

public class Lab7Part1 extends JFrame{

    public Lab7Part1() {
    	//set the title
    	super("Lab 7 Part 1");
    	//create the desktopPane
    	JDesktopPane desktop = new JDesktopPane();
    	//create an internal frame
    	JInternalFrame innerFrame = new JInternalFrame("Internal Window" ,
              										true, //resizable
              										false, //closable
              										true, //maximizable
              										false);//iconifiable
        //set the size & visibility of the inner frame
        innerFrame.setSize(300,300);
        innerFrame.setVisible(true);
        
        //create the panel
        JPanel panel = new JPanel();
        //create a label & button
        JLabel label = new JLabel("Internal Frame Label");
        JButton button = new JButton("Internal Frame Button");
        
        //add the components to the panel
        panel.add(label);
        panel.add(button);
        
        //add the panel to the inner frame
        innerFrame.add(panel); 
        //add the inner frame to the desktop pane
        desktop.add(innerFrame);
        
        //add the desktop pane to the content pane
        setContentPane(desktop);
        	    										
    	//set the size & visibility of the frame
    	setSize(600,600);
    	setVisible(true);
    }//end constructor
    
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab7Part1();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//class