import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersModel {
    private List<Person> people;
    private Person.NameEmailComparator comparator;

    public UsersModel() {
        people = new ArrayList<>();
        comparator = new Person.NameEmailComparator();
    }

    public List<Person> getUsers() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Position[] getPositions() {
        return Position.values();
    }

    public void sortUsersByName() {
        Collections.sort(people);
    }

    public void sortUsersByNameThenEmail() {
        Collections.sort(people,
            (p1, p2) -> {
                if (p1.getName().equalsIgnoreCase(p2.getName())) {
                    return p1.getEmail().compareTo(p2.getEmail());
                }
                return p1.getName().compareTo(p2.getName());
            }
        );
    }
}
