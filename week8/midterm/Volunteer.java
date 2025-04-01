public record Volunteer(String name, String phoneNumber, boolean isActive) {
    private static final boolean DEFAULT_IS_ATIVE = true;
    
    public Volunteer(String name, String phoneNumber) {
        this(name, phoneNumber, Volunteer.DEFAULT_IS_ATIVE);
    }
}
