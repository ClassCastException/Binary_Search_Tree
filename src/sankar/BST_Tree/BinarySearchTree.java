package sankar.BST_Tree;

// This class creates a Binary Search Tree data structure. It can store any object provided 
// that the object implements the Comparable interface and therefore has a compareTo method.

// The class provides an insertion and deletion method for the tree and can print the values
// of the tree in either preorder, inorder, or postorder.

public class BinarySearchTree<T extends Comparable<T>> {
	
	// Represents the root of the tree
	private TreeNode<T> root = null;
	
	// Constructor takes in a value that becomes the root
	public BinarySearchTree(T value){
		root = new TreeNode<T>(value, null);	
	}
	
	// Default constructor
	public BinarySearchTree(){}
	
	// Determines whether or not the tree is empty
	public boolean isEmpty(){
		return root == null;
	}
	
	// Inserts a new value into the tree; returns true if the insertion was successful
	public boolean insert(T value){
		// If no root value exists, then create one
		if(root == null){
			root = new TreeNode<T>(value,null);
		}
		else{
			// Create a temporary node to move through the tree
			TreeNode<T> temp = root;
			while(temp != null){
				// If a value in the node matches the value to be inserted, then no insertion is required
				if(temp.getValue().compareTo(value) == 0)
					// Return false to indicate that no insertion occurred
					return false;
				// If the value to be inserted is smaller than the node value
				else if(temp.getValue().compareTo(value) > 0){
					// Provided that the left subtree exists, move into it
					if(temp.getLeft() != null)
						temp = temp.getLeft();
					// Otherwise, instantiate a new node in the left subtree with the insertion value
					else
						temp.setLeft(new TreeNode<T>(value,temp));
				}
				// If the value to be inserted is larger than the node value
				else{
					// Provided that the right subtree exists, move into it
					if(temp.getRight() != null)
						temp = temp.getRight();
					// Otherwise, instantiate a new node in the right subtree with the insertion value
					else
						temp.setRight(new TreeNode<T>(value,temp));
				}
			}
		}
		// Return true to indicate successful insertion
		return true;
	}
	
	// Deletes the specified value from the tree; returns true if the deletion was successful
	public boolean delete(T value){
		// Create a temporary node to move through the tree
		TreeNode<T> temp = root;
		// Cannot delete anything from an empty tree
		if(isEmpty())
			return false;
		// Deleting the root requires special consideration and is done through a separate method
		if(temp.getValue().equals(value)){
			deleteRoot();
			return true;
		}
		while(true){
			// Checking the left branch of the tree
			if(temp.getValue().compareTo(value) > 0){
				// If the node is null, then you've reached the end of the tree
				if(temp.getLeft() == null)
					break;
				// If the left node's value matches, then delete it
				if(temp.getLeft().getValue().equals(value)){
					// Deletion if node has zero children
					if(temp.getLeft().getDegree() == 0)
						temp.setLeft(null);
					// Deletion if node has one child
					else if(temp.getLeft().getDegree() == 1)
						temp.setLeft(temp.getLeft().getLeft() == null ? temp.getLeft().getRight() : temp.getLeft().getLeft());
					// Deletion if node has two children
					else{
						// temp2 is supposed to reference the largest node in the deleted node's left sub-branch
						TreeNode<T> temp2 = temp.getLeft().getLeft();
						// Find the largest value in the left sub-branch
						while(temp2.getRight() != null)
							temp2 = temp2.getRight();
						// Store the largest value to a temporary variable
						T val = temp2.getValue();
						// Delete the node containing the largest variable
						delete(val);
						// Set the largest variable as the "deleted" node's new value, effectively "deleting" the old value
						temp.getLeft().setValue(val);
					}
				}
				else
					// Move in to the left branch of the tree
					temp = temp.getLeft();
			}
			// Checking the right branch of the tree
			else{
				// If the node is null, then you've reached the end of the tree
				if(temp.getRight() == null)
					break;
				// If the right node's value matches, then delete it
				if(temp.getRight().getValue().equals(value)){
					// Deletion if node has zero children
					if(temp.getRight().getDegree() == 0)
						temp.setRight(null);
					// Deletion if node has one child
					else if(temp.getRight().getDegree() == 1)
						temp.setRight(temp.getRight().getLeft() == null ? temp.getRight().getRight() : temp.getRight().getLeft());
					// Deletion if node has two children
					else{
						// temp2 is supposed to reference the largest node in the deleted node's left sub-branch
						TreeNode<T> temp2 = temp.getRight().getLeft();
						// Find the largest value in the left sub-branch
						while(temp2.getRight() != null)
							temp2 = temp2.getRight();
						// Store the largest value to a temporary variable
						T val = temp2.getValue();
						// Delete the node containing the largest variable
						delete(val);
						// Set the largest variable as the "deleted" node's new value, effectively "deleting" the old value
						temp.getRight().setValue(val);
					}
				}
				else
					// Move in to the right branch of the tree
					temp = temp.getRight();
			}
		} // while		
		// If the value was not found in the tree, then nothing was deleted
		return false;
	}
	
	// The following method deletes the root of the tree
	private void deleteRoot(){
		// If the root doesn't have any child nodes
		if(root.getDegree() == 0)
			root = null;
		// If the root has only one child node
		else if (root.getDegree() == 1)
			root = root.getLeft() != null ? root.getLeft() : root.getRight();
		// If the root has two children
		else{
			// temp represents the largest node in root's left sub-branch
			TreeNode<T> temp = root.getLeft();
			while(temp.getRight() != null)
				temp = temp.getRight();
			// Create a temporary variable to hold the largest value
			T val = temp.getValue();
			// Delete the largest value from the tree
			delete(val);
			// Set root's new value to the largest value, effectively "deleting" the old value
			root.setValue(val);
		}
			
	}
	
	// Note: It is suggested that the programmer override the default toString method of the object 
	// that he or she intends to store into the Binary Search Tree, so that the print method displays
	// more useful information.
	
	// Displays the values of the tree in preorder, inorder, and postorder
	public void print(){
		System.out.print("Preorder - ");
		preorder(root);
		System.out.println("");
		System.out.print("Inorder - ");
		inorder(root);
		System.out.println("");
		System.out.print("Postorder - ");
		postorder(root);
		System.out.println("\n");
	}
	
	// Recursively navigates through the tree and prints the elements in preorder
	public void preorder(TreeNode<T> temp){
		if(temp == null)
			return;
		else{
			System.out.print(temp.getValue() + " ");
			preorder(temp.getLeft());
			preorder(temp.getRight());
		}
	}
	
	// Recursively navigates through the tree and prints the elements in postorder
	public void postorder(TreeNode<T> temp){
		if(temp == null)
			return;
		else{
			postorder(temp.getLeft());
			postorder(temp.getRight());
			System.out.print(temp.getValue() + " ");
		}
	}
	
	// Recursively navigates through the tree and prints the elements in inorder
	public void inorder(TreeNode<T> temp){
		if(temp == null)
			return;
		else{
			inorder(temp.getLeft());
			System.out.print(temp.getValue() + " ");
			inorder(temp.getRight());
		}
	}
}
