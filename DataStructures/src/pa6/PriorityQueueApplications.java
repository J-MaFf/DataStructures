package pa6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueApplications {

    public static ArrayList<Student> topK(ArrayList<Student> students, int k) { // complete this method
        if (k > students.size()) {
            k = students.size();
        }
        // Create a Student priority queue; use the StudentComparator in this case.
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());
        // Add the first k students to the priority queue.
        for (int i = 0; i < k; i++) {
            pq.add(students.get(i));
        }
        StudentComparator sc = new StudentComparator();
        // For each remaining student, if the student has a higher grade than the
        // student with the lowest grade in the priority queue, remove the student
        // with the lowest grade from the priority queue and add the current student
        // to the priority queue.
        for (int i = k; i < students.size(); i++) {
            Student min = pq.peek();
            Student curr = students.get(i);
            // < 0 implies currentValue is smaller than minValue
            // = 0 means they are the same
            // > 0 means currentValue is larger than minValue
            if (sc.compare(curr, min) > 0) { // this checks if curr is smaller than min
                pq.poll();
                pq.add(curr);
            }
        }
        // Create an ArrayList of Students and add the students in the priority queue
        ArrayList<Student> topK = new ArrayList<>();
        while (!pq.isEmpty()) {
            topK.add(pq.poll());
        }

        return topK;
    }

    // prettier-ignore
    public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> arrays) {
        PriorityQueue<PriorityQueuePair> pq = new PriorityQueue<>(new PriorityQueuePairComparator());
        ArrayList<Integer> result = new ArrayList<>();
        int k = arrays.size();
        int[] indexes = new int[k];
        
        // insert the first number of each row into the priority queue
        for (int i = 0; i < k; i++) {
            pq.offer(new PriorityQueuePair(i, arrays.get(i).get(0)));
        }
        
        // merge k sorted arrays
        while (!pq.isEmpty()) {
            // extract the minimum element from the priority queue
            PriorityQueuePair pair = pq.poll();
            int row = pair.item;
            int col = indexes[row];
            result.add(pair.priority);
            
            // check if there are more elements in this row
            if (col < arrays.get(row).size() - 1) {
                // add the next element from this row to the priority queue
                pq.offer(new PriorityQueuePair(row, arrays.get(row).get(col + 1)));
                indexes[row]++;
            }
        }
    
    return result;
}
}
