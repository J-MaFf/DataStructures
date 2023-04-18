package pa5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Graph {

    public int level[];

    public BFS(String filePath) throws Exception {
        readUnweightedGraph(filePath);
    }

    /**
     * Initializes the level array to Integer.MAX_VALUE.
     */
    private void initialize() {
        level = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            level[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * Performs a breadth-first traversal of the graph starting at vertex s.
     * @param s the starting vertex
     */
    private void traverse(int s) {
        Queue<Integer> vertexQ = new LinkedList<Integer>();
        vertexQ.add(s);
        level[s] = 0;
        while (vertexQ.size() > 0) {
            int v = vertexQ.remove();
            Iterator<Edge> it = adjList.get(v).iterator();
            while (it.hasNext()) {
                Edge e = it.next();
                int w = e.dest;
                if (level[w] == Integer.MAX_VALUE) {
                    level[w] = level[v] + 1;
                    vertexQ.add(w);
                }
            }
        }
    }

    /**
     * Initializes and Executes a breadth-first traversal of the graph starting at vertex s.
     * @param s the starting vertex
     */
    public void execute(int s) {
        initialize();
        traverse(s);
    }

    /**
     * Counts the number of connected components in the graph.
     * @return the number of connected components
     */
    public int countComponents() {
        initialize();
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (level[i] == Integer.MAX_VALUE) {
                traverse(i);
                count++;
            }
        }
        return count;
    }

    /**
     * Computes the transitive closure of the graph.
     * @return a boolean matrix M such that M[i][j] is true if there is a path from i to j.
     */
    public boolean[][] computeTransitiveClosure() {
        boolean[][] M = new boolean[numVertices][];
        for (int i = 0; i < numVertices; i++) {
            M[i] = new boolean[numVertices];
            execute(i);
            for (int j = 0; j < numVertices; j++) {
                M[i][j] = (level[j] != Integer.MAX_VALUE); // true if there is a path from i to j
            }
        }
        return M;
    }
}
