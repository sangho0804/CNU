package Dijkstra;

import java.util.*;

public class Dijkstra {
	//static value
	//max size
	//for compare to weight
	static int inf = Integer.MAX_VALUE;
	static PriorityQueue<DijkstraNode> que = new PriorityQueue<>();
	
	//main
    public static void main(String[] args) {
    	int[][] t = {{0, 10, 5,inf,inf},{inf,0,2,1,inf},{inf,3,0,9,2},{inf,inf,inf,0,4},{7,inf,inf,6,0}};    
        dijkstra_run(t,inf);
    }   
    
    //initialize
    public static void initialize(int[][] t, int inf) {
    	
        for(int i = 0; i < t.length; i++){
            // 65+i = A
        	//so insert name for A to ~ 
        	DijkstraNode node = new DijkstraNode((char)(65+i),inf);
            que.add(node);
        }
    }
    

    public static void dijkstra_run(int[][] table, int inf){
        
    	initialize(table, inf);
    	// instant value
        DijkstraNode temp = que.poll();
        temp.setNowWeight(0);
        int index;
        LinkedList<DijkstraNode> dij_list = new LinkedList<>();
        Iterator<DijkstraNode> itrator;
        
        for(int i = 0; i < table.length; i++){
            index = temp.getName() - 65;
            
            System.out.println("------------------------------");
            System.out.print("S[" + i + "] : ");
            temp.print();
            System.out.println("------------------------------");

            for(int j = 0; j < table[index].length; j++){
                if(table[index][j] != 0 && table[index][j] != inf){
                    while(!que.isEmpty()){
                        dij_list.addFirst(que.poll());
                        if(dij_list.peek().name - 65 == j){
                            relax(dij_list.peek(),temp,table[index][j]);
                        }
                    }
                    while(!dij_list.isEmpty()){
                        que.add(dij_list.poll());
                    }
                }
            }

            //print at leftover que
            itrator = que.iterator();
            while(itrator.hasNext()){
                itrator.next().print();
            }
            if(que.isEmpty()){
                break;
            }
            //smallest element in que store temp
            temp = que.poll();
        }
    }

    public static void relax(DijkstraNode node, DijkstraNode preNode, int x){
        int temp = preNode.nowWeight + x;
        //nowNode weight compare to preNode weight + weight 
        if(node.nowWeight > temp){
            node.preWeight = node.nowWeight;
            node.nowWeight = temp;
            node.preNode = preNode;
            node.isChanged = true;
        }
    }


    
}