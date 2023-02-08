package oldPA6;


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
		// You can obtain the current size of the heap using the size() method. The last value in the heap is at index size() −1.
		// To read a value of heapArray at index i use the following syntax: heapArray.get(i)
		// To insert a new value v use the following syntax: heapArray.add(v)
		// To delete the last value in the heap, use the following syntax: heapArray.remove(size() - 1)
		// To update the value at index i to the value v, use the following syntax: heapArray.set(i, v)
		// To swap the contents of the heap at two indexes x and y, call the swap method with arguments x and y, i.e., swap(x, y)
		// You have to fill out the swap function. This is pretty much the same as how one would swap two values in an array. The only
		// difference is that over here we are dealing with vector/arraylist; so, use an appropriate combination of the methods described
		// above.
		// Finally, remember that we are going to store strings in the heap; hence, you cannot compare
		// the values (such as minKey and rightKey) using < or > symbol. Instead, you have to use
		// the compare command (in C++) or the compareTo command (in Java) to determine which
		// string (such as minKey and rightKey) is lexicographically smaller.
		String tmp = heapArray.get(index1);
		String tmp2 = heapArray.get(index2);
		heapArray.set(index2, tmp);
		heapArray.set(index1, tmp2);
	}

	public void insert(String value) { // complete this method
		int currentIndex = size();
		int parentIndex = (currentIndex - 1) / 2;
		heapArray.add(value);
		while (currentIndex > 0 && heapArray.get(parentIndex).compareTo(heapArray.get(currentIndex)) > -1) { // heapArray.get(parentIndex) > heapArray.get(currentIndex)
			swap(parentIndex, currentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	public void extract() { // complete this method
		swap(0, size() - 1);
		heapArray.remove(size() - 1);
		int currentIndex = 0, leftIndex = 1, rightIndex = 2;
		while (leftIndex < size()) {
			int minIndex = leftIndex;
			String minKey = heapArray.get(minIndex);
			if (rightIndex < size()) {
				String rightKey = heapArray.get(rightIndex);
				if (rightKey.compareTo(minKey) < 0) {
					minIndex = rightIndex;
					minKey = rightKey;
				}
			}
			if (minKey.compareTo(heapArray.get(currentIndex)) < 0) {
				swap(minIndex, currentIndex);
				currentIndex = minIndex;
			} else {
				break;
			} // end if / else
			leftIndex = 2 * currentIndex + 1;
			rightIndex = leftIndex + 1;
		} // end while
	}

	public static void heapSort(String array[], int arrayLen) throws Exception { // complete this method
		StringHeap objStringHeap = new StringHeap();
		for (int i = 0; i < arrayLen; i++) {
			objStringHeap.insert(array[i]);
		} // end for
		for (int i = 0; i < arrayLen; i++) {
			array[i] = objStringHeap.top();
			objStringHeap.extract();
		} // end for
	}

	public int size() {
		return heapArray.size();
	}

	public String toString() {
		return heapArray.toString();
	}
}
