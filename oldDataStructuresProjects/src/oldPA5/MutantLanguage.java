package oldPA5;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Year;
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

	private void readLanguage(String filePath) throws FileNotFoundException { // complete this method
		// Create a Scanner object fileReader on filePath.
		Scanner fileReader = new Scanner(new FileInputStream(filePath));

		// Read the number of distinct characters into the class-variable numVertices.
		numVertices = fileReader.nextInt();

		// Now, read the number of words in the language into the class-variable numWords
		numWords = fileReader.nextInt();
		// Allocate numWords cells for the class-array words. Note that words is a string array.
		words = new String[numWords];
		// Run a for loop from i = 0 to i < numWords.
		for (int i = 0; i < numWords; i++) {
			// Within the for-loop, use fileReader to read the line into the array cell words[i].
			words[i] = fileReader.next();
		} // end for
			// after loop, close file reader
		fileReader.close();

	}

	private void makeGraph() { // complete this method
		// Allocate numVertices cells for inDegree array.
		inDegree = new int[numVertices];
		// Allocate numVertices rows for adjList.
		adjList = new ArrayList<>(numVertices);

		// for (i = 0 to i < numVertices), do the following:
		for (int i = 0; i < numVertices; i++) {
			// set inDegree[i] to 0
			inDegree[i] = 0;

			// add a blank row to adjList. Adding this blank row is necessary so that we have reserved a row for each vertex,which will 
			// save us from a null pointer exception if we try to access an empty row (i.e., a vertex with no outgoing edges) later
			// on.
			adjList.add(new LinkedList<Edge>());

		} // end for

		// for (i = 0 to i < numWords −1), do the following:
		for (int i = 0; i < numWords - 1; i++) {
			// let currentWord be the word at index i of words[ ] array
			String currentWord = words[i];
			// let nextWord be the word at index i + 1 of words[ ] array
			String nextWord = words[i + 1];

			// let minLength be the minimum of the lengths of currentWord and nextWord.
			int minLength;
			// That is, if the lengths of currentWord and nextWord are 7 and 5 respectively,
			// then minLength = 5, and vice-versa. Ties are broken arbitrarily.
			if (currentWord.length() < nextWord.length()) {
				minLength = currentWord.length();
			} else {
				minLength = nextWord.length();
			}

			/*
			 * Now, we want to find the first character where currentWord and nextWord
			 * mismatch. Let this characters be x and y respectively. We want to draw an edge
			 * from the vertex for x to the vertex for y. Since x and y are lower-case characters
			 * with ASCII values starting from 97, and the graph can only support integers
			 * from 0, we subtract 97 from both x and y to reduce the scale (for any lower-case
			 * character) so that it starts from zero.
			 */
			for (int j = 0; j < minLength; j++) {
				// let x be the jth character of currentWord
				char x = currentWord.charAt(j);
				// let y be the jth character of nextWord
				char y = nextWord.charAt(j);

				if (x != y) { // if the char in currentWord does not correlate to the char in nextWord
					// let the source be x − 97
					int src = x - 97;
					// let the destination be y − 97
					int dest = y - 97;

					// create an edge e by calling the Edge constructor with arguments src and dest respectively
					Edge e = new Edge(src, dest);
					
					// add the edge e to the end of adjList[src]
					
					adjList.get(src).add(e);
					
					

					// increment inDegree[dest] by one
					inDegree[dest]++;
					break;
				}
			} // end for
		} // end for

	}

	public char[] getOrder() throws Exception { // complete this method
		// Create a char array topoOrder[ ] having length numVertices.
		char topoOrder[] = new char[numVertices];
		// • Create an integer queue vertexQ.
		Queue<Integer> vertexQ = new LinkedList<Integer>();
		// • Initialize an integer variable topoLevel = 0
		int topoLevel = 0;
		// • for (i = 0 to i < numVertices)
		for (int i = 0; i < numVertices; i++) {
			if (inDegree[i] == 0) { // – if (inDegree[i] equals 0), enqueue i
				vertexQ.add(i);
			}
		} // end for

		// • while (vertexQ′s size > 0), do the following:
		while (vertexQ.size() > 0) {
			// – let v be the vertex obtained by dequeue-ing vertexQ
			int v = vertexQ.remove();
			// – assign topoOrder[topoLevel] = (char) (v + 97)
			topoOrder[topoLevel] = (char) (v + 97);
			// – increment topoLevel by 1
			topoLevel++;
			// – let row be the linked list corresponding to the row adjList[v]; notice that row is a linked list of type Edge
			LinkedList<Edge> row = adjList.get(v);
			// – declare an iterator on the linked list row
			Iterator<Edge> rowIterator = row.iterator();
			// – while (iterator has not reached the end of the linked list row), do the following:
			while (rowIterator.hasNext()) {
				// Using the iterator, obtain adjEdge, which is the next outgoing edge of v, and then move the iterator.
				Edge adjEdge = rowIterator.next();
				// ∗ let w be the destination of adjEdge
				int w = adjEdge.dest;
				// ∗ decrement inDegree[w] by 1
				inDegree[w]--;
				// ∗ if (inDegree[w] equals 0), then enqueue w to vertexQ
				if (inDegree[w] == 0) {
					vertexQ.add(w);
				} // end if
			} // end while
		} // end while

		// At the end we return null when all vertices have not been added to the topological order, which implies that the
		// graph has a cycle and an ordering of the characters (and hence words) cannot be obtained.
		if (topoLevel != numVertices) {
			return null;
		} else {
			return topoOrder;
		} // end if / else

	} // end method getOrder
} // end class MutantLanguage
