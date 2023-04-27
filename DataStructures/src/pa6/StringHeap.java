

import java.util.ArrayList;

public class StringHeap {

	private ArrayList<String> heapArray;

	public StringHeap() {
		heapArray = new ArrayList<>();
	}

	public String top() {
		return heapArray.get(0);
	}

	private void swap(int index1, int index2) { // complete this method
	}

	public void insert(String value) { // complete this method
	}

	public void extract() { // complete this method
	}

	public static void heapSort(String array[], int arrayLen) throws Exception { // complete this method
	}

	public int size() {
		return heapArray.size();
	}

	public String toString() {
		return heapArray.toString();
	}
}
