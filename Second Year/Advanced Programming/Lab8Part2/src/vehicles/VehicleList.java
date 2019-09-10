/**
 * 
 */
package vehicles;

import java.util.Vector;

/**
 * @author Derek McCarthy B00007439
 *
 */
public class VehicleList {

	@SuppressWarnings("rawtypes")
	private Vector vehicleList = new Vector(); 
	
	public VehicleList() {
		vehicleList = new Vector();
	}
	
	public void addVehicleList(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}
	
	public Vector getVehicleList() {
		return vehicleList;
	}

}
