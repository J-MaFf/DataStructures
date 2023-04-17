package AvlTrees;

public class HW9Q3 {

    // Write a program to count the number of distinct numbers in an array of length N in O(N log N) time.
    public static void main(String[] args) {
        // prettier-ignore
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		AvlTree<Integer> tree = new AvlTree<>();
		for (int i = 0; i < arr.length; i++) {
			tree.insert(arr[i]);
		}
		System.out.println("The number of distinct #'s in the array is " + tree.size());
    }
}
