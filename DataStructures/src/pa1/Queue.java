package pa1;
import javax.management.AttributeNotFoundException;

public class Queue {

	private int maxQueueSize, front, rear, currentSize;
	private int[] queue;

	public Queue(int maxQueueSize) {
		if (maxQueueSize <= 0)
			System.out.println("Queue size should be a positive integer.");
		else {
			this.maxQueueSize = maxQueueSize;
			front = rear = 0;
			currentSize = 0;
			queue = new int[maxQueueSize];
		}
	}

	/**
	 * "enqueue" method: adds an item val to the collection
	 * 
	 * @param val item to be added
	 */
	public void enqueue(int val) { // complete this method
		if (currentSize == maxQueueSize) {
			System.out.println("Can't queue, queue is currently full.");
		} else {
			//System.out.println("Enqueueing " + val);
			queue[rear++] = val;
			currentSize++;
			if (rear == maxQueueSize) {
				rear = 0;
			}
			//System.out.println("Current size is " + currentSize);
		}
	} // end enqueue

	/**
	 * "dequeue" method: returns and removes the OLDEST item, provided the queue is not empty
	 * 
	 * @return the OLDEST item, provided the queue is not empty
	 */
	public int dequeue() throws AttributeNotFoundException { // complete this method
		if (currentSize == 0) {
			System.out.println("Can't dequeue, the queue is currently empty.");
			//throw new AttributeNotFoundException();
			return -1;
		} else {
			int val = queue[front++];
			currentSize--;
			//System.out.println("Dequeueing " + val);
			if (front == maxQueueSize) {
				front = 0;
			}
			return val;
		}
	} // end dequeue
	
	public int peek() {
		if (currentSize == 0) {
			System.out.println("Can't peek, the queue is currently empty.");
			//throw new AttributeNotFoundException();
			return -1;
		} else {
			return queue[front];
		}
	} // end peek 

	/**
	 * "size" method: returns the number of items in the queue
	 * 
	 * @return the number of items in the queue
	 */
	public int size() { // complete this method
		return currentSize;
	}

	public String toString() {
		if (size() == 0)
			return "[]";
		else {
			String output = "[";
			if (rear > front) {
				for (int i = front; i < rear - 1; i++)
					output += queue[i] + ", ";
				output += queue[rear - 1] + "]";
			} else {
				for (int i = front; i < maxQueueSize - 1; i++)
					output += queue[i] + ", ";
				output += queue[maxQueueSize - 1];

				for (int i = 0; i < rear; i++)
					output += ", " + queue[i];
				output += "]";
			}
			return output;
		}
	}
}
