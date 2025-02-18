package projectmyteam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PromotionUI {
    private ListView<String> promoListView; // แสดงรายการโปรโมชั่น
    private List<String> promoList; // เก็บข้อมูลโปรโมชั่น

    public PromotionUI(Stage primaryStage) {
        promoList = new ArrayList<>();
        promoListView = new ListView<>();

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // 🔹 Drop-down เลือกเมนูอาหาร
        ComboBox<String> foodMenu = new ComboBox<>();
        foodMenu.getItems().addAll("🍕 Pizza", "🍔 Burger", "🍣 Sushi", "🥗 Salad");
        foodMenu.setPromptText("Select a Food Item");

        // 🔹 Drop-down เลือกราคา
        ComboBox<String> priceMenu = new ComboBox<>();
        priceMenu.getItems().addAll("100", "200", "300", "400");
        priceMenu.setPromptText("Select Price");

        // ✅ ปุ่ม "ลดราคา"
        Button discountButton = new Button("ลดราคา");
        discountButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-weight: bold;");
        discountButton.setOnAction(e -> {
            String food = foodMenu.getValue();
            String price = priceMenu.getValue();
            if (food != null && price != null) {
                String promo = food + " ลดเหลือ " + (Integer.parseInt(price) * 0.8) + " บาท"; // ลด 20%
                promoList.add(promo);
                promoListView.getItems().setAll(promoList);
            }
        });

        // ✅ ปุ่ม "ลบโปรโมชัน"
        Button removeButton = new Button("ลบโปรโมชัน");
        removeButton.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
        removeButton.setOnAction(e -> {
            String selectedPromo = promoListView.getSelectionModel().getSelectedItem();
            if (selectedPromo != null) {
                promoList.remove(selectedPromo);
                promoListView.getItems().setAll(promoList);
            }
        });

        // ✅ ปุ่ม "ย้อนกลับ"
        Button backButton = new Button("ย้อนกลับ");
        backButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-weight: bold;");
        backButton.setOnAction(e -> {
            new RestaurantUI(primaryStage, null);
        });

        // Layout
        HBox selectBox = new HBox(5, foodMenu, priceMenu);
        VBox promoBox = new VBox(5, promoListView, removeButton);
        root.getChildren().addAll(selectBox, discountButton, promoBox, backButton);

        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.setTitle("Promotion Manager");
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
}
