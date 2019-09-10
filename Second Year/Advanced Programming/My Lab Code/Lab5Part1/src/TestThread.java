
public class TestThread {
	
	//array of letters
	static String letters[] = {"A","B","C"};
	
	public static void main(String[] args) {
		
		for (int x=0;x<4;x++){
			//loop through array
			for (int i=0;i<3;i++){
				new ThreadWithExtends(letters[i]).start();
			}//end inner for loop  
		}//end outter for loop
	}//end main method

}//end class
