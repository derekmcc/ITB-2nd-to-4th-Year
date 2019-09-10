import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab5Part4 extends JFrame implements ActionListener {
	
	//global variables
	JMenuItem menuItemBalance, menuItemDeposit, menuItemWithdraw, menuItemTransfer;
	JButton btnBalance, btnWithdraw, btnTransfer, btnDeposit, btnCancel, btnEnter;
	JLabel displayLabel, lblTxt;
	int balance = 3000, txtInt;
	JTextField txtInput;
	JPanel txtPanel;
	boolean flag = false, flag2 = false;
	String text;	
			
    public Lab5Part4() {
    	//set the title of the frame
    	super("Derek's ATM");
    	
    	//create the content pane
    	Container contentPane = getContentPane();
    	
    	//create the font & button icons
    	Font displayFont, btnFont;
    	ImageIcon okIcon = new ImageIcon("ok.png");
    	ImageIcon cancelIcon = new ImageIcon("cancel.png");
    	
    	//create the menu & add the menu items
    	JMenuBar mb = new JMenuBar();
    	JMenu atmMenu = new JMenu("Options",false);
    	atmMenu.add(menuItemBalance = new JMenuItem("View Balance"));
    	atmMenu.add(menuItemDeposit = new JMenuItem("Deposit Cash"));
    	atmMenu.add(menuItemWithdraw = new JMenuItem("Withdraw Cash"));
    	atmMenu.add(menuItemTransfer = new JMenuItem("Transfer Cash"));
    	
    	//add the acclerator keys for menu items
    	menuItemBalance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
    	menuItemDeposit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
    	menuItemTransfer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F , ActionEvent.CTRL_MASK));
    	menuItemWithdraw.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D , ActionEvent.CTRL_MASK));
    	
    	//add the mnemonics
    	menuItemBalance.setMnemonic('V');
    	menuItemDeposit.setMnemonic('D');
    	menuItemWithdraw.setMnemonic('W');
    	menuItemTransfer.setMnemonic('T');
    	
    	//add the menu to the menu bar and set it
    	mb.add(atmMenu);
    	setJMenuBar(mb);
    	
    	//add the action listeners to the menu items
    	menuItemBalance.addActionListener(this);
    	menuItemDeposit.addActionListener(this);
    	menuItemTransfer.addActionListener(this);
    	menuItemWithdraw.addActionListener(this);
    		
    	//create the display panel
    	JPanel displayPanel = new JPanel();
    	txtPanel = new JPanel();
    	displayLabel = new JLabel("Please choose an option");
    	
    	//create the text field to take inputs from the user
    	txtInput = new JTextField(10);
    	txtPanel.setBackground(Color.BLACK);
    	
    	//create the label and it to the panel
    	lblTxt = new JLabel("Enter Amount");
    	lblTxt.setForeground(Color.GREEN);
    	txtPanel.add(lblTxt);
    	txtPanel.add(txtInput);
    	
    	//set the layout of the panel
    	displayPanel.setLayout(new BorderLayout());
    	
    	//add the label to the display panel & set the font & colour
    	displayPanel.add(displayLabel, BorderLayout.CENTER);
    	displayPanel.add(txtPanel,BorderLayout.PAGE_END);
    	displayPanel.setBackground(Color.BLACK);
    	displayFont = new Font("Serif",Font.BOLD,20);
    	displayLabel.setFont(displayFont);
    	displayLabel.setForeground(Color.GREEN);
   		
    	//create the panels & buttons for the west side of atm
    	JPanel westPanel = new JPanel();
    	JPanel westPanel1 = new JPanel();
    	btnBalance = new JButton("Balance");
    	btnDeposit = new JButton("Deposit");
    	btnDeposit.setBackground(Color.lightGray);
    	btnBalance.setBackground(Color.lightGray);
    	
    	//add the action listeners to the buttons
    	btnBalance.addActionListener(this);
    	btnDeposit.addActionListener(this);
    	
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
    	btnWithdraw = new JButton("Withdraw");
    	btnTransfer = new JButton("Transfer");
    	btnTransfer.setBackground(Color.lightGray);
    	btnWithdraw.setBackground(Color.lightGray);
    	
    	//add the action listeners to the button
    	btnWithdraw.addActionListener(this);
    	btnTransfer.addActionListener((this));
    	
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
    	btnEnter = new JButton(okIcon);
    	btnCancel = new JButton(cancelIcon);
    	btnEnter.setBackground(Color.GREEN);
    	btnCancel.setBackground(Color.RED);
    	
    	//add action listeners to the buttons
    	btnEnter.addActionListener(this);
    	btnCancel.addActionListener(this);
    	
    	//add the buttons to the southPanel & set the layout
    	southPanel.setLayout(new GridLayout(1,2));
    	southPanel.add(btnEnter);
    	southPanel.add(btnCancel);
    	
    	//add the panels to the content pane
    	contentPane.add(displayPanel);
 		contentPane.add(westSide,BorderLayout.WEST);
    	contentPane.add(eastSide,BorderLayout.EAST);
    	contentPane.add(southPanel,BorderLayout.SOUTH);
    	
    	//hide the text panel
    	txtPanel.setVisible(false);
    	
    	//set the visibility and size of the frame 
    	setSize(800,500);
    	setVisible(true);
    }//end constructor
    
    public void actionPerformed(ActionEvent e){
    	//create an object of e for the enter button	
    	Object source = e.getSource();
    	
    	//if the user selects balance
    	if (e.getSource() == btnBalance || e.getSource() == menuItemBalance){
    		//display the balance
    		displayLabel.setText("Your Balance is €" + balance);
    		//hide the text panel
    		txtPanel.setVisible(false);
    	}//end if
    	
    	//else if the user selects withdraw
    	else if (e.getSource() == btnWithdraw || e.getSource() == menuItemWithdraw){
    		//display message
    		displayLabel.setText("Choose Amount to Withdraw");
    		//show the text panel
    		txtPanel.setVisible(true);
    		//set the flag to true
    		flag2 = true;
    	}//end else if
    	
    	//else if the user selects deposit
    	else if (e.getSource() == btnDeposit || e.getSource() == menuItemDeposit){
    		//display message
    		displayLabel.setText("Choose Amount to Deposit");
    		//show the text panel
    		txtPanel.setVisible(true);
    		//set the flag to true
    		flag = true;	
    	}//end else if
    	
    	//else if the user selects transfer
    	else if (e.getSource() == btnTransfer || e.getSource() == menuItemTransfer){
    		//display message
    		displayLabel.setText("Transfer Complete");
    		//hide the text panel
    		txtPanel.setVisible(false);
    	}//end else if
    		
    	//else if the presses cancel
    	else if (e.getSource() == btnCancel){
    		//prompt the user
    		displayLabel.setText("Please choose an option");
    		//reset the the variables
    		txtInput.setText("");
    		text = "";
    		txtInt = 0;
    		
    		//hide the text panel
    		txtPanel.setVisible(false);
    		
    		//set the flags to false
    		flag = false;
    		flag2 = false;
    	}//end else if
    	
    	//if the flag is true
    	if (flag == true){
    		//if the user presses enter
    		if (source == btnEnter){
	    		//set the text field to a string
	    		text = txtInput.getText();
	    		
	    		//if the user inputs non numeric digits
	    		if(!text.matches("\\d+")){
	    			//display error message
	    			displayLabel.setText("Error Numeric Digits Only");
	    			//reset the text area to empty
	    			txtInput.setText("");
	    		}//end if
	    		else{
	    			//convert the string input to an int
	    			txtInt = Integer.parseInt(text);
	    			//add the user input to the balance
	    			balance += txtInt;
	    			//display the new balance
	    			displayLabel.setText("Your Balance is €" + balance);
	    			//reset the text field
	    			txtInput.setText("");
	    			//hide the text panel
	    			txtPanel.setVisible(false);
	    			//set the flag to false
	    			flag = false;	
	    		}//end else if	
    		}//end if	
    	}//end if flag
    	
    	//if flag is true(User selects withdraw)
    	if (flag2 == true){
    		//if the enter button is clicked
    		if (source == btnEnter){
	    		//set the text field to a string
	    		text = txtInput.getText();
	    		
	    		//if the user inputs non numeric digits
	    		if(!text.matches("\\d+")){
	    			//display error message
	    			displayLabel.setText("Error Numeric Digits Only");
	    			//reset the text area to empty
	    			txtInput.setText("");
	    		}//end if
	    		
	    		//convert the string input to an int
	    		txtInt = Integer.parseInt(text);
	    		
	    		//if the input amount is greater than the balance 
	    		if (txtInt > balance){
	    			//display error message
	    			displayLabel.setText("Insufficent Funds");
	    			//reset the text area to empty
	    			txtInput.setText("");
	    			//hide the text panel
	    			txtPanel.setVisible(false);
	    		}//end else if
	    		else{
	    			//add the user input to the balance
	    			balance -= txtInt;
	    			//display the new balance
	    			displayLabel.setText("Your Balance is €" + balance);
	    			//reset the text field
	    			txtInput.setText("");
	    			//hide the text panel
	    			txtPanel.setVisible(false);	
	    			//set the flag to false	
	    			flag2 = false;	
	    		}//end else if	
    		}//end if
    	}//end if flag
    }//end handler method
    
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab5Part4();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class