package Playground;

public class Sorting {

	public static void selectionSort(int[] array, int arrayLen) {
		// loop through the array
		for (int i = 0; i < arrayLen - 1; i++) {
			// initialize `index` to the current `i`
			int index = i;
			// loop through the subarray starting from the next element
			for (int j = i + 1 ; j < arrayLen; j++) {
				// if the current element is smaller than the one at the `index`, update `index`
				if (array[j] < array[index]) {
					index = j;
				}
			}
			// swap the elements at `i` and `index`
			int smallNum = array[index];
			array[index] = array[i];
			array[i] = smallNum;
		}
	}

	public static void insertionSort(int[] array, int arrayLen) {
		// loop through the array starting from the second element
		for (int j = 1; j < arrayLen; j++) {  
			// store the current element in a variable called `key`
			int key = array[j];  
			// initialize `i` to `j` minus 1
			int i = j-1;  
			// loop through the subarray while `i` is greater than or equal to 0 and the element at `i` is greater than `key`
			while ( (i > -1) && ( array [i] > key ) ) {  
				// move the element at `i` one position to the right
				array [i+1] = array [i];  
				// decrement `i`
				i--;  
			} 
			// insert `key` into its proper position
			array[i+1] = key;  
		}
	}
}
