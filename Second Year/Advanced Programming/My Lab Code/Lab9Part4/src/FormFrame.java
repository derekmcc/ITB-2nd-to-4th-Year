import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FormFrame extends JFrame {
	
	RegisterPanel rp;

	public FormFrame() {
		super("FormFrame");
		rp = new RegisterPanel();
		setSize(400,200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//end constructor
	
	class RegisterPanel extends JPanel {
		
		JTextField txt1;
		
		public RegisterPanel(){
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			JPanel wrapper = new JPanel();
			JLabel lbl1 = new JLabel("Enter Name: ");
			txt1 = new JTextField(10);
			JButton btnSubmit = new JButton("Submit");
			
			btnSubmit.addActionListener(new SubmitResponder());
			
			panel1.setLayout(new GridLayout(1, 2));
			panel1.add(lbl1);
			panel1.add(txt1);
			panel2.add(btnSubmit);
			panel3.setLayout(new BorderLayout());
			panel3.add(panel1, BorderLayout.NORTH);
			panel3.add(panel2, BorderLayout.SOUTH);
			wrapper.setLayout(new GridBagLayout());
			wrapper.add(panel3);
			getContentPane().add(wrapper);
		}//end constructor
	
		public void overWriteTextField(String s) {
			txt1.setText(s);
			txt1.setEnabled(false);
		}//end over WriteTextField method
	}//end inner class
	
	class SubmitResponder implements ActionListener {	
		@Override
		public void actionPerformed(ActionEvent e) {
			FormFrame.this.rp.overWriteTextField("Submit Completed");
			FormFrame.this.setTitle("Submit Completed!!!");
		}//end actionPerformed method
	}//end inner class
	
	public static void main(String[] args) {
		JFrame frame = new FormFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method
}//end class
