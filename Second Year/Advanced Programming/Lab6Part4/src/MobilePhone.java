/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 *
 */
public class MobilePhone extends HandHeldDevice {

	private String networkName;
	
	public MobilePhone(String manufacturer, double weight, String networkName) {
		super(manufacturer, weight);
		this.networkName = networkName;
	}//end MobilePhone constructor

	public String getNetworkName() {
		return networkName;
	}//end getMethod

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}//end setMethod
	
	public String toString(){
		return super.toString() + "\nNetwork Name: " + networkName + "\n";
	}//end toSTring
}//end class
