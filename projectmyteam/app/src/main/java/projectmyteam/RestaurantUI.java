package projectmyteam;

import java.util.ArrayList;
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
        root.requestFocus();
        root.setOnMouseClicked(e -> root.requestFocus());

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
        FoodNameField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        FoodNameField.setPromptText("Enter Name");
        FoodNameField.setId("FoodNameField");

        TextField FoodPriceField = new TextField();
        FoodPriceField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        FoodPriceField.setPromptText("Enter Price");
        FoodPriceField.setId("FoodPriceField");

        Button AddFoodButton = new Button("Add");
        AddFoodButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        AddFoodButton.setOnMouseEntered(e -> AddFoodButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        AddFoodButton.setOnMouseExited(e -> AddFoodButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        AddFoodButton.setId("AddFoodButton");

        Button MenuButton = new Button("Menu");
        MenuButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        MenuButton.setOnMouseEntered(e -> MenuButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        MenuButton.setOnMouseExited(e -> MenuButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        MenuButton.setId("MenuButton");

        Button WorkerButton = new Button("Worker");
        WorkerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        WorkerButton.setOnMouseEntered(e -> WorkerButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        WorkerButton.setOnMouseExited(e -> WorkerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        WorkerButton.setId("WorkerButton");

        Button PromotionButton = new Button("Promo");
        PromotionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        PromotionButton.setOnMouseEntered(e -> PromotionButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        PromotionButton.setOnMouseExited(e -> PromotionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        PromotionButton.setId("PromotionButton");

        Button LogOutButton = new Button("Back");
        LogOutButton.setStyle("-fx-background-color:rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        LogOutButton.setOnMouseEntered(e -> LogOutButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        LogOutButton.setOnMouseExited(e -> LogOutButton.setStyle("-fx-background-color: rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        LogOutButton.setId("LogOutButton");

        HBox buttonBox = new HBox(10,LogOutButton, AddFoodButton, MenuButton, WorkerButton, PromotionButton);

        AddFoodButton.setOnAction(e -> {
            String name = FoodNameField.getText();
            double price = Double.parseDouble(FoodPriceField.getText());
        });

        MenuButton.setOnAction(e -> {
            new MenuUI(primaryStage);
        });

        WorkerButton.setOnAction(e -> {
            new WorkerUI(primaryStage);
        });

        PromotionButton.setOnAction(e -> {
            new PromotionUI(primaryStage);
        });

        LogOutButton.setOnAction(e -> {
            new LoginUI(primaryStage);
        });

        root.getChildren().addAll(FoodNameLabel, FoodNameField, FoodPriceLabel, FoodPriceField, buttonBox);
        primaryStage.setTitle("Restaurant Manager");
        primaryStage.setScene(new Scene(root, 300, 168));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}