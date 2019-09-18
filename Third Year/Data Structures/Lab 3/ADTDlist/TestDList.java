class TestDList {
	public static void main (String args[]) {
		
		ADTDList dList= new ADTDList();
		
		try {

			dList.add(0, new Integer(5));
			dList.add(1, new Integer(10));
			dList.add(2, new Integer(6));
			dList.add(3, new Integer(12));
			dList.add(4, new Integer(20));
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println("Head to tail output....");
		dList.displayHeadToTail();

		System.out.println("Tail to head output....");
		dList.displayTailToHead();

		// TODO: write a test to check for insertion in the middle of the list
		// Test 2: Try to add another item
		try{
			System.out.println("\nAttempting to add a new item at index 3 (of array)");
			dList.add(3, new Integer(88));
			System.out.println("***************\nUpdated List\n***************");
			dList.displayHeadToTail();
		} catch(ListIndexOutOfBoundsException e){
			//e.printStackTrace();
			System.out.println("Invalid index!!");
		}//end catch
		
		// TODO: write a test to check for deletion of the head
		try {
			System.out.println("\nRemoving the head of the list");
			dList.remove(0);
			System.out.println("Updated list with the head removed");
			dList.displayHeadToTail();	
		} catch (ListIndexOutOfBoundsException e) {
			e.printStackTrace();
		}//end catch
		
		// TODO: write a test to check for deletion of a non existing index 
		try {
			dList.remove(7);
		} catch (ListIndexOutOfBoundsException e) {
			e.printStackTrace();
		}//end catch		
	}//end main
}//end class