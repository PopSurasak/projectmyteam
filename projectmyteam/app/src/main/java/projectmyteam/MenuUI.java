package projectmyteam;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuUI {
    private ListView<String> foodListView;

    public MenuUI(Stage primaryStage) {
        List<String> foodList = RestaurantUI.getFoodList(); 

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 5;" + "-fx-background-color: linear-gradient(to bottom, rgb(255, 0, 208),rgb(255, 8, 8));");
        root.requestFocus();
        root.setOnMouseClicked(e -> root.requestFocus());

        Label foodMenuLabel = new Label("Food Menu:");
        foodMenuLabel.setStyle("-fx-font-weight: bold;");

        foodListView = new ListView<>();
        foodListView.setStyle("-fx-background-color: white; -fx-border-color: black;");
        
        if (foodList != null) {
            foodListView.getItems().addAll(foodList);
        }

        Button removeButton = new Button("Remove Food");
        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        removeButton.setOnMouseEntered(e -> removeButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        removeButton.setOnMouseExited(e -> removeButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));

        Button BackButton = new Button("Back");
        BackButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        BackButton.setOnMouseEntered(e -> BackButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        BackButton.setOnMouseExited(e -> BackButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        BackButton.setId("BackButton");

        HBox buttonBox = new HBox(10, BackButton, removeButton);

        removeButton.setOnAction(e -> {
            String selectedFood = foodListView.getSelectionModel().getSelectedItem();
            if (selectedFood != null) {
                foodListView.getItems().remove(selectedFood);
                foodList.remove(selectedFood);
            }
        });

        BackButton.setOnAction(e -> {
            new RestaurantUI(primaryStage, null);
        });

        root.getChildren().addAll(foodMenuLabel, foodListView, buttonBox);
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}