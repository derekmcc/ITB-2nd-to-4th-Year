// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface {
	
	// reference to linked list of items
	private Node head; 
	public Node tail; 
	private int numItems; 
	private Node curr = head;
	
	public ListReferenceBased() {
		numItems = 0;
		head = null;
	}  // end default constructor
	
	public boolean isEmpty() {
		return (numItems == 0);
	}  // end isEmpty
	
	public int size() {
		return numItems;
	}  // end size
	
	private Node find(int index) {
	  	
	  	// --------------------------------------------------
	  	// Locates a specified node in a linked list.
	  	// Precondition: index is the number of the desired
	  	// node. Assumes that 1 <= index <= numItems+1 
	  	// Postcondition: Returns a reference to the desired 
	  	// node.
	    // --------------------------------------------------
	  	Node curr = head;
	  	//traverse the list
	  	for (int i = 0; i < index; i++){
	  		//get the current node
	  		curr = curr.getNext();
	  	}//end for
	  	//return the current node
	  	return curr;
	} // end find
	
	public Object get(int index) 
		throws ListIndexOutOfBoundsException {
		if (index >= 0 && index <= numItems) {
      		Node curr = find(index);
      		return curr.getItem();
    	}//end if
    	else  {  // index out of range
    		throw new ListIndexOutOfBoundsException(
        		"ListIndexOutOfBoundsException on get");
    	}// end else
	} // end get
	
	public void add(int index, Object item)
	    throws ListIndexOutOfBoundsException {
		if (index >= 0 && index <= numItems) {
      		if (index == 0) {
				Node newNode = new Node(item, head);
				head = newNode;
				//tail = head;
      		}//end if
      		else {
        		tail  = find(index-1);
        		// insert the new node containing item after
        		// the node that prev references
				Node newNode = new Node(item, null);
				tail.setNext(newNode);
				tail = tail.getNext();
				if (index == numItems){
					Node newNode1 = new Node(item, tail.getNext());
					tail.setNext(head);
					tail = newNode;
				}//end if
      		}// end else
      		numItems++;
   		}//end if
    	else {
      		throw new ListIndexOutOfBoundsException(
                "List index out of bounds on add");
    	}//end else
	}//end add
	
	public void remove(int index) 
    		throws ListIndexOutOfBoundsException {
    			Node prev = find(index-1);
		if (index >= 0 && index < numItems) {
      		if (index == 0) {
				head = head.getNext();
				tail.setNext(head);
      		}//end if
      		else if(index == numItems-1){
      			tail.setNext(head);
      			tail = prev;
      			prev.setNext(head);
      		}//end else if
      		else {
				Node curr = prev.getNext();
				prev.setNext(curr.getNext());
      		}//end if
      		numItems--;
    	}//end if
    	else {
      		throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
    	}//end if  
	}//end remove
	
	public void removeAll() {
	    // setting head to null causes list to be
	    // unreachable and thus marked for garbage 
	    // collection
		head = null;
	  	numItems = 0;
	}//end removeAll
	
	public void display(){
		if (tail.getItem() != null && size() > 0){
			int i =1;
 			// list not empty
 			Node first = tail.getNext(); // reference first node
 			Node curr = first;
	 		// Loop invariant: curr refs next node to display
	 		do{
	 			//write output
	 			System.out.println(curr.getItem());
	 			curr = curr.getNext();
	 		}while(curr != first);
		} //End if
		else{
			System.out.println("List is EMPTY!!");
		}//end else
	}//end display
		
	public Node getTail(){
		return tail;
	}  
}//end ListReferenceBased