import java.text.DateFormatSymbols;
import java.util.Locale;
/**
 * This class prints the days of the week for the specific locale
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class LocaleDaysOfWeek {
	
	/**
	 * This method receives the locale and prints the days of the week for this locale
	 * @param a The locale to be passed to the method
	 */
	public static void getDays(Locale a){
		DateFormatSymbols dfs = new DateFormatSymbols(a);
		//string array to hold the days of the week
		String dayNames[] = dfs.getWeekdays(); 
		// Set calendar days
	    for (int i=0; i<7; i++){
	    	//print the days
	    	System.out.println(dayNames[i+1]);
	    }//end for
	    //print a new line
	    System.out.println();
	}//end method
}//end class
