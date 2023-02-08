package oldPA6;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

	public int distance[], parent[];
	private boolean closed[];

	public Dijkstra(String filePath) throws FileNotFoundException { // complete this constructor
		Graph g =  IOHelper.readWeightedGraph(filePath);
		numVertices = g.numVertices;
		adjList = g.adjList;
	}

	public void execute(int source) { // complete this method
		distance = new int[numVertices];
		parent = new int[numVertices];
		closed = new boolean[numVertices];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		} // end for
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		} // end for
		for (int i = 0; i < closed.length; i++) {
			closed[i] = false;
		} // end for
		distance[source] = 0;
		PriorityQueue<PriorityQueuePair> open = new PriorityQueue<PriorityQueuePair>(new PriorityQueuePairComparator());
		PriorityQueuePair pair = new PriorityQueuePair(source, 0);
		open.add(pair);
		while (!open.isEmpty()) {
			pair = open.remove();
			int minVertex = pair.item;
			if (closed[minVertex]) {
				continue;
			}
			closed[minVertex] = true;
			ArrayList<Edge> edgeList = adjList.get(minVertex);
			for (Edge adjEdge : edgeList) {
				int adjVertex = adjEdge.dest;
				if (!closed[adjVertex]) {
					int newDist = distance[minVertex] + adjEdge.weight;
					while (newDist < distance[adjVertex]) {
						distance[adjVertex] = newDist;
						parent[adjVertex] = minVertex;
						PriorityQueuePair e = new PriorityQueuePair(adjVertex, newDist);
						open.add(e);
					}
				}
			}
		}
	} // end execute
}
