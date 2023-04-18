package pa5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MutantLanguage extends Graph {

    private String words[];
    private int numWords;
    private int inDegree[];

    public MutantLanguage(String filePath) throws FileNotFoundException {
        readLanguage(filePath);
        makeGraph();
    }

    /**
     * Reads the language from the file and stores it in the words array.
     * @param filePath the path to the file
     * @throws FileNotFoundException if the file is not found
     */
    private void readLanguage(String filePath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new FileInputStream(filePath));
        numVertices = fileReader.nextInt();
        numWords = fileReader.nextInt();
        words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            words[i] = fileReader.next();
        }
        fileReader.close();
    }

    private void makeGraph() {} // complete this method

    public char[] getOrder() throws Exception {} // complete this method
}
