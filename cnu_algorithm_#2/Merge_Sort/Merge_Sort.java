package Merge_Sort;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Merge_Sort {
	static int count = 0;
	static int max_show = 10;

	public static void main(String[] args) {
		//fileStream
		
		String _Sort = "Merge_sort";
		String filePath = "./data02.txt";
		String out_filePath = "hw02_00_201802170_" + _Sort + ".txt";
		System.out.println(_Sort);
		//read
		int[] array = read(filePath);
		//sort
		array = mergeSort(array, 0, array.length-1);
		//write
		write(array, out_filePath);

		System.out.println(count);

	}
	//read_func
	public static int[] read(String _path) {
		String contents = "";
		try (FileInputStream fstream = new FileInputStream(_path);) {

			byte[] rb = new byte[fstream.available()];
			while (fstream.read(rb) != -1) {
			}
			fstream.close();
			contents = new String(rb);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		StringTokenizer st = new StringTokenizer(contents, ",");
		int[] array = new int[st.countTokens()];
		for (int i = 0; st.hasMoreElements(); i++)
			array[i] = Integer.parseInt(st.nextToken());

		print_array(array);

		return array;
	}
	//write_fun
	public static void write(int[] array, String out_filePath) {
		print_array(array);

		String str = "";
		for (int i = 0; i < array.length - 1; i++)
			str += Integer.toString(array[i]) + ",";
		str += Integer.toString(array[array.length - 1]);
		try (FileWriter fw = new FileWriter(out_filePath);) {
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//arr_read
	public static void print_array(int[] array) {
		
		for (int i = 0; i < max_show; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	//merge_sort_func
	public static int[] mergeSort(int[] array, int p , int r) {
		//sort
		if ( p < r) {
			//mid set
			int mid = (p+r)/2 ;
			//sort
			mergeSort(array, p, mid);
			mergeSort(array, mid+1, r);
			merge(array, p, mid, r);
		}
		return array;

	}
	//merge
	public static void merge(int[] array, int p, int mid, int r) {
		//find sub arrays size
		int n1 = mid - p + 1;
		int n2 = r - mid;
		//left / right temp array 
		int L[] = new int[n1+1];
		int R[] = new int[n2+1];
		
		//temp index copy
		for(int i = 0; i < n1; i++) {
			L[i] = array[p+i];
		}
		for(int j = 0; j < n2; j++ ) {
			R[j] = array[mid+j+1];
		}

		
		//last index value set max_value
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		//merge
		for(int k = p; k <= r; k++) {
			if(L[i] <= R[j]) {
				array[k] = L[i];
				i ++;
			}
			else {
				array[k] = R[j];
				j++;
			}
			count++;
			
		}
		
	}

}
