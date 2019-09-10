import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class FavouriteTvShow extends AlbumItem {

	private String favTv, about;
	private String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	private String imageFileName = "bb.png";
	
	public FavouriteTvShow() {
		this.favTv = "Breaking Bad";
		this.about = "A high school chemistry teacher diagnosed with \ninoperable lung cancer turns to manufacturing \nand selling methamphetamine in order to \nsecure his family's future.";
	}//end constructor
	
	public URL getImage(){
		try {
			imageURL = new URL(imageFilePath + "" + imageFileName);
		} catch(MalformedURLException e) {
			JOptionPane.showMessageDialog(null,"Could not find file");
		}//end catch
		return imageURL;
	}//end getImage
	
	public String getFacts(){
		return "Favourite TV Show: " + favTv + "\nAbout\n" + about;
	}//end getFacts
}//end class
