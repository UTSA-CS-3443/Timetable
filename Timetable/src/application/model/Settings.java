package application.model;

public class Settings 
{
	private Boolean isStartUp;
	private Boolean desktopNotifi;
	private Boolean isMuted; 
	private String alarmSound; // Path to audio file; Add default
	private int priorityInterval;
	
	public Settings()
	{
		return;
	}

	/**
	 * @return the isStartUp
	 */
	public Boolean getIsStartUp() {
		return isStartUp;
	}

	/**
	 * @param isStartUp the isStartUp to set
	 */
	public void setIsStartUp(Boolean isStartUp) {
		this.isStartUp = isStartUp;
	}

	/**
	 * @return the alarmSound
	 */
	public String getAlarmSound() {
		return alarmSound;
	}

	/**
	 * @param alarmSound the alarmSound to set
	 */
	public void setAlarmSound(String alarmSound) {
		this.alarmSound = alarmSound;
	}

	/**
	 * @return the isMuted
	 */
	public Boolean getIsMuted() {
		return isMuted;
	}

	/**
	 * @param isMuted the isMuted to set
	 */
	public void setIsMuted(Boolean isMuted) {
		this.isMuted = isMuted;
	}

	/**
	 * @return the priorityInterval
	 */
	public int getPriorityInterval() {
		return priorityInterval;
	}

	/**
	 * @param priorityInterval the priorityInterval to set
	 */
	public void setPriorityInterval(int priorityInterval) {
		this.priorityInterval = priorityInterval;
	}

	/**
	 * @return the desktopNotifi
	 */
	public Boolean getDesktopNotifi() {
		return desktopNotifi;
	}

	/**
	 * @param desktopNotifi the desktopNotifi to set
	 */
	public void setDesktopNotifi(Boolean desktopNotifi) {
		this.desktopNotifi = desktopNotifi;
	}
	
}
