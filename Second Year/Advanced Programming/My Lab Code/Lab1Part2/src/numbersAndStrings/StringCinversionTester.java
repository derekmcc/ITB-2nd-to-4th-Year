package numbersAndStrings;
/**
 * This is a string to int convert and vice versa program
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class StringCinversionTester {
	/**
	 * Main method
	 * @param args The command line arguments if any
	 */
	public static void main(String args[]) {
		//variables
		String temp1, temp2;
		int temp3, temp4;
		
		//call and pass the values to the converter classes
		temp1 = numbersAndStrings.NumberToStringConvertor.convertToString(1);
		temp2 = numbersAndStrings.NumberToStringConvertor.convertToString(2);
		temp3 = numbersAndStrings.StringToNumberConvertor.convertToNumber("One");
		temp4 = numbersAndStrings.StringToNumberConvertor.convertToNumber("Three");
		
		//print the converted info
		System.out.println(temp1);
		System.out.println(temp2);
		System.out.println(temp3);
		System.out.println(temp4);
	}//end main method
}//end class
