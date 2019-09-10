/**
 * This is a program that catches 3 types of exceptions, ArrayIdexOutOfBounds,
 * NullPointer exception and a general exception.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class TestMultipleCatches {
	
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {

		int array[] = {1,2,3,4,5}; 
		
		try {
			/**
			 *  1. ArrayIndexOutOfBoundsException
			 */
			for (int i=0;i<6;i++){
				array[i]++;
			}//end for 
			
			/**
			 *  2. NullPointerExecption
			 */
			String str = null;
			str.toString();
			
			/**
			 *  3. General Exception
			 */
			String s = "Hi";
			int num = Integer.parseInt(s);	
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of Bounds Error");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception Error");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception Error");
			e.printStackTrace();
		}//end catch
	}//end main method
}//end class
