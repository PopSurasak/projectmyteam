package projectmyteam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantUI {
    public RestaurantUI(Stage primaryStage, User user) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 5;" + "-fx-background-color: linear-gradient(to bottom, rgb(175, 208, 247),rgb(133, 16, 205));");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Label FoodNameLabel = new Label("Food Name:");
        FoodNameLabel.setStyle("-fx-font-weight: bold;");

        Label FoodPriceLabel = new Label("Food Price:");
        FoodPriceLabel.setStyle("-fx-font-weight: bold;");

        TextField FoodNameField = new TextField();
        FoodNameField.setId("FoodNameField");

        TextField FoodPriceField = new TextField();
        FoodPriceField.setId("FoodPriceField");

        Button AddFoodButton = new Button("Add Food");
        AddFoodButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        AddFoodButton.setId("AddFoodButton");

        Button MenuButton = new Button("Food Menu");
        MenuButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        MenuButton.setId("MenuButton");

        Button LogOutButton = new Button("Log out");
        LogOutButton.setStyle("-fx-background-color:rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;");
        LogOutButton.setId("LogOutButton");

        HBox buttonBox = new HBox(10, AddFoodButton, MenuButton);

        AddFoodButton.setOnAction(e -> {
            String name = FoodNameField.getText();
            // Restaurant.addFood(name);

            double price = Double.parseDouble(FoodPriceField.getText());
            // Restaurant.addPrice(price);
        });

        MenuButton.setOnAction(e -> {
            new MenuUI(primaryStage);
        });

        LogOutButton.setOnAction(e -> {
            new LoginUI(primaryStage);
        });

        root.getChildren().addAll(FoodNameLabel, FoodNameField, FoodPriceLabel, FoodPriceField, buttonBox, LogOutButton);
        primaryStage.setTitle("Manage Restaurant");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
}
