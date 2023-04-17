package pa5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetsAndMaps {

    /**
     * returns the alphabet of a given array of characters in sorted order, i.e.,
     * this method returns the distinct characters in the array in sorted order.
     *
     * The time complexity of this method is O(n log n)
     *
     * @param arr the array of characters
     * @param len the length of the array
     * @return the alphabet of the array in sorted order
     */
    public static ArrayList<Character> sortedAlphabet(char[] arr, int len) {
        TreeSet<Character> charSet = new TreeSet<>();
        ArrayList<Character> charList = new ArrayList<>();
        // take all the characters from the array and insert them into the ordered set
        for (int i = 0; i < len; i++) { // O(n)
            charSet.add(arr[i]); // O(log n)
        }
        // Sets only keep unique characters, so we can just iterate through the set and add them to the list
        Iterator<Character> it = charSet.iterator();
        while (it.hasNext()) {
            charList.add(it.next());
        }
        return charList;
    }

    /**
     * Sorts an array of characters in ascending order using a tree map. each character
     * must appear as many time as present in the original array
     */
    public static void bstSort(char[] arr, int len) {
        // Create an ordered map to store the characters and their frequencies
        TreeMap<Character, Integer> charMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            if (!charMap.containsKey(arr[i])) { // Key not found
                charMap.put(arr[i], 1);
            } else { // Key found
                charMap.put(arr[i], charMap.get(arr[i]) + 1);
            }
        }
        // Now we can iterate through the map and add the characters to the array
        int index = 0;
        Iterator it = charMap.keySet().iterator();
        while (it.hasNext()) {
            char key = (char) it.next();
            int freq = charMap.get(key);
            for (int i = 0; i < freq; i++) {
                arr[index] = key;
                index++;
            }
        }
    }

    /**
     * checks if an array contains a subarray whose sum is zero
     *
     * The time complexity of this method is O(n)
     * @param arr the array of integers
     * @param len the length of the array
     * @return true if the array contains a subarray whose sum is zero, false otherwise
     */
    public static boolean zeroSumSubArray(int[] arr, int len) {
        // Create an integer UNORDERED set.
        HashSet<Integer> unorderedSet = new HashSet<>();
        int prefixSum = 0;
        for (int i = 0; i < len; i++) {
            prefixSum += arr[i];
            // If the prefix sum is 0, then we found a subarray with sum 0
            if (prefixSum == 0) {
                return true;
            }
            // If the prefix sum is already in the set, then we found a subarray with sum 0
            if (unorderedSet.contains(prefixSum)) {
                return true;
            }
            // Add the prefix sum to the set because we haven't found a subarray with sum 0 yet
            unorderedSet.add(prefixSum);
        }
        // If we reach this point, then no subarray with sum 0 was found
        return false;
    }

    /**
     * returns the k heavy hitters in an array of integers. A heavy hitter is an
     * integer that appears more than n/k times in the array.
     *
     * @param arr the array of integers
     * @param len the length of the array
     * @param k the value of k
     * @return  an array list containing the k heavy hitters in the array
     */
    public static ArrayList<Integer> kHeavyHitters(int[] arr, int len, int k) {
        // Create an integer UNORDERED map
        HashMap<Integer, Integer> unorderedMap = new HashMap<>();
        // Compute the frequencies of each number in the array and store them in the map
        for (int i = 0; i < len; i++) {
            if (!unorderedMap.containsKey(arr[i])) { // Key not found
                unorderedMap.put(arr[i], 1);
            } else { // Key found
                unorderedMap.put(arr[i], unorderedMap.get(arr[i]) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList();
        // Iterate through the map and add the keys to the list if their frequency is greater than len / k
        Iterator it = unorderedMap.keySet().iterator();
        while (it.hasNext()) {
            int key = (int) it.next();
            int freq = unorderedMap.get(key);
            if (freq > len / k) {
                list.add(key);
                // Set the frequency of the key to 0 so that we don't add it again
                unorderedMap.put(key, 0);
            }
        }
        return list;
    }
}
