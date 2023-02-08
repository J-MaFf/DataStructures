/**
 * Program: Main.java
 * Author: Joey Maffiola
 * Class: 
 * Date: Jan 30, 2023
 */
package Playground;

public class Main {
	public static void main(String[] args) {
		int[] array = {9, 2, 5, 3, 7, 1, 8};
		int arrayLen = array.length;

		// Display original array
		System.out.println("Original array: ");
		for (int i = 0; i < arrayLen; i++) {
			System.out.print(array[i] + " ");
		}

		// Sort the array using selectionSort
		Sorting.selectionSort(array, arrayLen);
		System.out.println("\nArray after selectionSort: ");
		for (int i = 0; i < arrayLen; i++) {
			System.out.print(array[i] + " ");
		}

		// Reset the array to its original form
		array = new int[]{9, 2, 5, 3, 7, 1, 8};
		System.out.println("\n\nOriginal array: ");
		for (int i = 0; i < arrayLen; i++) {
			System.out.print(array[i] + " ");
		}

		// Sort the array using insertionSort
		Sorting.insertionSort(array, arrayLen);
		System.out.println("\nArray after insertionSort: ");
		for (int i = 0; i < arrayLen; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
