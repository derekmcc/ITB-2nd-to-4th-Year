import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class FavouriteMovie extends AlbumItem {

	private	String movie, about;
	private String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	private String imageFileName = "jw.png";
	
	public FavouriteMovie() {
		this.movie = "John Wick";
		this.about = "An ex-hitman comes out of \nretirement to track down the gangsters \nthat took everything from him.";
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
		return "Favourite Movie: " + movie + "\nAbout: " + about;
	}//end getFacts
}//end class
