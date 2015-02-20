package project06;

public class AVL{
	
	/**
	 * @author Semih Onay
	 */
	
	// - Node - //
	Node node;
	
	public AVL(){
		
	}
	
	public AVL(Node node){
		this.node = node;
	}
	
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	public int checkBalance(){
		return checkBalance(node);
	}
	
	public Node rLeft(){
		return rLeft(node);
	}
	
	public Node rRight(){
		return rRight(node);
	}
	public Node rLeft(Node node){
		Node root =node;
		Node left = root.left;
		Node right = root.right;
		Node rLeft = right.left;
		Node rRight = right.right;
		root = new Node(root.keyV,left,rLeft);
		right = new Node(right.keyV,root,rRight);
		return right;
	}
	
	public Node rRight(Node node){
		Node root = node;
		Node left = root.left;
		Node right = root.right;
		Node lLeft = left.left;
		Node lRight = left.right;
		root = new Node(root.keyV, lRight, right);
		left = new Node(left.keyV, lLeft, root);
		return left;
	}
	
	// - Checking the AVL tree - //
	public int check(Node node){
		if(height(node.right)-height(node.left)>=2){
			return 1;
		}
		else if(height(node.left) - height(node.right)>=2){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	// - Calculate Height - //
	public static int height(Node node){

		if (node == null){
			return 0;
		}
		
		int heightLeft = height(node.left);
		int heightRight = height(node.right);

		if( heightLeft > heightRight ){
			return heightLeft +1;
		}
		else{
			return heightRight +1;
		}
	}
	
	// - Insert node to Tree - //
	public Node insert(KeyValue key){
            
		if(node == null){
			node = new Node(key);
		}
		else{
			node = insert(node, new Node(key));
		}
		if(check(node)==0){
			return node;
		}
		else if(check(node)==1){
			node = rLeft(node);
			return node;
		}
		else{
			node = rRight(node);
			return node;
		}
	}
	
	// - Insert node to Tree - //
	public Node insert(Node node, Node node_x){
		if(node == null){
			return node_x;
		}
		if(node_x.keyV.key>node.keyV.key){
			return new Node(node.keyV,node.left,insert(node.right,node_x));
		}
		else{
			return new Node(node.keyV, insert(node.left, node_x), node.right);
		}
	}
	
	// - Delete node from Tree - //
	public Node delete(int key){
		if(node == null){
			System.out.println("Node is empty...");
		}
		else{
			node = deleteNode(key, node);
		}
		if(check(node)==0){
			return node;
		}
		else if(check(node)==1){
			node = rLeft(node);
			return node;
		}
		else{
			node = rRight(node);
			return node;
		}
	}	
	
	public Node deleteNode(int x, Node node ) {
        if( node == null ){
        	return null;
        }
        if(x <node.keyV.key){
        	node.left = deleteNode(x, node.left);
        }   
        else if(x >node.keyV.key){
        	node.right = deleteNode(x, node.right );
        }
        else if(node.left != null && node.right != null){
            node.keyV = findMin(node.right).keyV;
            node.right = removeMin(node.right);
        } 
        else{
            node = ( node.left != null ) ? node.left : node.right;
        }
        return node;
    }
	
	public Node removeMin( Node node ) {
        if( node == null ){
        	return node;
        }
        else if( node.left != null ){
            node.left = removeMin( node.left );
            return node;
        } 
        else{
        	 return node.right;
        }    
    }
	// - Find Node (which has minimum key value) - //
	public Node findMin( Node node ){
		if( node != null ){
			while( node.left != null ){
				node = node.left;
			}
		} 
		return node;
	}
}