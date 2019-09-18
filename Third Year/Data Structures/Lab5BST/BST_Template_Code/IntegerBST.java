import java.util.ArrayList;

public class IntegerBST implements IntegerBSTInterface { 
	
	//global scope variables
	private BNode root;
	private BNode left;
	private BNode right;
	
	/*
	 *Default Constructor
	 */	
	public IntegerBST(){
		// Empty tree, set the root to null
		root = null;
	}//end constructor
	
	/*
	 * Add method
	 */
	public void add(int d){
		//check if the root is empty
		if (root == null)
			//create a new root node 
			root = new BNode(d);
		else
			//if the root is not empty add the root
			add(root, d);
	}//end add method
	
	/*
	 * Private recursive add method to add a new node
	 */
	private void add(BNode node, int d) {
		//if the value is less than the node's value
		if (d < node.data()){
			// This value should go to the left of node
			// if the left of node is empty, then add the new node here
			if (node.left() == null) {
				//set the new node to the left of the node
				node.setLeft(new BNode(d));
			}//end if
			// else if the left of node is occupied, 
			else {
				//then call add recursively left
				add(node.left(),d);
			}//end else
		}//end if
		
		//else if the value is greather than the node's value
		else if (d > node.data()) {
			// This value should go to the right of node
			// if the right of node is emptythen add the new node here
			if (node.right ()== null){
				node.setRight(new BNode(d));
			}//end if
			// else if the right of node is occupied, then call add recursively right
			else {
				add(node.right(),d);
			}//end else
		}//end else if
	}//end add
	
	// Helper function to return the max of two values
	// Used in the recursive Height method
	private int max(int a,int b){ return a >= b? a:b;}
	
	// Public version of Height - non-recursive
	public int height(){
		//return the roots height
		return height(root);
	}//end height method
	
	// Private version of height - recursive
	private int height(BNode rt){
		//if the node is null
		if(rt == null)
			//return zero 
			return 0; 
		else{
			// Result will be ..
			// return 1 + the max of height of left subtree and height of right subtree
			// NOTE: the height of left and right subtrees can be found recursively
			return 1 + max(height(rt.left()),height(rt.right()));
		}//end else
	}//end height method
	
	// Public version of contains - non-recursive
	public boolean contains(int d){ 
		return contains(root, d);
	}//end contains method
	
	// Private version of contains - recursive
	private boolean contains(BNode node, int d){
		//if the node is empty
		if(node == null) 
			//return false
			return false; 
		else {
			//if the node value is equal to the passed value
			if(node.data() == d) 
				// We found it, return true
				return true; 
			//else if the value passed is less than the node value 		
			else if (d < node.data()) 
				// return recursive call down left subtree
				return contains(node.left(), d);
			else 	
				// return recursive call down right subtree
				return  contains(node.right(), d);
		}//end else 
	}//end method contains
	
	// Public version of inOrder - non recursive
	public ArrayList inOrder(){
		//create a new array list called lst 
		ArrayList lst = new ArrayList(); 
		// Recursive call
		inOrder(root,lst);
		//return the list
		return lst;
	}//end inOrder method
	
	// Private version of inOrder - recursive so need to pass root etc
	private void inOrder(BNode node, ArrayList lst){ 
		//if the node is not empty
		if(node != null){
			inOrder(node.left(), lst); //process left sub-tree
			lst.add(node.data()); //process root
			inOrder(node.right(),lst); //process right sub-tree
		}//end if 
	}//end inOrder method
	
	// Public version of preOrder - non recursive
	public ArrayList preOrder(){ 
		//create a new array list called lst
		ArrayList lst = new ArrayList(); 
		// Call to preOrder
		preOrder(root,lst);
		//return the list
		return lst;
	}//preOrder method
	
	// Private version of preOrder - recursive so need to pass root etc
	private void preOrder(BNode node, ArrayList lst){
		//if the node is not empty
		if(node != null){
			lst.add(node.data()); //process root
			preOrder(node.left(),lst); //process left sub-tree
			preOrder(node.right(),lst); //process right sub-tree
		}//end if
	}//end preOrder method
	
	// Public version of postOrder - non recursive
	public ArrayList postOrder(){ 
		//create a new array list called lst
		ArrayList lst = new ArrayList(); 
		// Call postOrder
		postOrder(root,lst);
		//return the list
		return lst;
	}//end postOrder method
	
	// Private version of postOrder - recursive so need to pass root etc
	private void postOrder(BNode node, ArrayList lst){
		//if the node is not empty
		if(node != null){
			postOrder(node.left(), lst); //process left sub-tree
			postOrder(node.right(),lst); //process right sub-tree
			lst.add(node.data()); //process root
		}//end if
	}//end postOrder method
	
	// Helper - function to find the maximum value from a root node
	private BNode findMax(BNode node) {
		//while the node to the right is not empty
		//assign the node to the right to the node
		while(node.right() != null) node = node.right();
			//return the node
			return node;
	}//end findMax method
	
	// Public version of remove, non-recursive
	public void remove(int d){
		//call the recursive remove method and assign the returned node to root
		root = remove(root, d);
	}//remove method
	
	// Private version of remove, recursive
	private BNode remove(BNode node, int d){
		//if the node is empty return null
		if (node == null) return null;
		//else if the value passed is less than node data recur down the tree to the left
		else if (d < node.data()) node.setLeft(remove(node.left(), d));
		//else if the value passed is greather than node data recur down the tree to the right
		else if (d > node.data()) node.setRight(remove(node.right(), d));
		else{
			// Found the node - ready to delete
			// Case 1 : Leaf node
			// If both left and right are empty then just set to null
			if (node.left() == null && node.right() == null){
				//set the node to empty
				node = null;
			}//end if
			
			// Case 2: One child
			// Node to delete has just one child, so replace it with either its left or right child
			else if ((node.left() != null && node.right() == null) || (node.left() == null && node.right() != null)){
				//if the node to the left is not empty
				if (node.left() != null){
					//assign the node to the left to the node
					node = node.left();
					//remove the node to the left
					remove(node.left(),d);
				}//end if
				//else if the node to the right is not empty
				else if (node.right() != null){
					//assign the node to the right to the node
					node = node.right();
					//remove the node to the right
					remove(node.right(),d);
				}//end else if
			}//end else if
			
			// Case 3 : Two children
			else{
				/*
				Replace the value in the node to be deleted by the rightmost
				element in its left sub-tree and then delete this node
				NOTE: use findMax to make the replacement and this
				case reduces to case 2 recursive call to remove.
				*/
				//temp placeholder for the left side node
				BNode tempLeft = new BNode(d);
				//assign the node to the left to temp left
				tempLeft = node.left();
				//assign the maximum right side value to the node
				node = findMax(node.right());
				//remove the node
				remove(node.right(),d);
				
				/*
				 * Set the node to the left temp left node
				 * So as not to loose the child nodes on the left
				 */
				node.setLeft(tempLeft);
			}//end else
		}//end else
		//return the node
		return node;
	}//end remove method
} // End class