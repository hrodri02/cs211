public enum Major {
    COMPUTER_SCIENCE("Computer Science"),
    HISTORY("History"),
    MATH("Math"),
    ENGLISH("English");

    private String displayString;

    private Major(String displayString) {
        this.displayString = displayString;
    }

    public String getDisplayString() {
        return this.displayString;
    }
}