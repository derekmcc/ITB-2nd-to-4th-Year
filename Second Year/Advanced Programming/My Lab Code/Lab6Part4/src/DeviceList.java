import java.util.Vector;

public class DeviceList {

	@SuppressWarnings("rawtypes")
	private Vector deviceList = new Vector(); 
	
	public DeviceList() {
		deviceList = new Vector();
	}
	
	public void addDeviceList(ElectronicDevice device) {
		deviceList.add(device);
	}
	
	public Vector getDeviceList() {
		return deviceList;
	}

}