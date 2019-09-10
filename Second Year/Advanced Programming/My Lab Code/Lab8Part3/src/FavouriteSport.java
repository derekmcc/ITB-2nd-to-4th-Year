import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class FavouriteSport extends AlbumItem {
	
	private String mainScoreType, originOfSport, favSport;
	private String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	private String imageFileName = "football.png";
	
	public FavouriteSport() {
		this.favSport = "Football";
		this.mainScoreType = "Goal";
		this.originOfSport = "England";
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
		return "Favourite Sport: " + favSport + "\nMain Score Type: " + mainScoreType + "\nOrigin of Sport: " + originOfSport;
	}//end getFacts
}//end constructor
