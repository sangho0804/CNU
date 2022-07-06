package Dijkstra;

public class DijkstraNode  implements Comparable<DijkstraNode> {
	char name; //name
    int preWeight; // pre weight store
    int nowWeight; // now weight store
    boolean isChanged; // change check
    DijkstraNode preNode; // preNode address

    //construct
    public DijkstraNode() {
    	this.name = '\0';
    	this.preWeight = 0;
    	this.nowWeight = 0;
    	this.isChanged = false;
    	this.preNode = null;
    }
    
    public DijkstraNode(char n, int x){
        name = n;
        preWeight = x;
        nowWeight = x;
    }
    
    // getter / setter
    public char getName() {
		return this.name;
    }
	
    private int getPreWeight() {
		// TODO Auto-generated method stub
    	return this.preWeight;

	}
    public int getNowWeight() {
		// TODO Auto-generated method stub
    	return this.nowWeight;
    	
	}
    public boolean getIsChanged() {
		// TODO Auto-generated method stub
    	return this.isChanged;

	}
    public DijkstraNode getPreNode() {
		// TODO Auto-generated method stub
    	return this.preNode;
    	
	}
    
    public void setName(char name) {
		this.name = name;
    }
	
    public void setPreWeight(int pre) {
		// TODO Auto-generated method stub
    	this.preWeight = pre;

	}
    public void setNowWeight(int now) {
		// TODO Auto-generated method stub
    	this.nowWeight = now;
    	
	}
    public void setIsChanged(boolean is) {
		// TODO Auto-generated method stub
    	this.isChanged = is;

	}
    public void setPreNode(DijkstraNode node) {
		// TODO Auto-generated method stub
    	this.preNode = node;
    	
	}
    

    public int compareTo(DijkstraNode o) {
        //for use prioty que 
        return this.getNowWeight() - o.getNowWeight();
    }

    //node print
    public void print(){
        if(this.getIsChanged()){
           //change print
            System.out.println("d[" + name +"] = " + preWeight + " -> d[" + name + "] = " + nowWeight);
        }else{
            //not print
            System.out.println("d[" + name +"] = " + nowWeight);
        }
        isChanged = false;
    }
}
