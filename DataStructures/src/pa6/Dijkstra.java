package pa6;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

    public int distance[], parent[];
    private boolean closed[];

    /**
     * Constructs a new Dijkstra object.
     * @param filePath the path to the file
     * @throws FileNotFoundException if the file is not found
     */
    public Dijkstra(String filePath) throws FileNotFoundException {
        Graph g = IOHelper.readWeightedGraph(filePath);
        this.numVertices = g.numVertices;
        this.adjList = g.adjList;
    } // complete this constructor

    public void execute(int source) {
        distance = new int[numVertices];
        parent = new int[numVertices];
        closed = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            closed[i] = false;
        }
        distance[source] = 0;

        PriorityQueue<PriorityQueuePair> open = new PriorityQueue<>(new PriorityQueuePairComparator());
        open.add(new PriorityQueuePair(source, 0));
        while (!open.isEmpty()) {
            PriorityQueuePair minElement = open.poll();
            int minVertex = minElement.item;
            // skip this vertex if it has already been closed
            if (closed[minVertex]) continue;
            closed[minVertex] = true;
            // for each outgoing edge adjEdge of minVertex
            for (Edge adjEdge : adjList.get(minVertex)) {
                int adjVertex = adjEdge.dest;
                if (!closed[adjVertex]) {
                    int newDist = distance[minVertex] + adjEdge.weight;
                    // use Dijkstra's edge relaxation rule to update the distance of adjVertex
                    if (newDist < distance[adjVertex]) {
                        distance[adjVertex] = newDist;
                        parent[adjVertex] = minVertex;
                        open.add(new PriorityQueuePair(adjVertex, newDist));
                    }
                }
            }
        }
    } // complete this method
}
