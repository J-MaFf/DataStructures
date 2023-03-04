package pa3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Program: MergeSortAndFriends.java Author: Joey Maffiola Class: COMPSCI 223 Date: Mar 4, 2023
 */
public class MergeSortAndFriends {

	/**
	 * "binaryMerge" method: This method takes two sorted arrays A and B and their respective lengths lenA and lenB as arguments. It
	 * merges A and B into a single sorted array C, and then returns C.
	 * 
	 * @param A    array A
	 * @param B    array B
	 * @param lenA length of array A
	 * @param lenB length of array B
	 * @return merged array C[] containing all elements from A[] and B[]
	 */
	private static int[] binaryMerge(int A[], int B[], int lenA, int lenB) {
		// Create new array of length lenA + lenB to store the merge
		int lenC = lenA + lenB;
		int[] C = new int[lenC];
		// Create three variables that represent the current index of the array
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
		// At this point, either A[] or B[] have had all their elements copied to C[]. Now, we will copy the rest of the remaining array
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
	}

	/**
	 * "commonElements" method: This method takes two sorted arrays A and B and their respective lengths lenA and lenB as arguments.
	 * Finds the common elements between A and B (without repeated counting of the same element) and returns them in an
	 * ArrayList<Integer>. The elements in the ArrayList<Integer>
	 * should be in sorted order. Complexity: O(lenA + lenB) or simply O(n) , linear time.
	 * 
	 * @param A    array A
	 * @param B    array B
	 * @param lenA length of array A
	 * @param lenB length of array B
	 * @return ArrayList<Integer> containing all common elements from A[] and B[] in sorted order.
	 */
	public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) { // complete this function
		// Create arrayList to store common elements
		ArrayList<Integer> commonElementsList = new ArrayList<Integer>();
		// Create two variables that represent the current index of the array
		int a = 0, b = 0;
		// Use a while loop to find common elements
		while (a < lenA && b < lenB) { // While there are elements left in A[] or B[]
			if (A[a] < B[b]) {
				a++;
			} else if (A[a] > B[b]) {
				b++;
			} else {
				// Here, we have verified that A[a] == B[b], which means we have found a common element. We shall copy this element to our array
				// list
				commonElementsList.add(A[a]);
				a++;
				// Now, we need to skip any recurring elements in A[a]. We only need to do this for one array, as the if conditionals above will
				// skip repeated elements in the other array.
				while (a < lenA && A[a] == B[b])
					a++;
			}
		}
		return commonElementsList;
	}

	/**
	 * "kWayMerge" method: This method takes the following as arguments: k sorted arrays in a jagged array lists (i.e., each
	 * row in the jagged array is a sorted array and there are k rows), the length of each row in another
	 * array listLengths, and the value of k. The task is to return a single merged sorted array.
	 * 
	 * @param lists       jagged array of sorted arrays
	 * @param listLengths length of each row in the jagged array
	 * @param k           number of rows in the jagged array (the # of sorted lists)
	 * @return merged array containing all elements from the jagged array in sorted order.
	 */
	public static int[] kWayMerge(int lists[][], int listLengths[], int k) { // complete this function
		// Base Case:
		if (k == 1) { // There is a single sorted array
			return lists[0];
		} else if (k == 2) { // there are two sorted arrays
			return binaryMerge(lists[0], lists[1], listLengths[0], listLengths[1]);
		}
		// Recursive case:
		// Create newK which stores the new number of sorted lists in the array that you are going to end up with after pairwise merging.
		int newK = (k + 1) / 2;
		// Create new jagged array using newK
		int[][] mergedLists = new int[newK][];
		// Create another array mergedListLengths of length newK, which is going to store the lengths of the pairwise merged lists.
		int[] mergedListLengths = new int[newK];
		//
		for (int i = 0; i < (k / 2); i++) { // Go through half of the lists[] rows
			mergedListLengths[i] = listLengths[2 * i] + listLengths[2 * i + 1]; // This sets the list length of the next two arrays to be merged
			mergedLists[i] = binaryMerge(lists[2 * i], lists[2 * i + 1], listLengths[2 * i], listLengths[2 * i + 1]); // here we merge two arrays based on index 2i and index 2i + 1
		} // end for
		// After this loop, if k is odd then the last row in lists, i.e., lists[k-1] does not have a pair to be merged with
		// Therefore, we would need to copy it into mergedLists[newK - 1]
		if (k % 2 != 0) { // if k is odd
			mergedLists[newK - 1] = lists[k - 1];
			mergedListLengths[newK - 1] = listLengths[k - 1];
		}
		return kWayMerge(mergedLists, mergedListLengths, newK);
	}

	/**
	 * "mergesort" method:
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergesort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(array, left, mid);
			mergesort(array, mid + 1, right);
			int A[] = Arrays.copyOfRange(array, left, mid + 1);
			int B[] = Arrays.copyOfRange(array, mid + 1, right + 1);
			int mergedArray[] = binaryMerge(A, B, A.length, B.length);
			int i = left;
			int j = 0;
			while (j <= right - left)
				array[i++] = mergedArray[j++];
		}
	}
}