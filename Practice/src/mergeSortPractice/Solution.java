/**
 * Program: Solution.java Author: Joey Maffiola Class: Date: Mar 1, 2023
 */
package mergeSortPractice;

public class Solution {
	/**
	 * "mergeTwoSortedArrays" method: This method will merge two sorted arrays into a single sorted array. the complexity is O(lenA + lenB)
	 * 
	 * @param A    - Array A
	 * @param B    - Array B
	 * @param lenA - Length of Array A
	 * @param lenB - Length of Array B
	 * @return - Returns the merged array
	 */
	public int[] mergeTwoSortedArrays(int[] A, int[] B, int lenA, int lenB) {
		// Create new array of length lenA + lenB to store the merge
		int[] C = new int[lenA + lenB];
		// Create three variables that represent the index of the array
		int a = 0, b = 0, c = 0;
		// Use a while loop to merge the array
		while (a < lenA && b < lenB) { // While there are elements left in A[] or B[]
			if (A[a] < B[b]) { // If Array A at a index is less than Array B at b index
				// Store A[a] inside C[c]
				C[c] = A[a];
				// Increment a so next time the while loop checks the next index of A[]
				a++;

			} else { // In this case, the array B at b index is less than or equal to Array A at a index
				// Store B[b] inside C[c]
				C[c] = B[b];
				// Increment b so next time the while loop checks the next index of B[]
				b++;
			}
			// Increment C so the next placement in C[] is at the next index
			c++;
		}
		// At this point, either A[] or B[] have had all their elements coppied to C[]. Now, we will copy the rest of the remaining array
		// to C[].
		while (a < lenA) { // Copy the rest of A[] to C[] (if any elements are left)
			C[c] = A[a];
			a++;
			c++;
		}
		while (b < lenB) { // Copy the rest of B[] to C[] (if any elements are left)
			C[c] = B[b];
			b++;
			c++;
		}

		// Return the merged array
		return C;
	} // end mergeTwoSortedArrays

	/**
	 * "mergeSort" method: This method will sort an array using the merge sort algorithm. It will recursively call itself to sort the array. The complexity is O(n log n)
	 * 
	 * @param array - Array to be sorted
	 * @param left  - Beginning index of the array
	 * @param right - Ending index of the array
	 * @return
	 * @return
	 */
	public void mergeSort(int[] array, int left, int right) {
		// Break array into roughly two equal parts if the array has length greater than 1
		if (left < right) { // if left is less than right then the array has a length greater than 1
			// Compute mid
			int mid = (left + right) / 2;
			// Recursively sort the two arrays based of of mid's value
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);

			// I think at this point, we are now dealing with single element arrays

			// Send to merge method
			merge(array, left, mid, right);

		}

	} // end mergeSort

	/**
	 * "merge" method: This method will merge two sub arrays into a single sorted array. The complexity is O(n)
	 * 
	 * @param array - Array to be sorted
	 * @param left - Beginning index of the array
	 * @param mid - Middle index of the array
	 * @param right - Ending index of the array
	 */
	private void merge(int[] array, int left, int mid, int right) {
		// Create temporary array
		int[] temp = new int[right - left + 1];
		// Create placeholder vars
		// i represents the index of the first half of the array
		// j represents the index of the second half of the array
		// k represents the index of the temp array
		int i = left, j = mid + 1, k = 0;

		// Loop through the sub arrays and compare until one of them become empty
		while (i <= mid && j <= right) {
			if (array[i] < array[j]) { // if index in first sub array is less than index at second sub array
				temp[k++] = array[i++];
			} else { // if index in first sub array is greater than or equal to index at second sub array
				temp[k++] = array[j++];
			}
		}
		// At this point one of the sub arrays is empty. Now copy the remaining array to temp
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		while (j <= right) {
			temp[k++] = array[j++];
		}

		// Now, use temp to overwrite the original array
		for (k = 0; k < right - left + 1; k++) {
			array[left + k] = temp[k];
		} // end for

	}

}
