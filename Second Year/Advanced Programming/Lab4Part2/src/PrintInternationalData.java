import java.text.NumberFormat;
import java.util.*;

/**
 * This is a program that uses localisation to get date, days of the week and the price
 * of a pint of milk in England, Spain and Holland
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class PrintInternationalData {
	
	/**
	 * Main Method
	 * @param args The command line arguments if any
	 */
	public static void main(String[] args) {
		//crete the locale objects
		Locale englishLocale = new Locale("en","EN");
		Locale spanishLocale = new Locale("es","ES");
		Locale dutchLocale = new Locale("nl","BE");
		
		//set the price of milk
		double milk = 2.50;
		
		//get the currency for the locale's
		NumberFormat englishCurrency = NumberFormat.getCurrencyInstance(englishLocale);
		NumberFormat spanishCurrency = NumberFormat.getCurrencyInstance(spanishLocale);
		NumberFormat dutchCurrency = NumberFormat.getCurrencyInstance(dutchLocale);
		
		//get the spanish info
		LocaleDateLong.getDate(spanishLocale);
		LocaleCurrency.getCurrency(spanishCurrency,milk);
		LocaleDaysOfWeek.getDays(spanishLocale);
		
		//get the english info
		LocaleDateLong.getDate(englishLocale);
		LocaleCurrency.getCurrency(englishCurrency,milk);
		LocaleDaysOfWeek.getDays(englishLocale);
		
		//get the dutch info
		LocaleDateLong.getDate(dutchLocale);
		LocaleCurrency.getCurrency(dutchCurrency,milk);
		LocaleDaysOfWeek.getDays(dutchLocale);
	}//end main method
}//end class
