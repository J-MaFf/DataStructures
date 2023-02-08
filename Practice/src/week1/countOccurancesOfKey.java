/**
 * Program: countOccurancesOfKey.java
 * Author: Joey Maffiola
 * Class: 
 * Date: Feb 7, 2023
 */

package week1;

import javax.management.AttributeNotFoundException;

import pa1.Queue;

public class countOccurancesOfKey {
	public static void main(String[] args) throws AttributeNotFoundException {
		Queue myQueue = new Queue(5);
		for (int i = 0; i < 5; i++) {
			myQueue.enqueue(20); 
		} // end for
		
		int val = countKey(myQueue, 20);
		System.out.println(val);
	}
	
	/**
	 * "countKey" method: on a queue that counts all occurrences of key in O(n) time, where n is the size of the queue.
	 * You have the following limitations:
	 * You CAN ONLY USE the queue functions: enqueue, dequeue, peek, and size, i.e., you CANNOT access the queue-array or the
	 * front/rear variables.
	 * You CANNOT use any other data structure/array. You can only use variables for storage.
	 * The original order of items MUST be maintained after the function stops.
	 * 
	 * @param key the number to search for
	 * @return how many times the key was found
	 * @throws AttributeNotFoundException if the queue is empty when attempting to dequeue
	 */
	public static int countKey(Queue queue, int key) throws AttributeNotFoundException {
		int count = 0;
		for (int i = 0; i < queue.size(); i++) {
			if (queue.peek() == key) {
				count++;
			} else {
				int temp = queue.dequeue();
				queue.enqueue(temp);
			}
		} // end for
		return count;
	} // end countKey
}
