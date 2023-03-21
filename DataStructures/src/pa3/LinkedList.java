package pa3;

public class LinkedList {

	private ListNode head, tail;
	private int size;
	private int mergedArray[];

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public void mergesort() {
		mergedArray = new int[size()];
		mergesort(0, size() - 1, head, tail);
	}

	/**
	 * "mergesort" method:
	 * 
	 * @param left
	 * @param right
	 * @param leftNode
	 * @param rightNode
	 */
	private void mergesort(int left, int right, ListNode leftNode, ListNode rightNode) { // complete this function
		if (left >= right) { // if LL is of length 1
			return;
		}
		int mid = (left + right) / 2;
		ListNode midNode = leftNode;
		// Move the place-holder using a loop from i = left to i < mid such that midNode points to the node at index mid
		for (int i = left; i < mid; i++) {
			midNode = midNode.next;
		} // end for
			// Now that midNode is the midNode, we can recursivley call mergeSort
		mergesort(left, mid, leftNode, midNode);
		mergesort(mid + 1, right, midNode.next, rightNode);
		// Initialize tracker vars
		int k = left;
		ListNode tmp1 = leftNode, tmp2 = midNode.next;
		while (tmp1 != midNode.next && tmp2 != rightNode.next) { // While there are nodes left in either sublist
			if (tmp1.value < tmp2.value) {
				mergedArray[k++] = tmp1.value;
				tmp1 = tmp1.next;
			} else { // tmp2.value is >= tmp1.value
				mergedArray[k++] = tmp2.value;
				tmp2 = tmp2.next;
			}
		}
		// At this point, one of the sublists is empty; now we copy the remaining list to our merged aray
		while (tmp1 != midNode.next) { // while there are still nodes in the first sublist
			mergedArray[k++] = tmp1.value;
			tmp1 = tmp1.next;
		}
		while (tmp2 != rightNode.next) {
			mergedArray[k++] = tmp2.value;
			tmp2 = tmp2.next;
		}
		k = left; // reset k
		ListNode tmp = leftNode; // tmp represents current ListNode
		// Use while loop to fill LL (i think)
		while (tmp != rightNode.next) {
			tmp.value = mergedArray[k++];
			tmp = tmp.next;
		}
	}

	public ListNode insertAtFront(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return newNode;
	}

	public ListNode insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return newNode;
	}

	public void printList() {
		if (size == 0)
			System.out.println("[]");
		else {
			ListNode tmp = head;
			String output = "[";
			for (int i = 0; i < size - 1; i++) {
				output += tmp.value + " -> ";
				tmp = tmp.next;
			}
			output += tail.value + "]";
			System.out.println(output);
		}
	}

	public int size() {
		return size;
	}
}
