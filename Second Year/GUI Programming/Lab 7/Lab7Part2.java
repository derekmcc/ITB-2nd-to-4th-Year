import javax.swing.*;
import java.awt.*;

public class Lab7Part2 extends JFrame{
	
	JDesktopPane desktop=buildDesktop(),desktopPane = new JDesktopPane();
	
    public Lab7Part2() {
    	//set the title
    	super("Cascade Frames");
    	
    	//create the content pane
      	Container contentPane = getContentPane();
      	//add the desktop to the content pane
    	contentPane.add(desktop);
    	
    	//set the size & visibility
    	setSize(700,700);
    	setVisible(true); 
    }//end constructor
    
    public JDesktopPane buildDesktop(){
    	//set the desktopPane to null
    	JDesktopPane desktopPane = null;
    	//create a new desktopPane
    	desktopPane = new JDesktopPane();
    	//set the X & Y offSet
    	final int xOffset = 20, yOffset = 20;
    	//create the inner frame
    	JInternalFrame innerFrame = new JInternalFrame();
		//loop to create 10 frames
    	for (int i=0;i<10;i++){
			//create a new frame with every loop iteration
    		innerFrame = new JInternalFrame("Frame " + (i+1) ,
              										true, //resizable
              										true, //closable
              										true, //maximizable
              										true);//iconifiable
    		//set the frame size & visibility
    		innerFrame.setSize(300,300);
       	 	innerFrame.setVisible(true);
       	 	//set the location of every new frame
       		innerFrame.setLocation(xOffset*(i+1), yOffset*(i+1));
       		//add every new frame to the desktopPane
       		desktopPane.add(innerFrame);
    	}//end if
		//return the desktopPane
    	return desktopPane;
    }//end desktop pane method
    
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab7Part2();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class