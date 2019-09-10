/**
 * 
 */
package vehicles;

/**
 * @author Derek McCarthy B00007439
 *
 */
public class Motorcycle extends Vehicle{
	
	private String type;
	private String colour;
	private int horsePower;
	
	/**
	 * 
	 */
	public Motorcycle(String make, double engineSize, int wheels, String type, String colour,int horsePower) {
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.type = type;
		this.colour = colour;
		this.horsePower = horsePower;			
	}//end constructor
	
	public Motorcycle(String make, double engineSize, int wheels, int horsePower) {
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.horsePower = horsePower;
	}//end constructor
	
	public Motorcycle(String make, double engineSize, int wheels, String type) {
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.type = type;
	}//end constructor
	
	public Motorcycle(String make, double engineSize, int wheels, String colour, int horsePower) {
		this.make = make;
		this.engineSize = engineSize;
		this.wheels = wheels;
		this.colour = colour;
		this.horsePower = horsePower;
	}//end constructor
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	public String toString(){
		if (getColour() == null && getType() == null){
			return super.toString() + "\nHorse Power: " + horsePower;
		}//end if
		else if (getColour() == null && getHorsePower() == 0){
			return super.toString() + "\nType: " + type;
		}//end else if
		else if (getType() == null){
			return super.toString() + "\nColour: " + colour + "\nHorse Power: " + horsePower;
		}//end else if
		return super.toString() + "\nType: " + type + "\nColour: " + colour + "\nHorse Power: " + horsePower;
	}//end toString method
}//end class
