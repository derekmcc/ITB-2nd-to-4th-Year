import java.io.*;

public class QueueTest{
		
	public static void main(String args[]){
		BufferedReader input = null;
		//variable to hold text file contents
		String line = null;
		//try to read in the text file
		try {
			input = new BufferedReader(new FileReader("palindromes.txt"));
			//while there's text being read in 
		    while (( line = input.readLine()) != null){
		        //call the isBalanced method and pass the contents of the text file
		        if (isPal(line) == true){
		        	System.out.println(line + " is a Palindrome!");
		        }//end if 
		        else {
		        	System.out.println(line + " is not a Palindrome!");
		        }//end else       
		    }//end while
		} catch (Exception e) {
			//print the stack trace
		    e.printStackTrace();
		} finally {
			//if theres no more text being read in
		    if(input != null) {
		    	try{
		    		//close the bufferReader
		    	 input.close();
		    	} catch (IOException io){
		    		io.printStackTrace();
		    	} catch (Exception e){
		    		e.printStackTrace();
		    	}//end catch
		    	 
		    }//end if                
		}//end finally block
		
		
		//Non palindromes
		String nonPalindromes[] = {"for", "if", "else", "finally", "catch", "exception", "system"};
		
		System.out.println("\n\nA list of non palindromes\n");
		for (int i = 0; i < nonPalindromes.length; i++){
			if (isPal(nonPalindromes[i]) == true){
				System.out.println(nonPalindromes[i].toUpperCase() + " is a Palindrome!");
	        }//end if 
	        else {
	        	System.out.println(nonPalindromes[i].toUpperCase() + " is not a Palindrome!");
	        }//end else	
		}//end for
		
		
	}//end main
	
	public static boolean isPal(String s){
		
		StackReferencedBased stack = new StackReferencedBased();
		QueueReferenceBased queue = new QueueReferenceBased();
		
		int length = s.length();
		char nextChar;
		for (int k = 0; k < length; k++){
			nextChar = s.charAt(k);
			queue.enqueue(nextChar);
			stack.push(nextChar);
		}//end for
		
		boolean charactersAreEqual = true;
		
		while (!queue.isEmpty() && charactersAreEqual == true){
			Object queueFront = queue.dequeue();
			Object stackTop = stack.pop();

			if (queueFront != stackTop){
				charactersAreEqual = false;
			}//end if
		}//end while
		return charactersAreEqual;
	}//end isPal
}//end class