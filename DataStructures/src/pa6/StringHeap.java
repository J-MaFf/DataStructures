package pa6;

import java.util.ArrayList;

public class StringHeap {

    private ArrayList<String> heapArray;

    public StringHeap() {
        heapArray = new ArrayList<>();
    }

    public String top() {
        return heapArray.get(0);
    }

    private void swap(int index1, int index2) {
        String temp = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, temp);
    } // complete this method

    /**
     * Inserts a value into the heap.
     * @param value The value to be inserted
     */
    public void insert(String value) {
        heapArray.add(value);
        int index = heapArray.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heapArray.get(index).compareTo(heapArray.get(parent)) > 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    } // complete this method

    /**
     * Extracts the smallest/topmost value from the heap.
     */
    public void extract() {
        // swap the last element with the root element
        swap(0, heapArray.size() - 1);
        // remove the last element
        heapArray.remove(heapArray.size() - 1);
        // trickle down the root element
        int index = 0;
        while (index < heapArray.size()) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left >= heapArray.size()) {
                break;
            }
            int max = left;
            if (right < heapArray.size()) {
                if (heapArray.get(right).compareTo(heapArray.get(left)) > 0) {
                    max = right;
                }
            }
            if (heapArray.get(index).compareTo(heapArray.get(max)) < 0) {
                swap(index, max);
                index = max;
            } else {
                break;
            }
        }
    } // complete this method

    /**
	 * Sorts the array using heap sort.
	 * @param array The array to be sorted
	 * @param arrayLen The length of the array to be sorted
	 * @throws Exception If the array is empty
	 */
    //prettier-ignore
    public static void heapSort(String array[], int arrayLen) throws Exception {
		StringHeap heap = new StringHeap();
        // insert all the strings of the array into the heap
		for (int i = 0; i < arrayLen; i++) {
			heap.insert(array[i]);
		}
        // set array[i] to the smallest/topmost string in the heap and extract it from the heap
		for (int i = 0; i < arrayLen; i++) {
			array[i] = heap.top();
			heap.extract();
		}
        flip(array, arrayLen);
	}

    // Array is in reverse order, so flip it
    public static void flip(String[] array, int arrayLen) {
        for (int i = 0; i < arrayLen / 2; i++) {
            String temp = array[i];
            array[i] = array[arrayLen - i - 1];
            array[arrayLen - i - 1] = temp;
        }
    }

    public int size() {
        return heapArray.size();
    }

    public String toString() {
        return heapArray.toString();
    }
}
