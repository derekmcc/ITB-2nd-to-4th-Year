import java.io.*;
import java.util.*;
public class ListTest{
	
	// Use this list of names for part B) of your assignment
	private static final String userData[] = {	"Li Zhang",
						"Shun Wen Chook",
						"Aleksandra Wos",
						"Wiktor Lesiak",
						"Gabby Farrell",
						"Dean Poynton",
						"Jenny O Connell",
						"Catharine Phoenix",
						"Piotr Poreba",
						"Karl Roche",
						"Florian Boyrie",
						"Daniel Molloy",
						"Danilo Loayon",
						"Owen Norris",
						"Agata Dzierzak",
						"Pawel Poreba",
						"Jack Bolger",
						"Stephen O Brien",
						"Maxence Morand",
						"Azriel Carl Pagayonan",
						"Liam Rooney",
						"Eoghan De Bhal",
						"Derek Mc Carthy",
						"Andrei Tudoran",
						"Emmanuel Apara",
						"Adam Mc Carthy",
						"Daniel Dixon",
						"Paul Lupu",
						"Conor Byrne",
						"Ken Kilmartin",
						"Conor Walsh",
						"Joseph Tierney",
						"Andrew Sherlock",
						"Richard Bukovcsan",
						"Christopher Slattery",
						"Sean Moloney",
						"Artur Wac",
						"Lee Gerety",
						"Nasir Iqbal",	
						"Jessica Tati"};
	
	public int binaryChoice(){
		if (Math.random() > 0.5){
			return 1;
		}//end if	
		else {
			return 0;
		}//end else	
	}//end binaryChoice

	public void sleepRandom(int seconds){
		try {
			Thread.sleep((long)(Math.random() * (seconds*1000) ));
		} catch(InterruptedException e){
			e.printStackTrace();
		}//end catch
	}//end sleepMethod

	public static void main(String[] args){
		
		//creat an instance of the class's
		ListTest lt = new ListTest();
		ListReferenceBased lrb = new ListReferenceBased();
		
		//variable counter to count the number of students
		int counter = 0;
		
		//Use the binaryChoice method to generate a Yes or No
		String choice = (lt.binaryChoice()==1) ? "Yes" : "No";

		//Use the sleepRandom method to create a delay between steps
		for(int i = 0; i < userData.length; i++){
			//display message
			System.out.println("[ Adding User: " + userData[i] + " ]");
			
			//try 
			try {
				//add the students to the list
				lrb.add(i, userData[i]);
				//increment counter
				counter++;
			//catch List index out bounds exception	
			} catch (ListIndexOutOfBoundsException e) {
				//display error message
				System.out.println("Invalid index!!");
				//display the stack trace
				e.printStackTrace();
			}//end
			//Sleep between 0 - 2 seconds
			lt.sleepRandom(1); 
		}//end for
		//display message
		System.out.println("[ " + counter + " users added to the list ]");
		//arraylist to hold the info of students who want to log off
		ArrayList<Object> al = new ArrayList<Object>();
		//counter to keep track of rounds
		int increment = 1;
		//while counter is not zero loop
		while (counter != 0) {	
			//display message
			System.out.println("\n\t\t****************Processing Round " + (increment++) + "****************\n");
			//increment numItem
			int numItem = 0;
			//if the tail is not null
			if (lrb.getTail() != null) {
				//set the reference to the head
				Node head = lrb.getTail().getNext();
				//assign the current node to the head
				Node curr = head;
				//do 
				do {
					//generate a random choice
					choice = (lt.binaryChoice()==1) ? "Yes" : "No";
					//display message
					System.out.println("[ " + curr.getItem() + " logging off : " +" " + choice + " ]");
					//Sleep between 0 - 2 seconds
					lt.sleepRandom(1); 
					//if choice is yes
					if (choice.equals("Yes")){
						//add the item to the arrayList
						al.add(numItem);
						//increment counter
						counter --;
					}//end if
					//increment numItem
					numItem++;
					//assign the next position to curr 
					curr = curr.getNext();
				}while(curr != head);
			}//en if

			//loop to remove the students from the circular list
			for (int i = al.size()-1; i >=0; i--) {
				//assign x the integer value of the arraylist at position i
				int x = (Integer)al.get(i);
				//try
				try {
					//remove the student from the circular list
					lrb.remove(x);
					//remove the student for the arraylist
					al.remove(i);
				//catch exceptions	
				} catch (IndexOutOfBoundsException ie) {
					//display stacktrace
					ie.printStackTrace();
				} catch (Exception e) {
					//display stacktrace
					e.printStackTrace();
				}//end catch	
			}//end for
			al.clear();
		}//end while
		
		//string border 
		StringBuilder border = new StringBuilder();
		border.append("\n*");
		//loop to add more stars to the border
		for(int i = 0; i < 70; i++){
			//add a star to the string with each iteration of the loop
			border.append("*");
		}//end for
		
		//display border
		System.out.println(border);
		//display message 
		System.out.println("\n\t\t\t[ All Users Logged Off! ]");
		//display border
		System.out.println(border);
	}//end main method
	
}//end class
