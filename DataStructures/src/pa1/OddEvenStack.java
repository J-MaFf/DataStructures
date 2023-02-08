package pa1;
import java.util.Arrays;

import javax.management.AttributeNotFoundException;

public class OddEvenStack {

	private int maxStackSize, oddTos, evenTos;
	private int[] stack;

	/**
	 * OddEvenStack constructor
	 * 
	 * @param maxStackSize the maximum size of the stack
	 */
	public OddEvenStack(int maxStackSize) { // complete the constructor
		if (maxStackSize <= 0)
			System.out.println("Stack size should be a positive integer.");
		else {
			this.maxStackSize = maxStackSize;
			stack = new int[this.maxStackSize];
			oddTos = -1;
			evenTos = this.maxStackSize;
		}

	}

	/**
	 * "push" method: If the stack is already full, then don’t add anything. Otherwise if the number to be
	 * added is odd, then increment oddTos and place the number. Otherwise, the number is even;
	 * decrement evenTos and place the number
	 * 
	 * @param val the value to be pushed
	 */
	public void push(int val) { // complete this method
		if (oddTos + evenTos == maxStackSize + 1) { // If the stack is already full, then don’t add anything.
			System.out.print("Cannot push! Stack is full.");
		} else {

			if (val % 2 == 1) { // number is odd
				// then increment oddTos and place the number
				stack[++oddTos] = val;
			} else { // number is even
				stack[--evenTos] = val;
			}
		}
	} // end push

	/**
	 * "popOdd" method: If there is no odd number in the stack (use oddTos to find this),
	 * then there is nothing to do. Otherwise, use oddTos to return and remove the latest added odd number.
	 * 
	 * @return the latest added odd number
	 */
	public int popOdd() throws AttributeNotFoundException { // complete this method
		if (oddTos == -1) { // if no odd numbers in the stack
			//throw new AttributeNotFoundException();
			System.out.print("Cannot pop! No odd numbers in stack.");
			
			return -1;
		} else { // odd number found in stack
			// return and remove the latest added odd number
			return stack[oddTos--];
		}
	} // end popOdd

	/**
	 * "popEven" method: If there is no even number in the stack (use evenTos to find this), then there is
	 * nothing to do. Otherwise, use evenTos to return and remove the latest added even number.
	 * 
	 * @return the latest added even number
	 * @throws AttributeNotFoundException if no even numbers are in the stack
	 */
	public int popEven() throws AttributeNotFoundException { // complete this method
		if (evenTos == maxStackSize) { // if no even numbers are in the stack
			//throw new AttributeNotFoundException();
			System.out.print("Cannot pop! No even numbers in stack.");
			return -1;
		} else { // even number found in the stack
			// return and remove the latest added even number
			return stack[evenTos++];
		}
	}

	/**
	 * "size" method: Returns the size of the stack by adding up the values.
	 * @return the size of the stack
	 */
	public int size() { // complete this method
		if (oddTos + evenTos == maxStackSize) {
			return maxStackSize;
		} else {
			int oddSize = oddTos + 1;
			int evenSize = maxStackSize - evenTos;
			return oddSize + evenSize;
		}
	}

	public String toString() {
		return Arrays.toString(stack);
	}
}
