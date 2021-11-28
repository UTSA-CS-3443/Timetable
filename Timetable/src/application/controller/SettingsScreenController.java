package application.controller;

import application.model.Setting;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The type Settings con.
 */
public class SettingsScreenController implements EventHandler<ActionEvent>, Initializable {
    private static final String COLOR_STYLE_RED = "-fx-background-color: red";
    private static final String COLOR_STYLE_GREEN = "fx-background-color: green";
    /**
     * The Desktop notif.
     */
    @FXML
    public ToggleButton desktopNotif;
    /**
     * The Mute button.
     */
    @FXML
    public ToggleButton muteButton;
    public Button homeButton;
    public Button twoSelection;
    public Button oneSelection;
    public Button threeSelection;
    public Button fourSelection;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == muteButton) {
            muteButtonToggle();
        } else if (actionEvent.getSource() == desktopNotif) {
            desktopNotifButton();
        } else if (actionEvent.getSource() == homeButton) {
            try {
                switchToMain(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (actionEvent.getSource() == oneSelection) {
            ///user goes here's
        } else if (actionEvent.getSource() == twoSelection) {
            ///User goes here
        } else if (actionEvent.getSource() == threeSelection) {
            ///User goes here
        } else {
            ///User goes here
        }
    }


    private void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/CalendarScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void playMedia() {
        mediaPlayer.play();
    }

    public void stopMedia() {
        mediaPlayer.stop();
    }

    /**
     * Mute button toggle.
     */
    public void muteButtonToggle() {
        if (Boolean.TRUE.equals(Setting.isMuted)) {
            Setting.isMuted = false;
            stopMedia();
            muteButton.setStyle(COLOR_STYLE_RED);
        } else {
            Setting.isMuted = true;
            playMedia();
            muteButton.setStyle(COLOR_STYLE_GREEN);
        }
    }

    /**
     * Desktop notif button.
     */
    public void desktopNotifButton() {
        if (Boolean.TRUE.equals(Setting.desktopNotifi)) {
            Setting.desktopNotifi = false;
            desktopNotif.setStyle(COLOR_STYLE_RED);
        } else {
            Setting.desktopNotifi = true;
            desktopNotif.setStyle(COLOR_STYLE_GREEN);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        media = new Media(Setting.alarmSound);
        mediaPlayer = new MediaPlayer(media);
        if (Boolean.TRUE.equals(Setting.desktopNotifi) || Boolean.FALSE.equals(Setting.desktopNotifi)) {
            if (Boolean.TRUE.equals(Setting.desktopNotifi)) {
                desktopNotif.setStyle(COLOR_STYLE_GREEN);
            } else {
                desktopNotif.setStyle(COLOR_STYLE_RED);
            }
        }
        if (Boolean.TRUE.equals(Setting.isMuted) || Boolean.FALSE.equals(Setting.isMuted)) {
            if (Boolean.TRUE.equals(Setting.isMuted)) {
                muteButton.setStyle(COLOR_STYLE_GREEN);
            } else {
                muteButton.setStyle(COLOR_STYLE_RED);
            }
        }
    }
}
