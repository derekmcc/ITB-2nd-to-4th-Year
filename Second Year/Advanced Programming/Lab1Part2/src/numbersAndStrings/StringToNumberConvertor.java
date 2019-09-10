package numbersAndStrings;
/**
 * This is an int to String convertor class
 * @author Derek McCarthy B00007439
 * version 1.0
 */
public class StringToNumberConvertor {
	/**
	 * 
	 * @param str To convert from string to int
	 * @return int Value of the converted string
	 */
	public static int convertToNumber (String str){
		if (str.matches("One")){
			return 1;
		}//end if
		else if (str.matches("Two")){
			return 2;
		}//end else if
		else{
			return 3;
		}//end else
	}//end convertToNumber method
}//end class
