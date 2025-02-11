package projectmyteam;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUI {
    public LoginUI(Stage primaryStage) {
        Vbox root = new Vbox(10)
            
        TextField usernameField = new TextField();
        usernameField.setId("usernameField");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setId("passwordField");
        
        Button loginButton = new Button("Login");
        loginButton.setId("loginButton");
        
        Button createButton = new Button("Create Account");
        createButton.setId("createButton");

        loginButton.setOnAction(e -> {
            User user = Database.authenticate(usernameField.getText(), passwordField.getText());
            if (user != null) new DashboardUI(primaryStage, user);
            else messageLabel.setText("Invalid credentials.");
        });
    }
}

public class UserUI {
    //placeholder
    }
}

public class RestaurantUI {
    //placeholder
    }
}

public class OrderUI {
    //placeholder
    }
}
