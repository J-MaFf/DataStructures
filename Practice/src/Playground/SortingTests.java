/**
 * Program: SortingTests.java
 * Author: Joey Maffiola
 * Class: 
 * Date: Feb 5, 2023
 */
package Playground;

import java.util.Arrays;

public class SortingTests {
	// In O(n) time, how do you sort a reverse-sorted array of length n? Specifically, change a non-increasing array to a
	// non-decreasing array.
	public static void main(String[] args) {
		int[] arr = { 19, 17, 14, 10, 6 };
		System.out.println(checkSort(arr, arr.length)); 
		reverseSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println(checkSort(arr, arr.length)); 

		int[] arr2 = { 150, 125, 110, 97, 86, 55, 43, 22, 7, 2 };
		System.out.println(checkSort(arr2, arr2.length));
		reverseSort(arr2, arr2.length);
		System.out.println(Arrays.toString(arr2));
		System.out.println(checkSort(arr2, arr2.length));
	}

	/**
	 * "reverseSort" method: reverses order of sort
	 * 
	 * @param arr the array to be reversed
	 * @param n   length of the array
	 */
	public static void reverseSort(int arr[], int n) {
		int endIndex = n - 1;
		for (int i = 0; i < n / 2; i++) {
			int temp = arr[endIndex];
			arr[endIndex] = arr[i];
			arr[i] = temp;
			endIndex--;
		}
	} // end reverseSort

	/**
	 * "checkSort" method: verify if an array of length n is sorted in non-decreasing order
	 * @param arr the array to be sorted
	 * @param n length of the array
	 * @return true if array is sorted in non-decreasing order, false if otherwise
	 */
	public static boolean checkSort(int arr[], int n) {
		for (int i = 0; i < n - 2; i++) {
			if (arr[i] > arr[i + 1])
				return false;
		}
		return true;
	}
}
