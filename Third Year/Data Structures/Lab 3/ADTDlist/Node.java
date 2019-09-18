public class Node {
  private Object item;
  private Node next;
  private Node prev;

  public Node(Object newItem) {
    item = newItem;
    next = null;
    prev = null;
  } // end constructor

  public Node(Object newItem, Node nextNode) {
    item = newItem;
    next = nextNode;
  } // end constructor

  public Node(Object newItem, Node nextNode, Node prevNode) {
      item = newItem;
      next = nextNode;
      prev = prevNode;
  }

  public void setItem(Object newItem) {
    item = newItem;
  } // end setItem

  public Object getItem() {
    return item;
  } // end getItem

  public void setNext(Node nextNode) {
    next = nextNode;
  } // end setNext

  public Node getNext() {
    return next;
  } // end getNext

  public void setPrev(Node prevNode) {
      prev = prevNode;
    } // end setPrev

    public Node getPrev() {
      return prev;
  } // end getPrev

} // end class Node

