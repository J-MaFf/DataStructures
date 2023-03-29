package pa4;
/**
 * Program: HashingWithChaining.java
 * Author: Joey Maffiola
 * Class: COMPSCI 223
 * Date: Mar 21, 2023
 */
import java.util.Iterator;
import java.util.LinkedList;

public class HashingWithChaining {

	LinkedList<Integer> hashTable[];
	int TABLE_SIZE;

	/**
	 * @param tableSize
	 */
	@SuppressWarnings("unchecked")
	public HashingWithChaining(int tableSize) {
		TABLE_SIZE = tableSize;
		hashTable = (LinkedList<Integer>[]) new LinkedList[TABLE_SIZE]; // this ain't a good method but java does not support array of generics;
		// should ideally use an array list with space reserved
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = new LinkedList<Integer>();
	}

	/**
	 * "getHashValue" method: retrives the hash value for a given key
	 * 
	 * @param val the key
	 * @return the hash value
	 */
	private int getHashValue(int val) {
		return (37 * val + 61) % TABLE_SIZE;
	}

	/**
	 * "getList" method: returns the linked list at a given index
	 * 
	 * @param index the index
	 * @return the linked list
	 */
	public LinkedList<Integer> getList(int index) {
		return hashTable[index];
	}

	/**
	 * "search" method: searches for a given key in the hash table
	 * 
	 * @param key the key
	 * @return true if the key is found, false otherwise
	 */
	public boolean search(int key) { // complete this method
		// First we shall retrieve the hash value
		int keyHashValue = getHashValue(key);

		// Search hash table for hash value, resulting in the linked list that would have the value, if present
		LinkedList<Integer> searchList = getList(keyHashValue); // Gets the list we need to search
		Iterator<Integer> listIterator = searchList.iterator(); // Create the iterator

		int val;
		while (listIterator.hasNext()) {
			val = listIterator.next(); // val = the current node (int) in the linked list
			// Check if val == key
			if (val == key) {
				return true;
			}

		}
		// Value was not found
		return false;

	}

	/**
	 * "insert" method: Inserts a value into the hash table if it is not already present
	 * 
	 * @param val the value to be inserted
	 * @return true if the value was inserted, false otherwise
	 */
	public boolean insert(int val) { // complete this method
		// If hash table already contains the value, return false
		if (search(val))
			return false;

		// The hash table does not contain the value. Therefore, let's add the val to the hash table

		// First we shall retrieve the hash value
		int keyHashValue = getHashValue(val);
		LinkedList<Integer> list = getList(keyHashValue); // Gets the list we need to search
		list.add(val); // Add the value to the list
		return true;
	}

	/**
	 * "remove" method: Removes a value from the hash table if it is present
	 * 
	 * @param val the value to be removed
	 * @return true if the value was removed, false otherwise
	 */
	public boolean remove(int val) { // complete this method
		// If hash table does not contain the value, return false
		if (!search(val))
			return false;

		// The hash table contains the value. Therefore, let's remove the val from the hash table
		Iterator<Integer> listIterator = getList(getHashValue(val)).iterator(); // Create the iterator
		int value;
		while (listIterator.hasNext()) {
			value = listIterator.next(); // value = the current node (int) in the linked list
			// Check if value == val
			if (value == val) {
				listIterator.remove(); // Remove the value from the list
				return true;
			}
		}
		// Value was not found
		return false;
	}

	/**
	 * "printStatistics" method: prints the statistics of the hash table
	 */
	public void printStatistics() {
		int maxSize = hashTable[0].size();
		int minSize = maxSize, total = maxSize;
		for (int i = 1; i < TABLE_SIZE; i++) {
			int size = hashTable[i].size();
			if (size > maxSize)
				maxSize = size;
			else if (size < minSize)
				minSize = size;
			total += size;
		}
		System.out.printf(
				"Max length of a chain = %d%n" + "Min length of a chain = %d%n" + "Avg length of chains = %d%n",
				maxSize, minSize, total / TABLE_SIZE);
	}
}
