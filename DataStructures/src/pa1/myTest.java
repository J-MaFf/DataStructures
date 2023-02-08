package pa1;
import javax.management.AttributeNotFoundException;

/**
 * Program: myTest.java
 * Author: Joey Maffiola
 * Class:
 * Date: Feb 5, 2023
 */

public class myTest {

	/**
	 * "main" method:
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// testStack();
		testQueue();
	} // end main

	/**
	 * "testStack" method: tests the stack class
	 */
	public static void testStack() {
		int maxStackSize = 5;
		Stack myStack = new Stack(maxStackSize);
		// Test push
		for (int i = 1; i <= maxStackSize + 1; i++) { // should fail on the last try
			myStack.push(i * 5);
			myStack.printStack();

		} // end for

		// Test size
		System.out.println("Size of stack is " + myStack.size());

		// Test pop
		for (int i = 0; i <= maxStackSize; i++) { // should fail on last pop
			myStack.pop();
			myStack.printStack();
		} // end for
	} // end testStack

	public static void testQueue() {
		int maxQueueSize = 5;
		// Create a queue
		Queue myQueue = new Queue(maxQueueSize);

		// Test enqueue
		for (int i = 1; i <= maxQueueSize - 1; i++) {

			myQueue.enqueue(i * 5);
			
			System.out.println(myQueue.toString());
		} // end for

		// test dequeue
		for (int i = 0; i < maxQueueSize; i++) {
			try {
				myQueue.dequeue();
				System.out.println("Current size is " + myQueue.size());
				System.out.println(myQueue.toString());
			} catch (AttributeNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Dequeue failed, queue was empty.");
			}
		} // end for

	} // end testQueue

}
