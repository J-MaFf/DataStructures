package pa4;
/**
 * Program: HashingWithProbing.java
 * Author: Joey Maffiola
 * Class: COMPSCI 223
 * Date: Mar 21, 2023
 */

public class HashingWithProbing {

	public int hashTable[]; // the hash table
	public int TABLE_SIZE; // the size of the hash table
	public int size; // the number of values in the hash table
	public int garbage; // the number of tombstones in the hash table

	public static final int EMPTY = -1;
	public static final int TOMBSTONE = -9;

	/**
	 * @param tableSize the size of the hash table
	 * @param size      the number of values in the hash table
	 * @param garbage   the number of tombstones in the hash table
	 * @param EMPTY     the value of an empty slot
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
	 * "getHashValue" method: returns the hash value of a given key
	 * 
	 * @param val the key
	 * @return the hash value
	 */
	private int getHashValue(int val) {
		return (37 * val + 61) % TABLE_SIZE;
	}

	/**
	 * "resize" method: resizes the hash table to a given size
	 * 
	 * @param newTableSize the new size
	 */
	private void resize(int newTableSize) { // complete this method
		// First create an array keys[ ] of length size
		int[] keys = new int[size]; // size = number of values in the hash table

		int k = 0; // k is the index of keys[]

		// Copy values that are >= 0 from hashTable[ ] to keys[ ]
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (hashTable[i] >= 0) {
				keys[k] = hashTable[i];
				k++;
			}
		}
		// Now all the values are in keys[ ]. We can now create a new hash table
		TABLE_SIZE = newTableSize; // Set the new table size
		hashTable = new int[TABLE_SIZE]; // Create a new hash table
		for (int i = 0; i < TABLE_SIZE; i++) {
			hashTable[i] = EMPTY; // Set all values to EMPTY
		}
		int oldSize = size; // Set the old size to the current size
		size = 0; // Reset the size
		garbage = 0; // Reset the garbage

		// Now we can insert the values from keys[ ] into the new hash table
		for (int i = 0; i < oldSize; i++) {
			insert(keys[i]);
		}
		// Now the hash table has been resized

	}

	/**
	 * "search" method: searches for a given key in the hash table
	 * 
	 * @param key the key
	 * @return the index of the key if found, -1 otherwise
	 */
	public int search(int key) { // complete this method
		// Obtain the hash value of the key
		int hashValue = getHashValue(key);

		for (int i = 0; i < TABLE_SIZE; i++) {
			if (hashTable[hashValue] == key)
				return hashValue;
			if (hashTable[hashValue] == EMPTY) // we have reached an empty slot
				return -1;
			hashValue++; // increment the hash value
			if (hashValue == TABLE_SIZE) // we have reached the end of the array in the probe sequence
				hashValue = 0; // reset the hash value to 0
		}
		// If we get here, the key is not in the hash table
		return -1;
	}

	/**
	 * "insert" method: inserts a given key in the hash table if it is not already present
	 * 
	 * @param val the key
	 * @return the index of the key if inserted, -1 otherwise
	 */
	public int insert(int val) { // complete this method
		// if the table is full, resize it
		if (size + garbage == TABLE_SIZE) {
			resize(2 * TABLE_SIZE);
		}
		// Obtain the hash value of the key
		int hashValue = getHashValue(val);

		// Probe the hash table until we find an empty slot
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (hashTable[hashValue] == val) // the key is already in the hash table
				return -1;
			if (hashTable[hashValue] == EMPTY) // we have reached an empty slot
				break;

			// Getting here means the current slot is full
			hashValue++; // Probe the next slot
			if (hashValue == TABLE_SIZE) // We have reached the end of the array in the probe sequence
				hashValue = 0; // wrap around to the beginning of the array
		}
		// Getting here means we have found an empty slot
		hashTable[hashValue] = val;
		size++;
		return hashValue; // return the index where the insertion took place

	}

	/**
	 * "remove" method: removes a given key from the hash table
	 * 
	 * @param val the key
	 * @return the index of the key if removed, -1 otherwise
	 */
	public int remove(int val) { // complete this method
		// Obtain index where the key is
		int index = search(val);

		if (index < 0) // the key is not in the hash table
			return -1;
		// Getting here means the key is in the hash table, so we can remove it
		hashTable[index] = TOMBSTONE;
		garbage++;
		size--;
		return index; // return the index where the removal took place
	}
}
