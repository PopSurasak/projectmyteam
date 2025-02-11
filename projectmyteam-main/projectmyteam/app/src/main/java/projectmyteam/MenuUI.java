package projectmyteam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuUI {
    public MenuUI(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 5;" + "-fx-background-color: linear-gradient(to bottom, rgb(255, 0, 208),rgb(255, 8, 8));");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Label FoodMenuLabel = new Label("Food Menu:");
        FoodMenuLabel.setStyle("-fx-font-weight: bold;");

        Button BackButton = new Button("Back");
        BackButton.setStyle("-fx-background-color:rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;");
        BackButton.setId("BackButton");

        // HBox buttonBox = new HBox(10, AddFoodButton, MenuButton);

        BackButton.setOnAction(e -> {
            new RestaurantUI(primaryStage, null);
        });

        root.getChildren().addAll(FoodMenuLabel, BackButton);
        primaryStage.setTitle("Menu Restaurant");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
}

