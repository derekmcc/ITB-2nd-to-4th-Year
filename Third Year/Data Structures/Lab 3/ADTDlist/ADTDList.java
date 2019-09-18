public class ADTDList implements DListInterface {

	Node head;
	Node tail;
	int numItems;
	private Node curr = head;
	
	public boolean isEmpty() {
		return (numItems == 0);
	}//end isEmpty
	
	public int size() {
		return numItems;
	}//end size
	
	public Node find(int index) {
	  	
	  	Node curr = head;
	  	//traverse the list
	  	for (int i = 0; i < index; i++){
	  		//get the current node
	  		curr = curr.getNext();
	  	}//end for
	  	//return the current node
	  	return curr;
	}//end find
	
	public Object get(int index)
		throws ListIndexOutOfBoundsException {
		if (index >= 0 && index <= numItems){
			Node curr = find(index);
			return curr.getItem();
		}//end if
		else {
			throw new ListIndexOutOfBoundsException(
				"ListIndexOutOfBoundsException on get");
		}//end else
	}//end get
	
	public void add(int index, Object item)
	    throws ListIndexOutOfBoundsException {
	    	
    	Node temp = new Node(item);
        if (index < 0 || index > numItems) {
            throw new ListIndexOutOfBoundsException(
            	"List index out of bounds on add");
        } //end if
        else if (index == 0) {
            Node temp1 = new Node(item);
        	if (head == null) {
            	head = temp1;
            	tail = head;
        	}//end if 
        	else {
            	temp1.setNext(head);
            	head.setPrev(temp1);
            	head = temp1;
        	}//end else
        	numItems++;
        } //end else if
        else if (index == numItems) {
            Node temp2 = new Node(item);
        	if (head == null) {
            	head = temp2;
            	tail = head;
        	}//end if 
        	else {
            	tail.setNext(temp2);
            	temp2.setPrev(tail);
            	tail = temp2;
       	 	}//end else
        	numItems++;
        }//end else if 
        else {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }//end for
            Node previous = curr.getPrev();
            previous.setNext(temp);
            temp.setPrev(previous);
            temp.setNext(curr);
            curr.setPrev(temp);
            numItems++;
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
	}//end removeAl
	
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
	
	public void displayHeadToTail(){
		for(Node curr = head; curr != null; curr = curr.getNext()){
 			System.out.println(curr.getItem());
		}//end for
	}//end displayHeadToTail
	
	public void displayTailToHead(){	
		for(Node curr = tail; curr != null; curr = curr.getPrev()){
			Node f =tail;
 			System.out.println(curr.getItem());
		}//end for 
	}//end displayTailToHead
}//end class

