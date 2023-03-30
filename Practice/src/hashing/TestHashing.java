package hashing;

public class TestHashing {

    public static void main(String[] args) {
        // Test countCommon
        NaiveHashTable a = new NaiveHashTable(10);
        NaiveHashTable b = new NaiveHashTable(15);

        // A = {1, 2, 4, 5, 6, 8, 9}
        a.insert(1);
        a.insert(2);
        a.insert(4);
        a.insert(5);
        a.insert(6);
        a.insert(8);
        a.insert(9);

        // B = {1, 2, 3, 4, 5, 7, 9, 10, 11, 12, 13, 14}
        b.insert(1);
        b.insert(2);
        b.insert(3);
        b.insert(4);
        b.insert(5);
        b.insert(7);
        b.insert(9);
        b.insert(10);
        b.insert(11);
        b.insert(12);
        b.insert(13);
        b.insert(14);

        System.out.println("Test countCommon");
        System.out.print("a: ");
        a.print();
        System.out.print("b: ");
        b.print();

        System.out.println("Common: " + a.countCommon(b));

        // Test characterFrequency
        NaiveHashTable letterTable = new NaiveHashTable(26);
        System.out.println("Test characterFrequency");
        letterTable.characterFrequency("Hello world");

        // Test isAnagram
        NaiveHashTable anagramOrNot = new NaiveHashTable(26);
        boolean firstTest = anagramOrNot.isAnagram("listen", "silent");
        boolean secondTest = anagramOrNot.isAnagram("listen", "silen");
        System.out.println("Test isAnagram");
        System.out.println("listen, silent: " + firstTest);
        System.out.println("listen, silenp: " + secondTest);
    } // end main
} // end class TestHashing
