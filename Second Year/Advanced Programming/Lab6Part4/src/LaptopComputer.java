
/**
 * @author Derek McCarthy B00007439
 * @version
 */
public class LaptopComputer extends Computer {
	
	private double batteryLife;

	public LaptopComputer(String manufacturer, double speed, double memory, double screenSize, double batteryLife) {
		super(manufacturer, speed,memory,screenSize);
		this.batteryLife = batteryLife;
	}//end constructor
	
	public double getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(double batteryLife) {
		this.batteryLife = batteryLife;
	}
	
	public String toString(){
		return super.toString() + "Battery Life: " + batteryLife + " Hours\n";
	}//end toString metod
}//end class