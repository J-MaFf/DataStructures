package pa5;

import java.util.Arrays;

public class customTest {

    public static void main(String[] args) {
        testOrdered();
    }

    public static void testOrdered() {
        System.out.println("*** Using Ordered Set & Map ***\n");
        char[] str = {
            'a',
            'b',
            'r',
            'a',
            'c',
            'a',
            'd',
            'a',
            'b',
            'r',
            'a',
            '$',
        };
        System.out.println(
            "Alphabet of " +
            Arrays.toString(str) +
            " is " +
            SetsAndMaps.sortedAlphabet(str, str.length)
        );

        System.out.print("Sorted order of " + Arrays.toString(str) + " is ");
        SetsAndMaps.bstSort(str, str.length);
        System.out.println(Arrays.toString(str));
    }
}
