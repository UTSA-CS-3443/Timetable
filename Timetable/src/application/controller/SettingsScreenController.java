package application.controller;

import application.Main;
import application.model.Settings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.FileChooser;
import java.io.File;
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
    public Button chooseSoundButton;
    public Button homeButton;
    
    //private User user;
    private Settings settings;

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == muteButton) {
            muteButtonToggle();
        } else if (actionEvent.getSource() == desktopNotif) {
            desktopNotifButtonToggle();
        } else if (actionEvent.getSource() == homeButton) {
        	Main.sceneSwitcher("CalendarScreen.fxml");
        } else if (actionEvent.getSource() == chooseSoundButton)
        {
        	chooseSound();
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
            muteButton.setText("Off");
        } else {
        	settings.setIsMuted(true);
            muteButton.setStyle(COLOR_STYLE_GREEN);
            muteButton.setText("On");
        }
    }

    /**
     * Desktop notif button.
     */
    public void desktopNotifButtonToggle() {
        if (Boolean.TRUE.equals(settings.getDesktopNotifi())) {
            settings.setDesktopNotifi(false);
            desktopNotif.setStyle(COLOR_STYLE_RED);
            desktopNotif.setText("Off");
        } else {
        	settings.setDesktopNotifi(true);
            desktopNotif.setStyle(COLOR_STYLE_GREEN);
            desktopNotif.setText("On");
        }
    }
    
    private void chooseSound()
    {
    	FileChooser file = new FileChooser();
    	file.setTitle("Choose Sound File");
    	// Restrict to common audio file types:
    	file.getExtensionFilters().addAll(
    			new FileChooser.ExtensionFilter("MP3 Files", "*.mp3"),
    			new FileChooser.ExtensionFilter("WAV Files", "*.wav"),
    			new FileChooser.ExtensionFilter("M4A Files", "*.m4a"),
    			new FileChooser.ExtensionFilter("OGG Files", "*.ogg"),
    			new FileChooser.ExtensionFilter("WMA Files", "*.wma"),
    			new FileChooser.ExtensionFilter("AAC Files", "*.aac")
    			);
    	
    	File soundFile = file.showOpenDialog(Main.stage);
    	if (soundFile != null)
    	{
	    	Main.user.getSettings().setAlarmSound(soundFile.toString());
	    	Main.user.saveUser();
    	}
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	Main.user.loadUser();
    	
    	settings = Main.user.getSettings();
    	
    	// Set buttons to correct style:
        if (Boolean.TRUE.equals(settings.getDesktopNotifi())) {
            desktopNotif.setStyle(COLOR_STYLE_GREEN);
            desktopNotif.setText("On");
        } else {
            desktopNotif.setStyle(COLOR_STYLE_RED);
            desktopNotif.setText("Off");
        }
        if (Boolean.TRUE.equals(settings.getIsMuted())) {
            muteButton.setStyle(COLOR_STYLE_GREEN);
            muteButton.setText("On");
        } else {
            muteButton.setStyle(COLOR_STYLE_RED);
            muteButton.setText("Off");
        }
    }
}
