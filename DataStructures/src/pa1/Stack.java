package pa1;
import java.util.Arrays;

/**
 * Program: Stack.java
 * Author: Joey Maffiola
 * Class: COMPSCI 223
 * Date: Feb 5, 2023
 */
public class Stack {

	private int maxStackSize, topOfStack;
	private int[] stack;

	public Stack(int maxStackSize) {
		if (maxStackSize <= 0)
			System.out.println("Stack size should be a positive integer.");
		else {
			this.maxStackSize = maxStackSize;
			topOfStack = -1;
			stack = new int[maxStackSize];
		}
	} // end Stack

	/**
	 * "push" method: Push a value to the top of the stack.
	 * @param val the value to be pushed.
	 */
	public void push(int val) { // complete this method
		if (topOfStack == maxStackSize - 1) {
			System.out.println("Can't add " + val + ", stack is full!");
		} else {
			//System.out.println("Pushing " + val);
			stack[++topOfStack] = val;
			
		}
		
		
	} // end push

	/**
	 * "pop" method: Pop a value from the top of the stack.
	 * @return the value at the top of the stack.
	 */
	public int pop() throws IndexOutOfBoundsException { // complete this method
		if (topOfStack == -1) {
			//System.out.println("Can't pop, stack is empty.");
			//throw new IndexOutOfBoundsException();
			return -1;
		} else {
			//System.out.println("Popping " + stack[topOfStack]);
			return stack[topOfStack--];
		}
	} // end pop

	/**
	 * "size" method: Show how many elements are in the stack.
	 * @return how many elements are in the stack.
	 */
	public int size() { // complete this method
		return topOfStack + 1;
	} // end size
	
	/**
	 * "printStack" method: prints out the stack
	 */
	public void printStack() {
		System.out.println("Top of stack is at index " + topOfStack);
		System.out.println("Current Stack:\n" + Arrays.toString(stack) + "\n");
	} // end printStack 
}
