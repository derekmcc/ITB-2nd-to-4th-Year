
/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class Computer {
	
	private double speed, memory, screenSize;

	public Computer(double speed, double memory, double screenSize) {
		this.speed = speed;
		this.memory = memory;
		this.screenSize = screenSize;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	
	public String toString(){
		return "\nSpeed: " + speed + "Ghz\nMemory: " + memory + "GB\nScreenSize: " + screenSize + " Inches";
	}//end toString method
}
