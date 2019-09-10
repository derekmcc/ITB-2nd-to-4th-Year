import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 *
 */
public abstract class AlbumItem {
	protected URL imageURL;
	protected String facts;

	//protected String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	public AlbumItem() {
		// TODO Auto-generated constructor stub
	}
	/*
	public URL getImage(String imageFileName){
		try {
			imageURL = new URL(imageFilePath + "" + imageFileName);
		} catch(MalformedURLException e) {
			JOptionPane.showMessageDialog(null,"Could not find file");
		}//end catch
		return imageURL;
	}//end getImage
	
	public String getFacts(){
		return "";
	}//end getFacts
	*/
	
	public URL getImage() {
		return imageURL;
	}
	public void setImageURL(URL imageURL) {
		this.imageURL = imageURL;
	}
	public String getFacts() {
		return facts;
	}

	public void setFacts(String facts) {
		this.facts = facts;
	}
}//end class
