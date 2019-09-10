
package com.mccarthy.util;

/**
 * This is the utility class which gets the sum and product of strings passed
 * and return them.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class StringUtility {
	
	/**
	 * @param s String to be passed
	 * @return sum The sum of the string passed in ascii
	 */
	public static int getSumOfAcsiiValues(String s) {
		//variables
		char c;
		int sum = 0;
		
		//loop to get the characters from the string
		for (int i=0; i < s.length(); i++){
			//assign the characters from the string to c (char)
			c = s.charAt(i);
			//get the integer value of the character
			int ascii = (int) c;
			//add the integer value to the sum
			sum += ascii;
		}//end for
		//return the sum
		return sum;
	}//end method
	
	/**
	 * 
	 * @param s String to be passed
	 * @return product The product of the string passed in ascii
	 */
	public static int getProductOfAsciiValues(String s) {
		//variables
		char c;
		int product = 0, temp = 0;
		//array to hold characters 
		int ascii[] = new int[s.length()];
		
		//loop to get the characters from the string
		for (int i=0; i < s.length(); i++){
			//assign the characters from the string to c (char)
			c = s.charAt(i);
			//get the integer value of the character
			ascii[i] = (int) c;
		}//end for
		
		//assign the first character in the array to a temp variable
		temp = ascii[0];
		//add the temp variable to the 
		product =temp;
		
		//loop to get the product
		for (int i=1;i<s.length();i++){
			//multiply the characters together to get the product
			product *= ascii[i];
		}//end for
		
		//return the product
		return product;
	}//end method
}//end class
