import java.io.File;
import java.io.IOException;

/**
 * This is a program to reverse a string and open a file
 * Using IOException and NullPointerException to catch any exceptions.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class TestDeclaringExceptions {
	/**
	 * Main Method 
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		
		//to print name in reverse
		reverseString("Derek");
		
		/**
		 * Uncomment to see null pointer exception
		 * to cause null pointer exception
		 */
		//reverseString(null);
		
		/**
		 * The openFile method required a try catch because IOException is a 
		 * checked exception which means you either need to catch it, or declare
		 * that your method will throw it.
		 */
		try {
			openFile("Derek");
		} catch (IOException e) {
			System.out.println("Could not open file");
			e.printStackTrace();
		}//end catch
	}//end main method
	
	/**
	 * Method to reverse and print a string
	 * @param s String to pass name to be reversed
	 * @throws NullPointerException To Throw exception
	 */
	public static void reverseString(String s) throws NullPointerException {
		String reverse = "";
		for(int i = s.length()-1; i>=0; i--){
		    reverse = reverse + s.charAt(i);
		}//end for
		System.out.println(reverse+"\n");
	}//end reverseString method
	
	/**
	 * Method to open a file
	 * @param fileName String to pass file name to open  
	 * @throws IOException To throw exception
	 */
	public static void openFile(String fileName) throws IOException {
		File file = new File(fileName);
		//check if file exists
		if(file.exists() == false){
			throw new IOException();
		}//end if
		else{
			System.out.println("File Opening....");
		}//end if
	}//end openFile method
}//end class
