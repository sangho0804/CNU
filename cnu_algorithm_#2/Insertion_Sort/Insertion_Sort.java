package Insertion_Sort;
//insertion_sort
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Insertion_Sort {

	static int count = 0;

	public static void main(String[] args) {
		//fileStream
		String _Sort = "Insertion_sort";
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
	//read
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
	
	//write
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
	//insetion_sort
	public static int[] sort(int[] array) {
		// 1 to array.length repeat
		for(int i = 1; i < array.length; i++) {
			//target
			int target = array[i];
			//before index
			int j = i - 1;
			// all arr index check
			// target > array[j] || j < 0 -> break while 
			while(j >= 0 && target < array[j]) {
				array[j + 1] = array[j];	
				j--;
				//repeat count
				count++;
			}
			//target change
			array[j + 1] = target;
			//repeat count
			count++;
		}
		
		return array;
	}
	
	
}