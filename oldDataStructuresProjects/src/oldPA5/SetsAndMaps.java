package oldPA5;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetsAndMaps {

	public static ArrayList<Character> sortedAlphabet(char[] arr, int len) { // complete this method
		// Note that the ordered set will directly solve this. So, create an ORDERED set. You will also need to return the alphabet in a
		// dynamic array; so, create one.
		// Notice that the input array contains characters; so, your dynamic array and ordered set should also be able to store
		// characters.
		TreeSet<Character> orderedSet = new TreeSet<>();
		ArrayList<Character> dynamicArray = new ArrayList<>();

		// Now, take all the characters from the array and insert them into the ordered set.
		for (char c : arr) {
			orderedSet.add(c);
		}
		// Since sets will only keep unique characters, you are pretty much done – all duplicates have been removed.
		// Just an use iterator on the set to retrieve the numbers one-by-one,and insert them into a dynamic array.
		Iterator<Character> iterator = orderedSet.iterator();
		while (iterator.hasNext()) {
			dynamicArray.add(iterator.next());
		}
		// Once all numbers have been added, return the dynamic array.
		return dynamicArray;
	}

	public static void bstSort(char[] arr, int len) { // complete this method
		// First create a character-integer ORDERED map.
		TreeMap<Character, Integer> orderedMap = new TreeMap<>();
		// Now, loop over the array. Within the loop:
		for (char c : arr) {
			/*
			 * – If the current character in the array is not in the map as a key, then insert it into
			 * the map as key with value one. This implies that this is the first time you are
			 * seeing the character, and so its frequency is one.
			 */
			if (!orderedMap.containsKey(c)) {
				orderedMap.put(c, 1);
			}
			/*
			 * – Else, get the stored frequency (i.e., value) of the current character (as key) from
			 * the map. Add one to this value and reinsert into the map (as value once again)
			 * with key as the current character. This implies that you have seen the current
			 * character in the string prior to this occurrence, and so its frequency should be
			 * increased by one.
			 */
			else {
				int frequency = orderedMap.get(c);
				orderedMap.put(c, frequency + 1);
			}
		} // end for
		/*
		 * At this point, all frequencies have been computed and are stored in the map as a
		 * character to frequency map. So, iterate over the map; note that you will iterate in
		 * sorted order of keys.
		 */
		Iterator<Character> mapIterator = orderedMap.keySet().iterator();

		/*
		 * For each key c, obtain the corresponding value v; this tells you how many copies of c exists in the original array.
		 * So, place v copies of c one by one into the arr[ ] array; note that you may need a counter to go over the array arr[ ]
		 */
		int counter = 0;
		while (mapIterator.hasNext()) {
			char key = mapIterator.next();
			int value = orderedMap.get(key);

			for (int i = 0; i < value; i++) {
				arr[counter] = key;
				counter++;
			} // end for

		} // end while
	}

	public static boolean zeroSumSubArray(int[] arr, int len) { // complete this method
		// Create an integer unordered set
		HashSet<Integer> unorderedSet = new HashSet<>();
		// initialize prefixSum to 0
		int prefixSum = 0;
		// Traverse array and do the folowing
		for (int i : arr) {
			// Update prefixSum by adding the current number in the array to it
			prefixSum += i;
			// If prefixSum is zero, then there is obviously a zero-sum array. So, return true.
			if (prefixSum == 0) {
				return true;
			}
			// Now, check if the set contains the prefix sum. If it does, then we have seen this prefix sum before. That means we must have a
			// zero-sum array. So, return true.
			if (unorderedSet.contains(prefixSum)) {
				return true;
			}
			// A match with prefix sum was not found. So, insert the prefix sum into the set.
			unorderedSet.add(prefixSum);
		} // end for
			// never found 0 sum sub array so return false
		return false;
	}

	public static ArrayList<Integer> kHeavyHitters(int[] arr, int len, int k) { // complete this method
//		Create an integer UNORDERED map (be careful with the data types for the map).
		HashMap<Integer, Integer> unorderedMap = new HashMap<>();
		ArrayList<Integer> returnList = new ArrayList<>();
//		Traverse through the array to compute the frequency of each number and store them
//		in the hashmap (same technique as you did before with sorting via map).
		for (int i : arr) {
			if (!unorderedMap.containsKey(i)) {
				unorderedMap.put(i, 1);
			} else {
				int frequency = unorderedMap.get(i);
				unorderedMap.put(i, frequency + 1);
			}
		} // end for

		Iterator<Integer> mapIterator = unorderedMap.keySet().iterator();
		while (mapIterator.hasNext()) {
			int key = mapIterator.next();
			int value = unorderedMap.get(key);
			// Now, you just report those numbers from the map whose frequency is more than n/k.
			//		These frequent numbers are to be added to a dynamic array and returned back.
			//		Notice that there are no duplicates in the output. One way to ensure that is by setting
			//		the frequency of a number to zero (in the map) when you have already added that to
			//		the dynamic array.
			if (value > len / k) {
				returnList.add(key);
			}
		} // end while
		return returnList;
	}
}
