
package com.mccarthy.testUtil;
import com.mccarthy.util.*;
/**
 * This is the main method which passes a string and calls the utility class 
 * and get the sum and product of the passed string and prints the results.
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class TestStringUtility {

	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		//string to be passed
		String name = "test";
		int sum, product;
		
		//create an instance of the String Utility class
		StringUtility au = new StringUtility();
		//pass the string and return the sum and product 
		sum = au.getSumOfAcsiiValues(name);
		product = au.getProductOfAsciiValues(name);
		
		//display the results
		System.out.println("The sum of " + name + " is " + sum + " in ASCII");
		System.out.println("The product of " + name + " is " + product + " in ASCII");
	}//end main
}//end class
