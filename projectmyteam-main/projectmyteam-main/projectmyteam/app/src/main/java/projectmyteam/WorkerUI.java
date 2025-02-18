package projectmyteam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkerUI {
    public WorkerUI(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 5;" + "-fx-background-color: linear-gradient(to bottom, rgb(11, 22, 236),rgba(187, 12, 240, 0.41));");
        root.requestFocus();
        root.setOnMouseClicked(e -> root.requestFocus());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Label WorkerLabel = new Label("Worker:");
        WorkerLabel.setStyle("-fx-font-weight: bold;");

        Button BackButton = new Button("Back");
        BackButton.setStyle("-fx-background-color:rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;");
        BackButton.setOnMouseEntered(e -> BackButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold;"));
        BackButton.setOnMouseExited(e -> BackButton.setStyle("-fx-background-color: rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;"));
        BackButton.setId("BackButton");

        // HBox buttonBox = new HBox(10, AddFoodButton, MenuButton);

        BackButton.setOnAction(e -> {
            new RestaurantUI(primaryStage, null);
        });

        root.getChildren().addAll(WorkerLabel, BackButton);
        primaryStage.setTitle("Worker Manager");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
