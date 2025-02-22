import java.util.Comparator;

public abstract class Person implements Comparable<Person> {
    private int id;
    private String name;
    private String email;
    // M2 HOMEWORK STATIC
    private static int numPeople = 0;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        numPeople++;
    }

    public Person(String name, String email) {
        this(numPeople, name, email);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // M2 HOMEWORK STATIC
    public static int getNumPeople() {
        return Person.numPeople;
    }

    @Override
    public int compareTo(Person p) {
        return name.compareTo(p.name);
    }

    @Override
    public String toString() {
        return  "\tid: " + id + "\n" + 
                "\tname: " + name + "\n" +
                "\temail: " + email + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        return (obj instanceof Person p) &&
            this.name.equalsIgnoreCase(p.name);
    }

    public static class NameEmailComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.name.equalsIgnoreCase(p2.name)) {
                return p1.email.compareTo(p2.email);
            }
            return p1.name.compareTo(p2.name);
        }
    }
}