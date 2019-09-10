import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class MyAlbum extends JFrame implements ActionListener {

	JLabel lbl1;
	JTextArea txt1;
	JButton btnForward;
	ImageIcon icon;
	AlbumItemList itemList;
	Vector<AlbumItem>itemClassList;
	int index = 0;
	JPanel lblPanel;
	
	public MyAlbum() {
		super("My Album");
		
		itemList = new AlbumItemList();
		
		AlbumItem a1 = new FavouriteAnimal();
		AlbumItem a2 = new FavouriteFootballTeam();
		AlbumItem a3 = new FavouriteMovie();
		AlbumItem a4 = new FavouriteSport();
		AlbumItem a5 = new FavouriteSubject();
		AlbumItem a6 = new FavouriteTvShow();
			
		
		itemList.addItemList(a1);
		itemList.addItemList(a2);
		itemList.addItemList(a3);
		itemList.addItemList(a4);
		itemList.addItemList(a5);
		itemList.addItemList(a6);
		
		//create a vector of the vehicleList
		itemClassList = itemList.<AlbumItem>getItemList();
	
		icon = new ImageIcon(a1.getImage());
		lbl1 = new JLabel();
		lbl1.setIcon(icon);
		txt1 = new JTextArea(10,23);
		txt1.setText(a1.getFacts());
		btnForward = new JButton("Forward");
		btnForward.addActionListener(this);

		lblPanel = new JPanel();
		JPanel txtPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		JPanel wrapper = new JPanel();
		
		lblPanel.add(lbl1);
		txtPanel.add(txt1);
		btnPanel.add(btnForward);
		wrapper.setLayout(new BorderLayout());
		wrapper.add(lblPanel, "North");
		wrapper.add(txtPanel, "Center");
		wrapper.add(btnPanel, "South");
		
		getContentPane().add(wrapper);
		setSize(400,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}//end constructor

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new MyAlbum();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}//end main method
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (index < itemClassList.size()) {
			AlbumItem iItem = (AlbumItem)itemClassList.<AlbumItem>elementAt(index);
			icon = new ImageIcon(iItem.getImage());
			lbl1.setIcon(icon);
			txt1.setText(iItem.getFacts());
			index++;	
		}//end if
		else {
			index = 0;
		}//end else
	}//end actionPerformed
}//end class
