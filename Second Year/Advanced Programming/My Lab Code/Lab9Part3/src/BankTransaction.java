
public class BankTransaction extends Thread {
	
	static BankAccount ba = new BankAccount(10000);
	
	@Override
	public void run() {
		synchronized(ba){
			ba.makeWithdrawl(10);
			System.out.println(getClass().getName());
			System.out.println("The current balance is: " + ba.getBalance());
		}//end synchronised
	}//end run method
}//end class
