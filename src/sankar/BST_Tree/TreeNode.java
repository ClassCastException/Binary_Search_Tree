package sankar.BST_Tree;

/*
 * The TreeNode class acts as a storage container to be used with the BinarySearchTree class. It contains mostly accessor
 * and mutator methods. It also contains references to its left and right subtrees along with its parent node. This class
 * is designed in a manner that allows it to be used by other data structures beyond the Binary Search Tree.
 */

public class TreeNode<T> {
	T value;
	TreeNode<T> left, right, parent;
	
	// Constructor
	public TreeNode(T value, TreeNode<T> parent){
		this.value = value;
		left = null;
		right = null;
		this.parent = parent;
	}
	
	// Returns the number of child nodes the node has
	public int getDegree(){
		int degree = 0;
		if(left != null)
			degree++;
		if(right != null)
			degree++;
		return degree;
	}
	
	public TreeNode<T> getParent(){
		return parent;
	}
	
	public TreeNode<T> getLeft(){
		return left;
	}
	
	public TreeNode<T> getRight(){
		return right;
	}
	
	public T getValue(){
		return value;
	}
	
	public void setLeft(TreeNode<T> t){
		left = t;
	}
	
	public void setRight(TreeNode<T> t){
		right = t;
	}
	
	public void setValue(T v){
		value = v;
	}	
}
