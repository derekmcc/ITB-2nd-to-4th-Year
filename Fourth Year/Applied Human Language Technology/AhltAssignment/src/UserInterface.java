import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;


/**
 * A parser for regular expressions 
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class UserInterface extends JFrame implements ActionListener{

	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;

	//global scope components
	JPanel northPanel = buildNorthPanel(), centerPanel = buildCenterPanel(), southPanel = buildSouthPanel(), wrapper;
	JLabel jlParseString;
	JLabel jlInput;
	//static JLabel jlBrackets;//////---REMOVE
	JButton btnParse;
	JTextField jtfInput;
	Container contentPane = getContentPane();
	static JTextArea jtBrackets;
	TokenizeUserInput tui;
	BracketedPhrasalStructurBuilder bracketedStructur;
	
	/*
	 * Default constructor to create GUI
	 */
	public UserInterface () {
		//set the title of the frame
		super("Regular Expressions Parser");
		
		//create the wrapper object to hold the panels
		wrapper = new JPanel();
		//set the layout of the wrapper object (panel)
		wrapper.setLayout(new BorderLayout());
		//create a internal wrapper
		JPanel wrapper1 = new JPanel();
		//add the panels to the wrapper setting the layout to borderLayout
		wrapper1.add(northPanel);
		wrapper1.add(centerPanel);
		wrapper.add(wrapper1, BorderLayout.NORTH);
		wrapper.add(southPanel, BorderLayout.CENTER);
		
		//add the wrapper to the contentPane
		contentPane.add(wrapper);
		
		//set the size & visibility
    	setSize(900,600);
    	setVisible(true);
    	setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * Panel to hold the text field and label
	 * @return Panel
	 */
	public JPanel buildNorthPanel() {
		//create the panel object
		JPanel panel = null;
		panel = new JPanel();
		
		//create a font object
		Font lblFont = new Font(("SansSerif"), Font.BOLD,26); 
		Font font = new Font(("SansSerif"), Font.PLAIN,18); 
		//instantiate the panel components
		jlInput = new JLabel("Enter Sentence");
		jtfInput = new JTextField(35);
		jtfInput.setPreferredSize(new Dimension(120, 50));
		//set the font of the label
		jlInput.setFont(lblFont);
		jtfInput.setFont(font);
		//add the components to the panel
		panel.add(jlInput);
		panel.add(jtfInput);
		
		//return the panel
		return panel;
	}//end buildNorthPanel method
	
	/**
	 * Panel to hold the button
	 * @return Panel
	 */
	public JPanel buildCenterPanel() {
		//create the panel object
		JPanel panel = null;
		panel = new JPanel();
		
		//create a font object
		Font btnFont = new Font(("SansSerif"), Font.BOLD,22); 
		
		//instantiate the panel components
		btnParse = new JButton("Parse");
		btnParse.setPreferredSize(new Dimension(120, 50));
		
		//set the font of the button
		btnParse.setFont(btnFont);
		
		//add an action listener to the button
		btnParse.addActionListener(this);
		
		//add the button to the panel
		panel.add(btnParse);
		
		//return the panel
		return panel;
	}//end buildSouthPanel method
	
	/**
	 * Panel to hold the parse string label
	 * @return
	 */
	public JPanel buildSouthPanel() {
		//create the panel object
		JPanel panel = null;
		panel = new JPanel();
		
		//create a font object
		Font parseFont = new Font(("SansSerif"), Font.BOLD,30); 
		Font bracketFont = new Font(("SansSerif"), Font.BOLD,22);
		Font textAreaFont = new Font(("SansSerif"), Font.PLAIN,22);
		
		
		//instantiate the panel components
		jlParseString = new JLabel("");
		jtBrackets = new JTextArea();
		jlParseString.setFont(parseFont);
		jtBrackets.setFont(textAreaFont);
		
		//set the size and edit(True/False) of the text area
		jtBrackets.setPreferredSize(new Dimension(800, 300)); 
		jtBrackets.setEditable(false);
		
		//set the layout of the panel
		panel.setLayout(new GridLayout(2,1));
		
		//add the label to the panel
		panel.add(jlParseString);
		panel.add(jtBrackets);
		
		//return the panel
		return panel;
	}//end buildSouthPanel method
	
	/*
	 * Action Listener to respond to button clicks
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//check if the user entered some text
		if (!jtfInput.getText().matches("")) {
			//add the users inputed sentence to a string variable placeholder
			String tempInput = jtfInput.getText().toLowerCase();
			//create tokens from the user sentence
			StringTokenizer st1 = new StringTokenizer(tempInput);
			//create an array to hold each individula word from the sentence
			ArrayList<String> usersWords = new ArrayList<String>();
			//loop to add the the word to the array list
			while(st1.hasMoreTokens()) {
				//add the words to the arry list
				usersWords.add(st1.nextToken());
			}//end while
			
			//create tokens from the user sentence 
			StringTokenizer st2 = new StringTokenizer(tempInput);
			//instantiate the tokenize user input class passing the token and the words
			tui = new TokenizeUserInput(st2, usersWords);
			//check if the users sentence is valid
			if (tui.checkRegularExpresion()) {
				//display label saying the sentence is valid
				jlParseString.setText("Acceptable Regular Expression: True");
				bracketedStructur = new BracketedPhrasalStructurBuilder(tui.getAddTagsToWords());
			}//end if 
			else {
				jlParseString.setText("Acceptable Regular Expression: False");
				MaxentTagger mTagger = new MaxentTagger("models/english-left3words-distsim.tagger");
				String tempTagger = mTagger.tagString(tempInput);
				//need to clear text area for jar 
				jtBrackets.setText("");
				jtBrackets.setText(tempTagger);
			}//end else
		}//end if
		//else if the user did'nt enter any text
		else {
			//display error message
			JOptionPane.showMessageDialog(this,"Error, Input can not be empty!!", "ERROR" ,JOptionPane.ERROR_MESSAGE);
		}//end else
	}//end ActionPerformed method
}//end class
