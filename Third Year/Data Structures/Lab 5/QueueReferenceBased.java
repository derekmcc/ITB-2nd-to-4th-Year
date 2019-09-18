// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class QueueReferenceBased implements QueueInterface {
	
	// reference to linked list of items
	private int numItems = 0; 
	private Node last;
	
	public QueueReferenceBased() {
		numItems = 0;
		last = null;
	}  // end default constructor
	
	public boolean isEmpty() {
		return (numItems == 0);
	}  // end isEmpty
	
	public void enqueue(Object newItem) 
		throws QueueException {
		Node newNode = new Node(newItem);	
		if (isEmpty()) {
			newNode.setNext(newNode);
		}//end if
		else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}//end else
		numItems++;
		last = newNode;
	}//end enqueue
	
	public Object dequeue() throws QueueException {
		if (!isEmpty()){
			Node first = last.getNext();
			
			if (first == last){
				last = null;
				numItems--;
			}//end if
			else {
				last.setNext(first.getNext());
				numItems--;
			}//end else
			return first.getItem();
		}//end if
		else {
			throw new QueueException("QueueException on dequeue");
		}//end else
	}//end dequeue
	
	public void dequeueAll() {
		last = null;
	  	numItems = 0;
	}//end removeAll
	
	public Object peek()
		throws QueueException{
			if (!isEmpty()) {
				Node first = last;
				return first.getItem();
			}//end if
			else {
				throw new QueueException("QueueException on peek");
			}//end else
	}//end peek	 
}//end ListReferenceBased