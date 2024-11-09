package BinaryTree;
public class BST {
	public class Node{
		private int value;
		private int height;
		private Node left;
		private Node right;
		public Node(int value) {
			this.value = value;
		}
		public int getValue() {
			return value; 
		}
	}
	private Node root;
	public BST() {
		
	}
	public int height(Node node) {
		if(node==null)return -1;
		return node.height;
	}
	public boolean isEmpty() {
		return root==null;
	}
	public void insert(int value) {
		root=insert(root,value);
	}
	public Node insert(Node node,int value) {
		if(node==null) {
			Node newnode = new Node(value);
			return newnode;
			
		}
		if(node.value>value) {
			node.left = insert(node.left,value);
		}
		if(node.value<value) {
			node.right = insert(node.right,value);
		}
		node.height=Math.max(height(node.left),height(node.right))+1;
		return node;
	}
	public boolean balanced() {
		return balanced(root);
	}
	private boolean balanced(Node node) {
		if(root==null)return true;
		return Math.abs(height(node.left)-height(node.right))<=1&&balanced(node.left)&&balanced(node.right);
	}
	public void display() {
		display(this.root,"Root Node: ");
	}
	private void display(Node node,String details) {
		if(node==null)return;
		System.out.println(details+node.value);
		display(node.left,"left child of "+node.value+" : ");
		display(node.right,"right child of "+node.value+" : ");
	}
	public void populate(int[] nums) {
		for(int i:nums) {
			insert(i);
		}
	}
}