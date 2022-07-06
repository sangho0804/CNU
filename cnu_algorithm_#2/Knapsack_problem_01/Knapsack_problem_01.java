package Knapsack_problem_01;

import java.util.Iterator;

public class Knapsack_problem_01 {
	
	//static value
	static  int[][] item = {{1,1} , {6,2} , {18,5}, {22,6} , {28,7} }; //value , wight
	static int [][] table;
	static int wight = 11;
	static int n = 5;
	
	//main
	public static void main(String[] args) {
		
		//table
		table = new int[n+1][wight+1];

		//insert
		for (int h = 0; h < n+1; h++) {
			for(int k =0; k < wight+1; k++) {
				table[h][k] = opt(h, k);
			}
		}
		
		//wight print
		System.out.println("wight : " +  wight);
		
		//table print
		for (int i = 0; i < n+1; i++) {
			for(int j = 0; j < wight+1; j++) {
				System.out.printf("%5d" , table[i][j]);		
			}
			System.out.println();
		}
		//max print
		//if inserted correctly , last index in table is max value 
		System.out.println("max : " + table[n][wight]);

	}
	
	//opt
	public static int opt(int index, int wight) {
		//index  = null or wight = 0
		if(index == 0 || wight == 0) {
			return 0;
		}
		// weight of the item > set wight
		else if(item[index-1][1] > wight) {
			return opt(index - 1,  wight);
		}
		//otherwise
		//find optimized value
		else {
			return theMax(opt(index-1,  wight), item[index-1][0] + opt(index-1, wight - item[index-1][1]));
		}
		
	}

	public static int theMax(int x, int y) {
		int max = (x > y) ? x : y ;
		return max;	
	}
}
