package oldPA3;


/**
 * The Class Recursion.
 */
public class Recursion {

	/**
	 * Sum even digits.
	 *
	 * @param n the n
	 * @return the sum of digits in n that are even
	 */
	public static int sumEvenDigits(int n) { // complete this function
		if (n < 10) {
			if (n % 2 == 0) {
				return n;
			} else {
				return 0;
			}
		} // end base case
		int remainder = n % 10;
		if (remainder % 2 == 1) {
			return sumEvenDigits(n / 10);
		} else {
			return remainder + sumEvenDigits(n / 10);
		}
	}

	/**
	 * Binary strings with more ones.
	 *
	 * @param n the n
	 */
	public static void binaryStringsWithMoreOnes(int n) {
		binaryStringsWithMoreOnes("", 0, 0, n);
	}

	/**
	 * Binary strings with more ones.
	 *
	 * @param str       the str
	 * @param numZeroes the num zeroes
	 * @param numOnes   the num ones
	 * @param n         the n
	 */
	private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) { // complete this function
		if (str.length() == n && numZeroes < numOnes) {
			System.out.println(str);
		} else if (str.length() < n) {
			binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n);
			binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n);
		}
	}
}