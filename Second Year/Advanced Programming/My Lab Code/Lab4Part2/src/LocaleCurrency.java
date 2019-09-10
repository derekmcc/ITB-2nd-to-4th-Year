import java.text.NumberFormat;
/**
 * This class prints the price of milk for a specific locale
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class LocaleCurrency {
	
	/**
	 * This method prints the price of milk for the specific locale's
	 * @param x The currency format of the locale 
	 * @param milk The price of milk
	 */
	public static void getCurrency(NumberFormat x, double milk) {
		System.out.println(x.format(milk));	
	}//end method	
}//end class
