/**
 * 
 */
package vehicles;

/**
 * @author Derek McCarthy B00007439
 *
 */
public class Car extends Vehicle {
	
	private int doors;
	private double luggageCapacity;
	private String bodyStyle;
	
	/**
	 * 
	 */
	public Car(String make, double engineSize, int wheels, int doors, double luggageCapacity, String bodyStyle) {
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.doors = doors;
		this.luggageCapacity = luggageCapacity;
		this.bodyStyle = bodyStyle;
	}//end constructor
	
	public Car(String make, double engineSize, int wheels, String bodyStyle) {
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.bodyStyle = bodyStyle;
	}//end constructor
	
	public Car(String make, double engineSize, int wheels, double luggageCapacity) {
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.luggageCapacity = luggageCapacity;
	}//end constructor
	
	public Car(String make, double engineSize, int wheels, int doors){
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.doors = doors;
	}//end constructor
		
	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public double getLuggageCapacity() {
		return luggageCapacity;
	}

	public void setLuggageCapacity(double luggageCapacity) {
		this.luggageCapacity = luggageCapacity;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}
	
	public String doorString(){
		return "\nNumber of Doors: " + getDoors();
	}//end string method
	
	public String luggageString(){
		return "\nLuggage Capacity: " + getLuggageCapacity() + " Liters";
	}//end string method
	
	public String bodyString(){
		return "\nBody Style: " + getBodyStyle();
	}//end string method
	
	public String toString(){
		if (getDoors() == 0 && getLuggageCapacity() == 0){
			return super.toString() + "\nBodyStyle: " + bodyStyle;
		}//end if
		else if (getDoors() == 0 && getBodyStyle() == null){
			return super.toString() + "\nLuggage Capacity: " + luggageCapacity;
		}//end else if
		else if (getLuggageCapacity() == 0 && getBodyStyle() == null){
			return super.toString() + "\nNumber of Doors: " + doors;
		}//end else if
		return super.toString() + "\nNumber of Doors: " + doors + "\nLuggage Capacity: " + luggageCapacity + "\nBodyStyle: " + bodyStyle;
	}//end toString method
}//end class
