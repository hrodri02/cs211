public class Player extends Person {
    private int position;

    public Player(String name, int position) {
        super(name);
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        if (0 <= position && position < 11) {
            this.position = position;
        }
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
        return (obj instanceof Player p) && 
            super.equals(obj) &&
            this.position == p.position; 
    }
}
