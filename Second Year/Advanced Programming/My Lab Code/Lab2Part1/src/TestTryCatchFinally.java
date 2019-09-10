/**
 * This is a program that deliberately causes a NumberFormatException.
 * By trying to convert a string to an integer.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class TestTryCatchFinally {
	
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		//start try
		try {
			String str = "Hi";
			int num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			System.out.println("\n\t\tThis is the Finally Block Calling\nDerek McCarthy");
		}//end finally
	}//end main method
}//end class
