package application.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignInController implements EventHandler<ActionEvent> {
    @FXML
    public Button signUpButton;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField emailField;
    @FXML
    public ImageView continueButton;
    @FXML
    public Label prompt;

    public void switchToSignUp(Event event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/application/SignUp.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/fontstyle.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            if (actionEvent.getSource() == signUpButton) {
                switchToSignUp(actionEvent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
