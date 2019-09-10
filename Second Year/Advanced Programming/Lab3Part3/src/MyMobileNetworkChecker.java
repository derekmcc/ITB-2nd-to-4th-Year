/**
 * This is a class to check if the mobile network entered is vodafone if its not
 * it will throw a custom exception 'NotMyNetworkException'.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class MyMobileNetworkChecker {
	
	/**
	 * Method to check if the 
	 * @param inputNetwork Of type string for the passed network
	 * @throws NotMyNetworkException Throw exception
	 */
	public static void checkMyMobileNetwork(String inputNetwork) throws NotMyNetworkException{
		/**
		 * If the passed network matches vodafone, Display network confirmed 
		 * Else throw exception
		 */
		if (inputNetwork.toLowerCase().matches("vodafone")){
			System.out.println("Mobile Phone Network Confirmed");
		}//end if
		//else if the network is not vodafone
		else{
			//print error message 
			System.err.println("Unknown Network");
			//throw the exception
			throw new NotMyNetworkException(inputNetwork);
		}//end else
	}//end method checkMyMobileNetworkChecker method
}//end class
