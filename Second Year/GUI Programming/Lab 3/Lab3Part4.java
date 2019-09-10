import javax.swing.*;
import java.awt.*;

public class Lab3Part4 extends JFrame{

    public Lab3Part4() {
    	//set the title of the frame
    	super("Derek's ATM");
    	
    	//create the content pane
    	Container contentPane = getContentPane();
    	
    	//create the font & button icons
    	Font displayFont, btnFont;
    	ImageIcon okIcon = new ImageIcon("ok.png");
    	ImageIcon cancelIcon = new ImageIcon("cancel.png");
    		
    	//create the display panel
    	JPanel displayPanel = new JPanel();
    	JLabel displayLabel = new JLabel("Please choose an option");
    	
    	//add the label to the display panel & set the font & colour
    	displayPanel.add(displayLabel);
    	displayPanel.setBackground(Color.BLACK);
    	displayFont = new Font("Serif",Font.BOLD,20);
    	displayLabel.setFont(displayFont);
    	displayLabel.setForeground(Color.GREEN);
   
    	//create the panels & buttons for the west side of atm
    	JPanel westPanel = new JPanel();
    	JPanel westPanel1 = new JPanel();
    	JButton btnBalance = new JButton("Balance");
    	JButton btnDeposit = new JButton("Deposit");
    	btnDeposit.setBackground(Color.lightGray);
    	btnBalance.setBackground(Color.lightGray);
    	
    	//create the labels 
    	JLabel lblBalance = new JLabel("See Account Balance");
    	JLabel lblDeposit = new JLabel("Depsit Cash / Cheque");
    	
    	//add the buttons to the panel
    	westPanel.setLayout(new GridLayout(2,1));
    	westPanel.add(btnBalance);
    	westPanel.add(btnDeposit);
    	
    	//add the labels to the panel 
    	westPanel1.setLayout(new GridLayout(2,1));
    	westPanel1.add(lblBalance);
    	westPanel1.add(lblDeposit);
    	
    	//add the panels to the westside of the atm screen
    	JPanel westSide = new JPanel();
    	westSide.setLayout(new GridLayout(1,2));
    	westSide.add(westPanel);
    	westSide.add(westPanel1);
    	
    	//set the font & colours for the west panel
    	westPanel1.setBackground(Color.BLACK);
    	btnFont = new Font("Serif",Font.ITALIC,15);
    	lblBalance.setFont(btnFont);
    	lblDeposit.setFont(btnFont);
    	lblBalance.setForeground(Color.GREEN);
    	lblDeposit.setForeground(Color.GREEN);
    	
    	//create the panels & buttons for the east of the atm screen
    	JPanel eastPanel = new JPanel();
    	JPanel eastPanel1 = new JPanel();
    	JButton btnWithdraw = new JButton("Withdraw");
    	JButton btnTransfer = new JButton("Transfer");
    	btnTransfer.setBackground(Color.lightGray);
    	btnWithdraw.setBackground(Color.lightGray);
    	
    	//create the labels
    	JLabel lblWithdraw = new JLabel("Withdraw Funds");
    	JLabel lblTransfer = new JLabel("Transfer Cash");
    	
    	//add the buttons to the panel
    	eastPanel.setLayout(new GridLayout(2,1));
    	eastPanel.add(btnWithdraw);
    	eastPanel.add(btnTransfer);
    	
    	//add the labels to the panel
    	eastPanel1.setLayout(new GridLayout(2,1));
   		eastPanel1.add(lblWithdraw);
    	eastPanel1.add(lblTransfer);
    	
    	//add the panels to the esast side of the screen 
    	JPanel eastSide = new JPanel();
    	eastSide.setLayout(new GridLayout(1,2));
    	eastSide.add(eastPanel1);
    	eastSide.add(eastPanel);
    	eastPanel1.setBackground(Color.BLACK);
    	
    	//set the font & colour of the butons
    	lblWithdraw.setFont(btnFont);
    	lblTransfer.setFont(btnFont);
    	lblWithdraw.setForeground(Color.GREEN);
    	lblTransfer.setForeground(Color.GREEN);
    	
    	
    	//create the enter and cancel buttons
    	JPanel southPanel = new JPanel();
    	JButton btnEnter = new JButton(okIcon);
    	JButton btnCancel = new JButton(cancelIcon);
    	btnEnter.setBackground(Color.GREEN);
    	btnCancel.setBackground(Color.RED);
    
    	//add the buttons to the southPanel & set the layout
    	southPanel.setLayout(new GridLayout(1,2));
    	southPanel.add(btnEnter);
    	southPanel.add(btnCancel);
    	
    	//add the panels to the content pane
    	contentPane.add(displayPanel);
 		contentPane.add(westSide,BorderLayout.WEST);
    	contentPane.add(eastSide,BorderLayout.EAST);
    	contentPane.add(southPanel,BorderLayout.SOUTH);
    	
    	//set hte visibility and size of the frame 
    	setSize(800,500);
    	setVisible(true);
    }//end constructor
    
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab3Part4();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class