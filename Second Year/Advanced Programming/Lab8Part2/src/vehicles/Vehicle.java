/**
 * 
 */
package vehicles;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class Vehicle {
	
	protected int wheels;
	protected double engineSize;
	protected String make;

	public String getMake() {
		return make;
	}//end getMake

	public int getWheels() {
		return wheels;
	}//end getWheels


	public double getEngineSize() {
		return engineSize;
	}//end getEngineSize	
	
	public String toString(){
		return "\nMake: " + make + "\nEngine Size: " + engineSize + "\nNumber of Wheels: " + wheels;
	}//end toString method
}//end class
