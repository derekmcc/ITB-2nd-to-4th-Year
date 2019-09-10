import java.net.URL;
import java.util.Vector;


/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class AlbumItemList {

	@SuppressWarnings("rawtypes")
	private Vector itemList = new Vector(); 
	
	public AlbumItemList() {
		itemList = new Vector();
	}
	
	public void addItemList(AlbumItem items) {
		itemList.add(items);
	}
	
	public Vector getItemList() {
		return itemList;
	}

}
