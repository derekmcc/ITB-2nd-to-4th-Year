/**
 * @(#)AssignmentPart9.java
 *
 *
 * @Derek McCarthy
 * @Student No: B00007439
 * @Derivation of Algorithms Assignment 1.
 *
 * ---- Question ---- 
 * Formally specify and hence solve the following problem:		
 * Given an array f[0..N), {N >  0} containing only the characters ‘A’, ‘B’ and ‘C’. Sort	the array	so that all C's precede.
 *
 * @version 1.00 2018/10/11
 */
import java.util.Random; 
//start class
public class AssignmentPart9 {
	//start main method
    public static void main(String args[]) {
    	
    	//global scope variables
    	int k = 0, q = 0, t = 0, j = 0;
   		final int N = 10;
   		char f[] = new char[N];
   		
   		//temp variables to help with the concurrent assignment of variables
   		int tempInt;
   		char temp1, temp2;
   		Random r = new Random();
   		
   		//add randoms chars to array (A-C)
   		for(int i = 0; i < f.length; i++){
     		f[i] = (char)(r.nextInt(3) + 65);
     		//System.out.print(f[i]);
		}//end for
   		
   		System.out.println("------------- Unprocessed Char's ----------------");
   		//traverse through array
   		for (int i = 0; i < N; i++){
   			//print array elements at position i
   			System.out.print(f[i]);
   		}//end for
   		
   		//assign the value of N to t
   		t = N;
   		
   		/*
   		 * traverse array
   		 * do q < t ->
   		 */
   		while (q < t) {
   			/*
   			 * check if the char at position q is C
   			 * if f.q = 'C' ->
   			 */
   			if (f[q] == 'C') {
   				/*
   				 * concurrent assignment alternative of variables
   				 * f.q, f.k := f.k, f.q 
   				 */
   				temp1 = f[q];
   				temp2 = f[k];
   				f[q] = temp2;
   				f[k] = temp1;
   				
   				/*
   				 * increment variables
   				 * q, k := q+1, k+1
   				 */
   				q++;
   				k++;
   			}//end if (fi)
   			
   			/*
   			 * check if the char at position q is B
   			 * [] f.q = 'B' ->
   			 */
   			else if (f[q] == 'B') {
   				/*
   				 * increment q
   				 * q := q + 1
   				 */
   				q = q + 1;	
   			}//end else if
   			
   			/*
   			 * check if the char at position q is A
   			 * [] f.q = 'A' ->
   			 */
   			else if (f[q] == 'A') {
   				/*
   				 * concurrent assignment alternative of variables
   				 * f.q, f.t-1 := f.t-1, f.q 
   				 */
   				temp1 = f[t-1];
   				temp2 = f[q];
   				f[q] = temp1;
   				f[t-1] = temp2;
   				tempInt = t;
   				// t := t - 1
   				t = tempInt - 1;
   			}//end else if
   			
   			//increment j 
   			j++;
   		}//end while(od)
   	
   		//reset j back to 0 
		j = 0;
		
		System.out.println("\n------------- Processed Char's ----------------");
   	
   		for (int i = 0; i < N; i++){
   			System.out.print(f[i]);
   		}//end for
   		
   		/*
   		 * traverse array
   		 * existential k, t 0 <= k <= t <= N
   		 */
   		while (k >= 0 && k <= t && t <= N){
   			/*
   			 * where all j: 0 <= j < k
   			 */
   			if (j >= 0 && j < k) {
   				// f.j = 'C'
   				f[j] = 'C';
   			}//end if 
   			
   			/*
   			 * where all j: k <= j < t
   			 */	
   			else if (j >= k && j < t) {
   				// f.j = 'B'
   				f[j] = 'B';
   				k++;
   			}//end else  
   			
   			/*
   			 * where all j: t <= j < N
   			 */	
   			else if (j >= t && j < N) {
   				// f.j = 'A'
   				f[j] = 'A';
   				k = k + 2;
   			}//end else if
   			
   			// increment variable j (array index)
   			j++;
   		}//end while
   		
   		//print array proof
   		System.out.println("\n------------- Proof ----------------");
   		for (int i = 0; i < N; i++){
   			System.out.print(f[i]);
   		}//end for
   		System.out.println();
    }//end main method
}//end class