public class Admin extends Person {
    private String imageIdUrl;
    private boolean isIdApproved;

    public Admin(String name, String imageIdUrl) {
        super(name);
        this.imageIdUrl = imageIdUrl;
        this.isIdApproved = false;
    }

    public String getImageIdUrl() {
        return this.imageIdUrl;
    }

    public boolean getIsIdApproved() {
        return this.isIdApproved;
    }

    public void setImageIdUrl(String imageIdUrl) {
        this.imageIdUrl = imageIdUrl;
    }

    public void setIdApproved(boolean isIdApproved) {
        this.isIdApproved = isIdApproved;
    }

    public void recordGameResults(String team1, int team1Goals, String team2, int team2Goals) {
        System.out.println(team1 + " scored " + team1Goals + " goals\n" + 
                            team2 + " scored " + team2Goals + " goals");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\timageIdUrl: " + this.imageIdUrl + "\n" +
                "\tisIdApproved: " + this.isIdApproved + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Admin p) &&
            super.equals(obj) &&
            this.imageIdUrl == p.imageIdUrl &&
            this.isIdApproved == p.isIdApproved; 
    }
}
