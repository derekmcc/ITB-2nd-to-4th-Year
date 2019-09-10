/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class Computer extends ElectronicDevice {
	
	private double speed, memory, screenSize;
	
	public Computer(String manufacturer, double speed, double memory, double screenSize) {
		super(manufacturer);
		this.speed = speed;
		this.memory = memory;
		this.screenSize = screenSize;
	}//end constructor

	public double getMemory() {
		return memory;
	}//end getMemory

	public void setMemory(double memory) {
		this.memory = memory;
	}//end setMemory

	public double getSpeed() {
		return speed;
	}//end getSpeed

	public void setSpeed(double speed) {
		this.speed = speed;
	}//end setSpeed

	public double getScreenSize() {
		return screenSize;
	}//end getScreenSize

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}//end setScreenSize
	
	public String toString(){
		return super.toString() + "\nSpeed: " + speed + "Ghz\nMemory: " + memory + "GB\nScreenSize: " + screenSize + " Inches\n";
	}//end toString method
}//end class
