package Binary_Search_Tree;
//node
public class BSTNode{
	BSTNode left, right;
	int value;
	
	//construct
	public BSTNode() {

		left = null;
		right = null;
		value = 0;

	}
	
	public BSTNode(int n) {

		left = null;
		right = null;
		value = n;
	}
		
	public void setLeft(BSTNode node) { // setter
		this.left = node;
	}
	public void setRight(BSTNode node) { // setter
		this.right = node;
	}
	public BSTNode getLeft() { // getter
		return this.left;
	}
	public BSTNode getRight() { // getter
		return this.right;
	}

	
	public void setValue(int val) { // setter
		this.value = val;
	}
	public int getValue() { // getter
		return this.value;
	}
	
	public boolean isEndNode() { // no child
		return ((this.left == null) && (this.right == null));
	}
	

	
}
