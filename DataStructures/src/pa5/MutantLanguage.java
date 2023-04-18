package pa5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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

    /**
     * Builds a directed graph based on the input words by creating edges between vertices
     * that differ by only one character. The graph is represented using an adjacency list
     * and the in-degree of each vertex is calculated.
     */

    private void makeGraph() {
        inDegree = new int[numVertices];
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            inDegree[i] = 0;
            adjList.add(new LinkedList<Edge>());
        }
        for (int i = 0; i < numWords - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            int minLength = Math.min(currentWord.length(), nextWord.length());
            for (int j = 0; j < minLength; j++) {
                char x = currentWord.charAt(j);
                char y = nextWord.charAt(j);
                if (x != y) {
                    int src = x - 'a';
                    int dest = y - 'a';
                    Edge e = new Edge(src, dest);
                    adjList.get(src).add(e);
                    inDegree[dest]++;
                    break;
                }
            }
        }
    }

    /**
     * This method uses topological sorting to find the order of the characters
     * or detect that the graph has a cycle.
     * @return If the graph has a cycle, the method
     * returns null. Otherwise, it returns an array of characters that represents
     * the order of the characters.
     * @throws Exception
     */
    public char[] getOrder() throws Exception {
        char[] topoOrder = new char[numVertices];

        Queue<Integer> vertexQ = new LinkedList<>();
        int topoLevel = 0;
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                vertexQ.add(i);
            }
        }
        while (vertexQ.size() > 0) {
            int v = vertexQ.remove();
            topoOrder[topoLevel++] = (char) (v + 'a');
            LinkedList<Edge> row = adjList.get(v);
            Iterator<Edge> it = row.iterator();
            while (it.hasNext()) {
                Edge adjEdge = it.next();
                int w = adjEdge.dest;
                inDegree[w]--;
                if (inDegree[w] == 0) {
                    vertexQ.add(w);
                }
            }
        }
        /* we return null when all vertices have not been added to the topological
        order, which implies that the graph has a cycle and an ordering of the characters (and
        hence words) cannot be obtained. */
        if (topoLevel != numVertices) {
            return null;
        } else {
            return topoOrder;
        }
    }
}
