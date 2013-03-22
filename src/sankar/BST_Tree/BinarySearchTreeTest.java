package sankar.BST_Tree;

import java.util.Scanner;

/* 
 * The following code is designed to test out the Binary Search Tree data structure by allowing the user to input values into the tree.
 * In this case, two trees are instantiated to test the trees ability to handle generic values (one that receives integer objects and
 * one that receives string objects). The user can insert and delete values from both trees and print out all values from both trees.
 * The user must first manipulate the tree that receives integer values before manipulating the tree that receives string values.
 */

//                        COMMANDS
//                        ========

// insert x   => Will insert the value "x" into the tree
// delete x   => Will delete the value "x" from the tree
// print      => Will print out the values of the tree

// Note: The commands are not case sensitive.

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = "";
		// Instantiate a new Binary Search Tree that takes in Integer objects
		BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		System.out.println("The tree you are inserting into takes in integer values only.");
		// Allow the user to enter commands until the user types in "quit"
		while(!command.equalsIgnoreCase("quit")){
			System.out.println("Please enter a command that you would like to perform.");
			command = sc.next();
			if(command.equalsIgnoreCase("insert")){
				// Checks to see if next value in the input stream is an integer
				if(sc.hasNextInt())
					intTree.insert(sc.nextInt()); // Only works for Java 5's autoboxing feature
			}
			if(command.equalsIgnoreCase("print")){
				intTree.print();
			}
			if(command.equalsIgnoreCase("delete")){
				// Checks to see if the next value in the input stream is an integer
				if(sc.hasNextInt())
					intTree.delete(sc.nextInt()); // Only works for Java 5's autoboxing feature
			}
			// Clear anything left in the input stream's buffer
			sc.nextLine();
		}
		// Reset the value of command
		command = "";
		// Instantiate a new Binary Search Tree that takes in String objects
		BinarySearchTree<String> stringTree = new BinarySearchTree<String>();
		System.out.println("The tree that you are inserting into takes in string values only.");
		// Allow the user to enter commands until the user types in "quit"
		while(!command.equalsIgnoreCase("quit")){
			System.out.println("Please enter a command that you would like to perform.");
			command = sc.next();
			if(command.equalsIgnoreCase("insert")){
				// Checks to see if there is another value in the input stream
				if(sc.hasNext())
					stringTree.insert(sc.next());
			}
			if(command.equalsIgnoreCase("print")){
				stringTree.print();
			}
			if(command.equalsIgnoreCase("delete")){
				// Checks to see if there is another value in the input stream
				if(sc.hasNext())
					stringTree.delete(sc.next());
			}
			// Clear anything left in the input stream's buffer
			sc.nextLine();
		}
		// Close the scanner
		sc.close();
	}

}
