package application.model;

public class Settings {
	
	private final String DEFAULT_NOTIFICATION_SOUND = "res/Notification/notification_alert.mp3";
    private Boolean desktopNotifi;
    private Boolean isMuted;
    public static String alarmSound;

    /**
     * Class constructor setting desktopNotifi to false, isMuted to false and alarmSound to the default sound.
     */
    public Settings() {
    	desktopNotifi = false;
    	isMuted = false;
    	alarmSound = DEFAULT_NOTIFICATION_SOUND;
    }
    
    /**
     * Overloaded class constructor setting desktopNotifi and isMuted to passed in values.
     * 
     * @param desktopNotifi, a Boolean representing weather or not desktop notifications are enabled.
     * @param isMuted, a Boolean representing if the app is muted or not.
     */
    public Settings(boolean desktopNotifi, boolean isMuted) {
    	this.desktopNotifi = desktopNotifi;
    	this.isMuted = isMuted;
    }

    /**
     * @return a String representing the alarm sound.
     */
    public String getAlarmSound() {
        return alarmSound;
    }

    /**
     * @param alarmSound, a String representing the alarm sound.
     */
    public void setAlarmSound(String alarmSound) {
        Settings.alarmSound = alarmSound;
    }

    /**
     * @return a Boolean representing if the app is muted or not.
     */
    public Boolean getIsMuted() {
        return isMuted;
    }

    /**
     * @param isMuted, a Boolean representing if the app is muted or not.
     */
    public void setIsMuted(Boolean isMuted) {
        this.isMuted = isMuted;
    }

    /**
     * @return a Boolean representing weather or not desktop notifications are enabled.
     */
    public Boolean getDesktopNotifi() {
        return desktopNotifi;
    }

    /**
     * @param desktopNotifi, a Boolean representing weather or not desktop notifications are enabled.
     */
    public void setDesktopNotifi(Boolean desktopNotifi) {
        this.desktopNotifi = desktopNotifi;
    }
}