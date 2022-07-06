package BFS;

public class BFS_Node {
	//instant value
	BFS_Node parent;
	int index;
	char name;
	int step;
	String color;
	
	//construct
	public BFS_Node() {
		this.parent = null;
		this.index = 0;
		this.name = ' ';
		this.color ="white";
		this.step = 0;
	}

	//getter setter start
	
	public void setParent(BFS_Node node) {
		this.parent = node;
		
	}

	public BFS_Node getParent() {
		return this.parent;
		
	}
	
	
	public void setIndex(int val) {
		this.index = val;
		
	}
	
	public int getIndex() {
		return this.index;
		
	}
	
	public void setName(char name) {
		this.name = name;
		
	}
	
	public char getName() {
		return this.name;
		
	}
	public void setColor(String color) {
		this.color = color;
		
	}
	
	public String getColor() {
		return this.color;
		
	}
	public void setStep(int s) {
		this.step = s;
		
	}
	
	public int getStep() {
		return this.step;
		
	}
	//getter / setter fin
	
	

}
