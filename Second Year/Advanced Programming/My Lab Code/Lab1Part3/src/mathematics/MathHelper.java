package mathematics;
/**
 * This is a class that receives 2 integers x and y. Where x will 
 * be to the power of y.
 * @author Derek McCarthy B00007439
 * version 1.0
 */
public class MathHelper {
	/**
	 * @param x Is an int to be multiplied by itself y times
	 * @param y Is the power value
	 * @return int x to the power of y
	 */
	public static int multiplyNums(int x, int y){	 
		//loop to multiply x by itself y times
		for (int i=1;i<y;i++){
			x = x*x;
		}//end for
		return x;
	}//end method
}//end class
