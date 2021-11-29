package application.controller;

import application.Main;
import application.model.Settings;
import application.model.User;
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
    //private Media media;
    //private MediaPlayer mediaPlayer;
    
    private User user;
    private Settings settings;

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == muteButton) {
            muteButtonToggle();
        } else if (actionEvent.getSource() == desktopNotif) {
            desktopNotifButton();
        } else if (actionEvent.getSource() == homeButton) {
        	Main.sceneSwitcher("CalendarScreen.fxml");
        } else if (actionEvent.getSource() == oneSelection) {
            ///user goes here's
        } else if (actionEvent.getSource() == twoSelection) {
            ///User goes here
        } else if (actionEvent.getSource() == threeSelection) {
            ///User goes here
        } else {
            ///User goes here
        }
        User.setSerializeUser(user);
    }

    /*public void playMedia() {
        mediaPlayer.play();
    }

    public void stopMedia() {
        mediaPlayer.stop();
    }*/

    /**
     * Mute button toggle.
     */
    public void muteButtonToggle() {
        if (Boolean.TRUE.equals(settings.getIsMuted())) {
            settings.setIsMuted(false);
            //stopMedia();
            muteButton.setStyle(COLOR_STYLE_RED);
        } else {
        	settings.setIsMuted(true);
            //playMedia();
            muteButton.setStyle(COLOR_STYLE_GREEN);
        }
    }

    /**
     * Desktop notif button.
     */
    public void desktopNotifButton() {
        if (Boolean.TRUE.equals(settings.getDesktopNotifi())) {
            settings.setDesktopNotifi(false);
            desktopNotif.setStyle(COLOR_STYLE_RED);
        } else {
        	settings.setDesktopNotifi(true);
            desktopNotif.setStyle(COLOR_STYLE_GREEN);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	user = (User) User.getSerializeUser();
    	settings = user.getSettings();
    	
        //media = new Media(settings.alarmSound);
        //mediaPlayer = new MediaPlayer(media);
        if (Boolean.TRUE.equals(settings.getDesktopNotifi())) {
            desktopNotif.setStyle(COLOR_STYLE_GREEN);
        } else {
            desktopNotif.setStyle(COLOR_STYLE_RED);
        }
        
        if (Boolean.TRUE.equals(settings.getIsMuted())) {
            muteButton.setStyle(COLOR_STYLE_GREEN);
        } else {
            muteButton.setStyle(COLOR_STYLE_RED);
        }
    }
}
