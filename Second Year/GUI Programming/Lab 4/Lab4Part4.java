//import the packages 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab4Part4 extends JFrame implements ActionListener {
	
	//declare the components
	JButton btnTopUp, btnMakeCall, btnSendText;
	JLabel lblDisplay,lblMake,lblCredit;
	JTextField txtAddCredit;
	JPanel panel,btnPanel,displayPanel,displayHeader,creditPanel,accountPanel; 
	int credit = 6;
		
    public Lab4Part4() {
    	//set the title of the frame
    	super("My Mobile");
    	ImageIcon phoneIcon = new ImageIcon("phone.png");
 		ImageIcon messageIcon = new ImageIcon("message.png");
 		ImageIcon topUpIcon = new ImageIcon("topUp.png");
 		
    	//create the components
    	Container contentPane = getContentPane();
    	panel = new JPanel();
    	btnPanel = new JPanel();
    	displayPanel = new JPanel();
    	displayHeader = new JPanel();
    	accountPanel = new JPanel();
    	creditPanel = new JPanel();
    	
    	lblMake = new JLabel("SAMSUNG");
    	lblDisplay = new JLabel();
    	lblCredit = new JLabel("Total Credit €"+credit);
    	txtAddCredit = new JTextField(10);
    	btnMakeCall = new JButton(phoneIcon);
    	btnSendText = new JButton(messageIcon);
    	btnTopUp = new JButton(topUpIcon);
    	
    	//hide the buttons borders only show the icon
    	btnMakeCall.setBorderPainted(false); 
        btnMakeCall.setContentAreaFilled(false); 
        btnMakeCall.setFocusPainted(false); 
        btnMakeCall.setOpaque(false);
    	btnSendText.setBorderPainted(false); 
        btnSendText.setContentAreaFilled(false); 
        btnSendText.setFocusPainted(false); 
        btnSendText.setOpaque(false);
    	btnTopUp.setBorderPainted(false); 
        btnTopUp.setContentAreaFilled(false); 
        btnTopUp.setFocusPainted(false); 
        btnTopUp.setOpaque(false);
    	
    	//set the size of the buttons
    	btnMakeCall.setPreferredSize(new Dimension(60,60));
    	btnSendText.setPreferredSize(new Dimension(60,60));
    	btnTopUp.setPreferredSize(new Dimension(60,60));
    	
    	//button panel
    	btnPanel.add(btnMakeCall);
    	btnPanel.add(btnSendText);
    	btnPanel.add(btnTopUp);
    	btnPanel.setLayout(new GridLayout(1,3,8,8));
    	
    	//add the action listeners
    	btnMakeCall.addActionListener(this);
    	btnSendText.addActionListener(this);
    	btnTopUp.addActionListener(this);
    	
    //	displayPanel.setBackground(Color.BLACK);
    //	panel.setBackground(Color.BLACK);
    	
    	//display panel
    	displayHeader.add(lblMake);
    	accountPanel.add(lblCredit);
    	creditPanel.add(txtAddCredit);
    	displayPanel.add(displayHeader);
    	displayPanel.add(creditPanel);/////////////////
    	displayPanel.add(accountPanel);
    	displayPanel.add(lblDisplay);
    	displayPanel.setLayout(new GridLayout(4,1,10,40));
    	JPanel pan = new JPanel();
    //	pan.add(displayPanel);
    	
    	
    	//panel.add(displayPanel);//DONT DO
    	
    //	panel.add(displayHeader,BorderLayout.PAGE_START);
    //	panel.add(pan,BorderLayout.CENTER);//DONT DO	
    	panel.add(btnPanel);
    	
    	contentPane.add(displayPanel,BorderLayout.PAGE_START);
    	contentPane.add(pan,BorderLayout.CENTER);
    	contentPane.add(panel,BorderLayout.PAGE_END);
    	
    //	contentPane.add(panel);
    	
    //	contentPane.add(lblDisplay);
    	//set the frame size and visibility
    	setSize(220,350);
    	setVisible(true);
    	
    }//end constructor
    
    //event handler method
    public void actionPerformed(ActionEvent e){
   		//reset the label to the empty string 
    	lblDisplay.setText("");
    	if (e.getSource() == btnMakeCall){
    		//if statement to check the user has sufficient credit
    		if (credit > 1){
    			//take the cost of the call away from the credit balance
    			credit -= 2;
    			//update the label with the balance
    			lblCredit.setText("Total Credit €"+credit);	
    		}//end inner if
    		
    		else {
    			//display the user has insufficient funds
    			lblDisplay.setText("Insufficent Funds");
    		//	btnMakeCall.setEnabled(false);
    		//	btnSendText.setEnabled(false);	
    		}//end else
    	}//end if
    	 
    	if (e.getSource() == btnSendText){
    		//if statement to check the user has sufficient credit
    		if (credit > 0){
    			//take the cost of the text away from the credit balance
    			credit -= 1;
    			//update the label with the balance
    			lblCredit.setText("Total Credit €"+credit);
    		}//end inner if
    		else{
    			//display the user has insufficient funds
    			lblDisplay.setText("Insufficent Funds");
    	//		btnMakeCall.setEnabled(false);
    	//		btnSendText.setEnabled(false);
    		}//end else
    	}//end if
    	
    	if (e.getSource() == btnTopUp){
    		String text = txtAddCredit.getText();
    		if(!text.matches("\\d+")){
    			lblDisplay.setText("Numeric Digits Only");
    			txtAddCredit.setText("");
    		}//
    		else{
    		//	String text = txtAddCredit.getText();
    			int creditInt = Integer.parseInt(text);
    			credit += creditInt;
    			//update the label with the balance
    			lblCredit.setText("Total Credit €"+credit);
    			txtAddCredit.setText("");
    		}//end else
    	}//end if
    }//end event handler method
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab4Part4();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    }//end main method
}//end class