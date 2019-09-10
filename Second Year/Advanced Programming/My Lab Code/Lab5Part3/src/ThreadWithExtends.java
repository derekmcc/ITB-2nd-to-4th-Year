/**
 * This is the thread class
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class ThreadWithExtends extends Thread{
	
	//create an object of the TestThread Class 't'
	TestThread t;
	
	/**
	 * 
	 * @param t An object of the TestThread class
	 */
	public ThreadWithExtends(TestThread t){
		this.t=t;
	}
	
	/**
	 * Method to run threads
	 */
	public void run(){
		//loop to run threads
		for (int i=1;i<5;i++){
			//call the printArrray method in the TestThread class
			t.printArray();
		}//end for
	}//end run method	
}//end class
