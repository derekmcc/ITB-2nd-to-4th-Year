
public class ListArrayBased implements ListInterface {
	

  	private static final int MAX_LIST = 10;
  	private Object items[];  
  	private int numItems;  

  	public ListArrayBased() {
    	items = new Object[MAX_LIST];
   		numItems = 0;
  	}// end default constructor
   
  	public boolean isEmpty() {
    	return (numItems == 0);
  	}//end isEmpty
   
  	public int size() {
    	return numItems;
  	}// end size
   
  	public void removeAll() {
    	// Creates a new array; marks old array for 
    	// garbage collection.
    	items = new Object[MAX_LIST];
    	numItems = 0;
  	}// end removeAll
  	
  	public void add(int index, Object item) 
                  throws  ListIndexOutOfBoundsException {
   		if (index >= 0 && index <= numItems) {
      		// make room for new element by shifting all items at 
      		// positions >= index toward the end of the 
      		// list (no shift if index == numItems+1)
      		for (int i = numItems-1; i >= index; i--) {
          		items[i+1] = items[i];
      		} // end for
      		// insert new item
      		items[index] = item;
      		numItems++;
    	}//end if 
    	
    	else if (index > MAX_LIST){  // index out of range
      		throw new ListIndexOutOfBoundsException(
       			"ListIndexOutOfBoundsException on add");
    	}  // end if
  	} //end add
   
  	public Object get(int index) 
                    throws ListIndexOutOfBoundsException {
    	if (index >= 0 && index <= numItems) {
      		return items[index];
    	}//end if
    	else  {  // index out of range
    		throw new ListIndexOutOfBoundsException(
        		"ListIndexOutOfBoundsException on get");
    	}// end else
  	}//end get
   
  	public void remove(int index) 
                     throws ListIndexOutOfBoundsException {
    	if (index >= 0 && index <= numItems) {
     		for (int pos = index+1; pos < size(); pos++) {
        		items[pos-1] = items[pos];
      		}// end for
      		numItems--;
    	}//end if
    	else {  // index out of range
      		throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
    	}//end else
  	}//end remove
  
  	public void display(){
  		for (int i = 0; i < numItems; i++){
  			System.out.println(items[i]);
  		}//end for
  	}//end display
}//end class
  
  	