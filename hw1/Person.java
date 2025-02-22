public abstract class Person {
    private int id;
    private String name;
    private static int curr_id = 0;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this(curr_id++, name);
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

    @Override
    public String toString() {
        return  "\tid: " + id + "\n" + 
                "\tname: " + name + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Person p) 
            && this.id == p.id 
            && this.name.equalsIgnoreCase(p.name);
    }
}