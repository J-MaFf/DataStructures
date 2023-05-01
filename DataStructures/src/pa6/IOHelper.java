package pa6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains helper methods for reading data from files.
 */
public class IOHelper {

    /**
     * Reads a list of students from a file and returns it.
     * @param filePath the path to the file
     * @return the list of students
     * @throws FileNotFoundException if the file is not found
     */
    public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(filePath));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Split the line into tokens
            String[] tokens = line.split(" ");
            String name = tokens[0];
            int grade = Integer.parseInt(tokens[1]);
            students.add(new Student(name, grade));
        }
        scanner.close();
        return students;
    } // complete this method

    /**
     * Reads a weighted graph from a file and returns it.
     * @param filePath the path to the file
     * @return the weighted graph
     * @throws FileNotFoundException if the file is not found
     */
    public static Graph readWeightedGraph(String filePath) throws FileNotFoundException {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(new FileReader(filePath));
        graph.numVertices = scanner.nextInt();
        graph.adjList = new ArrayList<>(graph.numVertices); // allocates numVertices rows for the adjacency list
        for (int i = 0; i < graph.numVertices; i++) graph.adjList.add(new ArrayList<>()); // allocates numVertices columns for each row
        int src, dest, weight;
        while (scanner.hasNextInt()) {
            src = scanner.nextInt();
            dest = scanner.nextInt();
            weight = scanner.nextInt();
            Edge e = new Edge(src, dest, weight);
            graph.adjList.get(src).add(e);
        }
        scanner.close();
        return graph;
    } // complete this method
}
