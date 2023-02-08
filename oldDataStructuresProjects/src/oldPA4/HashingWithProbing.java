package oldPA4;

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

	public HashingWithProbing(int tableSize) {
		TABLE_SIZE = tableSize;
		size = 0;
		garbage = 0;
		hashTable = new int[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = EMPTY;
	}

	private void resize(int newTableSize) { // complete this method
		// First create an array keys[ ] of length size; here, the class variable size reflects the actual number of values that are
		// present in the hash table.
		int keys[] = new int[size];
		// Now go through hashTable[ ] (whose length is given by TABLE SIZE) and collect the values that are ≥ 0 into the keys[ ] table.
		int ticker = 0;
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (hashTable[i] >= 0) {
				keys[ticker] = hashTable[i];
				ticker++;
			}
		} // end for
			// Now, set TABLE SIZE = newTableSize, and allocate TABLE SIZE many cells for hashTable[ ]. Then, use a loop to fill up
			// hashTable[] with EM P T Y . Refer to the constructor for something similar
		TABLE_SIZE = newTableSize;
		hashTable = new int[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = EMPTY;
		// Set oldSize = size, size = 0, and garbage = 0. Here, garbage reflects the number of Tombstones in the table, which is set to 0
		// because resizing will ignore tombstones
		size = 0;
		garbage = 0;
		// Finally run a loop and insert every value in the keys[ ] array back into the hashTable[ ]; use the insert method to this end.
		for (int i = 0; i < keys.length; i++) {
			insert(keys[i]);
		} // end for
			// Note that size will be restored to the initial value by the insert method.

	} // end resize

	public int search(int key) { // complete this method
		// Obtain the hashValue for the key using the getHashValue method.
		int hashVal = getHashValue(key);
		// Run a loop TABLE SIZE many times. Within the loop, do the following:
		for (int i = 0; i < TABLE_SIZE; i++) {
			// If hashTable[hashVal] equals key, then we have found key at index hashValue; so, return hashValue
			if (hashTable[hashVal] == key) {
				return hashVal;
			} // If hashTable[hashValue] equals EMPTY , then we have reached an empty slot; so, return −1
			else if (hashTable[hashVal] == EMPTY) {
				return -1;
			} // end if / else if
				// Increment hashValue; this means we are essentially probing to the next slot.
			hashVal++;
			// If hashValue equals TABLE SIZE, we have reached the end of the array in the probe sequence; so, reset hashValue = 0.
			if (hashVal == TABLE_SIZE) {
				hashVal = 0;
			} // end if
		} // end for
			// If the loop terminates, we have traversed the entire table and never found key; so, return −1
		return -1;
	} // end search

	public int insert(int val) { // complete this method
		// If the table is full (i.e., size + garbage equals TABLE SIZE), then we resize the hash table by calling the resize method with
		// 2 ∗size as argument.
		if (size + garbage == TABLE_SIZE) {
			resize(2 * size);
		} // end if
			// Obtain the hashValue for the key using the getHashValue method.
		int hashVal = getHashValue(val);
		// Run a loop TABLE SIZE many times. Within the loop, do the following:
		for (int i = 0; i < TABLE_SIZE; i++) {
			// If hashTable[hashValue] equals val, then we have found val at index hashValue; so, return −1 (insertion is not needed)
			if (hashTable[hashVal] == val) {
				// insertion not needed
				return -1;
			}
			// If hashTable[hashValue] equals EMPTY , then we have reached an empty slot; so, break away from the loop (no further probe is
			// needed)
			else if (hashTable[hashVal] == EMPTY) {
				break;
			}
			// Increment hashValue; this means we are essentially probing to the next slot
			hashVal++;
			// If hashValue equals TABLE SIZE, we have reached the end of the array in the probe sequence; so, reset hashValue = 0
			if (hashVal == TABLE_SIZE) {
				hashVal = 0;
			}
		} // end for
			// set hashTable[hashValue] = val and increment size
		hashTable[hashVal] = val;
		size++;
		// return hashValue, the index at which the insertion was carried out
		return hashVal;

	} // end insert

	public int remove(int val) { // complete this method
		// Obtain index by calling the search method with val as argument.
		int index = search(val);
		// If index is less than 0, then val is not present in the table; so, there is nothing to delete and we return −1.
		if (index < 0) {
			return -1;
		} // end if
			// Set hashTable[index] = TOMBSTONE, increment garbage, and decrement size
		hashTable[index] = TOMBSTONE;
		garbage++;
		size--;
		// return index, the index at which the deletion was carried out
		return index;

	} // end remove
} // end class
