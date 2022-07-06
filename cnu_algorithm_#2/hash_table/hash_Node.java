package hash_table;

public class hash_Node {
	//instant value
	hash_Node parent, child;
	int value;
	
	//construct
	public hash_Node(int n) {
		this.parent = null;
		this.child = null;
		this.value = n;
		
	}
	//construct
	public hash_Node(hash_Node p , int n) {
		this.parent  = p;
		this.child = null;
		this.value = n;
	}
	//getter setter start
	
	public void setParent(hash_Node node) {
		this.parent = node;
		
	}
	public void setChild(hash_Node node) {
		this.child = node;
		
	}
	
	public hash_Node getParent() {
		return this.parent;
		
	}
	
	public hash_Node getchild() {
		return this.child;
		
	}
	
	public void setValue(int val) {
		this.value = val;
		
	}
	
	public int getValue() {
		return this.value;
		
	}
	
	
	
	
	
	

}
