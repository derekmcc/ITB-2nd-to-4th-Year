
public class ThreadWithRunnable implements Runnable{
	
	int nums;
	
	public ThreadWithRunnable(int numbers) {
		nums = numbers;
	}//end constructor

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			 System.out.println(nums);
			 
			 try{ 
				//waits 1 second
				Thread.sleep((long)(Math.random() * 1000));
			 } catch (InterruptedException e) {	 
			 }//end catch
		 }//end for	
	}//end run
}//end class
