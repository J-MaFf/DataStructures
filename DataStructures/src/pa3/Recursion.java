package pa3;

public class Recursion {

	/**
	 * "sumEvenDigits" method: returns the sum of digits in n that are even
	 * 
	 * @param n the number to be processed
	 * @return the sum of digits in n that are even
	 */
	public static int sumEvenDigits(int number) {
		// Base case
		if (number < 10 && number % 2 != 0) { // number only has one digit and is odd
			return 0;
		} else if (number < 10) { // number is less than ten and even
			return number;
		}
		// Recursion rule
		// % (modulo) returns the remainder (the last digit) , while int division returns the remaining digits
		int lastDigit = number % 10;
		int remainingDigits = number / 10;
		if (lastDigit % 2 != 0) { // if the last digit is odd, we will not include it in the sum
			return sumEvenDigits(remainingDigits);
		} // Here , the last digit is even, so we will include it in the sum
		return lastDigit + sumEvenDigits(remainingDigits);
	}

	/**
	 * "binaryStringsWithMoreOnes" method:
	 * 
	 * @param n the number
	 */
	public static void binaryStringsWithMoreOnes(int n) {
		binaryStringsWithMoreOnes("", 0, 0, n);
	}

	/**
	 * "binaryStringsWithMoreOnes" method: prints all n-length binary strings having more ones than zeroes.
	 * 
	 * @param str       the string of binary
	 * @param numZeroes the number of 0's that occur
	 * @param numOnes   the number of 1's that occur
	 * @param n         the length of the binary string
	 */
	private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) {
		// Base case:
		if (str.length() == n && numZeroes < numOnes) {
			System.out.println(str);
			return;
		}
		// Recursive case
		else if (str.length() < n) {
			binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n);
			binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n);
		}
	}
}