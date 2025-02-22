public class Player extends Person {
    // M3 HOMEWORK ENUM USE
    private Position position;
    private static final Position DEFAULT_POSITION = Position.GOAL_KEEPER;

    public Player(String name, String email, Position position) {
        super(name, email);
        this.position = position;
    }

    public Player(String name, String email) {
        this(name, email, DEFAULT_POSITION);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void scored(int min) {
        System.out.println(getName() + " scored goal at the " + min + "th min.");
    }

    @Override
    public String toString() {
        return "{\n" +
                super.toString() + 
                "\tposition: " + this.position + "\n" +
                "}\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        return (obj instanceof Player p) && 
            super.equals(obj) &&
            this.position.equals(p.position); 
    }
}
