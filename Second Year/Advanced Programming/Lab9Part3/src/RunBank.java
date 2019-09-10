
public class RunBank {

	public static void main(String[] args) {
		BankTransaction bt = null;
		for(int i = 0; i<1000; i++){
			bt = new BankTransaction();
			bt.start();
		}//end for	
	}//end main method
}//end class
