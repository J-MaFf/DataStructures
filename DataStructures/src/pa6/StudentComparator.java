package pa6;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.grade != o2.grade) {
            return o1.grade - o2.grade;
        } else {
            return o1.name.compareTo(o2.name);
        }
    }
}
