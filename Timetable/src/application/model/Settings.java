package application.model;

//import java.io.Serializable;   COMMENTED BY BRIAN

/**
 * The type Settings.
 */
public class Settings {
	private final String DEFAULT_NOTIFICATION_SOUND = "res/Notification/notification_alert.mp3";
	/**
     * The constant desktopNotifi.
     */
    private Boolean desktopNotifi;
    /**
     * The constant isMuted.
     */
    private Boolean isMuted;
    /**
     * The constant alarmSound.
     */
    public static String alarmSound;

    /**
     * Instantiates a new Settings.
     */
    public Settings() {
    	desktopNotifi = false;
    	isMuted = false;
    	alarmSound = DEFAULT_NOTIFICATION_SOUND;
    }
    
    public Settings(boolean desktopNot, boolean muted) {
    	desktopNotifi = desktopNot;
    	isMuted = muted;
    }

    /**
     * Gets alarm sound.
     *
     * @return the alarmSound
     */
    public String getAlarmSound() {
        return alarmSound;
    }

    /**
     * Sets alarm sound.
     *
     * @param alarmSound the alarmSound to set
     */
    public void setAlarmSound(String alarmSound) {
        Settings.alarmSound = alarmSound;
    }

    /**
     * Gets is muted.
     *
     * @return the isMuted
     */
    public Boolean getIsMuted() {
        return isMuted;
    }

    /**
     * Sets is muted.
     *
     * @param isMuted the isMuted to set
     */
    public void setIsMuted(Boolean isMuted) {
        this.isMuted = isMuted;
    }

    /**
     * Gets desktop notifi.
     *
     * @return the desktopNotifi
     */
    public Boolean getDesktopNotifi() {
        return desktopNotifi;
    }

    /**
     * Sets desktop notifi.
     *
     * @param desktopNotifi the desktopNotifi to set
     */
    public void setDesktopNotifi(Boolean desktopNotifi) {
        this.desktopNotifi = desktopNotifi;
    }

}