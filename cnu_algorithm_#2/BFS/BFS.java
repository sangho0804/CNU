package BFS;

import java.util.*;
//BFS
public class BFS {
	//static variable
	static int numOfVertices; //size
	static LinkedList<BFS_Node> arr[]; //near list
	static Iterator<BFS_Node> iterator; //iterator
	static int step; //step

	//make vertex
	public BFS(int n) {
		numOfVertices = n;
		//ascii -> 'r' start
		int word = 114;

		arr = new LinkedList[numOfVertices];
		
		for (int i = 0; i < numOfVertices; i++) {
			BFS_Node node = new BFS_Node();
			arr[i] = new LinkedList<BFS_Node>();
			int word_ascii = word + i;
			char name = (char) word_ascii;
			node.setName(name);
			node.setIndex(i);
			arr[i].add(node);

		}
	}
	
	//make edge and near list
	public void addEdge(int n, int insert) {
		BFS_Node node = arr[insert].element();
		arr[n].add(node);
	}
	//BFS
	static void BFS(int s) {
		//variable
		step = s;
		LinkedList<BFS_Node> queue = new LinkedList<>();
		BFS_Node start = arr[1].element(); //start node
		//set start
		start.setColor("gray");
		start.setStep(step);
		start.setParent(null);
		
		//for execute loop
		queue.add(start);
		//use near list 
		//BFS start
		while (queue.size() != 0) {
			//current node
			BFS_Node curNode = queue.poll();
			//parent node
			BFS_Node preNode = curNode;
			//iterator
			iterator = arr[curNode.getIndex()].iterator();
			//BFS start
			while (iterator.hasNext()) {
				curNode = iterator.next();
				
				if (curNode.getColor() == "gray") {
					curNode.setColor("black");

				}

				if (curNode.getColor() == "white") {

					curNode.setColor("gray");

					curNode.setParent(preNode);

					curNode.setStep(curNode.getParent().getStep() + 1);

					queue.add(curNode);

				}

			}

		}
		//BFS fin

	}

	public static void main(String args[]) {
		// bfs
		BFS bfs = new BFS(8);
		// bfs edge
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 4);
		bfs.addEdge(1, 0);
		bfs.addEdge(1, 5);
		bfs.addEdge(2, 3);
		bfs.addEdge(2, 5);
		bfs.addEdge(2, 6);
		bfs.addEdge(3, 2);
		bfs.addEdge(3, 6);
		bfs.addEdge(3, 7);
		bfs.addEdge(4, 0);
		bfs.addEdge(5, 1);
		bfs.addEdge(5, 2);
		bfs.addEdge(5, 6);
		bfs.addEdge(6, 2);
		bfs.addEdge(6, 3);
		bfs.addEdge(6, 7);
		bfs.addEdge(7, 6);
		bfs.addEdge(7, 3);
		
		//set BFS
		BFS(0);
		
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
			System.out.printf("%10s", arr[i].element().getStep());
		}
		System.out.println();

	}
}
