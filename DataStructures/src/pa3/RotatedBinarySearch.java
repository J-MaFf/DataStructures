package pa3;

public class RotatedBinarySearch {

	/**
	 * "search" method: search for a key in a rotated array in O(log n) time
	 * 
	 * @param array  the array to be searched
	 * @param length the length of the array
	 * @param key    the number to be searched for
	 * @return the index where key is found
	 */
	public static int search(int array[], int length, int key) { // complete this function
		// First, aquire values needed for maxIndex call
		int lastValue = array[length - 1];
		int left = 0;
		int right = length - 1;
		// Find max index via method call
		int maxIndex = maxIndex(array, lastValue, left, right);

		// Now search for key
		if (key == array[maxIndex]) // if key is at maxIndex
			return maxIndex; // We have found the key
		else if (key >= array[left]) // if key value is greater than the first element of the array
			return binarySearch(array, left, maxIndex - 1, key); // Then search the first half of the array up to max index
		// else search the second half of the array from after maxIndex to the end of the array
		return binarySearch(array, maxIndex + 1, right, key);
	}

	/**
	 * "maxIndex" method: Searches for the index of the maximum value in a rotated array. We will use recursion
	 * 
	 * @param array     the array to be searched
	 * @param lastValue the last value in the array
	 * @param left      the left index
	 * @param right     the right index
	 * @return the index of the maximum value
	 */
	public static int maxIndex(int array[], int lastValue, int left, int right) { // complete this function
		// Base case
		if (left == right) // if array has only one element
			return left;
		// Array has more than one element if this code is reached
		int mid = (left + right) / 2;
		if (array[mid] > array[mid + 1]) // max is at mid
			return mid;
		else if (array[mid] < lastValue) // max is to the left of mid
			return maxIndex(array, lastValue, left, mid - 1);
		else // max is to the right of mid
			return maxIndex(array, lastValue, mid + 1, right);

	}

	/**
	 * "binarySearch" method: Searches for a key in a sorted array.
	 * 
	 * @param array the array to be searched
	 * @param left  the left index
	 * @param right the right index
	 * @param key   the number to be searched for
	 * @return the index of the key if found, -1 otherwise
	 */
	public static int binarySearch(int array[], int left, int right, int key) {
		if (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] < key)
				return binarySearch(array, mid + 1, right, key);
			else
				return binarySearch(array, left, mid - 1, key);
		}
		return -1;
	}
}
