package oldPA2;
/**
 * Program: BinarySearchApplications.java
 * Author: Joey Maffiola
 * Class: COMPSCI 172-01
 * Date: Sep 27, 2021
 */
public class BinarySearchApplications {

	/**
	 * Min index binary search.
	 *
	 * @param array       the array
	 * @param arrayLength the array length
	 * @param key         the key the function is searches for in array
	 * @return the minimum index where key appears. If key does not appear, then returns −1.
	 */
	public static int minIndexBinarySearch(int array[], int arrayLength, int key) { //
		// find the first occurrence of a given number in a sorted integer array
		// initialize the minimum index = -1
		int minIndex = -1;
		// Set left and right bounds of array
		int left = 0;
		int right = arrayLength - 1;

		while (left <= right) {
			// find mid
			int mid = (left + right) / 2;
			// If key is found, update minIndex, and search towards the left
			if (array[mid] == key) {
				minIndex = mid;
				right = mid - 1;
			}
			// if the key is less than the element at the mid index, discard right half
			else if (array[mid] > key) {
				right = mid - 1;
			}
			// if the key is greater than the element at the mid index, discard left half
			else {
				left = mid + 1;
			} // end if / else if / else

		} // end while
		return minIndex;

	}// end minIndexBinarySearch

	/**
	 * Max index binary search.
	 *
	 * @param array       the array
	 * @param arrayLength the array length
	 * @param key         the key the function is searches for in array
	 * @return he maximum index where key appears. If key does not appear, then returns −1.
	 */
	public static int maxIndexBinarySearch(int array[], int arrayLength, int key) {
		// find the last occurrence of a given number in a sorted integer array
		// initialize the minimum index = -1
		int maxIndex = -1;
		// Set left and right bounds of array
		int left = 0;
		int right = arrayLength - 1;

		while (left <= right) {
			// Find mid
			int mid = (left + right) / 2;
			// if key is found, update maxIndex and search to the right
			if (array[mid] == key) {
				maxIndex = mid;
				left = mid + 1;
			}
			// else if key is less than the element at the mid index, discard right half
			else if (array[mid] > key) {
				right = mid - 1;
			}
			// if the key is greater than the element at the mid index, discard left half
			else {
				left = mid + 1;
			} // end if / else if / else
		} // end while
		return maxIndex;
	} // end maxIndexBinarySearch

	/**
	 * Count number of keys.
	 *
	 * @param array       the array
	 * @param arrayLength the array length
	 * @param key         the key the function is searches for in array
	 * @return the number of times the key appears in the array. If key does not appear, then returns −1.
	 */
	public static int countNumberOfKeys(int array[], int arrayLength, int key) { // Returns 0 if key is not the in the array, else it returns the number of occurrences of key.
		int maxIndex = maxIndexBinarySearch(array, arrayLength, key);
		int minIndex = minIndexBinarySearch(array, arrayLength, key);
		if (maxIndex < 0 || minIndex < 0) {
			return 0;
		} else if (maxIndex == minIndex) {
			return 1;
		} else {
			return (maxIndex - minIndex) + 1;
		} // end if / else

	}

	/**
	 * Predecessor.
	 *
	 * @param array    the array
	 * @param arrayLen the array len
	 * @param key      the key the function is searches for in array
	 * @return a position in the array where the predecessor of key lies.
	 *         Needless to say that the array is sorted in ascending order. If the
	 *         predecessor of key is not defined, return −1.
	 */
	public static int predecessor(int array[], int arrayLen, int key) {
		// returns a position in the array where the predecessor of key lies. Needless to say that the array is sorted in ascending order.
		// If the predecessor of key is not defined, return −1.
		int predIndex = -1;
		int left = 0;
		int right = arrayLen - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] < key) {
				predIndex = mid;
				left = mid + 1;
			} else if (array[mid] == key) {
				return mid;
			} // end else if
				// if key is less than the element at the mid index, discard right half
			else if (array[mid] > key) {
				right = mid - 1;
			}
			// if the key is greater than the element at the mid index, discard left half
			else {
				left = mid + 1;
			} // end if / else if / else
		} // end while
		return predIndex;
	} // end predecessor

	/**
	 * Find peak.
	 *
	 * @param twoToneArray the two tone array
	 * @param arrayLen     the array len
	 * @return the index in the array that contains the maximum. The array does not need to be sorted
	 */
	public static int findPeak(int twoToneArray[], int arrayLen) { // complete this method
		int left = 0;
		int right = arrayLen - 1;
		while (left <= right) {
			int peak = -1;
			int mid = (left + right) / 2;
			// If left equals right, return left.

			if (twoToneArray[left] == twoToneArray[right]) {
				return left;
			} // If right = left + 1, return left or right whichever contains the larger value.
			else if ((twoToneArray[right] == twoToneArray[left + 1]) || twoToneArray[left] == twoToneArray[right - 1]) {
				if (twoToneArray[left] > twoToneArray[right]) {
					return left;
				} else {
					return right;
				} // end if / else
			} // end if / else if

			// If A[mid] is smaller than A[mid + 1], then set left = mid + 1
			if (twoToneArray[mid] < twoToneArray[mid + 1]) {
				left = mid + 1;
			} else if (twoToneArray[mid] < twoToneArray[mid - 1]) {
				right = mid - 1;
			} else {
				return mid;
			} // end if / else if/ else
		} // end while
		return -1; // no max found (unreachable I believe)
	} // end findPeak
} // end class
