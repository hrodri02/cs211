// M3 HOMEWORK ENUM
public enum Position {
    GOAL_KEEPER("Goal keeper"), CENTER_BACK("Center back"), 
    DEFENSIVE_MIDFIELDER("Defensive midfielder"), CENTRAL_MIDFIELDER("Central midfielder"), 
    ATTACKING_MIDFIELDER("Attacking midfielder"), STRIKER("Striker");

    private String displayString;

    private Position(String displayString) {
        this.displayString = displayString;
    }

    public String getDisplayString() {
        return this.displayString;
    }
}
