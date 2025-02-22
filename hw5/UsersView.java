import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

import javafx.collections.*;
import java.util.*;

public class UsersView {
    private GridPane gridPane;
    private Label nameLabel;
    private TextField nameInput;
    private Label emailLabel;
    private TextField emailInput;
    private Label positionLabel;
    private ComboBox positionInput;
    private TextArea output;
    private HBox buttonBox;
    private Button submitButton;

    public UsersView() {
        // TODO: add components to the grid pane
        this.gridPane = new GridPane();
        this.nameLabel = new Label("Name:");
        this.nameInput = new TextField();
        this.emailLabel = new Label("Email:");
        this.emailInput = new TextField();
        this.positionLabel = new Label("Positions:");
        List<String> options = new ArrayList<>();
        for (Position pos : Position.values()) {
            options.add(pos.toString());
        }
        this.positionInput = new ComboBox();
        this.positionInput.getItems().addAll(options);
        this.output = new TextArea();
        this.submitButton = new Button("Submit");
        this.buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(submitButton);

        // gridPane.setStyle("-fx-background-color: #aa0000;");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameInput, 1, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailInput, 1, 1);
        gridPane.add(positionLabel, 0, 2);
        gridPane.add(positionInput, 1, 2);
        gridPane.add(output, 0, 3, 2, 10);
        gridPane.add(buttonBox, 0, 13, 2, 1);
    }

    public Parent getRoot() {
        return this.gridPane;
    }
}
