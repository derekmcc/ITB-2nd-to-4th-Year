/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public abstract class HandHeldDevice extends ElectronicDevice {
	
	protected double weight;
	
	public HandHeldDevice(String manufacturer, double weight){
		super(manufacturer);
		this.weight = weight;
	}//end constructor
	
	public double getWeight() {
		return weight;
	}//end getWeight
		
	public String toString(){
		return super.toString() + "\nWeight: " + weight + " kg";
	}//end toString
}//end class
