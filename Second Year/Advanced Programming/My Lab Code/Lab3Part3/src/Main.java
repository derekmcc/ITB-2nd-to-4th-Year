/**
 * This is the running class of the program
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class Main {
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		
		/**
		 * Try pass the mobile phone network name to the MyMobileNetworkChecker class.
		 * If its matches the confirmed network name a message will appear confirming this, 
		 * if it does'nt match the network name a custom exception will be thrown.
		 */
		try {
			//To confirm network
			MyMobileNetworkChecker.checkMyMobileNetwork("Vodafone");
			//To throw exception
			MyMobileNetworkChecker.checkMyMobileNetwork("Three");
		} catch (NotMyNetworkException e) {
			//print the stack trace
			e.printStackTrace();
		}//end catch
	}//end main method
}//end class
