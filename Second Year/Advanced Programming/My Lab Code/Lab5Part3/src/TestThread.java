/**
 * This is a program to print out an array using a synchronised block
 * @author Derek McCarthy B00007439
 * @version 1.3
 */
public class TestThread {
	
	//Array to hold letters
	static String letters[] = {"A", "B","C"};
	
	/**
	 * Main Method of the program
	 * @param args For the arguments if theirs any
	 */
	public static void main(String args[]){
		TestThread obj = new TestThread(); 
		ThreadWithExtends t1=new ThreadWithExtends(obj); 
		t1.start();
	}//end main method
	
	/**
	 * Method to print array using threads and synchronised block
	 */
	void printArray(){
		//synchronised block to put a lock on the threads
		synchronized (this) {
			//loop to go through array
			for(int i=0;i<letters.length;i++){
				//print the letter
				System.out.println(letters[i]);
				//try & catch block
				try{
					//put the thread to sleep
					Thread.sleep(400);
				}catch(Exception e){
					e.printStackTrace();
				}//end catch
			}//end for
		}//end synchronised block
	}//end print array method
}//end class