package oldPA6;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueApplications {

	public static ArrayList<Student> topK(ArrayList<Student> students, int k) { // complete this method
		if (k > students.size()) {
			k = students.size();
		}
		PriorityQueue<Student> studentQueue = new PriorityQueue<>(new StudentComparator());
		for (int i = 0; i < k; i++) {
			studentQueue.add(students.get(i));
		} // end for
		StudentComparator studentComparator = new StudentComparator();
		for (int i = k; i < students.size(); i++) {
			Student min = studentQueue.peek();
			Student current = students.get(i);
			int compareVal = studentComparator.compare(min, current);
			if (compareVal < 0) {
				studentQueue.remove();
				studentQueue.add(current);
			}
		} // end for
		ArrayList<Student> dynamicStudents = new ArrayList<>();
		int queueSize = studentQueue.size();
		for (int i = 0; i < queueSize; i++) {
			dynamicStudents.add(studentQueue.remove());
		} // end for
		return dynamicStudents;
	}

	public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { // complete this method
		PriorityQueue<PriorityQueuePair> queue = new PriorityQueue<>(new PriorityQueuePairComparator());
		ArrayList<Integer> sortedNums = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			int priority = lists.get(i).get(0);
			PriorityQueuePair tmp = new PriorityQueuePair(i, priority);
			queue.add(tmp);
		} // end for
		int[] indexes = new int[lists.size()];
		for (int i = 0; i < lists.size(); i++) {
			indexes[i] = 1;
		} // end for
		
		while (!queue.isEmpty()) {
			PriorityQueuePair min = queue.remove();
			sortedNums.add(min.priority);
			int minItem = min.item;
			if (indexes[minItem] < lists.get(minItem).size()) {
				int priority = indexes[minItem];
				PriorityQueuePair tmp = new PriorityQueuePair(minItem, lists.get(minItem).get(priority));
				queue.add(tmp);
				indexes[minItem]++;
			}
		} // end while
		return sortedNums;
	} // end kWayMerge
}
