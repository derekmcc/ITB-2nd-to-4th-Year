/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 *
 */
public class Cannon implements Gun {

	protected int damage, numBullets;
	protected String weight, serialNumber;
	
	public Cannon(String serialNumber, int numBullets, int damage, String weight) {
		this.serialNumber = serialNumber;
		this.damage = damage;
		this.numBullets = numBullets;
		this.weight = weight;
	}

	@Override
	public String getReloadInstructions() {
		String desc = "Reload for " + this.getClass().getName();	
		String step1 = "Place wading into the cannon";
		String step2 = "place cannon ball into cannon";	
		return desc + "\n" + step1 + "\n" + step2;
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
