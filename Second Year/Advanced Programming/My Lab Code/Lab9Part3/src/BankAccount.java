
/**
 * @author Derek McCarthy B00007439
 * @version 1.0
 */
public class BankAccount {

	private int balance;
	
	public BankAccount(int startingBalance) {
		balance = startingBalance;
	}//end constructor

	public int getBalance() {
		synchronized (this) {
			return balance;
		}//end synchronised
		
	}//end getBalance

	public void makeWithdrawl(int withdraw) {
		synchronized (this) {
			balance -= withdraw;
		}//end synchronised	
	}//end makeWithDrawl
}//end class
