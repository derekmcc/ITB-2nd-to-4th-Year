/**
 * This is the admin options class with the CRUD options
 */
package crud;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.MainMenu;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class AdminOptions extends JFrame implements ActionListener {
	
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	
	//global scope variables
	private String ID, password, Role;
	private float account;
	
	//global scope components
	JButton btnAdd, btnDelete, btnUpdate, btnCancel;
	
	/**
	 * This is the GUI constructor which gets passed the users credentials
	 * 
	 * @param ID String value of the users studentID
	 * @param password String value of the users password
	 * @param Role String value to keep track of the users role eg.(Admin or regular user)
	 * @param account Float value of the amount the user has in there account
	 */
	public AdminOptions(String ID, String password, String Role, Float account) {
		//set the title of the frame
		super("Admin Options");
		
		//assign the value from the passed variables to the global scope variables 
		this.ID = ID;
		this.password = password;
		this.Role = Role;
		this.account = account;
		
		//create the panels to hold the components
		JPanel btnPanel = new JPanel();
		JPanel panel = new JPanel();
		JPanel wrapper = new JPanel();
		
		//create the buttons 
		btnAdd = new JButton("Add Game");
		btnDelete = new JButton("Delete Game");
		btnUpdate = new JButton("Update Game");
		btnCancel = new JButton("Cancel");
		
		//add the listeners to the buttons
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		
		//set the layout of the panel
		btnPanel.setLayout(new GridLayout(3, 1, 5, 10));
		
		//add the buttons to the panels
		btnPanel.add(btnAdd);
		btnPanel.add(btnDelete);
		btnPanel.add(btnUpdate);
		panel.add(btnCancel);
		
		//set the layout and add the buttonPanel to the wrapper
		wrapper.setLayout(new GridBagLayout());
		wrapper.add(btnPanel);
		
		//create container contentPane
		Container contentPane = getContentPane();
		
		//set the layout and add the panels to the contentPane
		contentPane.setLayout(new BorderLayout());
		contentPane.add(wrapper, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.PAGE_END);
		
		//set the size, visibility, resizability & position of the frame
		setSize(300,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}//end main method

	/**
	 * Action performed method to handle users responses 
	 * 
	 * @param e Action event variable to listen for action events
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//if the user clicks the add button 
		if (e.getSource() == btnAdd) {
			//close this class and open the add game class
			this.dispose();
			new AddGame(ID, password, Role, account);
		}//end if 
		//else if the users clicks the delete button
		else if (e.getSource() == btnDelete) {
			//close this class and open the delete game class
			this.dispose();
			new DeleteGame(ID, password, Role, account);
		}//end else if
		//else if the user clicks the update button
		else if (e.getSource() == btnUpdate) {
			//close this class and open the update game class
			this.dispose();
			new UpdateGame(ID, password, Role, account);
		}//end else if
		//else if the user clicks the cancel button
		else if (e.getSource() == btnCancel) {
			//close this class and open the main menu class
			this.dispose();
			new MainMenu(ID, password, Role, account);
		}//end else if
	}//end actionPerformed
}//end class
