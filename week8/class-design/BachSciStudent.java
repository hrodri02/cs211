public class BachSciStudent extends Student {
    private Double gpa;

    public BachSciStudent(String name, Major major, Boolean graduated, Double gpa) {
        super(name, major, graduated);
        this.gpa = gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Double getGpa() {
        return this.gpa;
    }

    public Integer tuition() {
        return 20_000;
    }

    @Override
    public String toString() {
        return super.toString() + ", gpa: " + gpa;
    }
}
