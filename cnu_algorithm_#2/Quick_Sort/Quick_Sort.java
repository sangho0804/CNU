package Quick_Sort;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.sound.midi.Patch;

public class Quick_Sort {
	static int count = 0;
	static int max_show = 10;

	public static void main(String[] args) {
		// fileStream

		String _Sort = "Quick_sort";
		String filePath = "./data02.txt";
		String out_filePath = "hw02_00_201802170_" + _Sort + ".txt";
		System.out.println(_Sort);
		// read
		int[] array = read(filePath);
		// write
		write(quickSort(array.clone(), 0, array.length - 1), out_filePath);

		System.out.println(count);
		
		_Sort = _Sort + "withRandomizePartition";
		System.out.println(_Sort);
		count = 0;
		print_array(array);
		write(quickSort_withRandom(array, 0, array.length - 1), out_filePath);
		
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

	// quick_sort_func
	public static int[] quickSort(int[] array, int p, int r) {
		// sort
		if (p < r) {
			int mid = partition(array, p, r);
			quickSort(array, p, mid - 1);
			quickSort(array, mid + 1, r);
		}
		return array;
	}
	
	// quick_sort_func
	public static int[] quickSort_withRandom(int[] array, int p, int r) {
		// sort
		if (p < r) {
			int mid = Randomized_partition(array, p, r);
			quickSort(array, p, mid - 1);
			quickSort(array, mid + 1, r);
		}
		return array;
	}

	// partition
	public static int partition(int[] array, int p, int r) {
		//right index value 
		int x = array[r];
		//temp reft index
		int i = p-1;
		//variable for repeat condition 
		int j = p;
		//partition start
		if(p < r) {
			//while
			while (j < r) {
				//reft <= right
			if (array[j] <= x) {
				i = i+1;
				swap(array, i, j);
			}
			j++;
			count++;
			}
		}
		swap(array, i + 1, r);
		return i + 1;
	}
	//randomized partition
	//in order to prevent worst time complexity 
	public static int Randomized_partition(int[] array, int p ,int r) {
		int i = (int)((p+r+1)*Math.random());
		swap(array, r, i);
		return partition(array, p, r);
		
	}

	// swap arr[i] < - > arr[j]
	public static void swap (int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
