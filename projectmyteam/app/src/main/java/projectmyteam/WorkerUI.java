package projectmyteam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class WorkerUI {
    private ListView<String> workerListView;
    private List<String> workerList;

    public WorkerUI(Stage primaryStage) {
        workerList = new ArrayList<>();
        workerListView = new ListView<>();

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 5;" + "-fx-background-color: linear-gradient(to bottom, rgb(235, 105, 170),rgba(101, 250, 32, 0.41));");
        root.setPadding(new Insets(10));
        root.requestFocus();
        root.setOnMouseClicked(e -> root.requestFocus());

        TextField workerNameField = new TextField();
        workerNameField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        workerNameField.setPromptText("Enter Worker Name");

        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px; -fx-background-insets: 0; -fx-padding: 0;");
        roleComboBox.getItems().addAll("Cleaner", "Waiter", "Co-Chef", "Head Chef", "Manager", "CEO");
        roleComboBox.setPromptText("Select Role");

        Button addButton = new Button("Add Worker");
        addButton.setStyle("-fx-background-color:rgb(38, 94, 168); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        addButton.setOnMouseEntered(e -> addButton.setStyle("-fx-background-color:rgb(63, 199, 169); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        addButton.setOnMouseExited(e -> addButton.setStyle("-fx-background-color:rgb(94, 76, 175); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));

        Button removeButton = new Button("Remove Worker");
        removeButton.setStyle("-fx-background-color:rgb(150, 22, 182); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        removeButton.setOnMouseEntered(e -> removeButton.setStyle("-fx-background-color: rgb(30, 182, 106); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        removeButton.setOnMouseExited(e -> removeButton.setStyle("-fx-background-color: rgb(43, 128, 197); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));

        addButton.setOnAction(e -> {
            String workerName = workerNameField.getText().trim(); 
            String roleName = roleComboBox.getValue();

            if (!workerName.isEmpty() && roleName != null) {
                String workerInfo = workerName + " - " + roleName;
                workerList.add(workerInfo);
                workerListView.getItems().setAll(workerList);
                workerNameField.clear();
            }
        });

        removeButton.setOnAction(e -> {
            String selectedWorker = workerListView.getSelectionModel().getSelectedItem();
            if (selectedWorker != null) {
                workerList.remove(selectedWorker);
                workerListView.getItems().setAll(workerList);
            }
        });

        backButton.setOnAction(e -> {
            new RestaurantUI(primaryStage, null);
        });

        HBox selectBox = new HBox(5, workerNameField, roleComboBox);
        HBox buttonBox = new HBox(10, addButton, removeButton);
        VBox workerBox = new VBox(5, workerListView);

        root.getChildren().addAll(selectBox, buttonBox, workerBox, backButton);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Worker Manager");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}