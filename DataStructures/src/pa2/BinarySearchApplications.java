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
			if (array[mid] == key) { // If the middle element is the key, update the minimum index and search the left half for an even smaller index
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
			if (array[mid] == key) { // If the middle element is the key, update the maximum index and search the right half for an even larger index
				maxIndex = mid;
				left = mid + 1;
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
	 * @return returns the number of occurrences of key, otherwise returns 0 if key is not the in the array
	 */
	public static int countNumberOfKeys(int array[], int arrayLength, int key) {
		// Get min and max indices using the methods I just wrote
		int minIndex = minIndexBinarySearch(array, arrayLength, key);
		int maxIndex = maxIndexBinarySearch(array, arrayLength, key);

		// Calculate occurrences of key
		if (minIndex >= 0) { // check if key occurs
			return maxIndex - minIndex + 1; // calculate and return key occurrences
		} else { // if key does not occur
			// returning zero instead of using the formula because -1 + -1 + 1 = -1
			// and the method should return 0 because there are no occurrences of the key.
			return 0;
		}

	} // end countNumberOfKeys

	/**
	 * "predecessor" method: Given a set of numbers, the predecessor of a number x is the highest number in the set that is less
	 * than or equal to x. This method returns the predecessor where x = key and the set of numbers = array
	 * 
	 * @param array    the set of numbers searched
	 * @param arrayLen length of the array
	 * @param key      the value being searched for
	 * @return a position in the array where the predecessor of key lies.
	 *         Needless to say that the array is sorted in ascending order.
	 *         If the predecessor of key is not defined, return -1.
	 */
	public static int predecessor(int array[], int arrayLen, int key) {
		// Instantiate search bounds, mix, and predecessor index
		int left = 0;
		int right = arrayLen - 1;
		int mid = -1;
		int predIndex = -1;
		while (left <= right) { // while search range is not empty
			mid = (left + right) / 2;
			if (key == array[mid]) { // if middle element is key, return mid index
				return mid;
			} else if (key > array[mid]) { // set predecessor index equal to mid (it is a good estimate) and search right half of array
				predIndex = mid;
				left = mid + 1;
			} else { // search left half of array
				right = mid - 1;
			}
		}
		// If key was not found, return the predecessor index
		return predIndex;
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
