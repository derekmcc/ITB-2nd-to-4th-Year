// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface {
	
	// reference to linked list of items
	private Node head; 
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
      		}//end if
      		else {
        		Node prev = find(index-1);
        		// insert the new node containing item after
        		// the node that prev references
				Node newNode = new Node(item, prev.getNext());
				prev.setNext(newNode);
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
		if (index >= 0 && index < numItems) {
      		if (index == 0) {
        		//delete the first node from the list
				head = head.getNext();
      		}//end if
      	else {
			Node prev = find(index-1);
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
		for(Node curr = head; curr != null; curr = curr.getNext()){
 			System.out.println(curr.getItem());
		}//end for
	}//end display
	
	public void listLargest () {
		
		String strLargest[] = new String[numItems];
		int i = 0;
	
		for(Node curr = head; curr != null; curr = curr.getNext()){
 			strLargest[i] = curr.getItem().toString();
 			i++;
		}//end for
 
		int index = 0; 			
		int elementLength = strLargest[0].length();
		
		for(int x=1; x < numItems; x++) {
		    if(strLargest[x].length() > elementLength) {
		        index = x; elementLength = strLargest[x].length();
		    }//end if
		}//end for
		
		System.out.print(strLargest[index]);
		
	}//end listLargest	  
}//end ListReferenceBased