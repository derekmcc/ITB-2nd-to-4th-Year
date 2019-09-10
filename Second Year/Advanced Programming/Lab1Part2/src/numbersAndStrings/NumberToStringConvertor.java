package numbersAndStrings;
/**
 * This is an int to string covertor class
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class NumberToStringConvertor {
	
	/**
	 * @param num To convert the int value to a string
	 * @return string Of the converted number
	 */
	public static String convertToString(int num){
		/**
		 * if statements to convert int to string & return
		 */
		if (num == 1){
			return "One";
		}//end if
		else if (num == 2){
			return "Two";
		}//end else if
		else{
			return "Three";
		}//end else if		
	}//end method
}//end class
