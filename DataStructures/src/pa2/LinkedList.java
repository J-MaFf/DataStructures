package pa2;

public class LinkedList {

	public ListNode head, tail;
	public int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public void insertAfter(ListNode argNode, int value) { // complete this method
	}

	public void deleteAfter(ListNode argNode) { // complete this method
	}

	public void selectionSort() { // complete this method
	}

	public boolean removeDuplicatesSorted() { // complete this method
	}

	public void pushOddIndexesToTheBack() { // complete this method
	}
    
    public void reverse() { // complete this method
    }

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

	public int getSize() {
		return size;
	}
}
