package projectmyteam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class PromotionUI {
    private ListView<String> promoListView;
    private List<String> promoList;

    public PromotionUI(Stage primaryStage) {
        promoList = new ArrayList<>();
        promoListView = new ListView<>();

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 5;" + "-fx-background-color: linear-gradient(to bottom, rgb(236, 228, 11),rgba(240, 115, 12, 0.96));");
        root.setPadding(new Insets(10));
        root.requestFocus();
        root.setOnMouseClicked(e -> root.requestFocus());

        ComboBox<String> foodMenu = new ComboBox<>();
        foodMenu.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px; -fx-background-insets: 0; -fx-padding: 0;");
        foodMenu.getItems().addAll("🍕 Pizza - 10$", "🍔 Burger - 5$", "🍣 Sushi - 30$", "🥗 Salad - 20$", "🍗 Fried Chicken - 10$");
        foodMenu.setPromptText("Food Menu");

        ComboBox<String> discountMenu = new ComboBox<>();
        discountMenu.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px; -fx-background-insets: 0; -fx-padding: 0;");
        discountMenu.getItems().addAll("Discount - 10%", "Discount - 20%","Discount - 30%", "Discount - 40%","Discount - 50%", "Discount - 60%","Discount - 70%", "Discount - 80%","Discount - 90%", "Discount - 99%");
        discountMenu.setPromptText("Discount");

        Button discountButton = new Button("Add Discount");
        discountButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        discountButton.setOnMouseEntered(e -> discountButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        discountButton.setOnMouseExited(e -> discountButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(40, 232, 46),rgb(30, 134, 4)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));

        Button removeButton = new Button("Remove Discount");
        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        removeButton.setOnMouseEntered(e -> removeButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        removeButton.setOnMouseExited(e -> removeButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(255, 0, 0),rgb(165, 14, 14)); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));

        discountButton.setOnAction(e -> {
            String food = foodMenu.getValue();
            String discount = discountMenu.getValue();

            if (food != null && discount != null) {
                String[] foodParts = food.split(" ");
                double originalPrice = Double.parseDouble(foodParts[foodParts.length - 1].replace("$", ""));
                double discountedPrice = originalPrice;

                if (discount.equals("Discount - 10%")) {
                    discountedPrice = originalPrice * 0.9;
                } else if (discount.equals("Discount - 20%")) {
                    discountedPrice = originalPrice * 0.8;
                } else if (discount.equals("Discount - 30%")) {
                    discountedPrice = originalPrice * 0.7;
                } else if (discount.equals("Discount - 40%")) {
                    discountedPrice = originalPrice * 0.6;
                } else if (discount.equals("Discount - 50%")) {
                    discountedPrice = originalPrice * 0.5;
                } else if (discount.equals("Discount - 60%")) {
                    discountedPrice = originalPrice * 0.4;
                } else if (discount.equals("Discount - 70%")) {
                    discountedPrice = originalPrice * 0.3;
                } else if (discount.equals("Discount - 80%")) {
                    discountedPrice = originalPrice * 0.2;
                } else if (discount.equals("Discount - 90%")) {
                    discountedPrice = originalPrice * 0.1;
                } else if (discount.equals("Discount - 99%")) {
                    discountedPrice = originalPrice * 0.01;
                }

                String formatPrice = (discountedPrice % 1 == 0) ? String.format("%.0f", discountedPrice) : String.format("%.2f", discountedPrice);
                String formatLabel = discount.split(" - ")[1];

                String promo = food + " ลดเหลือ " + formatPrice + "$ (" + formatLabel + ")";
                promoList.add(promo);
                promoListView.getItems().setAll(promoList);
            }
        });

        removeButton.setOnAction(e -> {
            String selectedPromo = promoListView.getSelectionModel().getSelectedItem();
            if (selectedPromo != null) {
                promoList.remove(selectedPromo);
                promoListView.getItems().setAll(promoList);
            }
        });

        backButton.setOnAction(e -> {
            new RestaurantUI(primaryStage, null);
        });

        HBox selectBox = new HBox(5, foodMenu, discountMenu);
        HBox buttonBox = new HBox(10, discountButton, removeButton);
        VBox promoBox = new VBox(5, promoListView);

        root.getChildren().addAll(selectBox, buttonBox, promoBox, backButton);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Promotion Manager");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}