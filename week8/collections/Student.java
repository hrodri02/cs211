import java.util.Comparator;

public class Student implements Comparable<Student> {
    private Integer id;
    private String name;
    private Major major;
    private Boolean graduated;
    private static Integer numStudents = 0;

    public Student(String name, Major major, Boolean graduated) {
        this.id = Student.numStudents;
        this.name = name;
        this.major = major;
        this.graduated = graduated;
        Student.numStudents++;
    }

    // getters
    public Integer getId() {
        return id;
    }

    public Major getMajor() {
        return major;
    }

    // setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

    public static Integer getNumStudents() {
        return Student.numStudents;
    }

    public void register() {
        System.out.println("Registered " + name);
    }

    @Override
    public String toString() {
        return "id: " + id + 
                ", name: " + name +
                 ", major: " + major.getDisplayString() + 
                 ", graduated: " + graduated; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return (obj instanceof Student s) && 
                id.equals(s.id) &&
                name.equals(s.name) &&
                major.equals(s.major) &&
                graduated.equals(s.graduated); 
    }

    @Override
    public int compareTo(Student otherStudent) {
        return name.compareTo(otherStudent.name);
    }

    public static class IdComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.id, s2.id);
        }
    }
}