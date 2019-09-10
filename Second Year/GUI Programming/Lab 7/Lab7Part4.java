import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.*;


public class Lab7Part4 extends JFrame implements ActionListener{
	
	//global variables
	JMenuItem xAndOItem, sudokuItem;
	JDesktopPane desktop;
	Border panelBorder = new LineBorder(Color.BLACK,2);
	JInternalFrame innerFrame1=sudokuFrame(), innerFrame2=xAndOframe(),iframe = new JInternalFrame();
	Font font;
	JButton[] buttons  = new JButton[9];
	boolean flag = false;
	
    public Lab7Part4() {
    	//set the title of the frame
    	super("Game's");
    	//set the menuBar  	
		setJMenuBar(buildMenu());
		//create the desktop
		desktop = new JDesktopPane();
		//create the content pane
    	Container contentPane = getContentPane();
    	//add the desktop to the content pane
    	contentPane.add(desktop);
    	//set the size & visibility
    	setSize(800,800);
    	setVisible(true);
    }//end constructor
    
    public JMenuBar buildMenu(){
    	//create the menu bar & menu 
    	JMenuBar mb = new JMenuBar();
    	JMenu select = new JMenu("Select",false);
    	//create the menu items
    	select.add(xAndOItem = new JMenuItem("X’s and O’s"));
    	select.add(sudokuItem = new JMenuItem("Sudoku"));
    	
    	//add action listeners to the menu items
    	xAndOItem.addActionListener(this);
    	sudokuItem.addActionListener(this);
    	
    	//add accelerators to the menu items
    	xAndOItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
    	sudokuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
    	
    	//add the mnemonics
    	xAndOItem.setMnemonic('X');
    	sudokuItem.setMnemonic('S');
    	
    	//add the menu to the menu bar
    	mb.add(select);
    	//return the menu bar
    	return mb;
    }//end menu method
    
    public JInternalFrame sudokuFrame(){
    	//set the internal frame to null
    	JInternalFrame iFrame = null;
    	//create a new internal frame
    	iFrame = new JInternalFrame("Derek's Sudoku");
    	
    	//create the panels
    	JPanel panel1 = null;
    	JPanel panel2 = new JPanel();
    	
    	//set the layout of the panel
    	panel2.setLayout(new GridLayout(3,3));
    	//create a font
    	font = new Font("SansSerif", Font.BOLD, 35);
    	
    	//loop to create panels for sudoku board
    	for (int i=0;i<9;i++){
    		//create a new panel with every loop iteration
    		panel1 = new JPanel();
    		//set the layout of the panel
    		panel1.setLayout(new GridLayout(3,3));
    		
    		//add a border to each 3*3 panel
    		panel1.setBorder(panelBorder);
    		
    		//loop to create textfields for the board
    		for (int x=0;x<9;x++){
    			//set the textfield to null
    			JTextField txtField = null;
    			//create a new text
    			txtField = new JTextField(1);
    			//set the font of the textfield
    			txtField.setFont(font);
    			//set the alignment of the textfield
    			txtField.setHorizontalAlignment(JTextField.CENTER);
    			//add a random number to the textField
				txtField.setText(""+(1+(int)(Math.random()*9)));
    			//add the textfield to thepanel
    			panel1.add(txtField);
    			//creat & add a new textfield to the panel
    			//panel1.add(new JTextField(10));
    			//set the 
    		}//end inner for 
    		
    		//loop to add the 3*3 panel to a 3*3 panel
    		for (int y=0;y<9;y++){
    			//add panel1 to the panel2
    			panel2.add(panel1);
    		}//end inner for
    	}//end outer for
    	
    	//add the panel to the frame
    	iFrame.add(panel2);
  		//set the size and visibility of the inner frame
    	iFrame.setSize(600,600);
    	iFrame.setVisible(true);
    	
    	//return the internal frame
    	return iFrame;
    }//end internal frame method
    
    public JInternalFrame xAndOframe(){
    	//set the internal frame to null
    	JInternalFrame iFrame;
    	//create a new internal frame
    	iFrame = new JInternalFrame("Derek's X & O's");
    	//create an array of buttons
    	JButton buttons[]  = new JButton[9];
    	//create a panel
    	JPanel panel = new JPanel();
    	//create a font
    	font = new Font("SansSerif", Font.BOLD, 45);
    	//set the layout of the panel
    	panel.setLayout(new GridLayout(3,3));
    	//loop to create 9 buttons
    	for(int x =0;x<buttons.length;x++){
    		//create a new button
    		buttons[x] = new JButton();
    		//add an action listener to the button
    		buttons[x].addActionListener(this);
    		//set the font of the button
    		buttons[x].setFont(font);
    		//add the buttons to the panel
    		panel.add(buttons[x]);
    	}//end for
    	
    	//add the panel to the frame
    	iFrame.add(panel);
  		//set the size and visibility of the inner frame
    	iFrame.setSize(600,600);
    	iFrame.setVisible(true);
    	
    	//return the internal frame
    	return iFrame;		
    }//end internal freame method
    
    //event handler method
    public void actionPerformed(ActionEvent e){
    	//create a temp object of the event
    	Object source = e.getSource();
    	//check if the object source is a jbutton 
	    if (source instanceof JButton){
	    	//create a temp button of the users selected button
	        JButton btnTemp = (JButton) e.getSource();
	    	//if the flag is false(default state)
	    	if(flag == false){
	    		//set the text on the button 
	    		btnTemp.setText("X");
	    		//set the flag to true
	    		flag=true;
	    	}//end if
	    	else{
	    		//set the text on the button 
	    		btnTemp.setText("O");
	    		//set the flag to false
	    		flag=false;
	    	}//end else	
	    }//end if 
	    else{
	    	//if the user selects sudoku
	        if (e.getSource() == sudokuItem){
	        	desktop.removeAll();
	        	//add the sudoku method to the desktop
    			desktop.add(sudokuFrame());
	    	}//end if
	    	//else if the user selects X & O's
	    	else if (e.getSource() == xAndOItem){
	    		desktop.removeAll();
	    		//add the X & O's method to the desktop
	    		desktop.add(xAndOframe());
	    	}//end else if
	    }//end else if    
    }//end handler method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab7Part4();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class