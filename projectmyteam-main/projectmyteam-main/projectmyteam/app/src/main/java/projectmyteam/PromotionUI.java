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
        root.setStyle("-fx-padding: 5;" + "-fx-background-color: linear-gradient(to bottom, rgb(236, 228, 11),rgba(240, 12, 12, 0.41));");
        root.setPadding(new Insets(10));
        root.requestFocus();
        root.setOnMouseClicked(e -> root.requestFocus());

        ComboBox<String> foodMenu = new ComboBox<>();
        foodMenu.getItems().addAll("🍕 Pizza", "🍔 Burger", "🍣 Sushi", "🥗 Salad");
        foodMenu.setPromptText("Select a Food Item");

        ComboBox<String> priceMenu = new ComboBox<>();
        priceMenu.getItems().addAll("100", "200", "300", "400");
        priceMenu.setPromptText("Select Price");

        Button discountButton = new Button("Add Discount");
        discountButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        discountButton.setOnMouseEntered(e -> discountButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold;"));
        discountButton.setOnMouseExited(e -> discountButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;"));

        Button removeButton = new Button("Remove Discount");
        removeButton.setStyle("-fx-background-color:rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;");
        removeButton.setOnMouseEntered(e -> removeButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold;"));
        removeButton.setOnMouseExited(e -> removeButton.setStyle("-fx-background-color: rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;"));    

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color:rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: rgb(200, 20, 5); -fx-text-fill: white; -fx-font-weight: bold;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: rgb(246, 28, 9); -fx-text-fill: white; -fx-font-weight: bold;"));

        discountButton.setOnAction(e -> {
            String food = foodMenu.getValue();
            String price = priceMenu.getValue();
            if (food != null && price != null) {
                String promo = food + " ลดเหลือ " + (Integer.parseInt(price) * 0.8) + " บาท"; // ลด 20%
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

        HBox selectBox = new HBox(5, foodMenu, priceMenu);
        HBox buttonBox = new HBox(10, discountButton, removeButton);
        VBox promoBox = new VBox(5, promoListView);

        root.getChildren().addAll(selectBox, buttonBox, promoBox, backButton);
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.setTitle("Promotion Manager"); 
        primaryStage.setResizable(false);
        primaryStage.show();    
    }
}
