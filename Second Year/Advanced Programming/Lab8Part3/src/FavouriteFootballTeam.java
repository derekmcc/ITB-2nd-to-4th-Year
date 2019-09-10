import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class FavouriteFootballTeam extends AlbumItem {
	
	private String teamName, favPlayer;
	private String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	private String imageFileName = "manUtd.png";
	
	public FavouriteFootballTeam() {
		this.teamName = "Manchester United";
		this.favPlayer = "Ibrahimovic";
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
		return "Favourite Football Team: " + teamName + "\nFavourite Player: " + favPlayer;
	}//end getFacts
}//end class
