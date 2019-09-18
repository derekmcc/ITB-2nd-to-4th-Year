public class StackReferenceBased implements StackInterface {
	  private Node top;
	  
	  public StackReferenceBased() {
		  // Stack will be empty when constructed
		  // NOTE: top = null is the definition of an empty stack
		  top = null;
	  }  // end default constructor
	  
	  public boolean isEmpty() {
		  // Return if top == null
		  return top ==  null;
	  } // end isEmpty
	
	  public void push(Object newItem) {
		  // INSERT AT THE HEAD OF THE LIST
		  // top will always reference the head of the list
		  
		  // Create a new Node with the item data
		  Node newNode = new Node(newItem, top);
		  // Make the new nodes nxt reference the current top of the stack
		  newNode.setNext(top);
		  // Make the top of the stack reference the new Node 
		  top = newNode;
	  }  // end push
	
	  public Object pop() throws StackException {
		  Node temp = null;
		  Node nextNode = top.getNext();
		  if (!isEmpty()) {
	    	// Take a copy of the top of the stack to be returned by pop
	    	temp = top;
	    	// Reset the top ref to the next node
	    	top = top.getNext();
	    	// Return the copy
	    	return temp.getItem();
		  }
		  else {
			  // pop on empty stack : Throw a StackException here
			  throw new StackException("Pop on empty stack");
		  } // end if
	  }  // end pop
	
	  public void popAll() {
	    // Make the stack empty again - see def of empty stack above
	    top = null;
	  }  // end popAll
	
	  public Object top() throws StackException {
		  Node temp = null; 
		  if (!isEmpty()) {/* The stack is not empty*/
			  // Return a copy of the top item - don't pop it 
			  temp = top;
		  }
		  else {
			  // top on empty stack : Throw a StackException here
			  throw new StackException("Top on empty stack");
		  }  // end if
		  return temp.getItem();
	  } // end peek
	
}  // end StackReferenceBased