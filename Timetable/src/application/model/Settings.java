package application.model;

import java.io.Serializable;

/**
 * The type Settings.
 */
public class Settings implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7974267776680377989L;
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
    //public static String alarmSound; // Path to audio file; Add default

    //public static int priorityInterval;

    /**
     * Instantiates a new Settings.
     */
    public Settings() {
    	desktopNotifi = false;
    	isMuted = false;
        return;
    }

    /**
     * Gets alarm sound.
     *
     * @return the alarmSound
     */
    /*public String getAlarmSound() {
        return alarmSound;
    }*/

    /**
     * Sets alarm sound.
     *
     * @param alarmSound the alarmSound to set
     */
    /*public void setAlarmSound(String alarmSound) {
        Settings.alarmSound = alarmSound;
    }*/

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
     * Gets priority interval.
     *
     * @return the priorityInterval
     */
    /*public int getPriorityInterval() {
        return priorityInterval;
    }*/

    /**
     * Sets priority interval.
     *
     * @param priorityInterval the priorityInterval to set
     */
    /*public void setPriorityInterval(int priorityInterval) {
        Settings.priorityInterval = priorityInterval;
    }*/

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