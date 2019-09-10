/**
 * @author Derek McCarthy B00007439
 *
 */
public class TestThread {

	//array of numbers
	static int numbers[] = {1,2,3};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//loop through array
		for (int i=0;i<numbers.length;i++){
			(new Thread(new ThreadWithRunnable(numbers[i]))).start();
		}//end for 
	}//end method
}//end class
