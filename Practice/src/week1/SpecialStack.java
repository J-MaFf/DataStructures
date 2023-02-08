package week1;
import java.util.Arrays;

import javax.management.AttributeNotFoundException;

/**
 * Program: SpecialStack.java
 * Author: Joey Maffiola
 * Class: COMPSCI 223
 * Date: Jan 29, 2023
 */
public class SpecialStack {

	private int maxStackSize, positiveTopOfStack, negativeTopOfStack, size;
	private int[] stack;

	/**
	 * @param maxStackSize maximum size of the stack
	 */
	public SpecialStack(int maxStackSize) {
		if (maxStackSize <= 0)
			System.out.println("Stack size should be a positive integer.");
		else {
			this.maxStackSize = maxStackSize;
			positiveTopOfStack = maxStackSize - 1;
			negativeTopOfStack = 0;
			size = 0;
			stack = new int[maxStackSize];
		}
	}

	/**
	 * @return the stack
	 */
	public int[] getStack() {
		return stack;
	}

	/**
	 * Adds a number val (positive, negative, or zero)
	 * to the stack as long as there is an empty cell in the array.
	 * Your implementation MUST allow a push as long as size() < N.
	 * 
	 * @param val the value being added to the stack.
	 */
	public void push(int val) { // Modified for pos / neg
		if (size == maxStackSize) { // if stack is full
			System.out.println("Cannot push " + val + "! Stack is full");
		} else { // if stack is not full
			if (val >= 0) { // if val = positive
				stack[positiveTopOfStack--] = val;
				size++;
			} else { // if val = negative
				stack[negativeTopOfStack++] = val;
				size++;
			}
			System.out.println("Pushed " + val + " sucessfully.");

		}
		System.out.println(Arrays.toString(stack));
	} // end push

	/**
	 * Returns and removes the latest added negative number from the stack
	 * 
	 * @return the latest added negative number from the stack
	 * @throws AttributeNotFoundException if there are no negative numbers in the stack
	 */
	public int popNeg() throws AttributeNotFoundException {
		if (negativeTopOfStack == 0) { // if no negative numbers in the stack
			throw new AttributeNotFoundException("There are no negative numbers in the stack.");
		} else { // if there is a negative number in the stack
			size--;
			int val = stack[--negativeTopOfStack];
			System.out.println("Popped " + val + " sucessfully.");
			stack[negativeTopOfStack] = 0;
			System.out.println(Arrays.toString(stack));

			return val;
		}
	}

	/**
	 * Returns and removes the latest added positive number from the stack
	 * 
	 * @return Returns the latest added positive number from the stack
	 * @throws AttributeNotFoundException if there are no positive numbers in the stack
	 */
	public int popNonNeg() throws AttributeNotFoundException {
		if (positiveTopOfStack == maxStackSize - 1) { // if are no positive numbers in the stack
			throw new AttributeNotFoundException("There are no positive numbers in the stack.");
		} else { // if there is a positive number in the stack
			size--;
			int val = stack[++positiveTopOfStack];
			System.out.println("Popped " + val + " sucessfully.");
			stack[positiveTopOfStack] = 0;
			System.out.println(Arrays.toString(stack));

			return val;
		}
	}

	/**
	 * @return how many elements are in the array
	 */
	public int size() {
		/*
		 * int pos, neg;
		 * pos = (maxStackSize - 1) - positiveTopOfStack;
		 * neg = negativeTopOfStack;
		 */
		System.out.println("Size is " + size + "\n");
		return size;
	}

}
