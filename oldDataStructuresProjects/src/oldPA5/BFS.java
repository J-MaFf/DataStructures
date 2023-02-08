package oldPA5;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Graph {

	public int level[];

	public BFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
	}

	private void initialize() { // complete this method
		// Allocate numVertices cells for the level[ ] array.
		level = new int[numVertices];

		// Use a loop to initialize all cells of level[ ] to ∞.
		for (int i : level) {
			i = Integer.MAX_VALUE;
		}
	}

	private void traverse(int s) { // complete this method
		// Create an integer queue vertexQ.
		LinkedList<Integer> vertexQ = new LinkedList<>();

		// • Enqueue s to vertexQ.
		vertexQ.add(s);

		// • Set level[s] = 0.
		level[s] = 0;
		// • while (vertexQ′s size > 0), do the following:
		while (vertexQ.size() > 0) {
			// – let v be the vertex obtained by dequeueing vertexQ
			int v = vertexQ.removeFirst();
			LinkedList<Edge> edgeList = adjList.get(v);

			// – Similar to what you did for the createOrder method in MutantLanguage, use an
			// iterator to visit each adjacent edge adjEdge of v, and do the following:
			Iterator<Edge> edgeIterator = edgeList.iterator();
			while (edgeIterator.hasNext()) {
				// ∗ let w be the destination of adjEdge
				Edge adjEdge = edgeIterator.next();
				int w = adjEdge.dest;

				// ∗ if (level[w] equals ∞) then
				if (level[w] == Integer.MAX_VALUE) {
					// · set level[w] to level[v] + 1
					level[w] = level[v + 1];
					// · enqueue w to vertexQ
					vertexQ.add(w);
				}
			}
		}
	}

	public void execute(int s) { // complete this method
		// Initialize BFS
		initialize();
		// Traverse from the vertex s
		traverse(s);

	}

	public int countComponents() { // complete this method

		// Initialize BFS
		initialize();
		// Initialize a counter to 0
		int counter = 0;

		for (int i = 0; i < numVertices; i++) {
			if (level[i] == Integer.MAX_VALUE) { // if (level value of vertex i is infinity) then
				// traverse from vertex i
				traverse(i);
				// Increment counter by 1
				counter++;
			} // end if
		} // end for

		return counter;

	}

	public boolean[][] computeTransitiveClosure() { // complete this method
		// Create a two-dimensional boolean matrix M that has numVertices many rows.
		boolean[][] M = new boolean[numVertices][];
		// • for (i = 0 to i < numVertices), do the following:
		for (int i = 0; i < numVertices; i++) {
			// – allocate numVertices many cells for row i of matrix M.
			M[i] = new boolean[numVertices];
			// – execute BFS from vertex i
			execute(i);
			// – using a loop for j = 0,1,2,...,numVertices−1 (all inclusive), set M[i][j] to true
			for (int j = 0; j < numVertices - 1; j++) {
				// if level[j] != ∞ (which means there is a path from i to j) return true, and false otherwise.
				if (level[j] != Integer.MAX_VALUE) {
					M[i][j] = true;
				} else {
					M[i][j] = false;
				}
			} // end for
		} // end for
			return M;

	}
}
