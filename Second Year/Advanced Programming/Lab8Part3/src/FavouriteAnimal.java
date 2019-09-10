import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class FavouriteAnimal extends AlbumItem {
	
	private String animalType, animalName;
	private String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	private String imageFileName = "horse.jpg";
	
	public FavouriteAnimal() {
		this.animalType = "Horse";
		this.animalName = "Buck";
	}//end constructor
	
	public String getFacts(){
		return "Fvourite Animal: " + animalType + "\nAnimal Name: " + animalName;
	}//end getFacts
	
	public String getImages(){
		return imageFileName;
	}//end getFacts
	
	//public URL getImage(){
		//return super.getImage(imageFileName);
	//}//end getImage
	///////////////////////////////////////////////////////////////////////////////////////////////
	public URL getImage(){
		try {
			imageURL = new URL(imageFilePath + "" + imageFileName);
		} catch(MalformedURLException e) {
			JOptionPane.showMessageDialog(null,"Could not find file");
		}//end catch
		return imageURL;
	}//end getImage
	
}//end class
