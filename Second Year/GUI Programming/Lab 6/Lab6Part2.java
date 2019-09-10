import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lab6Part2 extends JFrame implements ActionListener{
	//global array
	String destinations[] = {"Dublin","London","New York"}; 
		
	//global components
	JButton btnCbo, btnList = new JButton();
	JList<String>listDestination = new JList<String>(destinations);
	JComboBox<String>cboDestination = new JComboBox<String>(destinations);
	JPanel cboPanel=buildCboPanel(), listPanel=buildListPanel(), btnPanel=buildButtonPanel(), layoutPanel = new JPanel();
	
    public Lab6Part2() {
    	//set the title of the frame
    	super("Card Layout");
    	
    	//content pane
    	Container contentPane = getContentPane();
    	
    	//set the card layout of the layoutPanel
    	layoutPanel.setLayout(new CardLayout());
    	
    	//add the components to the layoutPanel
    	layoutPanel.add(cboPanel,"comboBox");
    	layoutPanel.add(listPanel,"list");
    	
    	//add the panels to the content pane
    	contentPane.add(layoutPanel, BorderLayout.NORTH);
    	contentPane.add(btnPanel);
    	
    	//set the size & visibility
    	setSize(300,300);
    	setVisible(true);
    }//end constructor
    
    public JPanel buildCboPanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a new panel
    	panel = new JPanel();
    	
    	//add combobox to the panel
    	panel.add(cboDestination);
    	//return the panel
    	return panel;
    }//end combobox method
    
    public JPanel buildListPanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a new panel
    	panel = new JPanel();
    	//add the list to the panel
    	panel.add(listDestination);
    	//return the panel
    	return panel;
    }//end combobox method
    
    public JPanel buildButtonPanel(){
    	//set the panel to null
    	JPanel panel = null;
    	//create a new panel
    	panel = new JPanel();
    	
    	//create the buttons
    	btnCbo = new JButton("ComboBox");
    	btnList = new JButton("J-List");
    	
    	//add the action listeners
    	btnCbo.addActionListener(this);
    	btnList.addActionListener(this);
    	//add the components to the panel
    	panel.add(btnCbo);
    	panel.add(btnList);
    	//return the panel
    	return panel;
    }//end buton panel method
    
    public void actionPerformed(ActionEvent e){
    	//Get the card layout from the main panel
		CardLayout card = (CardLayout)layoutPanel.getLayout();
		if (e.getSource() == btnCbo){
			//Move to combobox panel card in the card layout
			card.show(layoutPanel,"list");
			//Move to the next card in the card layout
			card.next(layoutPanel);
		}//end if
		else if (e.getSource() == btnList){
			//Move to combobox panel card in the card layout
			card.show(layoutPanel,"comboBox");
			//Move to the next card in the card layout
			card.next(layoutPanel);
		}//end if
    }//end handler method
    
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab6Part2();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class