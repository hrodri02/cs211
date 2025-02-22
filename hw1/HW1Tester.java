import java.util.List;
import java.util.ArrayList;

public class HW1Tester {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Player("Raul Jiminez", 9));
        people.add(new Referee("Diego Mendez", "https://amazon.s3/images/jadijapf"));
        people.add(new Admin("Carlos Gutierrez", "https://amazon.s3/images/jadijapf"));
        people.add(new Referee("Deniel Mendez", "https://amazon.s3/images/jadijapf"));

        Player raul = (Player) people.get(0);
        raul.scored(90);
        System.out.println(raul);
        
        Referee ref1 = (Referee) people.get(1);
        ref1.addCertifications("cert1");
        ref1.assignRedCard(0);
        
        Admin admin = (Admin) people.get(2);
        admin.recordGameResults("Fullham", 2, "Manchester United", 2);
        System.out.println(admin);

        people.get(3).setId(1);
        Referee ref2 = (Referee) people.get(3);
        ref2.addCertifications("cert1");

        System.out.println(ref1);
        System.out.println(ref2);
        System.out.println(ref1.equals(ref2));
    }
}
