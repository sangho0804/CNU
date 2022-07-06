package HuffmanCodes;

import java.util.*;

public class HuffmanCodes {
	//static value
	//node for insert
	static hNode root = new hNode();
	//real root
	static hNode real;
	//input string -> arr[] index
	static int index = 0;
	//result String
	static String result = "";
	//1 or 0 edge
	static char c1 = '1';
	static char c0 = '0';

	//node
	public static class hNode {
		hNode left, right;
		String len;
		String name;
		
		//construct
		public hNode() {
			this.len = "";
			this.name = "";
			this.left = null;
			this.right = null;
		}
		
		public hNode(String name) {
			this.name = name;
		}
		//getter / setter
		public void setLeftNode(hNode node) {
			this.left = node;
		}

		public void setRightNode(hNode node) {
			this.right = node;
		}

		public String getName() {
			return this.name;
		}

	} // node fin

	// treeSet insert
	public static void treeInput(String name, String len) {
		
		//lenth at insert element binary
		char[] len_char;
		len_char = new char[len.length()];
		//sch_nd <- root 
		hNode sch_nd = root;
		//real node
		real = sch_nd;
		
		//store edge
		for (int i = 0; i < len.length(); i++) {
			len_char[i] = len.charAt(i);

		}

		//insert
		for (int i = 0; i < len.length(); i++) {
			if (i < len.length() - 1) {
				if (len_char[i] == c1) {
					if (sch_nd.right == null) {
						sch_nd.setRightNode(new hNode("null_right"));
						sch_nd = sch_nd.right;
					} else {
						sch_nd = sch_nd.right;
					}
				}
				if (len_char[i] == c0) {
					if (sch_nd.left == null) {
						sch_nd.left = new hNode("null_left");
						sch_nd = sch_nd.left;
					} else {
						sch_nd = sch_nd.left;
					}
				}

			} else {
				if (len_char[i] == c1) {
					sch_nd.setRightNode(new hNode(name));
				}
				if (len_char[i] == c0) {
					sch_nd.setLeftNode(new hNode(name));
				}
			}
		}

	}// treeSet fin

	// decode
	public static void decode(String input) {
		
		char arr[];
		int inputLen = input.length();
		arr = new char[inputLen];
		int index = 0;
		
		for (int i = 0; i < inputLen; i++) {
			arr[i] = input.charAt(i);
		}
		
		decodeLine(arr, real, inputLen, index);

	}// decode fin

	
	// decode line
	//recursive method
	public static void decodeLine(char arr[], hNode node, int inputLen, int index) {
		
		//no child
		if (node.right == null && node.left == null) {

			String name = node.getName();
			node = real;
			result += name;

		}
		if (index == inputLen) {
			System.out.println(result);
			return;
		}

		if (arr[index] == c1) {
			decodeLine(arr, node.right, inputLen, index + 1);

		}

		if (arr[index] == c0) {
			decodeLine(arr, node.left, inputLen, index + 1);
		}

	}// decode line fin
	
	//main
	public static void main(String[] args) {
		String input = "0000011011110010101011111111000100101001110000100011100111100010010100110011110111100111000001111110111001110001111111000101001100011100101110101111011010111101011110000101010110010101000001101010110010110111100000000100100011110000110100110100011111110010101111100010010100110011101101010100000110111100101010001111101111001110110101011110011111101010010010001111110111011100101011010101100111110110100111010010010110011100010101101101";

		treeInput(" " ,"111");
		treeInput(".","101101");
		treeInput("G","000000");
		treeInput("T", "000001");
		treeInput("a","1001");
		treeInput("c","110100");
		treeInput("d","0001");
		treeInput("e","1010");
		treeInput("f","000010");
		treeInput("g","110101");
		treeInput("h","10111");
		treeInput("i","01110");
		treeInput("k","01111");
		treeInput("l","000011");
		treeInput("m","101100");
		treeInput("n","0101");
		treeInput("o","001");
		treeInput("r","1100");
		treeInput("s","10000");
		treeInput("t","0110");
		treeInput("u","0100");
		treeInput("v","110110");
		treeInput("w","110111");
		treeInput("y","10001");

		decode(input);

	}
}
