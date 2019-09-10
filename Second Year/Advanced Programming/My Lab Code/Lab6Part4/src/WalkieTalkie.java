
public class WalkieTalkie extends HandHeldDevice {
	
	private double rangeInKm;
	
	public WalkieTalkie(String manufacturer, double weight, double rangeInKm) {
		super(manufacturer, weight);
		this.rangeInKm = rangeInKm;
	}//end constructor
	
	public double getRangeInKm() {
		return rangeInKm;
	}//end getMethod

	public void setRangeInKm(double rangeInKm) {
		this.rangeInKm = rangeInKm;
	}//end setMethod

	public String toString(){
		return super.toString() + "\nRang: " + rangeInKm + "km\n";
	}//end class
}//end class
