import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UsersController extends Application {
    private UsersView view;
    private UsersModel model;

    public UsersController() {
        this.view = new UsersView();
        this.model = new UsersModel();
    }    

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(view.getRoot(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
