import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Lab7Part3 extends JFrame implements ActionListener {
	
	JMenuItem fontItem, imageItem;
	JInternalFrame fontFrame=buildFontFrame(), imageFrame=buildImageFrame(),innerFrame = new JInternalFrame();
	ImageIcon icon;
	JDesktopPane desktop;
    final int xOffset = 20, yOffset = 20;
    int num = 1; 
    	 
    public Lab7Part3() {
    	//set the title
    	super("Applications");
    	//create the desktop pane
    	desktop = new JDesktopPane();
    	//set the menu bar
	   	setJMenuBar(buildMenu());
	   	//create the content pane
	   	Container contentPane = getContentPane();
	   	//add the desktop to the content pane
    	contentPane.add(desktop);
    	//set the size & visibility
    	setSize(700,700);
    	setVisible(true);
    }//end constructor
    
    public JMenuBar buildMenu(){
    	//create the menu bar & menu
    	JMenuBar mb = new JMenuBar();
    	JMenu apps = new JMenu("Apps",false);
    	//create the menu items
    	apps.add(fontItem = new JMenuItem("Font App"));
    	apps.add(imageItem = new JMenuItem("Image App"));
    	//add action listeners to the menu items
    	fontItem.addActionListener(this);
    	imageItem.addActionListener(this);
    	
    	//add accelerators to the menu items
    	fontItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
    	imageItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
    	
    	//add the mnemonics
    	fontItem.setMnemonic('F');
    	imageItem.setMnemonic('I');
    	
    	//add the menu to the menu bar
    	mb.add(apps);
    	//return the menu bar
    	return mb;
    }//end menu method
    
    public JInternalFrame buildFontFrame(){
    	//set the internal frame to null
    	JInternalFrame iFrame = null;
    	//create a new internal frame
    	iFrame = new JInternalFrame();
    	
    	//create the labels
    	JLabel label1 = new JLabel("Hello World! 1");
    	JLabel label2 = new JLabel("Hello World! 2");
    	JLabel label3 = new JLabel("Hello World! 3");
    	
    	//create font 
    	Font font1, font2, font3;
    	//create a panel
    	JPanel panel = new JPanel();
    	
    	//set the font	
    	font1 = new Font("Serif",Font.ITALIC,15);
    	font2 = new Font("SANS_SERIF",Font.BOLD,15);
    	font3 = new Font("Garamond", Font.LAYOUT_LEFT_TO_RIGHT, 15);
    	
    	//set the font on the labels
    	label1.setFont(font1);
    	label2.setFont(font2);
    	label3.setFont(font3);
    	
 		//add the labels to the panel
    	panel.add(label1);
    	panel.add(label2);
		panel.add(label3);
    	
    	//set the layout of the panel
    	panel.setLayout(new GridLayout(3,0));
    	
    	//add the panel to the internal frame
    	iFrame.add(panel);
    	//set the size & visibility
    	iFrame.setSize(200,200);
    	iFrame.setVisible(true);
    	
    	//set the location of every new frame
       	iFrame.setLocation(xOffset*(num), yOffset*(num));
       	
    	//return the iframe
    	return iFrame;
    }//end internal frame method
    
    public JInternalFrame buildImageFrame(){
    	//set the internal frame to null
    	JInternalFrame iFrame = null;
    	//create a new internal frame
    	iFrame = new JInternalFrame();
    	icon = new ImageIcon("images/jayden.jpg");
    	
    	//create the labels
    	JLabel lblIcon = new JLabel();
    	JLabel label = new JLabel("Jayden");
    	
    	//create a panel
    	JPanel panel = new JPanel();
    	
    	//add the icon to the label
    	lblIcon.setIcon(icon);
    	
    	//add the labels to the panel
    	panel.add(label);
    	panel.add(lblIcon);
    	
    	//add the panel to the internal frame
    	iFrame.add(panel);
    	
    	//set the size & visibility
    	iFrame.setSize(200,220);
    	iFrame.setVisible(true);
    	
    	//set the location of every new frame
       	iFrame.setLocation(xOffset*(num), yOffset*(num));
    	//return the iframe
    	return iFrame;
    }//end internal frame method
    
    //event handler method
    public void actionPerformed(ActionEvent e){
    	//increment for frame location
    	num++;
    	if (e.getSource() == fontItem){
    		//add the internal frame to the desktop pane
    		desktop.add(buildFontFrame());
    	}//end if
    	else if (e.getSource() == imageItem){
    		//add the internal frame to the desktop pane
    		desktop.add(buildImageFrame());
    	}//end else if
    }//end handler method
    	
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab7Part3();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class