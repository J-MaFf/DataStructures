package pa2;

/**
 * Program: BinarySearchApplications.java
 * Author: Joey Maffiola
 * Class:
 * Date: Feb 17, 2023
 */
public class BinarySearchApplications {

	/*
	 * Caution: Your code should have complexity O(log n), where n = arrayLength. If your code
	 * ends up scanning the entire array (has a complexity O(n)), you will be awarded partial credit, even
	 * if you get the correct output.
	 */

	/**
	 * "minIndexBinarySearch" method: Finds and returns the first occurrence of key
	 * 
	 * @param array       the array to be searched
	 * @param arrayLength the length of the array
	 * @param key         the key to be searched for
	 * @return the minimum index where key appears. If key does not appear, then returns -1.
	 */
	public static int minIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method
		int left = 0;
		int right = arrayLength - 1;
		int minIndex = -1;
		// find first occurrence of key
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == key) {
				minIndex = mid;
				right = mid - 1;
			} else if (array[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		} // end while
		return minIndex;

	} // end minIndexBinarySearch

	/**
	 * "maxIndexBinarySearch" method:
	 * 
	 * @param array       the array to be searched
	 * @param arrayLength the length of the array
	 * @param key         the key to be searched for
	 * @return the maximum index where key appears. If key does not appear, then returns -1.
	 */
	public static int maxIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method

	} // end maxIndexBinarySearch

	/**
	 * "countNumberOfKeys" method:
	 * 
	 * @param array       the array to be searched
	 * @param arrayLength the length of the array
	 * @param key         the key to be searched for
	 * @return 0 if key is not the in the array, else it returns the number of occurrences of key.
	 */
	public static int countNumberOfKeys(int array[], int arrayLength, int key) { // complete this method

	} // end countNumberOfKeys

	/**
	 * "predecessor" method:
	 * 
	 * @param array
	 * @param arrayLen
	 * @param key
	 * @return
	 */
	public static int predecessor(int array[], int arrayLen, int key) { // complete this method

	} // end predecessor

	/**
	 * "findPeak" method:
	 * 
	 * @param twoToneArray
	 * @param arrayLen
	 * @return
	 */
	public static int findPeak(int twoToneArray[], int arrayLen) { // complete this method

	} // end findPeak
} // end class BinarySearchApplications
