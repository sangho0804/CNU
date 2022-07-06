package Heap_Sort;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Heap_Sort {
	static int count = 0;
	static int max_show = 10;
	public static void main(String[] args) {
		// fileStream

		String _Sort = "Heap_sort";
		String filePath = "./data03.txt";
		String out_filePath = "hw03_00_201802170_" + _Sort + ".txt";
		System.out.println(_Sort);
		// read
		int[] array = read(filePath);
		// write
		write(heapSort(array), out_filePath);

//debug
//		int[] array = {7,8,5,9,6,2,4,0,1,3};
//		heapSort(array);
//		for(int i =0; i < array.length; i++) {
//			System.out.print(array[i] + " ");
//		}
//		
//		System.out.println();
		
		
		System.out.println(count);

	}

	// read_func
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

	// write_fun
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

	// arr_read
	public static void print_array(int[] array) {

		for (int i = 0; i < max_show; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	// heap_sort_func
	public static int[] heapSort(int[] array) {
		//variable size have arr length
		int size = array.length;
		//build max heap
		build_max_heap(array);
		//sort
		for(int i = array.length; i >= 1; i--) {
			//swap first idx < - > last idx
			//move the max
			swap(array, 0, i-1);
			//in order to Exclud max
			size = size - 1;
			//after swap
			//first idx heapify
			max_heapify(array, 1, size);
		}
		
		return array;
		
	}
	


	//build max heap
	public static void build_max_heap(int[] array) {
		//variable size have arr length
		int size = array.length;
		//build
		
		for(int i = size/2; i > 0; i--) {
			max_heapify(array, i, size);
		}
//		System.out.println("fin_build");
		
	}

	//max heapify
	public static void max_heapify(int[] array , int i , int size) {
		//left child
		int l = 2*i;
		//right child
		int r = 2*i + 1;
		//variable largest
		int largest = 0;
		
		// left child more then parent
		if(l <= size && array[l-1] > array[i-1]) {
			largest = l;
		}
		//not
		else {
			largest = i;
		}
		//then 
		//// right child more then parent or left child
		if(r <= size && array[r-1] > array[largest-1]) {
			largest = r;
			
		}
		
		//When parent node is not the biggest
		if (largest != i) {
			swap(array, i-1, largest-1);
			max_heapify(array, largest,size);
		}
		//time complexity
		count++;
		
//debug
//		System.err.println("heapfiy");
//		for(int _i = 0; _i < array.length; _i++) {
//			System.out.print(+array[_i] + " ");
//		}
//		System.out.println();
		
	}
	


	// swap arr[i] < - > arr[j]
	public static void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
//debug
//		System.out.println("swap");
//		for(int _i =0; _i < a.length; _i++) {
//			System.out.print(a[_i] + " ");
//		}
//		System.out.println();
		
		
	}
}
