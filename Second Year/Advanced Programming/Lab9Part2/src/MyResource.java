import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class MyResource extends JFrame implements ActionListener {
	
	JLabel lbl1;
	JButton btn1, btn2 ,btn3;
	Locale locGerman = new Locale("de","DE");
	Locale locSpanish = new Locale("es","ES");
	Locale locItalian = new Locale("it","IT");
	ResourceBundle res; 
	Font font = new Font("Ariel", Font.BOLD, 16);
	public MyResource() {
		super("My Resource");
		
		lbl1 = new JLabel("Hello");
		lbl1.setFont(font);
		btn1 = new JButton("German");
		btn2 = new JButton("Italian");
		btn3 = new JButton("Spanish");
		
		JPanel btnPanel = new JPanel();
		JPanel panel = new JPanel();
		JPanel wrapper = new JPanel();
		
		btnPanel.setLayout(new GridLayout(1, 3));
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		panel.setLayout(new BorderLayout());
		panel.add(lbl1, BorderLayout.NORTH);
		panel.add(btnPanel, BorderLayout.SOUTH);
		wrapper.add(panel);
		getContentPane().add(wrapper);
		
		setVisible(true);
		setSize(300,100);
		setLocationRelativeTo(null);
		setResizable(false);
	}//end constructor
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			res = res.getBundle("ProgramResources",locGerman);
			lbl1.setText(res.getString("Hello"));
		}//end if
		else if (e.getSource() == btn2) {
			res = res.getBundle("ProgramResources",locItalian);
			lbl1.setText(res.getString("Hello"));
		}//end if
		else if (e.getSource() == btn3) {
			res = res.getBundle("ProgramResources",locSpanish);
			lbl1.setText(res.getString("Hello"));
		}//end if
	}//end actionPerformed method
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new MyResource();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method
}//end class
