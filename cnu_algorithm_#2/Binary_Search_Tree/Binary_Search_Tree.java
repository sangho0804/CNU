package Binary_Search_Tree;

//bst
public class Binary_Search_Tree {

	static int nodecount = 1;
	static BSTNode _root;

	public static void main(String[] args) {
		// test 1 and 2
//		 int arr[] = {55,60,90,15,8,3,28,18,45,48,50,41,30,38,33,32,36};
		// test 3
		int[] arr = { 55, 60, 90, 15, 8, 3, 28, 18, 45, 48, 50, 41, 30, 38, 33, 32, 36 };

		// root
		_root = new BSTNode(arr[0]);
		// root value
		for (int i = 1; i < arr.length; i++) {
			treeInsert(_root, arr[i]);
			nodecount++;
		}
		// print
		nodeprint(_root);
		treeDelete(_root, 30);
//		treeDelete(_root, 55);
		nodeprint(_root);
		BSTNode min =  treeMin(_root);
		BSTNode search = treeSearch(_root, 8);
		System.out.println();
		System.out.println("min : " + min.value);
		System.out.println();
		System.out.println("find 8 serch: " + search.value);
		

		System.out.println(nodecount);

	}

	// nodeindexing
	static void nodeindexing(BSTNode node, int[] arr, int index) {
		if (node != null) {
			arr[index - 1] = node.getValue();
			nodeindexing(node.left, arr, index * 2);
			nodeindexing(node.right, arr, index * 2 + 1);
		}
	}

	// nodeprint
	static void nodeprint(BSTNode node) {
		int arr[] = new int[(int) Math.pow(2, nodecount) - 1];
		int count = 1;
		nodeindexing(node, arr, 1);
		int indent = 128;
		System.out.println(arr[0]);
		String format;
		for (int i = 1, j = 1, k = 2; i < arr.length; i++, j++) {
			format = "%-" + Integer.toString(indent) + "d";
			System.out.printf(format, arr[i]);
			if (arr[i] != 0) {
				count++;

			}
			if (count == nodecount) {
				break;
			}
			if (j == k) {
				System.out.println();
				k = k * 2;
				j = 0;
				indent = (int) (indent / 2);
			}
		}
		System.out.println();
	}

	// treeSearch
	static BSTNode treeSearch(BSTNode root, int key) {
		// find root or root null
		if (root == null || key == root.value) {
			return root;
		}
		// recursive find value
		if (key < root.value) {
			return treeSearch(root.getLeft(), key);
		} else {
			return treeSearch(root.getRight(), key);
		}
		
	}

	// treeinsert
	static BSTNode treeInsert(BSTNode root, int key) {
		// if key exist
		BSTNode findNode = treeSearch(root, key);
		if (findNode != null) {
			return findNode;
		}

		// insert node have key
		BSTNode newNode = new BSTNode(key);
		// curent is compare node
		// parent node is parent
		BSTNode parent = null;
		BSTNode current = root;

		// to compare node has null
		while (current != null) {
			parent = current;
			// insert key less than compare node value
			if (key < current.value) {
				current = current.left;
				// without left
				// insert
				if (current == null) {
					parent.left = newNode;
					return newNode;
				}
				// insert key more than compare node value
			} else {
				current = current.right;
				// without right
				// insert
				if (current == null) {
					parent.right = newNode;
					return newNode;
				}
			}
		}
		return newNode;
	}

	// treeMin
	static BSTNode treeMin(BSTNode root) {
		//min has right sub tree
		BSTNode right_sub_node = null;
		BSTNode minNode = root;
		while (minNode.left != null) {
			//min node parent
			right_sub_node = minNode;
			minNode = minNode.left;
		}
		//if minnode has right sub tree
		//min parent left = min node right sub tree
		if (minNode != root) {
			right_sub_node.left = minNode.right;
		}
		return minNode;
	}

	// treeDelete
	static void treeDelete(BSTNode root, int key) {
		nodecount--;
		// compare node
		BSTNode current = root;
		// parent
		BSTNode parent = root;

		// compare left child value flag
		boolean isLeftChild = true;

		// find key
		while (current.value != key) {
			parent = current;
			if (current.value > key) {
				isLeftChild = true;
				current = current.getLeft();
			} else {
				isLeftChild = false;
				current = current.getRight();
			}
			// not exist key in tree
			if (current == null) {
				return;
			}
		}

		// 1. has not child
		if (current.getLeft() == null && current.getRight() == null) {
			// has not child and compare node is root
			if (current == root) {
				_root = null;
			}
			// dissconnet child
			else if (isLeftChild) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
		// 2. only one child
		// have right child
		else if (current.getLeft() == null) {
			BSTNode exchangenode = current.getRight();
			if (current == root) {
				_root = exchangenode;
			} else if (isLeftChild) {
				parent.setLeft(exchangenode);
			} else {
				parent.setRight(exchangenode);
			}
		}
		// have left child
		else if (current.getRight() == null) {
			BSTNode exchangenode = current.getLeft();
			if (current == root) {
				_root = exchangenode;
			} else if (isLeftChild) {
				parent.setLeft(exchangenode);
			} else {
				parent.setRight(exchangenode);
			}
		}

		// 3. have two child
		else {
			// find min in right sub tree
			BSTNode exchangenode = treeMin(current.getRight());
			if (current == root) {
				_root = exchangenode;
			} else if (isLeftChild) {
				parent.setLeft(exchangenode);
			} else {
				parent.setRight(exchangenode);
			}

			if (exchangenode != current.getRight()) {
				exchangenode.setRight(current.getRight());
			}
			exchangenode.setLeft(current.getLeft());
		}

	}

}
