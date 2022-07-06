package hash_table;

import java.util.Hashtable;
import java.util.Iterator;

public class hash_table {
	// static variable
	static int Hash_table_Length = 10;

	public static void main(String[] args) {
		int[] arr = {55,60,90,15,8,3,28,18,45,48,50,41,30,38,33,32,36};
		hash_Node[] Hash_table = new hash_Node[Hash_table_Length];
		for (int i = 0; i < arr.length; i++) {
			hash_Insert(Hash_table, arr[i]);
			
		}
		hash_Print(Hash_table);
	
		
//		hash_Delete(Hash_table, 8);
//		hash_Print(Hash_table);
		
//		hash_Delete(Hash_table, 18);
//		hash_Print(Hash_table);
//		
		hash_Delete(Hash_table, 38);
		hash_Print(Hash_table);
	}
	//hash function
	// key % 10
	//have index 0 ~ 9
	static int hash_function(int key) {
		return (key % 10);
	}
	//hash insert
	static void hash_Insert(hash_Node[] Hash_table, int value) {
		//have key use hash function
		int hash_key = hash_function(value);
		hash_Node pNode = Hash_table[hash_key];
		//insert
		if (pNode == null) {
			hash_Node node = new hash_Node(null, value);
			Hash_table[hash_key] = node;
		}
		//not empty in hash table key place 
		else {
			
			while(true) {
				if(pNode.getchild() != null) {
					pNode = pNode.getchild();
				}
				else {
					hash_Node node = new hash_Node(pNode, value);
					pNode.setChild(node);
					break;
				}
			}
		}
	}
	//hash search
	static hash_Node hash_Search(hash_Node[] Hash_table, int value) {
		//have key use hash function
		int hash_key = hash_function(value);
		hash_Node sNode = Hash_table[hash_key];
		//search node
		//next child if not equal
		while(true) {
			if(sNode.getValue() == value) {
				break;
			}
			else {
				sNode = sNode.getchild();
			}
		}
		return sNode;
		
	}

	
	//hash delete
	static void hash_Delete(hash_Node[] Hash_table, int value) {
		hash_Node target = hash_Search(Hash_table, value);
		//have not parent and have child
		if (target.getParent() == null && target.getchild() != null) {
			Hash_table[hash_function(value)] = target.getchild();
		}
		//have parent and have not child
		else if(target.getParent() != null && target.getchild() == null) {
			target.getParent().setChild(null);
			
		}
		//have not parent and have not child
		else if(target.getParent() == null && target.getchild() == null) {
			Hash_table[hash_function(value)] = null;
			
		}
		//have parent and have child
		else if(target.getParent() != null && target.getchild() != null) {
			target.getParent().setChild(target.getchild());
			
		}
		
	}

	// hash_print
	static void hash_Print(hash_Node[] Hash_table) {
		hash_Node hash_Node = null;
		int count = 1;
		for (int i = 0; count != 0; i++) {
			count = 0;
			for (int j = 0; j < Hash_table.length; j++) {
				hash_Node = Hash_table[j];
				for (int k = 0; (hash_Node != null) && (k < i); k++) {
					if (hash_Node.getchild() != null) {
						hash_Node = hash_Node.getchild();
					} else {
						hash_Node = null;
						break;
					}

				}
				if (hash_Node != null) {
					System.out.printf("%-8d", hash_Node.getValue());
					count++;
				} else {
					System.out.printf("%-8d", 0);
				}

			}
			System.out.println();

		}
		System.out.println();

	} // end print

}
