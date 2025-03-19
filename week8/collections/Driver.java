import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Student s1 = new Student("Brayan", Major.ENGLISH, false);
        Student s2 = new Student("Jana", Major.ENGLISH, false);
        Student s3 = new Student("Heri", Major.COMPUTER_SCIENCE, false);
        Student s4 = new Student("Beatriz", Major.COMPUTER_SCIENCE, false);
        List<Student> students = List.of(s1, s2, s3, s4);

        Map<Major, List<Student>> majorToList = groupByMajor(students);
        countStudentsByMajor(majorToList);

        System.out.println(students);
        Map<Integer, Student> idToStudent = createIdToStudentMap(students);
        updateMapWithGraduates(idToStudent, List.of(s3,s4));
        System.out.println(students);
    }

    public static Map<Major, List<Student>> groupByMajor(List<Student> students) {
        Map<Major, List<Student>> majorToList = new HashMap<>();
        for (Student s : students) {
            Major m = s.getMajor();
            if (majorToList.containsKey(m)) {
                majorToList.get(m).add(s);
            } else {
                majorToList.put(m, new ArrayList<>());
                majorToList.get(m).add(s);
            }
        }
        return majorToList;
    }

    public static void countStudentsByMajor(Map<Major, List<Student>> majorToList) {
        for (Major m : majorToList.keySet()) {
            System.out.println("major: " + m + ", number of students: " + majorToList.get(m).size());
        }
    }

    public static void updateMapWithGraduates(Map<Integer, Student> allStudents, List<Student> recentlyGraduatedStudents) {
        for (Student s : recentlyGraduatedStudents) {
            Integer id = s.getId();
            Student studentToUpdate = allStudents.get(id);
            studentToUpdate.setGraduated(true);
        }
    }

    public static Map<Integer, Student> createIdToStudentMap(List<Student> students) {
        Map<Integer, Student> idToStudent = new HashMap<>();
        for (Student s : students) {
            Integer id = s.getId();
            idToStudent.put(id, s);
        }
        return idToStudent;
    }
}
