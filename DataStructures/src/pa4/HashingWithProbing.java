package pa4;

public class HashingWithProbing {

	public int hashTable[];
	public int TABLE_SIZE;
	public int size;
	public int garbage;

	public static final int EMPTY = -1;
	public static final int TOMBSTONE = -9;

	private int getHashValue(int val) {
		return (37 * val + 61) % TABLE_SIZE;
	}

	/**
	 * @param tableSize
	 */
	public HashingWithProbing(int tableSize) {
		TABLE_SIZE = tableSize;
		size = 0;
		garbage = 0;
		hashTable = new int[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = EMPTY;
	}

	/**
	 * "resize" method: resizes the hash table to a new size
	 * 
	 * @param newTableSize the new size
	 */
	private void resize(int newTableSize) { // complete this method
	}

	/**
	 * "search" method: searches for a given key in the hash table
	 * 
	 * @param key the key
	 * @return the index of the key if found, -1 otherwise
	 */
	public int search(int key) { // complete this method
	}

	/**
	 * "insert" method: inserts a given key in the hash table
	 * 
	 * @param val the key
	 * @return the index of the key if inserted, -1 otherwise
	 */
	public int insert(int val) { // complete this method
	}

	/**
	 * "remove" method: removes a given key from the hash table
	 * 
	 * @param val the key
	 * @return the index of the key if removed, -1 otherwise
	 */
	public int remove(int val) { // complete this method
	}
}
