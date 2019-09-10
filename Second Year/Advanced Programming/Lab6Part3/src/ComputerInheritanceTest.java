/**
 * 
 */

/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class ComputerInheritanceTest {
	
	public static void main(String ars[]){
		//computer objects
		Computer comp1 = new Computer(3.6,16,23.6);
		Computer comp2 = new Computer(4.8,8,15.6);
		
		//laptop objects
		Computer comp3 = new LaptopComputer(2.9,4,19.6, 8.30);
		Computer comp4 = new LaptopComputer(5.9,6,14.6, 6);
		
		//print computer objects
		System.out.println("Computer 1's Details" + comp1.toString() + "\n");
		System.out.println("Computer 2's Details" + comp2.toString() + "\n");
		
		//print laptop objects
		System.out.println("Laptop 1's Details" + comp3.toString());
		System.out.println("Laptop 2's Details" + comp4.toString());
	}//end main method
}//end class
