package application.controller;

import application.Main;
import application.model.Settings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import java.net.URL;
import java.util.ResourceBundle;

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
    
    //private User user;
    private Settings settings;

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == muteButton) {
            muteButtonToggle();
        } else if (actionEvent.getSource() == desktopNotif) {
            desktopNotifButton();
        } else if (actionEvent.getSource() == homeButton) {
        	Main.sceneSwitcher("CalendarScreen.fxml");
        }
        
        Main.user.saveUser();
    }

    /**
     * Mute button toggle.
     */
    public void muteButtonToggle() {
        if (Boolean.TRUE.equals(settings.getIsMuted())) {
            settings.setIsMuted(false);
            muteButton.setStyle(COLOR_STYLE_RED);
        } else {
        	settings.setIsMuted(true);
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
    	Main.user.loadUser();
    	
    	settings = Main.user.getSettings();
    	
    	// Set buttons to correct style:
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
