import java.util.*;
/**
 * 
 * @author Kevin
 *
 */

/* BStree.java is a class that creates a binary tree that organizes a set of random number inorder.
 * The only data structure used was an array to store the random numbers. An array was used because i only need an int type stored and 
 * i knew the fixed size of the array.
 * No user input is required. Program works itself.
 */
public class BStree {
	//random generator
	static Random ran = new Random();
	//root node, head of the tree 
	Node root;
	 //method to add the node to the tree
	 public void addNode(int number){
		 //first node is set to the parameters of Node class constructor
		 Node newNode = new Node(number);
		 //if this is the first node
		 if(root ==null)
			 root = newNode;
		 
		 else{
			 //the current node is set to the root
			Node mainNode = root;
			 // every node has a parent node
			 Node parent;
			 
			 while(true){
				 //parent is set to current node
				 parent = mainNode;
				 //if the number being passed through is less then the current node is moved to the left
				 if(number < mainNode.number){
					 mainNode = mainNode.leftChild;
					 //if the node is null returns
					 if(mainNode == null){
						 parent.leftChild = newNode;
						 return;
					 }
					 //else the object must be greater than or equal to so it goes right
					 }else{
						 mainNode = mainNode.rightChild;
						 if(mainNode == null){
							 parent.rightChild = newNode;
							 return;
						 }
					 }
						 
				 }
			 }
		 }

	 //recursive transversal
	 //infix numbers are not organized
	 //post fix numbers are organized
	 public void getInOrder(Node mainNode){
		 //continues until current node is equal to node
		 if(mainNode != null){
			 //recalls method for left node
			 getInOrder(mainNode.leftChild);
			 
			 System.out.println(mainNode);
			 //recalls method for right node
			 getInOrder(mainNode.rightChild);
		 }
		 
	 }
	 
	 public static void main(String[] args) {
		 //array is declared and set to 100 size
		int[] randomNumbers = new int[100];
		//for loop sets each array box with a random number 1-99
		for(int i=0;i<randomNumbers.length;i++)
			randomNumbers[i] = ran.nextInt(98)+1;
		//output text to show array of random numbers
		System.out.println("Array of Random Numbers. Range of (1-99).");
		System.out.println(Arrays.toString(randomNumbers)); 
		
		//tree is declared with this class
		BStree tree = new BStree();
			
		//for loop passes every array number through tree using addNode method
		for(int i: randomNumbers)
			tree.addNode(i);
		
		//calls recursive function to organize nodes
		tree.getInOrder(tree.root);		
	 }
}

//Node class
class Node{
	//number imported from array
	int number;
	/*leftChild and rightChild nodes are used to determine where the next integer from array goes.
	 * In tree a less number goes left and a number greater than or equal to goes right.
	 */
	Node leftChild;
	Node rightChild;
	//constructor sets parameter number to int number declared in class
	Node(int number){
		this.number = number;
	}
	//to string text
	public String toString(){
		return number + " ";
	}
	
}