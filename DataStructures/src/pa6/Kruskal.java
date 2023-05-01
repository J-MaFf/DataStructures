package pa6;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal extends Graph {

    public Kruskal(String filePath) throws FileNotFoundException {
        Graph g = IOHelper.readWeightedGraph(filePath);
        this.numVertices = g.numVertices;
        this.adjList = g.adjList;
    } // complete this constructor

    // create a comparator to compare edges based on their weights
    class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.weight - e2.weight;
        }
    }

    public ArrayList<Edge> runKruskal() {
        ArrayList<Edge> edgeList = new ArrayList<>();
        // Sort edgeList in non-decreasing order based on the weights of each edge. use EdgeComparator
        for (int i = 0; i < numVertices; i++) {
            for (Edge e : adjList.get(i)) {
                if (e.src < e.dest) edgeList.add(e);
            }
        }
        Collections.sort(edgeList, new EdgeComparator());

        // Create a union-find object
        UnionFind objUF = new UnionFind(numVertices);
        ArrayList<Edge> mst = new ArrayList<>();
        int numEdgesAdded = 0;
        for (Edge e : edgeList) {
            int src = e.src;
            int dest = e.dest;
            // if src and dest are in different components
            if (objUF.find(src) != objUF.find(dest)) {
                objUF.doUnion(src, dest);
                mst.add(e);
                numEdgesAdded++;
                if (numEdgesAdded == numVertices - 1) break;
            }
        }
        return mst;
    } // complete this method
}
