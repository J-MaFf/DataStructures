package pa1;
public class QueueUsingStack {

	Stack mainStack;
	int maxQueueSize;

	public QueueUsingStack(int maxQueueSize) {
		this.maxQueueSize = maxQueueSize;
		mainStack = new Stack(maxQueueSize);
	}

	/**
	 * "enqueue" method: 
	 * @param val the value to be enqueued.
	 */
	public void enqueue(int val) { // complete this method
		// If the size of the mainStack is zero, then just push the new item onto the mainStack
		if (mainStack.size() == 0) {
			mainStack.push(val);
		} else { // Otherwise, do the following steps:
			// Create a stack “tempStack”, having the same capacity as the size of the mainStack
			Stack tempStack = new Stack(mainStack.size());
			// Pop all numbers from mainStack and push them onto tempStack
			while (mainStack.size() != 0) {
				tempStack.push(mainStack.pop());
			}
				// Push the new number onto mainStack
			mainStack.push(val);
			// Pop all numbers from tempStack and push them onto mainStack.
			while (tempStack.size() != 0) {
				mainStack.push(tempStack.pop());
			}
		}
	} // end enqueue

	/**
	 * "dequeue" method: 
	 * @return
	 */
	public int dequeue() { // complete this method
		return mainStack.pop();
	} // end dequeue

	/**
	 * "size" method: 
	 * @return the size of the queue
	 */
	public int size() { // complete this method
		return mainStack.size();
	} // end size

	/**
	 * "toString" method: prints the queue
	 */
	public String toString() {
		if (size() == 0) {
			return "[]";
		} else {
			String output = "[";
			int n = size();
			for (int i = 0; i < n - 1; i++) {
				int x = dequeue();
				output += x + ", ";
				enqueue(x);
			}
			int x = dequeue();
			output += x + "]";
			enqueue(x);
			return output;
		}
	}
}
