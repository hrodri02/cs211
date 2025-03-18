import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDriver {
    public static void main(String[] args) {
        Student s1 = StudentFactory.newBachSciStudent(
            "Heri",
            Major.COMPUTER_SCIENCE, 
            true, 
            3.45);

        Student s2 = StudentFactory.newBachSciStudent(
            "Bray",
            Major.ENGLISH, 
            true, 
            3.45);

        Student s3 = StudentFactory.newMastersStudent(
            "Jana",
            Major.HISTORY, 
            true, 
            "Some topic");


        // Can you invoke methods that are in only the parent class? 
        // Student s1 = BachSciStudent
        // invoked a parent method
        // cannot invoke a child class method unless we cast
        System.out.println(((BachSciStudent) s1).getGpa());
        // Only the child class? In the parent and overridden in the child (and then which version is executed)?
        // When and how do you use instanceof and casts to access methods in a child class?

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        System.out.println(students);
        Collections.sort(students);
        System.out.println("Sorted by name");
        System.out.println(students);

        Collections.sort(students, new Student.IdComparator());
        System.out.println("Sorted by id");
        System.out.println(students);

        for (Student s : students) {
            s.register();
            if (s instanceof BachSciStudent bs) {
                System.out.println(bs.tuition());
            }
            else if (s instanceof MastersStudent ms) {
                System.out.println(ms.tuition());
            }
        }

        Course c1 = new Course("HIS 100", 4);
        Course c2 = new Course("CS 100", 35,4);
        List<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);
        System.out.println(courses);
        System.out.println("Sort by name");
        Collections.sort(courses);
        System.out.println(courses);        
    }
}
