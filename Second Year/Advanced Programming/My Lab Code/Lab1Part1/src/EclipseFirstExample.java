
/**
 * This is a program to call and print your favourite subject
 * @author Derek McCarthy B00007439
 * @version 1.0 
 */
public class EclipseFirstExample {
	/**
	 * Main Main method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		// call and print greeting
		printFavouriteSubject("Programming");
	}//end main method
	
	/**
	 * Print the Favourite Subject  
	 * @param str A string To hold favourite subject
	 */
	public static void printFavouriteSubject(String str){
		// print the greeting
		System.out.print("Your favourite subject is " + str);
	}//end method
}//end class