package projectmyteam;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        usernameField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        usernameField.setPromptText("Enter username");
        usernameField.setId("usernameField");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        passwordField.setPromptText("Enter password");
        passwordField.setId("passwordField");

        TextField visiblePasswordField = new TextField();
        visiblePasswordField.setStyle("-fx-background-radius: 15; -fx-border-radius: 15; -fx-border-color: gray; " + "-fx-border-width: 1px;");
        visiblePasswordField.setPromptText("Enter password");
        visiblePasswordField.setId("visiblePasswordField");

        ToggleButton eyeButton = new ToggleButton("👁");
        eyeButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 15px; -fx-padding: 0; -fx-pref-width: 25px; -fx-pref-height: 15px;");
        eyeButton.setFocusTraversable(false);
        eyeButton.setId("eyeButton");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        loginButton.setOnMouseEntered(e -> loginButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        loginButton.setId("loginButton");
        
        Button createButton = new Button("Create Account");
        createButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        createButton.setOnMouseEntered(e -> createButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        createButton.setOnMouseExited(e -> createButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        createButton.setId("createButton");

        Button bypassButton = new Button("Bypass Login");
        bypassButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;");
        bypassButton.setOnMouseEntered(e -> bypassButton.setStyle("-fx-background-color:rgb(0, 41, 247); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        bypassButton.setOnMouseExited(e -> bypassButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20; -fx-border-radius: 20;"));
        bypassButton.setId("bypassButton");

        HBox buttonBox = new HBox(10, loginButton, createButton, bypassButton);

        loginButton.setOnAction(e -> {
            User user = Database.authenticate(usernameField.getText(), passwordField.getText());
            if (user != null) new RestaurantUI(primaryStage, user);
        });

        createButton.setOnAction(e -> {
            if (Database.registerUser(usernameField.getText(), passwordField.getText()))
            new LoginUI(primaryStage);
        });

        bypassButton.setOnAction(e -> {
            new RestaurantUI(primaryStage, null);
        });

        eyeButton.setOnAction(e -> {
            boolean showPassword = eyeButton.isSelected();
            if (showPassword) {
                visiblePasswordField.setText(passwordField.getText());
                passwordField.setVisible(false);
                visiblePasswordField.setVisible(true);
            } else {
                passwordField.setText(visiblePasswordField.getText());
                visiblePasswordField.setVisible(false);
                passwordField.setVisible(true);
            }
        });

        StackPane passwordStack = new StackPane();
        passwordStack.setAlignment(Pos.CENTER_RIGHT);
        passwordStack.getChildren().addAll(passwordField, visiblePasswordField, eyeButton);
        visiblePasswordField.setVisible(false);
        visiblePasswordField.managedProperty().bind(visiblePasswordField.visibleProperty());
        passwordField.managedProperty().bind(passwordField.visibleProperty());

        root.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordStack, buttonBox);
        primaryStage.setTitle("My Restaurant");
        primaryStage.setScene(new Scene(root, 300, 168));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}