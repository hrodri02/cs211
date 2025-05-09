public class Driver {
    public static void main(String[] args) {
        RegistrationRequest request1 = new RegistrationRequest("", "Smith");
        SizeValidator.validate(request1);
        RegistrationRequest request2 = new RegistrationRequest("John", "");
        SizeValidator.validate(request2);
        RegistrationRequest request3 = new RegistrationRequest("John", "Smith");
        SizeValidator.validate(request3);
    }
}
