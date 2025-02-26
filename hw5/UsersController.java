import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UsersController extends Application {
    private UsersView view;
    private UsersModel model;

    public UsersController() {
        this.view = new UsersView();
        this.model = new UsersModel();

        view.setSubmitButtonHandler(this::submitButtonHandler);
        view.setSortButtonHandler(this::sortButtonHandler);
    }    

    @Override
    public void start(Stage stage) {
        UsersController controller = new UsersController();
        Scene scene = new Scene(controller.view.getRoot(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void submitButtonHandler(ActionEvent event) {
        String errorMessage = "";
        try {
            String name = view.getNameInputText();
            if (name.isEmpty()) {
                errorMessage = "Name must not be empty.";
                throw new IllegalArgumentException();
            }

            String email = view.getEmailInputText();
            if (email.isEmpty()) {
                errorMessage = "Email must not be empty.";
                throw new IllegalArgumentException();
            }

            Position position = view.getPositionInputValue();
            if (position == null) {
                errorMessage = "Position must be selected.";
                throw new IllegalArgumentException();
            }

            Player newPlayer = new Player(name, email, position);
            model.addPerson(newPlayer);

            String playerList = "";
            for (Person person : model.getUsers()) {
                playerList += person.getName() + "\n";
            }

            view.setOutput(playerList);
                    
        } catch (IllegalArgumentException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Input Error");
            error.setHeaderText(null);
            error.setContentText(errorMessage);
            error.showAndWait();
        } finally {
            view.clearForm();
        }
    }

    private void sortButtonHandler(ActionEvent event) {

    }

}
