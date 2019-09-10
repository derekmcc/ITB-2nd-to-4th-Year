import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Lab6Part3 extends JFrame implements ChangeListener{
	
	//global components
	JSlider volumeSlider, bassSlider = new JSlider();
	JLabel lblVolume, lblBass = new JLabel();
	JPanel volumePanel=buildVolumePanel(), bassPanel=buildBassPanel(), disPanel = new JPanel();
	
    public Lab6Part3(){
    	//set the title
    	super("Stereo");

    	//create content pane
    	Container contentPane = getContentPane();
    	
    	//add the panels to the display panel
    	disPanel.add(volumePanel);
    	disPanel.add(bassPanel);
    	//add the panel to the content pane
    	contentPane.add(disPanel);
    	
    	//set the size & visibility
    	setSize(300,200);
    	setVisible(true);
    }//end constructor
    
    public JPanel buildVolumePanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a new panel
    	panel = new JPanel();
    	//create the jslider
    	volumeSlider = new JSlider();
    	//set the max & min values of the slider
    	volumeSlider.setMaximum(30);
    	volumeSlider.setMinimum(0);
    	
    	//create a label
    	lblVolume = new JLabel("Volume : 30");
    	
    	//add change listener
    	volumeSlider.addChangeListener(this);
    	
    	//set the layout of the panel
    	panel.setLayout(new GridLayout(2,0));
    	
    	//add the components to the panel
    	panel.add(lblVolume);
    	panel.add(volumeSlider);
    	
    	//return the panel
    	return panel;
    }//end buildVolumePanel
    
    public JPanel buildBassPanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a new panel
    	panel = new JPanel();
    	//create the jslide
    	bassSlider = new JSlider();
    	
    	//set the max & min values of the slider
    	bassSlider.setMaximum(10);
    	bassSlider.setMinimum(-10);
    	
    	//create a label
    	lblBass = new JLabel("Bass : 10");
    	
    	//add change listener
    	bassSlider.addChangeListener(this);
    	
    	//set the layout of the panel
    	panel.setLayout(new GridLayout(2,0));
    	
    	//add the components to the panel
    	panel.add(lblBass);
    	panel.add(bassSlider);
    	
    	//return the panel
    	return panel;
    }//end buildBassPane
    
    public void stateChanged(ChangeEvent e){
    	//if the user adjusts the volume slider
    	if (e.getSource() == volumeSlider){
    		//display the volume
    		lblVolume.setText("Volume : "+volumeSlider.getValue());
    	}//end if
    	else{
    		//display the bass number
    		lblBass.setText("Bass : "+bassSlider.getValue());
    	}//end else	
    }//end event method
    
    public static void main(String args[]){
    	JFrame frame = new Lab6Part3();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class