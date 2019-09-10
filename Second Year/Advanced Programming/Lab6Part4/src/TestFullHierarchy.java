import java.util.Vector;
/**
 * 
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class TestFullHierarchy {

	public static void main(String[] args) {
		//create and instantiate the objects
		DeviceList deviceList = new DeviceList();
		ElectronicDevice dev1 = new Computer("Dell", 4.2, 16.2, 23.3);
		ElectronicDevice dev2 = new LaptopComputer("Apple", 3.2, 8, 13.3, 8);
		ElectronicDevice dev3 = new MobilePhone("Samsung", 0.5, "Vodafone");
		ElectronicDevice dev4 = new WalkieTalkie("Sony", 1, 67.5);
		
		//add the objects to the deviceList
		deviceList.addDeviceList(dev1);
		deviceList.addDeviceList(dev2);
		deviceList.addDeviceList(dev3);
		deviceList.addDeviceList(dev4);
		
		//create a vector of the deviceList
		Vector deviceClassList = deviceList.getDeviceList();
		
		//loop through vector and print its contents
		for(int i = 0; i < deviceClassList.size(); i++) {
			ElectronicDevice eDevice = (ElectronicDevice)deviceClassList.elementAt(i);
			System.out.println(eDevice.toString());
		}//end for
	}//end main method
}//end class
