import java.util.Vector;

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class GunTest {

	public static void main(String[] args) {
		
		Vector gunList = new Vector();
		
		Gun gun1 = new Revolver("A1235452",6, 6, "Light");
		Gun gun2 = new SemiAutomatic("A12345678", 12, 6, "Light");
		Gun gun3 = new Cannon("A523578",1, 10, "Extremely Heavy");

		gunList.addElement(gun1);
		gunList.addElement(gun2);
		gunList.addElement(gun3);
		
		for(int i=0; i < gunList.size(); i++) {
			Gun currentGun = (Gun)gunList.elementAt(i);
			System.out.println(currentGun.getSerialNumber());
			System.out.println(currentGun.getReloadInstructions());
			System.out.println("Number of Bullets: "+currentGun.getNumBullets());
			System.out.println("Damage out of 10: "+currentGun.getDamage());
			System.out.println(currentGun.getWeight()+ "\n");
		}//end for 
	}//end main method
}//end class
