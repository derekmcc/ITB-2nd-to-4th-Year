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
 * @version 1.0
 */
public class GUIWithAnonymousInnerClass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//JButton btn1; 
	//JLabel lbl1;
	
	public GUIWithAnonymousInnerClass() {
		super("Anonymous Inner Class");
		JButton btn1 = new JButton("Button");
		JLabel lbl1 = new JLabel("Hello");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(lbl1,"North");
		panel.add(btn1,"South");
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setText("Outer class label set by inner class " + GUIWithAnonymousInnerClass.class.getName());
				//lbl1.setText("Outer class label set by inner class " + getClass().getName());
			}//end actionPerformed
		});
		 
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
		JFrame frame = new GUIWithAnonymousInnerClass();
	}//end main method
}//end class
