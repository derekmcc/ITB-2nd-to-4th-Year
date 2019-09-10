import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * This class prints the date the program was created
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class LocaleDateLong {
	
	/**
	 * This method receives a locale and prints the date the program was created 
	 * @param a The locale to be passed to the method
	 */
	public static void getDate(Locale a){
		Date currentDate = new Date(117, 1, 2);
		final DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.LONG, a);
		final String format = dateInstance.format(currentDate);
		System.out.println(format);
	}//end method
}//end class
