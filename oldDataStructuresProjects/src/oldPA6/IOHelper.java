package oldPA6;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOHelper {

	public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException { // complete this method
		ArrayList<Student> dynamicArray = new ArrayList<>();
		Scanner fileScanner = new Scanner(new FileInputStream(filePath));
		while (fileScanner.hasNext()) { // go through, grab names grades from text file, add to dynamic array, after while return dynamicArray
			String name = fileScanner.next();
			int grade = fileScanner.nextInt();
			Student student = new Student(name, grade);
			dynamicArray.add(student);
		}
		fileScanner.close();
		return dynamicArray;
	}

	public static Graph readWeightedGraph(String fPath) throws FileNotFoundException { // complete this method
		Scanner fileScanner = new Scanner(new FileInputStream(fPath));
		Graph graph = new Graph();
		graph.numVertices = fileScanner.nextInt();
		graph.adjList = new ArrayList<>(graph.numVertices);
		for (int i = 0; i < graph.numVertices; i++) {
			graph.adjList.add(new ArrayList<>());
		} // end for
		while (fileScanner.hasNext()) {
			int src, dest, weight; 
			src = fileScanner.nextInt();
			dest = fileScanner.nextInt();
			weight = fileScanner.nextInt();
			Edge e = new Edge(src, dest, weight);
			graph.adjList.get(src).add(e);
		}
		fileScanner.close();
		return graph;
	}

}
