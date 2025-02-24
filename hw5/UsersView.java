import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.collections.*;

import java.util.*;

public class UsersView {
    private GridPane gridPane;
    private Label nameLabel;
    private TextField nameInput;
    private Label emailLabel;
    private TextField emailInput;
    private Label positionLabel;
    private ComboBox<Position> positionInput;
    private TextArea output;
    private HBox buttonBox;
    private Button submitButton;
    private Button sortButton;

    public UsersView() {
        gridPane = new GridPane();
        nameLabel = new Label("Name:");
        nameInput = new TextField();
        emailLabel = new Label("Email:");
        emailInput = new TextField();
        positionLabel = new Label("Positions:");
        positionInput = new ComboBox(FXCollections.observableArrayList(Position.values()));
        output = new TextArea();
        submitButton = new Button("Submit");
        sortButton = new Button("Sort by name then email");
        buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(submitButton);
        buttonBox.getChildren().add(sortButton);

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

    public String getNameInputText() {
        return nameInput.getText();
    }

    public String getEmailInputText() {
        return emailInput.getText();
    }

    public Position getPositionInputValue() {
        return positionInput.getValue();
    }

    public void setOutput(String text) {
        output.setText(text);
    }

    public void setSubmitButtonHandler(EventHandler<ActionEvent> handler) {
        submitButton.setOnAction(handler);
    }

    public void setSortButtonHandler(EventHandler<ActionEvent> handler) {
        sortButton.setOnAction(handler);
    }

    public void clearForm() {
        nameInput.clear();
        emailInput.clear();
        positionInput.setValue(null);
    }
}
