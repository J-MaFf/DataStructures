package oldPA2;
/**
 * The Class LinkedList.
 */
public class LinkedList {

	public ListNode head, tail;

	/** The size. */
	public int size;

	/**
	 * Instantiates a new empty linked list.
	 */
	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Insert after function inserts a node with value 'value' after the argNode. You may assume that
	 * argNode is not null.
	 *
	 * @param argNode the argument node
	 * @param value   the value to be inserted after the argument node
	 */
	public void insertAfter(ListNode argNode, int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = argNode.next;
		argNode.next = newNode;
		if (argNode == tail) {
			tail = newNode;
		} // end if
		size++;

	} // end insertAfter

	/**
	 * Delete after.
	 *
	 * @param argNode the arg node
	 */
	public void deleteAfter(ListNode argNode) {
		// case 1
		if (argNode == tail) {
			System.out.println("Can't delete after tail");
		} // end if
		else if (argNode.next == tail) {
			size--;
			argNode.next = null;
			tail = argNode;
		} // end else if
		else {
			// Create temp var to hold the node we are deleting
			ListNode temp = argNode.next;
			// Point argNode's next to temp's next
			argNode.next = temp.next;
			// remove temp's next (break the link)
			temp.next = null;
			size--;

		} // end else

	} // end deleteAfter

	/**
	 * Selection sort.
	 */
	public void selectionSort() {
		ListNode minNode = new ListNode(0);
		ListNode pointer = head;
		// Traverse the List
		while (pointer != null) {
			minNode = pointer;
			ListNode tempNode = new ListNode(0);
			tempNode = pointer.next;
			while (tempNode != null) {
				if (minNode.value > tempNode.value) {
					minNode = tempNode;
				} // end if
				tempNode = tempNode.next;
			} // end while
			int x = pointer.value;
			pointer.value = minNode.value;
			minNode.value = x;
			pointer = pointer.next;

		} // end while

	} // end selectionSort

	/**
	 * Removes the duplicates sorted.
	 *
	 * @return true, if successful
	 */
	public boolean removeDuplicatesSorted() {
		// check if linked list is sorted
		ListNode currentNode = head;

		// check if linked list is sorted
		for (int i = 0; i < size - 1; i++) {
			if (currentNode == null) {
				return false;
			} else if (currentNode.value > currentNode.next.value) {
				return false;
			} // end if
			else {
				currentNode = currentNode.next;
			} // end else
		} // end for

		// to reach this point, the list needs to be sorted. Will return false up above if the list is not sorted
		// reset currentNode to the beginning
		currentNode = head;
		while (currentNode != tail) {
			// might need to check if currentNode != null
			if (currentNode == null) {
				break;
			}
			// compare current node value with next node value. If the same, delete, delete after current node.
			if (currentNode.value == currentNode.next.value) {
				deleteAfter(currentNode);
			} // end if
			else {
				currentNode = currentNode.next;
			} // end else
		} // end while
		return true;
	}

	/**
	 * Push odd indexes to the back.
	 */
	public void pushOddIndexesToTheBack() {
		// Scan through the linked list using a loop and a placeholder, but this time only loop over the even indexes 0, 2, 4, 6, and so
		// on.
		// check if linked list is sorted
		ListNode currentNode = head;
		// for all even indices
		for (int i = 0; i < size - 1; i += 2) {
			// Within the loop, insert the value in the node immediately after the placeholder at the end of the linked list and delete the
			// node after the placeholder. Move placeholder to its next node
			insertAtEnd(currentNode.next.value);
			deleteAfter(currentNode);
			currentNode = currentNode.next;

		} // end for

	} // end pushOddIndexesToTheBack

	/**
	 * Reverse.
	 */
	public void reverse() {
		ListNode previous = head;
		ListNode current = head.next;
		while (current != null) {
			ListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		ListNode x = head;
		head = tail;
		tail = x;
		tail.next = null;
	}

	/**
	 * Insert at front.
	 *
	 * @param value the value
	 * @return the list node
	 */
	ListNode insertAtFront(int value) {
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

	/**
	 * Insert at end.
	 *
	 * @param value the value
	 * @return the list node
	 */
	ListNode insertAtEnd(int value) {
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

	/**
	 * Delete head.
	 */
	void deleteHead() {
		if (0 == size) {
			System.out.println("Cannot delete from an empty list");
		} else if (1 == size) {
			head = tail = null;
			size--;
		} else {
			size--;
			ListNode tmp = head;
			head = head.next;
			tmp.next = null;
			tmp = null;
		}
	}

	/**
	 * Gets the node at.
	 *
	 * @param pos the pos
	 * @return the node at
	 */
	public ListNode getNodeAt(int pos) {
		if (pos < 0 || pos >= size || 0 == size) {
			System.out.println("No such position exists");
			return null;
		} else {
			ListNode tmp = head;
			for (int i = 0; i < pos; i++)
				tmp = tmp.next;
			return tmp;
		}
	}

	/**
	 * Prints the list.
	 */
	void printList() {
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

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
}
