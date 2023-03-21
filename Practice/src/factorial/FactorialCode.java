/**
 * Program: FactorialCode.java
 * Author: Joey Maffiola
 * Class: 
 * Date: Mar 2, 2023
 */
package factorial;

public class FactorialCode {
	// n! = n * (n-1) * (n-2) * (n-3) ... * 3 * 2 * 1
	/**
	 * "getFactorial" method: This method will take a number and return the factorial of that number. We will do this by using recursion.
	 * @param number - The number to take the factorial of
	 */
	public int getFactorial(int number) {
		// First, we will check if the number is base case 
		if (number < 2 ) { 
			return 1;
		}
		// Recursive rule:
		return number * getFactorial(number - 1);
	} // end takeFactorial 
}