import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateUsersFX extends Application {
    @Override
    public void start(Stage stage) {
        UsersView view = new UsersView();
        UsersModel model = new UsersModel();
        UsersController controller = new UsersController(view, model);
        Scene scene = new Scene(view.getRoot(), 640, 480);
        stage.setScene(scene);
        stage.show();
        // test code
    }

    public static void main(String[] args) {
        launch();
        /* 
        List<Person> people = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Position[] positions = Position.values();
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Enter" + 
                "\n\t1 to create new player." + 
                "\n\t2 to display the list of players sorted by name." +
                "\n\t3 to display the list of players sorted by name, then email." +
                "\n\t4 to exit."
            );
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("name: ");
                    String name = scan.nextLine().trim();

                    System.out.print("email: ");
                    String email = scan.nextLine().trim();

                    do {
                        displayPositions(positions);
                        System.out.print("position: ");
                        String position = scan.nextLine().trim().toUpperCase();
                        if (isPositionValid(positions, position)) {
                            Position playerPos = Enum.valueOf(Position.class, position);
                            people.add(PersonFactory.newPlayer(name, email, playerPos));
                            System.out.println("Success: new player created.");
                            break;
                        }
                        else {
                            System.out.println("Error: position is invalid.");
                        }
                    } while (true);
                    break;
                case 2:
                    Collections.sort(people);
                    System.out.println(people);
                    break;
                case 3:
                    Collections.sort(people, new Person.NameEmailComparator());
                    System.out.println(people);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    keepGoing = false;
                    break;
            }
        }
        scan.close();
        */
    }

    /*
    public static void displayPositions(Position[] positions) {
        System.out.println("The possible positions are: ");
        for (Position position : positions) {
            System.out.println("\t" + position);
        }
    }

    public static boolean isPositionValid(Position[] positions, String position) {
        for (Position pos : positions) {
            if (pos.toString().equalsIgnoreCase(position)) {
                return true;
            }
        }
        return false;
    }
    */
}
