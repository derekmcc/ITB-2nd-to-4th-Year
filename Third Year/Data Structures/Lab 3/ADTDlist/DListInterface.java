public interface DListInterface {
  // list operations:
  public boolean isEmpty();
  public int size();
  public void add(int index, Object item) throws ListIndexOutOfBoundsException;
  public Node find(int index);
  public void remove(int index) throws ListIndexOutOfBoundsException;
  public Object get(int index) throws ListIndexOutOfBoundsException;
  public void removeAll();
  public void displayHeadToTail();
  public void displayTailToHead();
}