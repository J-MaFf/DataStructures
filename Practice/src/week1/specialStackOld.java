package week1;

/**
 * Program: specialStack.java
 * Author: Joey Maffiola
 * Class: COMPSCI 220-02
 * Date: Jan 28, 2023
 */

public class specialStackOld {
	private int maxStackSize, positiveTopOfStack, negativeTopOfStack, topOfStack;
	private int[] stack;

	public specialStackOld(int maxStackSize) {
		if (maxStackSize <= 0) {
			System.out.println("Stack size must be a positive intager.");
		} else {
			this.maxStackSize = maxStackSize;
			positiveTopOfStack = -1;
			negativeTopOfStack = -1;
			topOfStack = -1;
			stack = new int[this.maxStackSize];
		}
	} // end specialStack

	public void push(int i) {
		if (topOfStack == maxStackSize - 1) {
			System.out.println("Push failed, stack is full.");
		} else if (i >= 0) {
			stack[++topOfStack] = i;
			positiveTopOfStack = topOfStack;
		} else {
			stack[++topOfStack] = i;
			negativeTopOfStack = topOfStack;
		}
	} // end push

	public int pop() throws IndexOutOfBoundsException {
		if (topOfStack <= -1) {
			throw new IndexOutOfBoundsException("Pop failed, stack is empty.");
		} else if (stack[topOfStack] >= 0) {
			popNonNeg();
		} else {
			popNeg();
		}
		throw new IndexOutOfBoundsException("Pop failed");
	} // end pop

	public int peek() throws IndexOutOfBoundsException {
		if (topOfStack <= -1) {
			throw new IndexOutOfBoundsException("Peek failed, stack is empty.");
		} else {
			return stack[topOfStack];
		}
	} // end peek

	public int size() {
		return topOfStack + 1;
	} // end size

	public int popNeg() throws IndexOutOfBoundsException {
		if (topOfStack <= -1) {
			throw new IndexOutOfBoundsException("Pop failed, stack is empty.");
		} else {
			int neg = stack[negativeTopOfStack];
			// Find new negativeTopOfStack
			for (int i = negativeTopOfStack - 1; i > -1; i--) {
				if (stack[i] < 0) {
					negativeTopOfStack = i;
					break;
				}
			} // end for

		}

		return maxStackSize; // very wrong
	} // end popNeg

	public int popNonNeg() {
		return maxStackSize; // very wrong

	} // end popNonNeg
}
