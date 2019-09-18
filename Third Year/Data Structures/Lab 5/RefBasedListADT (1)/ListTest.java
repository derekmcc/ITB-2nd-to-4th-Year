import java.io.*;


public class ListTest{
	public static void main(String args[]){
		ListReferenceBased la = new ListReferenceBased();

		// Test 1: Add 10 items to the list - No Max - Dynamic list
		try{
			la.add(0,"Bread");
			la.add(1,"Milk");
			la.add(2,"Cereal");
			la.add(3,"Coffee");
			la.add(4,"Sugar");
			la.add(5,"Beer");
			la.add(6,"Chicken");
			la.add(7,"Rice");
			la.add(8,"Wine");
			la.add(9,"Cakes");
		}
		catch(ListIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
			System.out.println("Invalid index!!");
		}
		
		// Display the list
		la.display();
		System.out.println("List size is " + la.size());

		// Test 2: Try to add another item
		try{
			System.out.println("Attempting to add a new item at index 5");
			la.add(5, "Another Item");
		}
		catch(ListIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
			System.out.println("Invalid index!!");
		}
		
		// Test 3: Remove the first item
		try{
			System.out.println("Removing " + la.get(0) + " from list");
			la.remove(0);
		}
		catch(ListIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
			System.out.println("Invalid index!!");
		}

		la.display();
		System.out.println("List size is " + la.size());

		// Test 4: Try to add another item - should be room now
		try{
			System.out.println("Attempting to add Tea at index 100");
			la.add(100, "Tea");
		}
		catch(ListIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
			System.out.println("Invalid index!!");
		}

		la.display();
		System.out.println("List size is " + la.size());

		// Test 5: Remove the last item
		try{
			System.out.println("Removing " + la.get(la.size()-1) + " from list");
			la.remove(la.size()-1);
		}
		catch(ListIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
			System.out.println("Invalid index!!");
		}

		la.display();
		System.out.println("List size is " + la.size());

		// Test 6: Remove item at index 4 from list
		try{
			System.out.println("Removing " + la.get(4) + " from list");
			la.remove(4);
		}
		catch(ListIndexOutOfBoundsException e)
		{
			//e.printStackTrace();
			System.out.println("Invalid index!!");
		}

		la.display();
		System.out.println("List size is " + la.size());

		// Test 7: Remove all items from the list
		System.out.println("Removing all items from the list.");		
		la.removeAll();

		// Test 8: Is the list Empty?
		System.out.println("List is Empty? = " + la.isEmpty());


	}
}