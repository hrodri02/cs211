public record Course(String name, Integer maxStudents, Integer credits) implements Comparable<Course> {
    private static final Integer DEFAULT_MAX_STUDENTS = 30;

    public Course(String name, Integer credits) {
        this(name, Course.DEFAULT_MAX_STUDENTS, credits);
    }

    @Override
    public int compareTo(Course otherCourse) {
        return this.name.compareTo(otherCourse.name);
    }
}
