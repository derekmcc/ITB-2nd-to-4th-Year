package application;
/**
 * This is a program to get the power of a number by another number
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class Application {
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main (String args[]){
		
		//call the method and display the results 
		int result = mathematics.MathHelper.multiplyNums(16, 2);
		System.out.println("16 to the power of 2 = " + result); 
	}//end main method
}//end class
