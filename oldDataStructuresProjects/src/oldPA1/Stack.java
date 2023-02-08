package oldPA1;

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
	}

	public void push(int val) { // complete this method
		if (topOfStack == maxStackSize - 1) {
			System.out.println("Cannot push! Stack is full");
		} else {
			stack[++topOfStack] = val;
		}
	}

	public int pop() { // complete this method
		if (topOfStack == -1) {
			System.out.println("Cannot pop! Stack is empty");
			return -1; // Maybe wrong
		} else {
			return stack[topOfStack--];
		}
	}

	public int size() { // complete this method
		return topOfStack + 1;
	}
}
