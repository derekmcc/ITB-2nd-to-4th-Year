import javax.swing.*;
import java.awt.*;

public class Lab6Part1 extends JFrame{

   	public Lab6Part1() {
   		//set the title
   		super("Lab 6 Part 1");
   		
   		//create content pane & panels
   		Container contentPane = getContentPane();
   		JPanel panel = new JPanel();
   		JPanel panel1 = new JPanel();
   		JPanel panel2 = new JPanel();
   		
   		//create components
   		JButton btn1 = new JButton("Enter");
   		JButton btn2 = new JButton("Enter");
   		JLabel lbl1 = new JLabel("Name 1");
   		JLabel lbl2 = new JLabel("Name 2");
   		JTextField txt1 = new JTextField(10);
   		JTextField txt2 = new JTextField(10);
   		//set the layout of the panels
   		panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
   		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
   		
   		//add the components to panel 1
   		panel1.add(lbl1);
   		panel1.add(txt1);
   		panel1.add(btn1);
   		
   		//add the components to panel 2
   		panel2.add(lbl2);
   		panel2.add(txt2);
   		panel2.add(btn2);
   		
   		//set the layout of the panel
   		panel.setLayout(new BorderLayout());
   		
   		//add the panel to the main panel & set the layout
   		panel.add(panel2,BorderLayout.NORTH);
   		panel.add(panel1,BorderLayout.CENTER);
   		
   		//add the panels to the content pane
   		contentPane.add(panel);
   		
   		//set the size & visibility
   		setSize(300,300);
   		setVisible(true);
    }//end constructor
    
   	public static void main(String args[]){
   		//create the frame
   		JFrame frame = new Lab6Part1();
   		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   	}//end main method 
}//end class