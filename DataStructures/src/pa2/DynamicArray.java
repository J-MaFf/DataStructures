package pa2;

import java.util.Arrays;

/**
 * Program: DynamicArray.java Author: Joey Maffiola Class: COMPSCI 223 - Data Structures Date: Feb 22, 2023
 */
public class DynamicArray {

	int A[];
	int numElements;
	int length;

	/**
	 * @param initialSize the initial size of the array
	 */
	public DynamicArray(int initialSize) {
		numElements = 0;
		length = initialSize;
		A = new int[initialSize];
	}

	/**
	 * "copyArray" method: Helper function that creates an array tmp[] of size newArrayLen if arrayLen <= newArrayLen, then copies
	 * array[] to tmp[] else
	 * copies the first newArrayLen elements of array[] into tmp[]
	 * 
	 * @param array       the array to be copied
	 * @param arrayLen    the length of array
	 * @param newArrayLen the new length of the array
	 * @return if arrayLen <= newArrayLen, then copies array[] to tmp[] else copies the first newArrayLen elements of array[] into
	 *         tmp[]
	 */
	private int[] copyArray(int[] array, int arrayLen, int newArrayLen) {
		int[] tmp = new int[newArrayLen];
		if (arrayLen <= newArrayLen) {
			for (int i = 0; i < arrayLen; i++)
				tmp[i] = array[i];
		} else {
			for (int i = 0; i < newArrayLen; i++)
				tmp[i] = array[i];
		}
		return tmp;
	}

	/**
	 * "access" method: allows access to an element of the array
	 * 
	 * @param index the index of the element to be accessed
	 * @return the value of the element at index
	 */
	public int access(int index) {
		if (index >= numElements)
			throw new ArrayIndexOutOfBoundsException();
		return A[index];
	}

	/**
	 * "update" method: allows updating an element of the array
	 * 
	 * @param index the index of the element to be updated
	 * @param val   the new value of the element at index
	 */
	public void update(int index, int val) {
		if (index >= numElements)
			throw new ArrayIndexOutOfBoundsException();
		A[index] = val;

	}

	/**
	 * "insertAtEnd" method: inserts a new element at the end of the array
	 * 
	 * @param val the value of the new element
	 */
	public void insertAtEnd(int val) {
		// Check to see if there is room in the array
		if (numElements == length) { // if array is full
			// Resize array to twice its length
			int newArrayLen = length * 2;
			A = copyArray(A, length, newArrayLen);
			length = newArrayLen;
		}
		// Add value to the end of the array
		A[numElements++] = val;
	}

	/**
	 * "deleteLast" method: deletes the last element of the array
	 */
	public void deleteLast() {
		// Check to see if array is empty
		if (numElements == 0) {
			System.out.println("Cannot delete from an empty array");
		} else if (numElements == 1) { // check if array only has one element
			numElements = 0;
			int newLen = 1;
			A = copyArray(A, length, newLen);
			length = newLen;
		} else {
			numElements--;
			// Check to see if array is only 1/4 full
			if (4 * numElements == length) {
				// Get new array length
				int newLen = numElements * 2;
				// Set array to copied array with new length
				A = copyArray(A, length, newLen);
				length = newLen;
			}
		}
	}

	/**
	 * "getSize" method: gets the number of elements in the array
	 * 
	 * @return the number of elements in the array
	 */
	public int getSize() {
		return numElements;
	}

	/**
	 * "toString" method: returns a string representation of the array
	 */
	public String toString() {

		return Arrays.toString(Arrays.copyOfRange(A, 0, numElements));
	}
}
