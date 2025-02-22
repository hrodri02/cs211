public abstract class Person implements Comparable<Person> {
    private int id;
    private String name;
    // M2 HOMEWORK STATIC
    private static int numPeople = 0;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        numPeople++;
    }

    public Person(String name) {
        this(numPeople, name);
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
                "\tname: " + name + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        return (obj instanceof Person p) &&
            this.name.equalsIgnoreCase(p.name);
    }
}