import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lab9Part4 extends JFrame implements ActionListener, ItemListener{
	
	Container contentPane = getContentPane();
	JButton btnEnter, btnSelect;
	JRadioButton radioButton1, radioButton2, radioButton3;
	JDialog dialog;
	//image icons
	ImageIcon zombieIcon = new ImageIcon("images/zombie.png");
	ImageIcon childIcon = new ImageIcon("images/child.png");
	ImageIcon dumpsterIcon = new ImageIcon("images/dumpster.png");
	ImageIcon policeIcon = new ImageIcon("images/police.png");	
	ImageIcon asylumIcon = new ImageIcon("images/asylum.png");
	ImageIcon leprechaunIcon = new ImageIcon("images/leprechaun.jpg");
	ImageIcon lepIcon = new ImageIcon("images/lep.png");
				
    public Lab9Part4() {
    	//set the title
    	super("Lab 9 Part 4");
    	//create a panel
    	JPanel panel = new JPanel();
    	btnEnter = new JButton("Start Adventure");
    	//add a action
    	btnEnter.addActionListener(this);
    	//add the button to the panel
    	panel.add(btnEnter);
    	
    	//add the panel to the contentPane
    	contentPane.add(panel);
    
		//set the size & visibility
		setSize(300,100);
		setVisible(true);
    }//end constructor
    
    public JDialog buildJdialog(){
    	//create a jdialog
    	dialog = new JDialog();
    	//set the title
    	dialog.setTitle("Choose a Door");
    	//create a label & image label
		JLabel label = new JLabel(new ImageIcon("images/doors.png"));
		JLabel label1 = new JLabel("Choose a door?");
		
		//create a panel
		JPanel panel = new JPanel();
		//add a label to the panel
		panel.add(label);
		//create 3 radio buttons
		radioButton1 = new JRadioButton("Door 1");
		radioButton2 = new JRadioButton("Door 2");
		radioButton3 = new JRadioButton("Door 3");
		//add listeners to the radio buttons
		radioButton1.addItemListener(this);
		radioButton2.addItemListener(this);
		radioButton3.addItemListener(this);
		//creat a button group
		ButtonGroup group = new ButtonGroup();
		//add the radio buttons to the group
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		//add the label to the panel
       	panel.add(label1);
       	//add the radio buttons to the panel
		panel.add(radioButton1);
		panel.add(radioButton2);
		panel.add(radioButton3);	
		//add the dialog to the panel	
		dialog.add(panel);
		//pack the dialog
		dialog.pack();
		//set the size & visibility
		dialog.setVisible(true);
		dialog.setSize(400,400);
		//return the dialog
		return dialog;
    }//end buildJdialog method
    
    public void buildDoor1(){
    	//create an array of objects
    	Object[] options = {"Run away", "Hide"};
        int n = JOptionPane.showOptionDialog(contentPane,
                        "After exiting the door, you see a group of zombies coming towards you do you Run or Hide?",
                        "Doorway 1 Zombies",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,zombieIcon,
                        options,
                        options[0]);
        if (n == JOptionPane.YES_OPTION){
            Object[] options2 = {"Help the child", "Carry on Running"};
            int n1 = JOptionPane.showOptionDialog(contentPane,
                            "As you are running you see a small child sitting on the ground do you stop to help them or carry on running?",
                            "Choose an option",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,childIcon,
                            options2,
                            options2[0]);
        	if (n1 == JOptionPane.YES_OPTION){
        		JOptionPane.showMessageDialog(contentPane,"As you approach the child she looks up at you, you can see blood around her \nmouth, and you try to run away but as you turn you trip,\nthe girl runs towards you and starts to eat you. The End.",
        			"Story End",JOptionPane.INFORMATION_MESSAGE);	
        	}//end if help child
        	else if (n1 == JOptionPane.NO_OPTION){
        		JOptionPane.showMessageDialog(contentPane,"As you are running you see a fire in the distance, so you run towards it as \nyou approach the fire you see a group of people with guns who says you are safe now and \nyou can join them in their quest to hunt down all zombies. The End. ",
        			"Story End",JOptionPane.INFORMATION_MESSAGE);
        	}//end else if (carry on running)                    
        } //end if (run away)
        
        else if (n == JOptionPane.NO_OPTION){
    	  	Object[] options3 = {"Exit Dumpster", "Stay Hiding"};
            int n2 = JOptionPane.showOptionDialog(contentPane,
                            "You see a dumpster so you jump in and hide. You can hear the zombies passing \nby as you are hiding. Two hours pass and you can’t hear the zombies \nany more but you hear a group of men calling out does anybody need \nassistance do you exit the dumpster or stay hiding?",
                            "Choose an option",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,dumpsterIcon,
                            options3,
                            options3[0]);
        	if (n2 == JOptionPane.YES_OPTION){
        		JOptionPane.showMessageDialog(contentPane,"The men grab hold of you and chain you up. They place you \nIn the back of their truck and take you to there base. When you get \nthere, you can see other people chained up with missing limbs. \nAs you look around you notice the bandits are eating human flesh. \nAs one of the men tries to adjust the chains to cut your arm off \nyou manage to overpower him and take his gun. You kill him and \nall of the other bandits and free the people who are chained up.\nThe End.",
        			"Story End",JOptionPane.INFORMATION_MESSAGE);	
        	}//end if exit dumpster
        	else if (n2 == JOptionPane.NO_OPTION){
        		JOptionPane.showMessageDialog(contentPane,"After a few minutes, you hear gunshots. Then the lid of the \ndumpster is opened by a woman who says you are safe \nnow and tells you those men shouting were cannibals and \nthat she has killed them. She says you can join her \ngroup and you set off for her camp. The End.",
        			"Story End",JOptionPane.INFORMATION_MESSAGE);
        	}//end else if saty hiding		
        }//else if (hide)
    }//end door1 method
    
    public void buildDoor2(){
    	Object[] options = {"Tell Police Man", "Carry on walking"};
        int n = JOptionPane.showOptionDialog(contentPane,
                        "As you enter door 2 you are transported back in time to 1906 you see a police man do you \ntell him you’re from the future or carry on walking past?",
                        "Doorway 2 Time Travel",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,policeIcon,
                        options,
                        options[0]);
    	if (n == JOptionPane.YES_OPTION){
        		JOptionPane.showMessageDialog(contentPane,"The police man thinks you’re mad and has you committed \nto a mental asylum. In the mental asylum, you receive \nelectroconvulsive therapy which makes you lose \nyour mind and you spend the rest of \nyour life in the asylum.",
        			"Story End",JOptionPane.INFORMATION_MESSAGE,asylumIcon);	
    	}//end if exit dumpster
    	else if (n == JOptionPane.NO_OPTION){
    		JOptionPane.showMessageDialog(contentPane,"You become one of the wealthiest men in the world by betting \non sporting events and investing in products you knew would do well.\nThe End",
    			"Story End",JOptionPane.INFORMATION_MESSAGE);
    	}//end else if stay hidden
    }//end door2 method
    
    public void buildDoor3(){
    	Object[] options = {"Drink Liquid", "Dont drink liquid"};
        int n = JOptionPane.showOptionDialog(contentPane,
                        "A leprechaun approaches and presents you with a bottle of liquid to drink. He say's you'll have \neternal youth if you drink it. Do you drink the liquid or not?",
                        "Doorway 3 Leprechaun",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,leprechaunIcon,
                        options,
                        options[0]);
    	if (n == JOptionPane.YES_OPTION){
        		JOptionPane.showMessageDialog(contentPane,"You start to feel a burning sensation and think that you have been poisoned,\nthe leprechaun tells you that it is normal and after a few minutes \nyou start to feel better than ever. As the years roll \nby you don’t age a day. The End.",
        			"Story End",JOptionPane.INFORMATION_MESSAGE);	
    	}//end if drink liquid
    	else if (n == JOptionPane.NO_OPTION){
    		JOptionPane.showMessageDialog(contentPane,"The leprechaun grabs you and tries to force you to dink the liquid. You manage\nto overpower him and make him drink it, he then begins to dissolve \ntill all that’s left of him is a pool of liquid on the ground. You then \nloot his belongs and find a bag of gold coins so you take \nthe bag and go on your way. The End.",
    			"Story End",JOptionPane.INFORMATION_MESSAGE,lepIcon);
    	}//end else if dont drink
    }//end door3 method
    
    //event handler method
    public void actionPerformed(ActionEvent e){
    	if (e.getSource() == btnEnter){
    		buildJdialog();
    	}//end if
    }//end handler
    
    //handle for radio button events
   	public void itemStateChanged(ItemEvent e){	
   		if (e.getSource() == radioButton1){
   			dialog.dispose();
   			buildDoor1();
   		}//end if
   		if(e.getSource() == radioButton2){
   			dialog.dispose();
   			buildDoor2();
   		}//end if
   		if(e.getSource() == radioButton3){
   			dialog.dispose();
   			buildDoor3();
   		}//end if
   	}//end item handler
   	
    public static void main(String args[]){
    	//create the frame
    	JFrame frame = new Lab9Part4();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end main method
}//end class