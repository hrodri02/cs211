import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;

import java.beans.EventHandler;
import java.util.*;

public class CalculatorView extends Parent 
{
    private TextField input;
    private List<Button> buttons;
    private GridPane gridPane;

    public CalculatorView() {
        input = new TextField("0");
        this.gridPane = new GridPane();
        buttons = new ArrayList<>();

        gridPane.setStyle("-fx-background-color: #aa0000;");
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        input.setPrefWidth(100);
        input.setEditable(false);
        gridPane.add(input, 0, 0, 4, 1);
        
        buttons.add(new Button("7"));
        buttons.add(new Button("8"));
        buttons.add(new Button("9"));
        buttons.add(new Button("+"));

        buttons.add(new Button("4"));
        buttons.add(new Button("5"));
        buttons.add(new Button("6"));
        buttons.add(new Button("-"));

        buttons.add(new Button("1"));
        buttons.add(new Button("2"));
        buttons.add(new Button("3"));
        buttons.add(new Button("x"));

        buttons.add(new Button("C"));
        buttons.add(new Button("0"));
        buttons.add(new Button("="));
        buttons.add(new Button("/"));
        
        for (int row = 1; row <= 4; row++) {
            for (int col = 0; col < 4; col++) {
                int index = col + 4*(row - 1);
                Button button = buttons.get(index);
                gridPane.add(button, col, row);
            }
        }
    }
    
    public Parent getRoot() {
        return this.gridPane;
    }

    public void setButtonsHandler(CalculatorController handler) {
        for (Button button : buttons) {
            button.setOnAction(handler);
        }
    }

    public String getButtonText(Object src) {
        Button b = (Button) src;
        return b.getText();
    }

    public void resetInput() {
        input.setText("0");
    }

    public String getInputText() {
        return input.getText();
    }

    public void setInputText(String text) {
        input.setText(text);
    }

    public Button getButtonAtIndex(int index) {
        return buttons.get(index);
    }
}
