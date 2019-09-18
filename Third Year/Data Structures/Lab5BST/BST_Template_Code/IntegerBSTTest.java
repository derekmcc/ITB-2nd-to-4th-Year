import java.util.*;

class IntegerBSTTest{
	// Visualisation of what out tree should look like
	public static void printTree(){
		System.out.println("*********************");
		System.out.println("*  BST Test Program *");
		System.out.println("*********************");
		System.out.println("         12");
		System.out.println("        /  \\");
		System.out.println("      5     15");
		System.out.println("     / \\    / \\");
		System.out.println("    3   7  13  17");
		System.out.println("   /     \\");
		System.out.println("  1       9");
	}//end printTree
	
	public static void main(String args[]){
		
		// Create an IntegerBST object
		IntegerBST intBst = new IntegerBST();
		
		// Some tree data
		int items[] = {12,5,3,1,7,9,15,13,17};
		
		// Print a visual representation of what the tree should look like
		printTree();

		// T E S T   C A S E  1 : Adding items to BST
		// Loop through our array data and create the BST
		for(int i = 0; i < items.length; i++){
			intBst.add(items[i]);
		}
		
		// T E S T   C A S E  2 : in-order traversal
		// Show an in-order traversal of the tree
		ArrayList inorder = intBst.inOrder();
		System.out.println("In-order " + inorder.toString());
		
		// T E S T   C A S E  3 : pre-order traversal
		// Show an pre-order traversal of the tree 
		ArrayList preorder = intBst.preOrder();
		System.out.println("Pre-order " + preorder.toString());
		
		// T E S T   C A S E  4 : post-order traversal
		// Show an post-order traversal of the tree 
		ArrayList postorder = intBst.postOrder();
		System.out.println("Post-order " + postorder.toString());

		// T E S T   C A S E  5 : Check the height of the tree, should be = 4
		// Print the height of the tree
		System.out.println("Height of tree =  " + intBst.height());
		
		// T E S T   C A S E  6 : Search the BST for some values
		// Check if the tree contains the value 14. Should be == false
		System.out.println("Tree contains the value 14 is " + intBst.contains(14));
		// Check if the tree contains the value 7. Should be == true
		System.out.println("Tree contains the value 7 is " + intBst.contains(7));
		
		// T E S T   C A S E  7 : First case for removal - leaf node
		System.out.println("Remove a leaf node (1)");
		intBst.remove(1);
		// Check result with an in-order traversal
		inorder = intBst.inOrder();
		System.out.println("In-order " + inorder.toString());

		// T E S T   C A S E  8 : Second case for removal - node with 1 child
		System.out.println("Remove a node with 1 child (7)");
		intBst.remove(7);
		// Check result with an in-order traversal
		inorder = intBst.inOrder();
		System.out.println("In-order " + inorder.toString());

		// T E S T   C A S E  9 : Third case for removal - node with 2 children
		System.out.println("Remove a node with 2 children (15)");
		intBst.remove(15);
		// Check result with an in-order traversal
		inorder = intBst.inOrder();
		System.out.println("In-order " + inorder.toString());

		// T E S T   C A S E  10 : Try remove a node that does not exist
		System.out.println("Try to remove a node that does not exist (20)");
		intBst.remove(20);
		// Check result with an in-order traversal
		inorder = intBst.inOrder();
		System.out.println("In-order " + inorder.toString());
				
	}
}