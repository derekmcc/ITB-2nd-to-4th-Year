import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class FavouriteSubject extends AlbumItem {

	private String favSubject, favLanguage;
	private String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	private String imageFileName = "prog.png";
	
	public FavouriteSubject() {
		this.favSubject = "Programming";
		this.favLanguage = "Java";
	}//end constructor
	
	public URL getImage() {
		try {
			imageURL = new URL(imageFilePath + "" + imageFileName);
		} catch(MalformedURLException e) {
			JOptionPane.showMessageDialog(null,"Could not find file");
		}//end catch
		return imageURL;
	}//end getImage
	
	public String getFacts(){
		return "Favourite Subject: " + favSubject + "\nFavourite Programming Language: " + favLanguage;
	}//end getFacts
}//end class
