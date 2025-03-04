package projectmyteam;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RestaurantUI {
    private static List<String> foodList = new ArrayList<>();

    public RestaurantUI(Stage primaryStage, Account user) {
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

        Label warningFoodLabel = new Label();
        warningFoodLabel.setStyle("-fx-font-weight: bold;");
        warningFoodLabel.setTextFill(Color.RED);

        Label warningPriceLabel = new Label();
        warningPriceLabel.setStyle("-fx-font-weight: bold;");
        warningPriceLabel.setTextFill(Color.RED);

        TextField FoodNameField = new TextField();
        FoodNameField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        FoodNameField.setPromptText("Enter Name");
        FoodNameField.setId("FoodNameField");

        TextField FoodPriceField = new TextField();
        FoodPriceField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        FoodPriceField.setPromptText("Enter Price");
        FoodPriceField.setId("FoodPriceField");

        Button AddFoodButton = new Button("Add");
        AddFoodButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        AddFoodButton.setOnMouseEntered(e -> AddFoodButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        AddFoodButton.setOnMouseExited(e -> AddFoodButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        AddFoodButton.setId("AddFoodButton");

        Button MenuButton = new Button("Menu");
        MenuButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        MenuButton.setOnMouseEntered(e -> MenuButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        MenuButton.setOnMouseExited(e -> MenuButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        MenuButton.setId("MenuButton");

        Button WorkerButton = new Button("Worker");
        WorkerButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        WorkerButton.setOnMouseEntered(e -> WorkerButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        WorkerButton.setOnMouseExited(e -> WorkerButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        WorkerButton.setId("WorkerButton");

        Button PromotionButton = new Button("Promo");
        PromotionButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        PromotionButton.setOnMouseEntered(e -> PromotionButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        PromotionButton.setOnMouseExited(e -> PromotionButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        PromotionButton.setId("PromotionButton");

        Button LogOutButton = new Button("Back");
        LogOutButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        LogOutButton.setOnMouseEntered(e -> LogOutButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        LogOutButton.setOnMouseExited(e -> LogOutButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        LogOutButton.setId("LogOutButton");
        
        HBox nameBox = new HBox(10,FoodNameLabel, warningFoodLabel);
        HBox priceBox = new HBox(10,FoodPriceLabel, warningPriceLabel);
        HBox buttonBox = new HBox(10,LogOutButton, AddFoodButton, MenuButton, WorkerButton, PromotionButton);

        FoodNameField.setOnMouseClicked(e -> {
            warningFoodLabel.setText("");
        });

        FoodPriceField.setOnMouseClicked(e -> {
            warningPriceLabel.setText("");
        });

        AddFoodButton.setOnAction(e -> {
            String name = FoodNameField.getText().trim();
            String priceText = FoodPriceField.getText().trim();
            warningFoodLabel.setText("");
            warningPriceLabel.setText("");
        
            boolean nameEmpty = name.isEmpty();
            boolean priceEmpty = priceText.isEmpty();
            boolean invalidPrice = false;
        
            if (!priceEmpty) {
                try {
                    Double.parseDouble(priceText);
                } catch (NumberFormatException ex) {
                    invalidPrice = true;
                }
            }
        
            if (nameEmpty && (priceEmpty || invalidPrice)) {
                warningFoodLabel.setText("Put a valid Name");
                warningPriceLabel.setText("Put a valid price");
            } else if (nameEmpty) {
                warningFoodLabel.setText("Put a valid Name");
            } else if (priceEmpty || invalidPrice) {
                warningPriceLabel.setText("Put a valid price");
            } else {
                double price = Double.parseDouble(priceText);
                String foodItem = name + " - $" + price;
                foodList.add(foodItem);
                FoodNameField.clear();
                FoodPriceField.clear();
            }
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

        root.getChildren().addAll(nameBox, FoodNameField, priceBox, FoodPriceField, buttonBox);
        primaryStage.setTitle("Restaurant Manager");
        primaryStage.setScene(new Scene(root, 300, 168));
        primaryStage.setResizable(false);
        primaryStage.show();
        Platform.runLater(() -> root.requestFocus());
    }

    public static List<String> getFoodList() {
        return foodList;
    }
}