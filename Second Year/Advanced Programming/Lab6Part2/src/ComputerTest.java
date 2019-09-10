/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class ComputerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create the computer objects
		Computer comp1 = new Computer(3.6,16,23.6);
		Computer comp2 = new Computer(4.8,8,15.6);
		Computer comp3 = new Computer(4.9,16,21);
		
		//print the computer details
		System.out.println("Computer 1's Details" + comp1.toString());
		System.out.println("Computer 2's Details" + comp2.toString());
		System.out.println("Computer 3's Details" + comp3.toString());
	}//end main method
}//end class
