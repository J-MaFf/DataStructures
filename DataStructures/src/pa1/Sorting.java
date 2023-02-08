package pa1;
public class Sorting {

	/**
	 * "selectionSort" method: sorts an array in non-decreasing order.
	 * This happens by checking each index against the previous index, and the smaller number is stored to a variable
	 * named small. This continues till the end of the array, and then swaps the smallest number with index[0]. This
	 * repeats for each index of the array.
	 * 
	 * @param array    the array to be sorted.
	 * @param arrayLen the length of the array.
	 */
	public static void selectionSort(int[] array, int arrayLen) { // complete this method
		// The first loop sets the starting index of the sub-array
		for (int i = 0; i < arrayLen - 1; i++) {
			int minIndex = i;
			// The second loop compares index values to each other, and swaps as needed
			for (int j = i; j < arrayLen; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j; 
				} 
			} // end for
			int smallNum = array[minIndex];
			array[minIndex] = array[i];
			array[i] = smallNum;
		} // end for
	} // end selectionSort

	/**
	 * "insertionSort" method: sorts an array in non-decreasing order.
	 * This happens by looping through the array to find the smallest value. Then, the algo
	 * swaps the smallest value with the index before it repeatedly untill the smallest value
	 * is in index i (0 to start). 
	 * @param array the array to be sorted.
	 * @param arrayLen the length of the array.
	 */
	public static void insertionSort(int[] array, int arrayLen) { // complete this method
		int temp;
		// For each position in the array
		for (int i = 0; i < arrayLen; i++) {
			int j = i;
			temp = array[j];
			while (j > 0 && temp < array[j-1]) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		} // end for
	} // end insertionSort
}
