import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HW2Tester {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        // M2 USING FACTORY
        people.add(PersonFactory.newPlayer("Raul Jiminez", 9));
        people.add(PersonFactory.newReferee("Diego Mendez", "https://amazon.s3/images/jadijapf"));
        people.add(PersonFactory.newAdmin("Carlos Gutierrez", "https://amazon.s3/images/jadijapf"));
        people.add(PersonFactory.newReferee("Deniel Mendez", "https://amazon.s3/images/jadijapf"));
        people.add(PersonFactory.newReferee("diego Mendez", "https://amazon.s3/images/jadijapf"));
        System.out.println("Number of people: " + Person.getNumPeople());

        Person ref1 = people.get(1);
        Person ref2 = people.get(4);
        System.out.println(ref1);
        System.out.println(ref2);
        System.out.println(ref1.equals(ref2));
        System.out.println(ref1.equals(ref1));
        System.out.println(ref1.equals(null));

        System.out.println("before");
        for (Person p : people) {
            System.out.println(p.getName());
        }
        Collections.sort(people);
        System.out.println("after");
        for (Person p : people) {
            System.out.println(p.getName());
        }
    }
}
