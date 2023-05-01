package pa5;

import java.io.File;
import java.util.Arrays;

public class customTest {

    static final String DIRECTED_GRAPH1_PATH = "directed1.txt";
    static final String DIRECTED_GRAPH2_PATH = "directed2.txt";
    static final String UNDIRECTED_GRAPH1_PATH = "undirected1.txt";
    static final String UNDIRECTED_GRAPH2_PATH = "undirected2.txt";
    static final String MUTANT1_PATH = "mutant1.txt";
    static final String MUTANT2_PATH = "mutant2.txt";
    static final String MUTANT3_PATH = "mutant3.txt";

    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory is: " + currentDirectory);

        testOrdered();
        System.out.println();
        testZeroSum();
        System.out.println();
        testHeavyHitters();
        System.out.println();
        testBFS(DIRECTED_GRAPH1_PATH);
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

    private static void testZeroSumHelper(int[] arr, int len) {
        boolean isZero = SetsAndMaps.zeroSumSubArray(arr, len);
        System.out.printf("\n%s", Arrays.toString(arr));
        if (!isZero) System.out.printf(
            " has no subarray whose sum is zero."
        ); else System.out.printf(" has a subarray whose sum is zero.");
    }

    private static void testZeroSum() {
        System.out.println("*** Using Unordered Set & Map ***");
        int[] arr1 = { 12, -26, 1, 8, 9, -6, 4, -12, -3, 12 };
        testZeroSumHelper(arr1, arr1.length);
        int[] arr2 = { 1, 7, 19, -14, 1, -14, 12 };
        testZeroSumHelper(arr2, arr2.length);
        int[] arr3 = { 1, 7, 19, -14, 1, -14, 8, 9, -6, 4, -12, -3, 12 };
        testZeroSumHelper(arr3, arr3.length);
        int[] arr4 = { -6, 4, -12, -3, 12 };
        testZeroSumHelper(arr4, arr4.length);
        int[] arr5 = { -6, 4, -12, 0, -3, 12 };
        testZeroSumHelper(arr5, arr5.length);
        int[] arr6 = { 0, -6, 4, -12, -3, 12 };
        testZeroSumHelper(arr6, arr6.length);
        int[] arr7 = { 1, 8, 9, -6, 4, -12, -3 };
        testZeroSumHelper(arr7, arr7.length);
        int[] arr8 = { 1, 8, 9, 0 };
        testZeroSumHelper(arr8, arr8.length);
    }

    private static void testHeavyHitters() {
        System.out.println();
        int[] arr = { 5, 3, 4, 5, 1, 3, 5, 3, 9, 4, 9, 2, 3, 8, 3, 0, 9, 3, 9 };
        System.out.println("Array is: " + Arrays.toString(arr));
        for (int i = 2; i <= 9; i++) System.out.printf(
            "%d-heavy hitters are: %s\n",
            i,
            SetsAndMaps.kHeavyHitters(arr, arr.length, i)
        );
    }

    private static void testBFS(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return;
            }

            BFS bfs = new BFS(filePath);
            for (int j = 0; j < bfs.numVertices; j++) {
                bfs.execute(j);
                System.out.println(
                    "Level array (from v" +
                    j +
                    "):   " +
                    Arrays
                        .toString(bfs.level)
                        .replaceAll("" + Integer.MAX_VALUE, "infty")
                );
            }
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
