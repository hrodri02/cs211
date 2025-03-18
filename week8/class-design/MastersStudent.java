public class MastersStudent extends Student {
    String thesisTopic;

    public MastersStudent(String name, Major major, Boolean graduated, String thesisTopic) {
        super(name, major, graduated);
        this.thesisTopic = thesisTopic;
    }

    public Integer tuition() {
        return 30_000;
    }

    @Override
    public String toString() {
        return super.toString() + ", thesis topic: " + thesisTopic;
    }
}
