
/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class LaptopComputer extends Computer {

	private double batteryLife;

	public LaptopComputer(double speed, double memory, double screenSize, double batteryLife) {
		super(speed,memory,screenSize);
		this.batteryLife = batteryLife;
	}//end constructor

	public String toString(){
		return super.toString() + "\nBattery Life: " + batteryLife + " Hours\n";
	}//end toString method
}
