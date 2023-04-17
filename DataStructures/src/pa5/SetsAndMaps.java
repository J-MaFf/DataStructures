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

    public static boolean zeroSumSubArray(int[] arr, int len) {} // complete this method

    public static ArrayList<Integer> kHeavyHitters(int[] arr, int len, int k) {} // complete this method\
}
