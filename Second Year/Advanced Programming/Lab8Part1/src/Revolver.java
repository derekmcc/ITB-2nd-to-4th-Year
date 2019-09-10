public class Revolver implements Gun {
	
	protected int numBullets, damage;
	protected String weight, serialNumber;
	
	public Revolver(String serialNumber, int numBullets, int damage, String weight){
		this.serialNumber = serialNumber;
		this.numBullets = numBullets;
		this.damage = damage;
		this.weight = weight;
	}//end constructor

	public String getReloadInstructions() {	
		String desc = "Reload for " + this.getClass().getName();	
		String step1 =  "Pop open the chamber and load bullets";
		String step2 = "Pop the revolving chamber back in place";	
		return desc + "\n" + step1 + "\n" + step2;
	}//end reload instructions

	@Override
	public int getNumBullets() {
		return numBullets;
	}
	
	public void setNumBullets(int numBullets) {
		this.numBullets = numBullets;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getWeight() {
		return "Weight: " + weight;
	}

	@Override
	public String getSerialNumber() {
		return "\t"+this.getClass().getName()+" Information\nSerial Number: " + serialNumber;
	}
}

