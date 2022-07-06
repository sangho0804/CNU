package DFS;


public class DFS_Node {
	//instant value
		DFS_Node parent;
		DFS_Node child;
		int index;
		char name;
		int start;
		int last;
		//color
		String color;
		
		//construct
		public DFS_Node() {
			this.parent = null;
			this.child = null;
			this.index = 0;
			this.name = ' ';
			this.color ="white";
			this.start = 0;
			this.last = 0;
		}

		//getter setter start
		
		public void setParent(DFS_Node node) {
			this.parent = node;
			
		}

		public DFS_Node getParent() {
			return this.parent;
			
		}
		
		public void setChild(DFS_Node node) {
			this.child = node;
			
		}

		public DFS_Node getChild() {
			return this.child;
			
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
		public void setStart(int s) {
			this.start = s;
			
		}
		
		public int getStart() {
			return this.start;
			
		}
		public void setLast(int s) {
			this.last = s;
			
		}
		
		public int getLast() {
			return this.last;
			
		}
		
		
		
}
