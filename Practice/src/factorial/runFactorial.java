/**
 * Program: runFactorial.java
 * Author: Joey Maffiola
 * Class: 
 * Date: Mar 2, 2023
 */
package factorial;

public class runFactorial {
	public static void main(String[] args) {
		// Lets take the factorial of 3
		int number = 3;
		// Create a new FactorialCode object
		FactorialCode factorial = new FactorialCode();
		// Call the getFactorial method
		int factorialNumber = factorial.getFactorial(number);
		// Print the factorial of the number
		System.out.println("The factorial of " + number + " is " + factorialNumber);

	}
}
