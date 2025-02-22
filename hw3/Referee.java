import java.util.ArrayList;
import java.util.List;

public class Referee extends Admin {
    private List<String> certifications;

    public Referee(String name, String email, String imageIdUrl) {
        super(name, email, imageIdUrl);
        this.certifications = new ArrayList<>();
    }

    public Referee(String name, String email) {
        this(name, email, null);
    }

    public List<String> getCertifications() {
        return this.certifications;
    }

    public void addCertifications(String certification) {
        this.certifications.add(certification);
    }

    public void assignYellowCard(int playerId) {
        System.out.println("Referee gave yellow card to player " + playerId);
    }

    public void assignRedCard(int playerId) {
        System.out.println("Referee gave red card to player " + playerId);
    }

    @Override
    public String toString() {
        return "{\n" +
                super.toString() +
                "\tcertifications: " + this.certifications + "\n" +
                "}\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        return (obj instanceof Referee otherRef) &&
            super.equals(obj) &&
            this.certifications.equals(otherRef.certifications); 
    }
}
