import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab6Part4 extends JFrame implements ActionListener, ItemListener {
	
	//global variables & events
	JPanel q1Panel=buildQ1Panel(), q2Panel=buildQ2Panel(), q3Panel=buildQ3Panel(),
		 resultPanel=buildResultPanel(), layoutPanel = new JPanel();
	JRadioButton rdoQ1Choice1, rdoQ1Choice2, rdoQ1Choice3,rdoQ2Choice1,rdoQ2Choice2,rdoQ2Choice3,
		rdoQ3Choice1,rdoQ3Choice2,rdoQ3Choice3; 
	JLabel qLabel, lblIcon1, lblIcon2, lblIcon3, lblResult1, lblResult2, lblResult3;
	ImageIcon icon;
	JButton btnNext = new JButton();
	ButtonGroup group1, group2, group3;
	Container contentPane = getContentPane();
	int count = 0;
	
    public Lab6Part4() {
    	//set the title of the frame
    	super("Quiz");
    	
    	//set the card layout of the layoutPanel
    	layoutPanel.setLayout(new CardLayout());
    	
    	//add the panels to the main panel
    	layoutPanel.add(q1Panel);
    	layoutPanel.add(q2Panel);
    	layoutPanel.add(q3Panel);
 		layoutPanel.add(resultPanel);
    	contentPane.add(layoutPanel,BorderLayout.NORTH);
    	contentPane.add(buildButtonPanel());
    		
    	//set the size & visibility
    	setSize(400,410);
    	setVisible(true);
    }//end constructor
    
    public void actionPerformed(ActionEvent e){	
    	//Get the card layout from the main panel
		CardLayout card = (CardLayout)layoutPanel.getLayout();
		if (count == 0){
			if(group1.getSelection()==null){
				JOptionPane.showMessageDialog(contentPane,
				            	"Choose an option",
				                "Error choose an option",
				                JOptionPane.WARNING_MESSAGE);
			}//end if
			else{
				card.next(layoutPanel);
				count = 1;
			}//end else	
		}//end if
		else if (count == 1){
			if(group2.getSelection()==null){
				JOptionPane.showMessageDialog(contentPane,
				            	"Choose an option",
				                "Error choose an option",
				                JOptionPane.WARNING_MESSAGE);
			}//end if
			else{
				card.next(layoutPanel);
				count = 2;
			}//end else	
		}//end else if
		else if (count == 2){
			if(group3.getSelection()==null){
				JOptionPane.showMessageDialog(contentPane,
				            	"Choose an option",
				                "Error choose an option",
				                JOptionPane.WARNING_MESSAGE);
			}//end if
			else{
				card.next(layoutPanel);
			}//end else	
		}//end else if	
    }//end handeler method
    
    //handle for radio button events
   	public void itemStateChanged(ItemEvent e){
   		//if the user chooses option 1 on Question 1
   		if (e.getSource() == rdoQ1Choice1){
   			//create the icon
   			icon = new ImageIcon("images/football.png");
   			//add the icon to the label
   			lblIcon1.setIcon(icon);
   			//add the text to the label
   			lblResult1.setText("Your favourite sport is Football");
   		}//end if
   		//if the user chooses option 2 on Question 1
   		else if (e.getSource() == rdoQ1Choice2){
   			//create the icon
   			icon = new ImageIcon("images/golf.png");
   			//add the icon to the label
   			lblIcon1.setIcon(icon);
   			//add the text to the label
   			lblResult1.setText("Your favourite sport is Golf");
   		}//end else if
   		//if the user chooses option 3 on Question 1
   		else if (e.getSource() == rdoQ1Choice3){
   			//create the icon
   			icon = new ImageIcon("images/tennis.png");
   			//add the icon to the label
   			lblIcon1.setIcon(icon);
   			//add the text to the label
   			lblResult1.setText("Your favourite sport is Tennis");
   		}//end else if
   		//if the user chooses option 1 on Question 2
   		else if (e.getSource() == rdoQ2Choice1){
   			//create the icon
   			icon = new ImageIcon("images/black.jpg");
   			//add the icon to the label
   			lblIcon2.setIcon(icon);
   			//add the text to the label
   			lblResult2.setText("Your favourite Colour is Black");
   		}//end else if
   		//if the user chooses option 2 on Question 2
   		else if (e.getSource() == rdoQ2Choice2){
   			//create the icon
   			icon = new ImageIcon("images/blue.png");
   			//add the icon to the label
   			lblIcon2.setIcon(icon);
   			//add the text to the label
   			lblResult2.setText("Your favourite Colour is Blue");
   		}//end else if
   		//if the user chooses option 3 on Question 2
   		else if (e.getSource() == rdoQ2Choice3){
   			//create the icon
   			icon = new ImageIcon("images/green.png");
   			//add the icon to the label
   			lblIcon2.setIcon(icon);
   			//add the text to the label
   			lblResult2.setText("Your favourite Colour is Green");
   		}//end else if
   		//if the user chooses option 1 on Question 3
   		else if (e.getSource() == rdoQ3Choice1){
   			//create the icon
   			icon = new ImageIcon("images/ireland.png");
   			//add the icon to the label
   			lblIcon3.setIcon(icon);
   			//add the text to the label
   			lblResult3.setText("Your favourite Country is Ireland");
   		}//end else if
   		//if the user chooses option 2 on Question 3
   		else if (e.getSource() == rdoQ3Choice2){
   			//create the icon
   			icon = new ImageIcon("images/eng.png");
   			//add the icon to the label
   			lblIcon3.setIcon(icon);
   			//add the text to the label
   			lblResult3.setText("Your favourite Country is England");
   		}//end else if
   		//if the user chooses option 3 on Question 3
   		else if (e.getSource() == rdoQ3Choice3){
   			//create the icon
   			icon = new ImageIcon("images/usa.jpg");
   			//add the icon to the label
   			lblIcon3.setIcon(icon);
   			//add the text to the label
   			lblResult3.setText("Your favourite Country is USA");
   		}//end else if
  	}//end radio handler
  	
    public JPanel buildQ1Panel(){
    	//set the panel to null
    	JPanel panel = null;
    	
    	//create components panels
    	JPanel rdoPanel = new JPanel();
    	
    	//create a new panel
    	panel = new JPanel();
    	
    	//create radio buttons
    	rdoQ1Choice1 = new JRadioButton("Football",false);
    	rdoQ1Choice2 = new JRadioButton("Golf",false);
    	rdoQ1Choice3 = new JRadioButton("Tennis",false);
   		
   		//add item listeners 
    	rdoQ1Choice1.addItemListener(this);
    	rdoQ1Choice2.addItemListener(this);
    	rdoQ1Choice3.addItemListener(this);

    	//create the button group 
    	group1 = new ButtonGroup();
    	
    	//add the buttons to the group
   		group1.add(rdoQ1Choice1);
    	group1.add(rdoQ1Choice2);
    	group1.add(rdoQ1Choice3);
    	
    	//create the labels
    	qLabel = new JLabel("What is your favourite sport?");
    	lblIcon1 = new JLabel();
    	
    	//add the radio buttons to the panel
    	rdoPanel.add(rdoQ1Choice1);
    	rdoPanel.add(rdoQ1Choice2);
    	rdoPanel.add(rdoQ1Choice3);
    	
    	//add the panels to the main panel
    	panel.add(qLabel);
    	panel.add(rdoPanel);
    	panel.add(lblIcon1);
    		
    	//return the panel
    	return panel;
    }//end buildQ1Panel
    
    public JPanel buildQ2Panel(){
    	//set the panel to null
    	JPanel panel = null;
    	
    	//create components panels
    	JPanel rdoPanel = new JPanel();
    	
    	//create a new panel
    	panel = new JPanel();
    	
    	//create radio buttons
    	rdoQ2Choice1 = new JRadioButton("Black",false);
    	rdoQ2Choice2 = new JRadioButton("Blue",false);
    	rdoQ2Choice3 = new JRadioButton("Green",false);
   		
   		//add item listeners 
    	rdoQ2Choice1.addItemListener(this);
    	rdoQ2Choice2.addItemListener(this);
    	rdoQ2Choice3.addItemListener(this);

    	//create the button group 
    	group2 = new ButtonGroup();
    	
    	//add the buttons to the group
   		group2.add(rdoQ2Choice1);
    	group2.add(rdoQ2Choice2);
    	group2.add(rdoQ2Choice3);
    	
    	//create the labels
    	qLabel = new JLabel("What is your favourite colour?");
    	lblIcon2 = new JLabel();
    	
    	//add the radio buttons to the panel
    	rdoPanel.add(rdoQ2Choice1);
    	rdoPanel.add(rdoQ2Choice2);
    	rdoPanel.add(rdoQ2Choice3);
    	
    	//add the panels to the main panel
    	panel.add(qLabel);
    	panel.add(rdoPanel);
    	panel.add(lblIcon2);
    		
    	//return the panel
    	return panel;
    }//end buildQ2Panel
    
    public JPanel buildQ3Panel(){
    	//set the panel to null
    	JPanel panel = null;
    	
    	//create components panels
    	JPanel rdoPanel = new JPanel();
    	
    	//create a new panel
    	panel = new JPanel();
    	
    	//create radio buttons
    	rdoQ3Choice1 = new JRadioButton("Ireland",false);
    	rdoQ3Choice2 = new JRadioButton("England",false);
    	rdoQ3Choice3 = new JRadioButton("USA",false);
   		
   		//add item listeners 
    	rdoQ3Choice1.addItemListener(this);
    	rdoQ3Choice2.addItemListener(this);
    	rdoQ3Choice3.addItemListener(this);

    	//create the button group 
    	group3 = new ButtonGroup();
    	
    	//add the buttons to the group
   		group3.add(rdoQ3Choice1);
    	group3.add(rdoQ3Choice2);
    	group3.add(rdoQ3Choice3);
    	
    	//create the labels
    	qLabel = new JLabel("What is your favourite Country?");
    	lblIcon3 = new JLabel();
    	
    	//add the radio buttons to the panel
    	rdoPanel.add(rdoQ3Choice1);
    	rdoPanel.add(rdoQ3Choice2);
    	rdoPanel.add(rdoQ3Choice3);
    	
    	//add the panels to the main panel
    	panel.add(qLabel);
    	panel.add(rdoPanel);
    	panel.add(lblIcon3);

    	//return the panel
    	return panel;
    }//end buildQ3Panel
    
    public JPanel buildResultPanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a new panel
    	panel = new JPanel();
    	//create the labels
    	JLabel label = new JLabel("Answers To Questions");
    	lblResult1 = new JLabel();
    	lblResult2 = new JLabel();
    	lblResult3 = new JLabel();
    	
    	//create & set the font
    	Font lblFont = new Font( "Serif", Font.BOLD, 18 );
    	label.setFont(lblFont);
    	
    	//set the layout of the panel
    	panel.setLayout(new GridLayout(4,1));
    	
    	//add the labels to the panel
    	panel.add(label);
    	panel.add(lblResult1);
    	panel.add(lblResult2);
    	panel.add(lblResult3);
    	//return the panel
    	return panel;
    }//end buildResultPanel
    
     public JPanel buildButtonPanel(){
     	//set the panel to null
    	JPanel panel = null;
    	//create a new panel
    	panel = new JPanel();
    	JPanel btnNextPanel = new JPanel();
    	//create the button
    	btnNext = new JButton("Next Question");
    	btnNextPanel.add(btnNext);
    	
    	//add an action listener
    	btnNext.addActionListener(this);
    	//add the button panel to the panel
    	panel.add(btnNextPanel);
    	//return the panel
    	return panel;
     }//end BuildButtonPanel
    
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab6Part4();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
    	
}//end class