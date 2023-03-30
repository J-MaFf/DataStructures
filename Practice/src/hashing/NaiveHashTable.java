package hashing;

import javax.print.attribute.standard.MediaSize.NA;

public class NaiveHashTable {

    private int[] table;
    private int size;

    // NaiveHashTable constructor
    public NaiveHashTable(int size) {
        this.size = size;
        table = new int[size];
    } // end constructor

    // Methods

    /**
     * countCommon - counts the number of common elements between two NaiveHashTable objects
     * @param compareTo - the NaiveHashTable object to compare to
     * @return the number of common elements
     */
    public int countCommon(NaiveHashTable compareTo) {
        int count = 0;
        int size = 0;

        // Determine which table is smaller
        if (this.size > compareTo.size) {
            size = compareTo.size;
        } else {
            size = this.size;
        }

        // Loop through the smaller table and count the number of common elements
        for (int i = 0; i < size; i++) {
            if (this.search(i) && compareTo.search(i)) {
                count++;
            }
        }

        return count;
    } // end countCommon

    /**
     * characterFrequency - counts the number of times each character occurs in a string and prints the results
     * @param s - the string to count the characters in
     */
    public void characterFrequency(String s) {
        int[] letterCount = new int[26];
        s = s.toLowerCase();

        // Populate letterTable with the characters in s and count the number of characters
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == ' ') continue; // Ignore spaces

            int charIndex = currentChar - 'a';
            if (!this.search(charIndex)) {
                this.insert(charIndex);
                letterCount[charIndex]++;
            } else {
                letterCount[charIndex]++;
            }
        }

        // Print the characters and their frequencies
        for (int i = 0; i < 26; i++) {
            if (this.search(i)) {
                System.out.println((char) (i + 'a') + ": " + letterCount[i]);
            }
        }
    } // end characterFrequency

    /*
     * Given two strings of lengths N & M, assuming constant time hashing,
     * write an O(N+M) time program to determine if the strings are anagrams of each other.
     */

    public boolean isAnagram(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        // Count the frequency of characters in the first word
        for (int i = 0; i < firstWord.length(); i++) {
            char currentChar = firstWord.charAt(i);
            if (currentChar == ' ') {
                continue; // Ignore spaces
            }
            charCounts[currentChar - 'a']++;
        }

        // Check the frequency of characters in the second word
        for (int i = 0; i < secondWord.length(); i++) {
            char currentChar = secondWord.charAt(i);
            if (currentChar == ' ') {
                continue; // Ignore spaces
            }
            if (--charCounts[currentChar - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    // insert
    public void insert(int key) {
        table[key] = 1;
    } // end insert

    // search
    public boolean search(int key) {
        if (table[key] == 1) {
            return true;
        } else {
            return false;
        }
    } // end search

    // delete
    public void delete(int key) {
        table[key] = 0;
    } // end delete

    // print
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(table[i] + " ");
        }
        System.out.println();
    } // end print
} // end class NaiveHashTable
