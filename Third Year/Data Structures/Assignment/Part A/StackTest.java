import java.io.*;
//start of class
public class StackTest{
	//start of main method
	public static void main(String[] args) throws Exception{
	
		//create an instance of CheckBalanced
		CheckBalanced stack = new CheckBalanced();
		
		//check to see if any arguments were passed
		if (args.length == 0) {
			//display message
            System.out.println("ERROR:: Need to pass a text file as an argument");
        }//end if 
        else {
			//variable to hold the text file's name
            String fileName = args[0];
			//to read in the text file contents
            BufferedReader input = new BufferedReader(new FileReader(fileName));
			//variable to hold text file contents
            String line = null;
			//try to read in the text file
            try {
            	//while there's text being read in 
                while (( line = input.readLine()) != null){
                    //call the isBalanced method and pass the contents of the text file
                    stack.isBalanced(line);        
                }//end while
            } catch (Exception e) {
            	//print the stack trace
                e.printStackTrace();
            } finally {
            	//if theres no more text being read in
                if(input != null) {
                	 //close the bufferReader
                	 input.close();
                }//end if                
            }//end finally block
        }//end else
	}//end main method
}//end class