import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */

public class FullTranslationGUI extends JFrame implements ActionListener, ItemListener{
	ResourceBundle res;
	//String cboTags[] = {res.getString("btn1"),"frenchTag"};
	Locale locales []  = Calendar.getAvailableLocales();
	JTextArea txt1 = new JTextArea(15,15);
	Locale locEnglish = new Locale("en","EN");
	Locale locFrench = new Locale("fr","FR");
	Locale locale;
	JButton btnLocale;
	JComboBox<String> cbo1 = new JComboBox<String>();
	DefaultComboBoxModel model; 
	JPanel panel1;
	
	boolean flag = false;
	
	public FullTranslationGUI() {
		super("Lab4Part4");
		
		res = res.getBundle("ProgramResources",locEnglish);

		btnLocale = new JButton(res.getString("btn1"));
		
		cbo1.addItem(res.getString("englishTag"));
		cbo1.addItem(res.getString("frenchTag"));
		cbo1.addItemListener(this);

		JScrollPane txtPane = new JScrollPane(txt1);
		panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		btnLocale.addActionListener(this);
		panel1.setLayout(new BorderLayout());
		panel1.add(cbo1,BorderLayout.NORTH);
		panel1.add(txtPane,BorderLayout.CENTER);
		panel1.add(btnLocale,BorderLayout.SOUTH);
		
		Container contentPane = getContentPane();
		contentPane.add(panel1);
		flag = false;
		
		//set the size & visibility
		setSize(300,300);
		setVisible(true);
	}//end constructor


	public void setLocale(Locale lo){
		locale = lo;
	}//end setLocale
	
	public static void main(String[] args) {
		JFrame frame = new FullTranslationGUI();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//end main method

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnText = btnLocale.getText();
		if(e.getActionCommand().equals(res.getString("btn1"))){
            for(int i=0; i<locales.length; i++){
            	if(btnText.equals("List All Locales")){
            		txt1.append(locales[i].getDisplayName(locEnglish)+"\n");
            	}
            	else{
            		txt1.append(locales[i].getDisplayName(locFrench)+"\n");
            	}
            }//end for    
        }//end if	
	}//actionPerformed

	@Override
	public void itemStateChanged(ItemEvent e) {
		String selectedItem = (String)cbo1.getSelectedItem();
		
		if(e.getItem().equals(res.getString("englishTag"))){
			flag = false;
			res = res.getBundle("ProgramResources",locEnglish);
			btnLocale.setText(res.getString("btn1"));
			panel1.remove(cbo1);
			cbo1 = new JComboBox<String>();
			cbo1.addItem(res.getString("englishTag"));
			cbo1.addItem(res.getString("frenchTag"));
			cbo1.validate();
			cbo1.addItemListener(this);
			txt1.setText("");
			panel1.add(cbo1,BorderLayout.NORTH);
		}//end if
		else if (e.getItem().equals(res.getString("frenchTag"))){
			flag = true;
			res = res.getBundle("ProgramResources",locFrench);
			btnLocale.setText(res.getString("btn1"));
			panel1.remove(cbo1);
			cbo1 = new JComboBox<String>();
			cbo1.addItem(res.getString("frenchTag"));
			cbo1.addItem(res.getString("englishTag"));
			cbo1.validate();
			cbo1.addItemListener(this);
			panel1.add(cbo1,BorderLayout.NORTH);	
		}//end else if
	}//end method
}//end class
