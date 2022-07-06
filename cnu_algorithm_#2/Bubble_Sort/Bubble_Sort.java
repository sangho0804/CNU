package Bubble_Sort;
//bublble_sort

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Bubble_Sort {

	static int count = 0;

	public static void main(String[] args) {
		//fileStream
		
		String _Sort = "Bubble_sort";
		String filePath = "./data01.txt";
		String out_filePath = "hw01_00_201802170_" + _Sort + ".txt";
		System.out.println(_Sort);
		//read
		int[] array = read(filePath);
		//sort
		array = sort(array);
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
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	//bubble_sort_func
	public static int[] sort(int[] array) {
		// 1 to array.legth repeat
		for (int i = 1; i < array.length; i++) {
			// 0 to array.length -i repeat
			for (int j = 0; j < array.length - i; j++) {
				// if before arr value > after arr value
				// swap
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
				//repeat count
				count++;
			}
		}
		return array;
	}

	// swap arr[i] < - > arr[j]
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
