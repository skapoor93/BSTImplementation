import java.util.Stack;

/**
 * Class for Binary Search Tree
 * 
 * @author Shivam Kapoor
 *
 */
public class BinaryTrees {

	Node root;

	/**
	 * Parameterized constructor
	 * 
	 * @param data
	 */
	public BinaryTrees(int data){
		this.root = new Node(data);
	}

	/**
	 * Default Constructor
	 */
	public BinaryTrees(){
		root = null;
	}

	/**
	 * Iterative inorder traversal
	 * 
	 * @param root
	 */
	public void iterativeInOrderTraversal(Node root)
	{
		if(root==null)
			System.out.println("Tree is empty");
		else
		{
			Node current = root;
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || current!=null)
			{
				if(current!=null)
				{
					stack.push(current);
					current = current.getLeft();
				}
				else
				{
					Node temp = stack.pop();
					System.out.print(temp.getData()+" ");
					current = temp.getRight();
				}
			}
		}
	}
	
	/**
	 * Iterative pre order traversal
	 * 
	 * @param root
	 */
	public void iterativePreOrderTraversal(Node root){
		if(root==null){
			System.out.println("Tree is empty");
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node temp = stack.pop();
			System.out.println(temp.getData());
			if(temp.getRight()!=null)
				stack.push(temp.getRight());
			if(temp.getLeft()!=null)
				stack.push(temp.getLeft());
		}
	}
	
	/**
	 * Iterative post order traversal
	 * 
	 * @param root
	 */
	public void iterativePostOrderTraversal(Node root){
		if (root == null) {
			return;
		}
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node node = root;
		s1.push(node);
		while (!s1.isEmpty()) {
			Node temp = s1.pop();
			s2.push(temp);
			if(temp.getLeft() != null) {
				s1.push(temp.getLeft());
			}
			if(temp.getRight() != null) {
				s1.push(temp.getRight());
			}
		}
		while(!s2.isEmpty()) {
			Node temp = s2.pop();
			System.out.print(temp.getData() + " ");
		}
	}
	
	/**
	 * Recursive post order traversal
	 * 
	 * @param root
	 */
	public void recursivePostOrderTraversal(Node root){
		if(root != null){
			recursivePostOrderTraversal(root.getLeft());
			recursivePostOrderTraversal(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}

	/**
	 * Recursive inorder traversal
	 * 
	 * @param root
	 */
	public void recursiveInorderTraversal(Node root){
		if(root != null){
			recursiveInorderTraversal(root.getLeft());
			System.out.print(root.getData()+" ");
			recursiveInorderTraversal(root.getRight());
		}
	}

	/**
	 * Recursive preorder traversal
	 * 
	 * @param root
	 */
	public void recursivePreOrderTraversal(Node root){
		if(root!=null){
			System.out.print(root.getData()+" ");
			recursivePreOrderTraversal(root.getLeft());
			recursivePreOrderTraversal(root.getRight());
		}
	}
}


class Node{
	private Node left;
	private Node right;
	private int data;

	public Node(int data) {
		super();
		this.data = data;
		left = null;
		right = null;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}