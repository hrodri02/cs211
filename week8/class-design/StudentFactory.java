public class StudentFactory {
    public static Student newBachSciStudent(String name, Major major, Boolean graudated, Double gpa) {
        return new BachSciStudent(name, major, graudated, gpa);
    }

    public static Student newMastersStudent(String name, Major major, Boolean graudated, String thesisTopic) {
        return new MastersStudent(name, major, graudated, thesisTopic);
    }
}
