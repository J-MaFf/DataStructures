package pa2;

/**
 * Program: LinkedList.java Author: Joey Maffiola Class: COMPSCI 223 Date: Feb 19, 2023
 */
public class LinkedList {

	public ListNode head, tail;
	public int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * "insertAfter" method: Function inserts a node with value value after the node argNode. You may assume that argNode is not null.
	 * 
	 * @param argNode the argument node
	 * @param value   the value of the new node
	 */
	public void insertAfter(ListNode argNode, int value) {
		// Create a new node with the given value
		ListNode newNode = new ListNode(value);

		// Set the next node of the new node to the next node of the argument node
		newNode.next = argNode.next;

		// Set the next node of the argument node to the new node
		argNode.next = newNode;

		// If the argument node is the tail node, set the tail to the new node
		if (argNode == tail) {
			tail = newNode;
		}

		// Increment the size of the list
		size++;
	}

	/**
	 * "deleteAfter" method: Function deletes the node after argNode. You may assume that argNode is not null.
	 * 
	 * @param argNode the argument node
	 */
	public void deleteAfter(ListNode argNode) {
		// If argNode is the last node in the linked list, then there is nothing to delete
		if (argNode == tail) {
			// Nothing to delete
			System.out.println("Cannot delete after tail.");
		} else if (argNode.next == tail) { // if the node after argNode is the last node in the linked list, then remove all references to tail
			tail = argNode;
			argNode = null;
			tail.next = null;
			// decrement size (because we just deleted a node)
			size--;
		} else {
			// Get node after argNode (the node to be deleted) and store it in placeholder node
			ListNode deleteThisNode = argNode.next;
			// Set the new next for argNode, which is the next for the node we are deleting
			argNode.next = deleteThisNode.next;
			// remove references from placeholder
			deleteThisNode = null;
			// decrement size (because we just deleted a node
			size--;
		}

	} // end deleteAfter

	/**
	 * "selectionSort" method: sorts the linked list using selection sort method.
	 */
	public void selectionSort() {
		// Traverse through each node (except the last one, because LinkedList will be sorted by then)
		for (int i = 0; i < size - 2; i++) { // i = current index being sorted
			// Variable for storing the smallestValue in the sub array as well as the first node in the sub array
			ListNode smallNode, checkNode;
			checkNode = smallNode = getNodeAt(i);
			// Traverse through sub array and find the minimum value
			for (int j = i; j < size; j++) { // j = place in sub array
				checkNode = getNodeAt(j);
				if (smallNode.value <= checkNode.value) { // if the small node is less than or equal to the node being checked
					// do nothing
				} else { // If small node is bigger than the node being checked
					// Then this node is the smallest (so far) and we will save it to smallNode
					smallNode = checkNode;
				}
			} // end for
				// After traversing through the sub array, swap i node and small node
			int placeholder = getNodeAt(i).value;
			getNodeAt(i).value = smallNode.value;
			smallNode.value = placeholder;

		} // end for

	} // end selectionSort method

	/**
	 * "removeDuplicatesSorted" method: checks whether or not the linked list is sorted in ascending order. If it is not sorted, then
	 * the function returns
	 * false. Otherwise, the function removes the duplicate occurrences of each number from the list (i.e., only one occurrence of
	 * each number remains).
	 * Then the function returns true.
	 * 
	 * @return false if no duplicates, true if there are duplicates
	 */
	public boolean removeDuplicatesSorted() {
		// Check to see if the list is sorted
		for (int i = 0; i < size - 1; i++) {
			if (getNodeAt(i).value > getNodeAt(i + 1).value) {
				return false;
			}
		}
		// Now that we know the list is sorted, we can remove duplicates
		for (int i = 0; i < size - 1; i++) {

			while (getNodeAt(i).value == getNodeAt(i + 1).value) { // While the next node is equal to the current node
				deleteAfter(getNodeAt(i)); // Delete the next node
				if (i == size - 1) { // If we are at the end of the list, then break out of the while loop
					break;
				}
			}
		}
		return true;
	} // end removeDuplicatesSorted

	/**
	 * "pushOddIndexesToTheBack" method: pushes all the odd indexes to the back of the linked list, starting with index 1, then 3,
	 * then 5, and so on.
	 */
	public void pushOddIndexesToTheBack() {
		ListNode placeholder = head;
		// Loop through all the even indexes of the list
		for (int i = 0; i < size; i += 2) {
			// Check if the next node is at an odd index
			if (placeholder.next != null && i + 1 < size) {
				insertAtEnd(placeholder.next.value); // Insert the value of the next node at the end of the list
				deleteAfter(placeholder); // Delete the next node
			}
			placeholder = placeholder.next; // Move the placeholder to the next node
		} // end for
	} // end pushOddIndexesToTheBack

	/**
	 * "reverse" method: reverses a linked list in-place, i.e., without using any extra space (such as an array or another linked
	 * list) other than variables.
	 */
	public void reverse() {
		
	} // end reverse

	/**
	 * "insertAtFront" method: inserts a node with value value at the front of the linked list.
	 * 
	 * @param value the value of the new node
	 * @return the new node
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
	} // end insertAtFront

	/**
	 * "insertAtEnd" method: inserts a node with value value at the end of the linked list.
	 * 
	 * @param value the value of the new node
	 * @return the new node
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
	} // end insertAtEnd

	/**
	 * "deleteHead" method: deletes the head of the linked list.
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
	} // end deleteHead

	/**
	 * "getNodeAt" method: returns the node at position pos in the linked list.
	 * 
	 * @param pos the position of the node to return
	 * @return the node at position pos, or null if pos is invalid
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
	} // end getNodeAt

	/**
	 * "printList" method: prints the linked list.
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
	} // end printList

	/**
	 * "getSize" method: Gets the size of the linked list.
	 * 
	 * @return the size of the linked list
	 */
	public int getSize() {
		return size;
	} // end getSize
} // end LinkedList class
