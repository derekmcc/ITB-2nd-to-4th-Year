
public class ThreadWithExtends extends Thread{

	public ThreadWithExtends (String str) {
		super(str);
	}//end constructor

	/**
	 * Method to run threads
	 */
	public void run(){
		 System.out.println(getName());	
		 try{
			sleep((long)(Math.random() * 1000));
		 } catch (InterruptedException e) {	 
		 }//end catch
	}//end run method
}//end class
