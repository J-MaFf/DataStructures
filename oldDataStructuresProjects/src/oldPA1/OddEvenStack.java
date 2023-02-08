package oldPA1;

import java.util.Arrays;

public class OddEvenStack {

	private int maxStackSize, oddTos, evenTos;
	private int[] stack;

	public OddEvenStack(int maxStackSize) { // complete the constructor
		if (maxStackSize <= 0)
			System.out.println("Stack can not be negative.");
		else {
			this.maxStackSize = maxStackSize;
			stack = new int[maxStackSize]; //Initialize stack array
			evenTos = maxStackSize;
			oddTos = -1;
		}

	}

	public void push(int val) { // complete this method
		if ((maxStackSize - evenTos) + (oddTos + 1) == maxStackSize) {
			System.out.println("Cannot push! Stack is full.");
		} else if (val % 2 == 0) { // if even
			evenTos--;
			stack[evenTos] = val;
		} else {
			oddTos++;
			stack[oddTos] = val;
		}
	}

	public int popOdd() { // complete this method
		if (oddTos == -1) {
			System.out.println("Cannot pop! Odd is empty.");
			return oddTos;
		} else {
			return stack[oddTos--];
		}

	}

	public int popEven() { // complete this method
		if (evenTos == maxStackSize) {
			System.out.println("Cannot pop! Even is empty.");
			return -1;
		} else {
			return stack[evenTos++];
		}
	}

	public int size() { // complete this method
		return (maxStackSize - evenTos) + (oddTos + 1);
	}

	public String toString() {
		return Arrays.toString(stack);
	}
}
