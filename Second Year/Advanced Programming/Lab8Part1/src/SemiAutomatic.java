
/**
 * @author Derek McCarthy B00007439
 *
 */
public class SemiAutomatic implements Gun {
	
	protected int damage, numBullets;
	private String serialNumber;
	protected String weight;
	
	public SemiAutomatic(String serialNumber, int numBullets, int damage, String weight) {
		this.serialNumber = serialNumber;
		this.damage = damage;
		this.numBullets = numBullets;
		this.weight = weight;
	}
	
	public String getReloadInstructions() {
		String desc = "Reload for " + this.getClass().getName();	
		String step1 = "Remove magazine";
		String step2 = "Pop bullets into magazine";
		String step3 = "Replace magazine";	
		return desc + "\n" + step1 + "\n" + step2 + "\n" + step3;
	}

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
