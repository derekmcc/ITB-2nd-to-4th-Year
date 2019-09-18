// ****************************************************
// Interface for the ADT list
// ****************************************************
public interface QueueInterface
{
  // list operations:
  public boolean isEmpty();
  public void enqueue(Object item) throws QueueException;
  public Object dequeue() throws QueueException;
  public Object peek() throws QueueException;
  public void dequeueAll();
} // end ListInterface