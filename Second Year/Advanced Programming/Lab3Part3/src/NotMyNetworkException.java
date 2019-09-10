/**
 * This is the custom exception class, which will throw an exception if called.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class NotMyNetworkException extends Exception{
	//serial version
	private static final long serialVersionUID = 1L;
	
	public NotMyNetworkException(String message) {
		super(message);
	}
}//end class
