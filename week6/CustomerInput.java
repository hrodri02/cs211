import java.io.*;
import java.util.*;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class CustomerInput extends Application {

    private Stage primaryStage;
    private Text statusText, resultText;
    private Button uploadButton;
    private List<Customer> customers;

    private final static Font RESULT_FONT = Font.font("Helvetica", 24);
    private final static Font INPUT_FONT = Font.font("Helvetica", 20);

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        VBox uploadBox = new VBox();
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setSpacing(20);
        Text uploadLabel = new Text("Upload a comma-separated file with customer data.");
        uploadLabel.setFont(INPUT_FONT);
        uploadButton = new Button("Upload data");
        uploadButton.setOnAction(this::processDataUpload);

        uploadBox.getChildren().add(uploadLabel);
        uploadBox.getChildren().add(uploadButton);
        primaryBox.getChildren().add(uploadBox);

        VBox resultsBox = new VBox();
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setSpacing(20);
        statusText = new Text("");
        statusText.setVisible(false);
        statusText.setFont(RESULT_FONT);
        statusText.setWrappingWidth(475);
        statusText.setFill(Color.RED);
        resultText = new Text("");
        resultText.setVisible(false);
        resultText.setFont(RESULT_FONT);
        resultsBox.getChildren().add(statusText);
        resultsBox.getChildren().add(resultText);
        primaryBox.getChildren().add(resultsBox);

        Scene scene = new Scene(primaryBox, 475, 200, Color.TRANSPARENT);
        primaryStage.setTitle("Customer Data Upload");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void processDataUpload(ActionEvent event) {
        statusText.setVisible(false);
        resultText.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        parseFile(file);
    }

    private void parseFile(File file) {
        String token = null;
        try (Scanner fileScan = new Scanner(new FileReader(file))) {
            customers = new ArrayList<>();

            while (fileScan.hasNext()) {
                String line = fileScan.nextLine();
                
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");
                String id = lineScan.next();
                if (id.contains(String.valueOf("@"))) {
                    throw new InvalidCharacterException("Invalid ID: " + id);
                }

                token = lineScan.next();
                int numOrders = Integer.parseInt(token);
                
                Customer newCustomer = new Customer(id, numOrders);
                customers.add(newCustomer);
            }

            showResultsOfFileUpload();
        }
        catch (NumberFormatException ex) {
            setStatusText("Error: " + token + " is not an integer.");    
        }
        catch (InvalidCharacterException ex) {
            setStatusText(ex.getMessage());
        }
        catch (NullPointerException ex) {
            setStatusText("Error: No file was selected.");
        }
        catch (IOException ex) {
            setStatusText("Error: " + ex.getMessage());
        }
    }

    public void showResultsOfFileUpload() {
        setStatusText("Success: " + customers.size()  + " customers were created.");

        int totalNumOrders = 0;
        for (Customer c : customers) {
            totalNumOrders += c.getNumberOfOrders();
        }

        setResultText("Total Number of Orders: " + totalNumOrders);
        uploadButton.setDisable(true);
    }

    private void setStatusText(String text) {
        statusText.setVisible(true);
        statusText.setText(text);
    }

    private void setResultText(String text) {
        resultText.setVisible(true);
        resultText.setText(text);
    }

    public static void main(String[] args) {
        launch(args);
    }

}