/**
 * This is the login class used to take the users student ID and password and log the user into the system if
 * there credentials match those stored in the DB or else display error message if they don't.
 */
package gui;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dbController.LoginController;

/**
 * @author Derek McCarthy B00007439
 * @author Matthew Reilly  B00092951 
 * @author Christopher Slattery B00092939
 * @version 1.0
 */
public class Login extends JFrame implements ActionListener {
	//default serial
	private static final long serialVersionUID = 1L;
	
	//global scope variables & components
	public JButton btnExit, btnLogin;
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    public JTextField txtID; 
    public JPasswordField txtPassword;
    public JMenuItem menuHelp;

	/**
	 * Login constructor (GUI)
	 */
	public Login() {
		//title of the frame
		super("Login");
		 	
		//labels for components
		JLabel lblWelcome = new JLabel("Welcome, Please enter your student ID and Password");
		JLabel lblID = new JLabel("Student ID   ");
		JLabel lblPassword = new JLabel("Password   ");
		
		//create the menu & add the menu items
    	JMenuBar mb = new JMenuBar();
    	JMenu menu = new JMenu("Help");
    	menu.add(menuHelp = new JMenuItem("View Student ID's & Passwords"));
    	mb.add(menu);
    	setJMenuBar(mb);
    	menuHelp.addActionListener(this);
    	
		//text fields to take user inputs
		txtID = new JTextField(10);
		txtPassword = new JPasswordField(10);
		
		//buttons for user response
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		
		//panels to hold components
		JPanel txtPanel = new JPanel();
		JPanel lblPanel1 = new JPanel();
		JPanel lblPanel2 = new JPanel();
		JPanel btnPanel = new JPanel();
		JPanel conPanel = new JPanel();
		
		//set the layout of the panels
		txtPanel.setLayout(new GridLayout(2,1));
		lblPanel2.setLayout(new GridLayout(2,1));
		conPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		if (shouldFill){
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
		}//end if
		if (shouldWeightX){
            c.weightx = 0.5;
		}//end if
		
		//container for panels
		Container contentPane = getContentPane();
		
		//add components and set constraints to the panels
		lblPanel1.add(lblWelcome);
		lblPanel2.add(lblID);
		lblPanel2.add(lblPassword);
		txtPanel.add(txtID);
		txtPanel.add(txtPassword);
		btnPanel.add(btnLogin);
		btnPanel.add(btnExit);
		
		//add action listeners
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		
		//add constraints 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		conPanel.add(lblPanel2, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		conPanel.add(txtPanel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;     
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		conPanel.add(btnPanel, c);
		
		//position components centrally  
		contentPane.setLayout(new GridBagLayout());
		
		//add the panel(s) to the content pane
		contentPane.add(conPanel);
		
		//set the size, visibility, resizability & position of the frame
		setSize(300,250);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * Method to handle the users interaction from the listeners
	 * 
	 * @param e Event object
	 */
	public void actionPerformed(ActionEvent e) {
		//if the user clicks the login button
		if (e.getSource() == btnLogin) {
			//temp variables for ID & password
			String tempPsw, tempID;
			//assign the inputed text ID to the temp variable 'tempID' 
			tempID = txtID.getText();;
			//assign the inputed text password to the temp variable 'tempPsw' 
			tempPsw = String.valueOf(txtPassword.getPassword()); 
			
			//create an instance of the login class
			LoginController lg = new LoginController();
			
			/**
			 * Pass the ID & password to the userLogin method in the login controller class and
			 * return the boolean value true/false to the variable 'login'. 
			 */
			boolean login = lg.userLogin(tempID, tempPsw);
			//if login is true (the ID and password match those stored in the DB)
			if (login) {
				//close this class and call the main menu
				this.dispose();
				new MainMenu(lg.getStudentID(),lg.getStudentPassword(),lg.getUserRole(),lg.getStudentAccount());
			} else {
				//or else if the login is false (the ID and password don't match those stored in the DB), display error message
				JOptionPane.showMessageDialog(getContentPane(),
					    "StudentID or Password not found\nPlease Try Again", "Error",JOptionPane.ERROR_MESSAGE);
			}//end else
		}//end if
		
		//else if the user clicks the exit button
		else if (e.getSource() == btnExit) {
			//display message
			JOptionPane.showMessageDialog(getContentPane(),
				    "Thanks for using our system goodbye!", "Goodbye",JOptionPane.INFORMATION_MESSAGE);
			//close the program
			this.dispose();
		}//end else if
		
		//else if the user clicks the help button 
		else if(e.getSource() == menuHelp) {
			//call the help class to view users ID's and password's
			 new Help();
		}//end else if
	}//end actionPerformed method
}//end class
