import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorFX extends Application {
    @Override
    public void start(Stage stage) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
        Scene scene = new Scene(view.getRoot(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}