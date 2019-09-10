import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Lab8Part3 extends JFrame implements MouseInputListener{
	
	//global component
	JLabel label;
	
    public Lab8Part3() {
    	//set the title
    	super("MouseListener");
    	
    	//create a panel
    	JPanel panel = new JPanel();
    	
    	//create a label
    	label = new JLabel();
    	
    	//add the label to the panel
    	panel.add(label);
    		
    	//add the mouse listeners to the panel
    	panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
    	//create contentPane
    	Container contentPane = getContentPane();
    	//add the panel to the contentPane
    	contentPane.add(panel);
    
    	//set the size and visibility
    	setSize(600,200);
    	setVisible(true);
    }//end constructor
    
    public void mouseClicked(MouseEvent e) {
    	//set the text
		label.setText("Mouse Click Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Click\n" + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());
		}//end if
	}//end mouseClicked method

	public void mouseEntered(MouseEvent e) {
		//set the text
		label.setText("Mouse Entered Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Enter");
		}//end if		
	}//end mouseEntered method

	public void mouseExited(MouseEvent e) {
		//set the text
		label.setText("Mouse Exit Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Exit");
		}//end if		
	}//end mouseExited method

	public void mousePressed(MouseEvent e) {
		//set the text
		label.setText("Mouse Pressed Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Pressed");
		}//end if		
	}//end mousePressed method

	public void mouseReleased(MouseEvent e) {
		//set the text
		label.setText("Mouse Released Event");	
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Release");
		}//end if		
	}//end mouseReleased method

	public void mouseDragged(MouseEvent e) {
		//set the text
		label.setText("Mouse Dragged " + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());	
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Drag");
		}//end if 		
	}//end mouseDragged method

	public void mouseMoved(MouseEvent e) {
		//set the text
		label.setText("Mouse Move " + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());	
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Move");
		}//end if		
	}//end mouseMoved method
	
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab8Part3();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class