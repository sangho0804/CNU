package Union_Find;

public class Union_Find {
	
	public static void main(String[] args) {
		int k = 10;
		int[] arr = new int[k];
		for(int i = 0; i < arr.length; i++ ) {
			arr[i] = i;
		}
			Union(arr , 8 , 1);
			Union(arr , 5 , 1);
			Union(arr , 0 , 1);
			Union(arr , 5 , 9);
			Union(arr , 7 , 2);
			Union(arr , 6 , 4);
			print(arr);

		
	}
	
	
	//find
	static int find(int[] arr , int x) {
		//value == index
		if(arr[x] == x) {
			return x;
		}
		//value != index
		else
			//find parent
			return find(arr, arr[x]);
	}
	
	//union
	static void Union(int[] arr, int x, int y) {
		// TODO Auto-generated method stub
		//parent of x
		int fx = find(arr, x);
		//parent of y
		int fy = find(arr, y);
		
		//chain
		if(fx < fy) {
			arr[fy] = fx;
		}
		else 
			arr[fx] = fy;
			
	
	}
	
	static void print(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%-4d" ,i);
			for(int j = i; j < arr.length; j++) {
				if((j == i) && (arr[j] != i)) {
					break;
				}
				if(arr[j] == i) {
					System.out.print(j +" ");
					if(i != j) {
						print_recursive(arr , j);
					}
				}
			}
			System.out.println();
		}
	}
	
	static void print_recursive(int[] arr, int index) {
		for(int i = index; i < arr.length; i++) {
			if(arr[i] == index) {
				System.out.print(i + " ");
				if( i != index)	{
					print_recursive(arr, i);
				}
			}
		}
	}

}
