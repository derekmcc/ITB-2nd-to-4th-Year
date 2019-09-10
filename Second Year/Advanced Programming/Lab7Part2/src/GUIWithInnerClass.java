import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Derek McCarthy B00007439
 *
 */
public class GUIWithInnerClass extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JButton btn1; 
	JLabel lbl1;
	
	public GUIWithInnerClass(){
		super("Inner Class");
		btn1 = new JButton("Button");
		lbl1 = new JLabel("Hello");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(lbl1,"North");
		panel.add(btn1,"South");
		btn1.addActionListener(new ButtonResponder());
		
		Container contentPane = getContentPane();
		contentPane.add(panel);
		
		setVisible(true);
		setSize(400,300);
		//setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		JFrame frame = new GUIWithInnerClass();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method
	
	class ButtonResponder implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//To print correct name
			//lbl1.setText("Outer class label set by inner class " + ButtonResponder.class.getName());
			
			lbl1.setText("Outer class label set by inner class " + ButtonResponder.class.getSimpleName());
		}//end actionPerformed method
	}//end class
}//end class
