package projectmyteam;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUI {
    public LoginUI(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 5; " + "-fx-background-color: linear-gradient(to bottom, #FFD700, #FF4500);");
        root.requestFocus();
        root.setOnMouseClicked(e -> root.requestFocus());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font-weight: bold;");

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-weight: bold;");
            
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setId("usernameField");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setId("passwordField");
        
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        loginButton.setOnMouseEntered(e -> loginButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;"));
        loginButton.setId("loginButton");
        
        Button createButton = new Button("Create Account");
        createButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        createButton.setOnMouseEntered(e -> createButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold;"));
        createButton.setOnMouseExited(e -> createButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;"));
        createButton.setId("createButton");

        HBox buttonBox = new HBox(10, loginButton, createButton);

        loginButton.setOnAction(e -> {
            User user = Database.authenticate(usernameField.getText(), passwordField.getText());
            if (user != null) new RestaurantUI(primaryStage, user);
        });

        createButton.setOnAction(e -> {
            if (Database.registerUser(usernameField.getText(), passwordField.getText()))
            new LoginUI(primaryStage);
        });

        root.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, buttonBox);
        primaryStage.setTitle("My Restaurant");
        primaryStage.setScene(new Scene(root, 300, 165));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
