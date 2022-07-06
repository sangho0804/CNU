package DFS;

import java.util.Iterator;
import java.util.LinkedList;

//DFS
public class DFS {
	//static variable
	static int numOfVertices;
	static LinkedList<DFS_Node> arr[];
	static Iterator<DFS_Node> iterator;
	static int starttime , lasttime;

	//make vertex
	public DFS(int n) {
		numOfVertices = n;
		int word = 117;

		arr = new LinkedList[numOfVertices];
		for (int i = 0; i < numOfVertices; i++) {
			DFS_Node node = new DFS_Node();
			arr[i] = new LinkedList<DFS_Node>();
			int word_ascii = word + i;
			char name = (char) word_ascii;
			node.setName(name);
			node.setIndex(i);
			arr[i].add(node);
		}
		
		
	}
	//make edge
	public void addEdge(int n, int insert) {
		DFS_Node node = arr[insert].element();
		arr[n].add(node);
	}
	//DFS start
	//use recursive method
	static void DFS_set() {
		starttime = 0;
		//exception handling : vertex not found
		for(int k = 0; k < numOfVertices; k++) {
			if(arr[k].element().getColor() == "white") {
				DFS_visit(k);
			}
		}
	}
	//DFS_set
	static void DFS_visit(int i) {
		//startime
		starttime += 1;
		//first node
		DFS_Node curnode = arr[i].element();
		curnode.setStart(starttime);
		curnode.setColor("gray");
		iterator = arr[i].iterator();
		//parent node
		DFS_Node prenode = curnode;
		//iterator
		while(iterator.hasNext()) {
			curnode = iterator.next();
			
			if(curnode.getColor() == "white") {
				curnode.setParent(prenode);
				//deep serch
				//recusive draw close
				DFS_visit(curnode.getIndex());
			}
		}
		//fin serch
		prenode.setColor("black");
		//fin time
		starttime += 1;
		prenode.setLast(starttime);
	
		
		
	}
	//main
	public static void main(String args[]) {
		// bfs
		DFS dfs = new DFS(6);
		// bfs edge
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 4);
		dfs.addEdge(1, 4);
		dfs.addEdge(2, 4);
		dfs.addEdge(2, 5);
		dfs.addEdge(3, 1);
		dfs.addEdge(4, 3);
		dfs.addEdge(5, 5);
		
		DFS_set();
		
		//print
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%10s", arr[i].element().getName());
		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%10s", arr[i].element().getColor());
		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].element().getParent() == null) {
				System.out.printf("%10s", "null");

			} else {
				System.out.printf("%10s", arr[i].element().getParent().getName());
			}

		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%10s", arr[i].element().getStart());
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%10s", arr[i].element().getLast());
		}
		System.out.println();

	}
	

}
