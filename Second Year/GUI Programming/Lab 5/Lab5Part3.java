import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab5Part3 extends JFrame implements ActionListener{
	
	//global variables
	JMenuItem sNewsItem, lNewsItem, weatherItem;
	JPanel panel, headlinePanel, imagePanel, txtPanel;
	Container contentPane;
	JLabel lblHeadline,lblImageIcon, lblSnewsIcon, lblHeadlineIcon, lblWeatherIcon;
	JTextArea txtArea;
	ImageIcon sNewsIcon, lNewsIcon, weatherIcon;
	Font headline = new Font("Serif", Font.BOLD, 40);
	Font paragraph = new Font("Font", Font.ROMAN_BASELINE, 18);
	JScrollPane pane;
		
    public Lab5Part3() {
    	//set the title
    	super("Ireland News");
    	
    	//create the menu bar and sub menus
    	JMenuBar mb = new JMenuBar(); 
    	JMenu newsMenu = new JMenu("News",false);
    	newsMenu.add(sNewsItem = new JMenuItem("Sports News"));
    	newsMenu.add(lNewsItem = new JMenuItem("Local News"));
    	newsMenu.add(weatherItem = new JMenuItem("Weather"));	
    	mb.add(newsMenu);	
    	setJMenuBar(mb);
    	
    	//add the mnemonics
    	sNewsItem.setMnemonic('S');
    	lNewsItem.setMnemonic('L');
    	weatherItem.setMnemonic('W');
    	
    	//add the acclerator keys for menu items
    	sNewsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
    	lNewsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D , ActionEvent.CTRL_MASK));
    	weatherItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
    	
    	//add the action listeners
    	lNewsItem.addActionListener(this);
    	sNewsItem.addActionListener(this);
    	weatherItem.addActionListener(this);
    	
		//create the label for the headlines	
    	lblHeadline = new JLabel();

    	//create the panel
    	panel = new JPanel();
    	headlinePanel = new JPanel();
    	imagePanel = new JPanel();
    	txtPanel = new JPanel();
    	txtArea = new JTextArea(22,60);
    	lblImageIcon = new JLabel();	 
		txtArea.setFont(paragraph);
		lblHeadline.setFont(headline);
		
		//wrap the text from the text area	
    	txtArea.setLineWrap(true);
    	txtArea.setWrapStyleWord(true);
    	
    	//create the scroll pane
    	pane = new JScrollPane(txtArea);
    	pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	txtPanel.add(pane);
    	
    	//set the layput
    	panel.add(headlinePanel,BorderLayout.PAGE_START);
    	panel.add(imagePanel,BorderLayout.CENTER);
    	panel.add(txtPanel,BorderLayout.SOUTH);
    	txtPanel.setVisible(false);
    	
    	//create the contentPane
    	contentPane = getContentPane();
    	contentPane.add(panel);
    	
    	//set the size and visibility
    	setSize(900, 1000);
		setVisible(true);	
    }//end constructor
    
    public void actionPerformed(ActionEvent e){
    	
    	//if the user selects local news
    	if (e.getSource() == lNewsItem){
    		//create and add the image icon to the label
    		lNewsIcon = new ImageIcon("samsung1.png");
    		lblImageIcon.setIcon(lNewsIcon);
    		
    		//set the text for the headline
    		lblHeadline.setText("US bans Samsung Galaxy Note 7 on all flights");
	    	headlinePanel.add(lblHeadline);
	    	
	    	//add the image label to the image panel
	    	imagePanel.add(lblImageIcon);
	    	
	    	//set the text of the text area
	    	txtArea.setText("In the wake of Samsung's global recall of the Galaxy Note 7, the US has now banned the"+
	    		 "device on all aircraft,even if its turned off. Previously, the Federal Aviation Administration"+ 
	    		 "(FAA) only issued a warning to have passengers keep the phones powered down during flights."+ 
	    		 "But now, Bloomberg reports, you can't bring it on the plane at all. This follows recent news that"+ 
	    		 "Samsung has ended the production and sales of the Note 7 entirely due to smoke and fire incidents,"+
	    		 "which happened even to replacement handsets. It's not entirely clear when the phone would be taken"+
	    		 "away from you -- whether it'd be during the security screening or when you're onboard the"+
				 "plane -- but if you haven't already returned it, you should at least do so before your next flight.");
			
			//set the visibility to true	 
	    	setVisible(true);
    	}//end if
    	
    	else if (e.getSource() == sNewsItem){
    		//create and add the image icon to the label
    		sNewsIcon = new ImageIcon("manU.jpg");
    		lblImageIcon.setIcon(sNewsIcon);
    		
    		//set the text for the headline
    		lblHeadline.setText("Man United facing one BIG selection dilemma");
	    	headlinePanel.add(lblHeadline);
	    	
	    	//add the image label to the image panel
	    	imagePanel.add(lblImageIcon);
	    	
	    	//set the text of the text area
	    	txtArea.setText("Jose Mourinho won’t need reminding of what can happen when you get your team selection wrong."+
	    		 "He picked half-fit Jesse Lingard and Henrikh Mkhitaryan to start against Manchester City last month."+ 
	    		 "And by the time he had a chance to rectify his mistake, Manchester United were already 2-1 down and"+ 
	    		 "Pep Guardiola was in control of their first meeting in the Premier League."+ 
	    		 "Mourinho might have got away with it against one of the league’s middling sides. But not against City."+ 
	    		 "The same is true of all big games, of which Liverpool at Anfield is one. They are decided by fine margins."+
	    		 "Lingard is likely to start against Liverpool, although this time he should be fully fit. Mkhitaryan,"+
	    		 "who hasn’t featured since his derby disaster, is back from injury but may have to settle for a place"+
				 "on the bench.");
				 
			//set the visibility to true	 
			setVisible(true);
    	}//end else if
    	
    	else if (e.getSource() == weatherItem){
    		//create and add the image icon to the label
    		weatherIcon = new ImageIcon("weather.jpg");
    		lblImageIcon.setIcon(weatherIcon);
    		
    		//set the text for the headline
    		lblHeadline.setText("Rain warning in place with thunderstorms");
	    	headlinePanel.add(lblHeadline);
	    	
	    	//add the image label to the image panel
	    	imagePanel.add(lblImageIcon);
	    	
	    	//set the text of the text area
	    	txtArea.setText("Met Eireann have issued a status yellow rain warning ahead of a wet weekend across"+
	    		 "the country. Connacht and Leinster will get the worst of the morning rain with Munster"+ 
	    		 "avoiding the early rain. Most of the country will have dry spells during the afternoon"+ 
	    		 "but showers will dominate again this evening. A Met Eireann forecaster said Mainly "+ 
	    		 "dry and bright over Munster and Ulster this morning, but heavy rain over Connacht and"+
	    		 "Leinster with isolated thunderstorms.");
	    	
	    	//set the visibility to true	 
	    	setVisible(true);
    	}//end else if
    	
    	//show the text panel
    	txtPanel.setVisible(true);
    }//end event handler
    
    public static void main (String args[]){
    	//create the frame
    	JFrame frame = new Lab5Part3();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
}//end class