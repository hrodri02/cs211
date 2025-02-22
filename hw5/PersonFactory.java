public class PersonFactory {
    public static Person newPerson(String type, String name, String email) {
        Person p;
        if (type.equalsIgnoreCase("Player"))
            p = new Player(name, email);
        else if (type.equalsIgnoreCase("Admin"))
            p = new Admin(name, email);
        else if (type.equalsIgnoreCase("Referee"))
            p = new Referee(name, email);
        else
            throw new IllegalArgumentException(type + " is an invalid Person type.");
        return p;
    }

    public static Person newPlayer(String name, String email, Position position) {
        return new Player(name, email, position);
    }

    public static Person newAdmin(String name, String imageIdUrl) {
        return new Admin(name, imageIdUrl);
    }

    public static Person newReferee(String name, String imageIdUrl) {
        return new Referee(name, imageIdUrl);
    }
}
