/**
 * 
 */
package vehicleRun;

import java.util.Vector;

import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;
import vehicles.VehicleList;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class VehicleTest {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create and instantiate the objects
		VehicleList vehicleList = new VehicleList();
		//Vehicle v1 = new Vehicle();
		Vehicle vehicle1 = new Car("Ford", 1.8, 4,4,18.7,"Hatchback");
		Vehicle vehicle2 = new Car("BMW", 3.5, 4, "Saloon");
		Vehicle vehicle3 = new Car("Renault", 1.1, 4, 15.2);
		Vehicle vehicle4 = new Car("Toyota", 1.6, 4, 4);
		Vehicle vehicle5 = new Car("Mercedes", 3.0, 4,4,26.7,"Saloon");
		Vehicle vehicle6 = new Motorcycle("Honda", 450, 2, "Off Road", "Black", 26);
		Vehicle vehicle7 = new Motorcycle("BMW", 550, 2, 26);
		Vehicle vehicle8 = new Motorcycle("Harley Davidson", 350, 2, "Road");
		Vehicle vehicle9 = new Motorcycle("Kawasaki", 500, 3, "White", 36);
		Vehicle vehicle10 = new Motorcycle("Yamaha", 550, 2, "Off Road", "Green", 34);
		
		//add the objects to the vehicleList
		vehicleList.addVehicleList(vehicle1);
		vehicleList.addVehicleList(vehicle2);
		vehicleList.addVehicleList(vehicle3);
		vehicleList.addVehicleList(vehicle4);
		vehicleList.addVehicleList(vehicle5);
		vehicleList.addVehicleList(vehicle6);
		vehicleList.addVehicleList(vehicle7);
		vehicleList.addVehicleList(vehicle8);
		vehicleList.addVehicleList(vehicle9);
		vehicleList.addVehicleList(vehicle10);
		
		//create a vector of the vehicleList
		Vector<Vehicle>vehicleClassList = vehicleList.<Vehicle>getVehicleList();
		
		//loop through vector and print its contents
		for(int i = 0; i < vehicleClassList.size(); i++) {
			Vehicle vVehicle = (Vehicle)vehicleClassList.<Vehicle>elementAt(i);
			System.out.println("\tVehicle: " + (i+1) + vVehicle.toString() + "\n");
		}//end for
	}//end main method
}//end class
