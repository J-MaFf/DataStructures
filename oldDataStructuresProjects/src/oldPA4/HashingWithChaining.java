package oldPA4;

import java.util.Iterator;
import java.util.LinkedList;

public class HashingWithChaining {

	LinkedList<Integer> hashTable[];
	int TABLE_SIZE;

	@SuppressWarnings("unchecked")
	public HashingWithChaining(int tableSize) {
		TABLE_SIZE = tableSize;
		hashTable = (LinkedList<Integer>[]) new LinkedList[TABLE_SIZE]; // this ain't a good method but java does not support array of generics;
		// should ideally use an array list with space reserved
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = new LinkedList<Integer>();
	}

	private int getHashValue(int val) {
		return (37 * val + 61) % TABLE_SIZE;
	}

	public LinkedList<Integer> getList(int index) {
		return hashTable[index];
	}

	public boolean search(int key) { // complete this method
		// obtain hash value for key using getHashValue
		int hashVal = getHashValue(key);
		// use getList to get the linked list from the hashTable[ ] for this hash value
		LinkedList<Integer> list = getList(hashVal);
		// iterate through this linked list using an iterator.
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			int next = iterator.next();
			// If the iterator’s value equals key, then the list contains the key; so, return true.
			if (next == key) {
				return true;
			} // end if
		} // end while
			// Once the iteration completes, return false.
		return false;
	}

	public boolean insert(int val) { // complete this method
		// Remember that your hash table should contain a number only once. So, first use search to check if the hash table already
		// contains val. If it does, then return false.
		if (search(val) == true) {
			return false;
		} // end if
			// Obtain the hash value for val using getHashValue function.
		int hashVal = getHashValue(val);
		// use getList to get the linked list from the hashTable[ ] for this hash value.
		LinkedList<Integer> list = getList(hashVal);
		// Now, insert the value at the end of the linked list, and return true.
		list.add(val);
		return true;

	}

	public boolean remove(int val) { // complete this method
		// First obtain the hash value for val using getHashValue function.
		int hashVal = getHashValue(val);
		// Use getList to get the linked list from the hashTable[ ] for this hash value.
		LinkedList<Integer> list = getList(hashVal);
		// Now, iterate through this linked list using an iterator.
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			int next = iterator.next();
			// If the iterator’s value equals val, then the list contains val; so, delete using the iterator and return true.
			if (next == val) {
				iterator.remove();
				return true;
			} // end if
		} // end while
			// Once the iteration completes, return false.
		return false;
	}

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
		System.out.printf("Max length of a chain = %d%n" + "Min length of a chain = %d%n" + "Avg length of chains = %d%n", maxSize, minSize, total / TABLE_SIZE);
	}
}
