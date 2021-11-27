package application.controller;

import application.model.Settings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Settings con.
 */
public class SettingsCon implements EventHandler<ActionEvent>, Initializable {
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

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == muteButton) {
            muteButtonToggle();
        } else if (actionEvent.getSource() == desktopNotif) {
            desktopNotifButton();
        }

    }

    /**
     * Mute button toggle.
     */
    public void muteButtonToggle() {
        if (Boolean.TRUE.equals(Settings.isMuted)) {
            Settings.isMuted = false;
            muteButton.setStyle(COLOR_STYLE_RED);
        } else {
            Settings.isMuted = true;
            muteButton.setStyle(COLOR_STYLE_GREEN);
        }
    }

    /**
     * Desktop notif button.
     */
    public void desktopNotifButton() {
        if (Boolean.TRUE.equals(Settings.desktopNotifi)) {
            Settings.desktopNotifi = false;
            desktopNotif.setStyle(COLOR_STYLE_RED);
        } else {
            Settings.desktopNotifi = true;
            desktopNotif.setStyle(COLOR_STYLE_GREEN);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Boolean.TRUE.equals(Settings.desktopNotifi) || Boolean.FALSE.equals(Settings.desktopNotifi)) {
            if (Boolean.TRUE.equals(Settings.desktopNotifi)) {
                desktopNotif.setStyle(COLOR_STYLE_GREEN);
            } else {
                desktopNotif.setStyle(COLOR_STYLE_RED);
            }
        } if (Boolean.TRUE.equals(Settings.isMuted) || Boolean.FALSE.equals(Settings.isMuted)) {
            if (Boolean.TRUE.equals(Settings.isMuted)) {
                muteButton.setStyle(COLOR_STYLE_GREEN);
            } else {
                muteButton.setStyle(COLOR_STYLE_RED);
            }
        }
    }
}