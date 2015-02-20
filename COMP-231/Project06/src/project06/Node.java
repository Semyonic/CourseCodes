package project06;

public class Node {
	
	/**
	 * @author Semih Onay
	 */
	
	Node left;
	Node right;
	KeyValue keyV;

	public Node(KeyValue keyV) {
		this.keyV = keyV;
	}
	
	public Node(KeyValue keyV, Node left, Node right){
		this.keyV = keyV;
		this.left = left;
		this.right = right;
	}
	
	public Node(KeyValue keyV, Node left, boolean right){
		if(!right){
		this.keyV = keyV;
		this.left = left;
		}
	
	}
	
	public Node(KeyValue keyV, boolean left, Node right){
		if(!left){
		this.keyV = keyV;
		this.right = right;
		}
	}
	
	public void setLeft(Node node){
		this.left = node;
	}
	
	public void setRight(Node node){
		this.right = node;
	}
	
}