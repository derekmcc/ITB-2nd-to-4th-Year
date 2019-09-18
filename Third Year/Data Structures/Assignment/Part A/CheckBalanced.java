import java.util.Stack;

public class CheckBalanced implements StackInterface {
	private Node top;
	private static boolean balancedSoFar = false;
	private int counter;
	  
	public CheckBalanced() {
		// Stack will be empty when constructed
		// NOTE: top = null is the definition of an empty stack
		top = null;
	}//end default constructor
	
	public boolean isEmpty() {
		// Return if top == null
		return top ==  null;
	}//end isEmpty
	
	public void push(Object newItem) {
		// Create a new Node with the item data
		Node newNode = new Node(newItem, top);
		// Make the new nodes nxt reference the current top of the stack
		newNode.setNext(top);
		// Make the top of the stack reference the new Node 
		top = newNode;
	}//end push
	
	public Object pop() throws StackException {
		Node temp = null;
		Node nextNode = top.getNext();
		if (!isEmpty()) {
			//Take a copy of the top of the stack to be returned by pop
			temp = top;
			//Reset the top ref to the next node
			top = top.getNext();
			// Return the copy
			return temp.getItem();
		}//end if
		else {
			//pop on empty stack : Throw a StackException here
			throw new StackException("Stack Exception, Pop on empty stack");
		}//end else
	}//end pop
	
	public void popAll() {
		// Make the stack empty again - see def of empty stack above
		top = null;
	}//end popAll
	
	public Object top() throws StackException {
		Node temp = null; 
		if (!isEmpty()) {/* The stack is not empty*/
			//Return a copy of the top item - don't pop it 
			temp = top;
		}//end if
		else {
			// top on empty stack : Throw a StackException here
			throw new StackException("Stack Exception, Top on empty stack");
		}//end else
		return temp.getItem();
	}//end peek
		  
	public void isBalanced(String s) {
		//create a new stack
		Stack stack = new Stack();
		//set balancedSoFar to true
		balancedSoFar = true;
		//set counter to 0
		counter = 0;
		//variable character (to check characters in string) 
		char ch;
		
		//while the brackets are balanced and the counter is less than the string file length 
		while (balancedSoFar == true && counter < s.length()) {
			//assign the character at the counters position to ch
			ch = s.charAt(counter);
			//increment counter
			counter++;
			
			//if character (ch) is equal to an open bracket
			if (ch == '{') {
				//push an open brace
				stack.push('{'); 
			}//end if
			//esle if character (ch) is equal to a closing bracket
			else if (ch == '}') {
				//if stack is not empty
				if (!stack.isEmpty()) {
					//pop a matching open brace
					stack.pop(); 
				}//end if
				else {
					//no matching open brace
					balancedSoFar = false; 
				}//end else
			}//end else if
		}//end while
		
		//if the brackets are balanced and the stack is not empty
		if (balancedSoFar && stack.isEmpty()) {
			//display message
			System.out.println("\nBALANCED\n");
		}//end if
		else {
			//display message	
			System.out.println("\nNOT BALANCED\n");
		}//end else
	}//end isBalanced
}//end StackReferenceBased