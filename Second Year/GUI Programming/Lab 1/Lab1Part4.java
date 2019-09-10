import java.util.Scanner;
public class Lab1Part4 {

    public static void main (String args[]) {
    	//scanner to take inputs from the user
    	Scanner input = new Scanner (System.in);
    	
    	//variables
    	String firstName, lastName;
    	int age, ageBy3;
    	
    	//take inputs from the user
    	System.out.print("Enter First Name : ");
    	firstName = input.nextLine();
    	System.out.print("Enter Last Name : ");
    	lastName = input.nextLine();
    	System.out.print("Enter Age : ");
    	age = input.nextInt();
    	
    	//method call
    	printMyName(firstName,lastName);
    	ageBy3 = tripleAge(age);
    	
    	//print age
    	System.out.println("\nYour age * 3 is " + ageBy3);
    }//end main method
    
    public static int tripleAge(int age){
    	//return the age * 3
    	return age * 3;  	
    }//end tripleAge method
    
    public static void printMyName(String firstName, String lastName){
    	//print the first and last name
    	System.out.println(firstName + " " + lastName);	
    }//end printMyAge method
}//end class