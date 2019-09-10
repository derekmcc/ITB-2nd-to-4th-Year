import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTranslator extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;
	ResourceBundle res;
	JButton btn1, btn2, btn3, btnTranslate;
	Locale locEnglish = new Locale("en","EN");
	Locale locFrench = new Locale("fr","FR");
	int count = 0;
  
	public ButtonTranslator() {
		super("Translator");
		res = res.getBundle("resources.ProgramResource",locFrench); 		
    
		btn1 = new JButton(res.getString("btn1"));
	    btn2 = new JButton(res.getString("btn2"));
	  	btn3 = new JButton(res.getString("btn3"));
	    btnTranslate = new JButton("Translate To French");
	    btnTranslate.addActionListener(this);
		    
	    //create the panels
		JPanel translatePanel = new JPanel();
		JPanel outPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		//set the layout of the panels
		btnPanel.setLayout(new GridLayout(3,1));
		outPanel.setLayout(new GridBagLayout());
		
		//add the 'Translated' buttons to the panel 
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		
		//add the translate button to the panel
		translatePanel.add(btnTranslate);
		
		//add the inner panels to the outer panel
		outPanel.add(btnPanel);
		outPanel.add(translatePanel);
	
		//add the panels to the content pane
		Container contentPane = getContentPane();
		contentPane.add(outPanel);
		setSize(300,300);
	    setVisible(true);
	}//end constructor

	public static void main(String[] args) {
		ButtonTranslator frame = new ButtonTranslator();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end  main

	@Override
	public void actionPerformed(ActionEvent e) {
		if (count == 0){
			res = res.getBundle("resources.ProgramResource",locEnglish);
			if (btn1.getText().equals("One") && btn2.getText().equals("Two") && btn3.getText().equals("Three")){
				btn1.setText(res.getString("translateTo1"));
				btn2.setText(res.getString("translateTo2"));
				btn3.setText(res.getString("translateTo3"));
			}//end if
			btnTranslate.setText("Traduire en Anglais");
			count++;
		}//end if
		else{
			res = res.getBundle("resources.ProgramResource",locFrench); 
			if (btn1.getText().equals("Un") && btn2.getText().equals("Deux") && btn3.getText().equals("Trois")){
				btn1.setText(res.getString("btn1"));
				btn2.setText(res.getString("btn2"));
				btn3.setText(res.getString("btn3"));
			}//end if
			btnTranslate.setText("Translate To French");
			count--;
		}//end else
	}//end actionPerformed
}//end class
