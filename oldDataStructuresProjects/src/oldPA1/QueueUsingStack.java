package oldPA1;

public class QueueUsingStack {

	Stack mainStack;
	int maxQueueSize;

	public QueueUsingStack(int maxQueueSize) {
		this.maxQueueSize = maxQueueSize;
		mainStack = new Stack(maxQueueSize);
	}

	public void enqueue(int val) { // complete this method
		if (mainStack.size() == 0) {
			mainStack.push(val);
		} else {
			// Create a stack “tempStack”, having the same capacity as the size of the mainStack.
			Stack tempStack = new Stack(mainStack.size());
			while (mainStack.size() != 0) {
				// Pop all numbers from mainStack and push them onto tempStack.
				// Pop all numbers from tempStack and push them onto mainStack.
				tempStack.push(mainStack.pop());
			}
			mainStack.push(val);
			
			while (tempStack.size() != 0) {
				mainStack.push(tempStack.pop());
			}
		}// end else
	}// end enqueue

	public int dequeue() { // complete this method
		// pop to main stack
		return mainStack.pop();
	}

	public int size() { // complete this method
		return mainStack.size();
	}

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
