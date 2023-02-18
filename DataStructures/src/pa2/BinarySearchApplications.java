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
	public static int minIndexBinarySearch(int array[], int arrayLength, int key) {
		// Initialize the left and right endpoints of the search range, and the minimum index where key appears
		int left = 0;
		int right = arrayLength - 1;
		int minIndex = -1;

		while (left <= right) { // While the search range is not empty
			int mid = (left + right) / 2; // Find the middle element of the current range
			if (array[mid] == key) { // If the middle element is the key, update the minimum index
				minIndex = mid;
				right = mid - 1;
			} else if (array[mid] > key) { // If the middle element is greater than the key, search the left half
				right = mid - 1;
			} else { // If the middle element is less than the key, search the right half
				left = mid + 1;
			}
		} // End while

		return minIndex; // Return the minimum index where key appears (or -1 if it does not appear)
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
		// Initialize the left and right endpoints of the search range, and the maximum index where key appears
		int left = 0;
		int right = arrayLength - 1;
		int maxIndex = -1;

		while (left <= right) { // While the search range is not empty
			int mid = (left + right) / 2; // Find the middle element of the current range
			if (array[mid] == key) { // If the middle element is the key, update the maximum index
				maxIndex = mid;
				left  = mid + 1;
			} else if (array[mid] > key) { // If the middle element is greater than the key, search the left half
				right = mid - 1;
			} else { // If the middle element is less than the key, search the right half
				left = mid + 1;
			}
		} // End while

		// Return the maximum index where key appears (or -1 if it does not appear)
		return maxIndex;
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
