/**
 * This is a program that cause 2 exceptions within a 
 * nested try catch block. 
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class nestedTryCatch {
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		 try {
		      System.out.println("Outter Try");
		      int array[] = {1,2,3};
	    	  System.out.println(array[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of Bounds Exception " + e);
			e.printStackTrace();
			try {
		    	  System.out.println("Inner Try\n");
		    	  int num = 4 % 0;   
		      } catch (ArithmeticException  ae) {
		    	  System.out.println("Inner Catch " + ae);
		    	  ae.printStackTrace();
		      }//end inner catch
		}//end outer catch
	}//end main method
}//end class
