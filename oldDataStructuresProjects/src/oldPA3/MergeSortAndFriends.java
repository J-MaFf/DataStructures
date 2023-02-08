package oldPA3;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortAndFriends {

	private static int[] binaryMerge(int A[], int B[], int lenA, int lenB) { // complete this function
		int lenC = lenA + lenB;
		int C[] = new int[lenC];
		// create new integer array C with length lenC
		int a = 0, b = 0, c = 0;
		while (a < lenA && b < lenB) {
			if (A[a] < B[b]) {
				C[c] = A[a];
				a++;
			} else {
				C[c] = B[b];
				b++;
			}
			c++;
		} // end while
		while (a < lenA) {
			C[c] = A[a];
			a++;
			c++;
		}
		while (b < lenB) {
			C[c] = B[b];
			b++;
			c++;
		}
		return C;
	} // end binaryMerge

	public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) { // complete this function
		ArrayList<Integer> dynamicArray = new ArrayList<Integer>();
		int a = 0, b = 0;
		while (a < lenA && b < lenB) {
			if (A[a] < B[b]) {
				a++;
			} else if (A[a] > B[b]) {
				b++;
			} else {
				dynamicArray.add(A[a]);
				a++;
				while (a < lenA && A[a] == B[b]) {
					a++;
				} // end while
			} // end else
		} // end while
		return dynamicArray;
	} // end commonElements

	public static int[] kWayMerge(int lists[][], int listLengths[], int k) { // complete this function
		if (k == 1) {
			return lists[k - 1];
		} else if (k == 2) {
			return binaryMerge(lists[k - 2], lists[k - 1], listLengths[k - 2], listLengths[k - 1]);
		} else {
			int newK = (k + 1) / 2; // This is the new number of sorted lists that you are going to end up with after pairwise merging
			int mergedLists[][] = new int[newK][];
			int mergedListLengths[] = new int[newK];
			for (int i = 0; i <= (k / 2) - 1; i++) {
				mergedListLengths[i] = listLengths[2 * i] + listLengths[(2 * i) + 1];
				mergedLists[i] = binaryMerge(lists[2 * i], lists[(2 * i) + 1], listLengths[2 * i], listLengths[(2 * i) + 1]);
			} // end for
			if (k % 2 != 0) { // checking if K is odd because if k is odd then the last row in lists, i.e., lists[k −1] does not have a pair to be merged with,
								// and so it simply gets copied into mergedLists[newK −1].
				mergedLists[newK - 1] = lists[k - 1];
				mergedListLengths[newK - 1] = listLengths[k - 1];
			} // end if
			return kWayMerge(mergedLists, mergedListLengths, newK);
		} // end else
	} // end kWayMerge

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