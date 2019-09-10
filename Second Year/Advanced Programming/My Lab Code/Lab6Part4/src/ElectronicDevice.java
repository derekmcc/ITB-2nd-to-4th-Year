
public abstract class ElectronicDevice {
	
	protected String manufacturer;
	
	public ElectronicDevice(String manufacturer){
		this.manufacturer = manufacturer;
	}//end constructor
	
	public String getManufacture() {
		return manufacturer;
	}//end getManufacture

	public String toString(){
		return "Manufacture: " + manufacturer;
	}//end toString method
}//end class
