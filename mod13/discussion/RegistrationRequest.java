public class RegistrationRequest {
    @Size(max = 255, message = "first name must be between 1 and 255 characters.")
    private final String firstName;
    @Size(min = 2, max = 255, message = "last name must be between 2 and 255 characters.")
    private final String lastName;    

    public RegistrationRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}