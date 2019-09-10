import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lab8Part2 extends JFrame implements ActionListener {
	
	//global variables
	JLabel colourFontLabel;
	Font font;
	JButton btnChangeColour;
	
    public Lab8Part2() {
    	//set the title
    	super("Colour Chooser");
    	
    	//create a font
    	font = new Font("SansSerif", Font.BOLD, 35);
    	
    	//create a label & set the font
    	colourFontLabel = new JLabel("This text will change colour");
    	colourFontLabel.setFont(font);
    	
    	//create button
    	btnChangeColour = new JButton("Change text colour");
    	btnChangeColour.addActionListener(this);
    	
    	//create a jpanel
    	JPanel panel = new JPanel();
    	
    	//add the components to the panel
    	panel.add(colourFontLabel);
    	panel.add(btnChangeColour);
    	
    	//create contentPane
    	Container contentPane = getContentPane();
    	//add the panel to the contentPane
    	contentPane.add(panel);
    
    	//set the size and visibility
    	setSize(600,200);
    	setVisible(true);
    }//end constructor
    
    //event handler method
    public void actionPerformed(ActionEvent e){
    	//set the initial colour
    	Color colour = Color.RED;  
    	//create the colour chooser	
		Color color = JColorChooser.showDialog(this,"Select a color",colour);
		//set the colour of the text to the users chosen colour  
		colourFontLabel.setForeground(color);
    }//end handler method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab8Part2();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class