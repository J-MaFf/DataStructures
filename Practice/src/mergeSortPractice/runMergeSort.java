package mergeSortPractice;

public class runMergeSort {
	public static void main(String[] args) {
		// Create a new Solution object
		Solution solution = new Solution();
		// Create an array to be sorted
		int[] array = { 5, 4, 3, 2, 1, 9, -56, 97, 5, 26};
		// Call the mergeSort method
		solution.mergeSort(array, 0, array.length - 1);
		// Print the sorted array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
