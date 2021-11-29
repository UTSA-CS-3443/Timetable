package application.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Event 
{
	private ArrayList<String> dates;
	private Color color;
	private int timeToRemind;
	private boolean isPriority;
	private String desc;
	private boolean isCompleted;
	private boolean isMissed;
	private String ID;
	
	public Event(Color color, int timeToRemind, Boolean isPriority, String desc, boolean isCompleted, boolean isMissed, ArrayList<String> dates)
	{
		this.color = color;
		this.timeToRemind = timeToRemind;
		this.isPriority = isPriority;
		this.desc = desc;
		this.dates = dates;
		this.isCompleted = isCompleted;
		this.isMissed = isMissed;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		this.ID = (String) dtf.format(now); // Generates an id which is the time of creation. 
	}
	
	
	public void addDate(String date)
	{
		dates.add(date);
	}
	
	public void removeDate(String date)
	{
		dates.remove(date);
	}

	/**
	 * @return the dates
	 */
	public ArrayList<String> getDates() {
		return dates;
	}

	/**
	 * @param dates the dates to set
	 */
	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the timeToRemind
	 */
	public int getTimeToRemind() {
		return timeToRemind;
	}

	/**
	 * @param timeToRemind the timeToRemind to set
	 */
	public void setTimeToRemind(int timeToRemind) {
		this.timeToRemind = timeToRemind;
	}

	/**
	 * @return the isPriority
	 */
	public Boolean getIsPriority() {
		return isPriority;
	}

	/**
	 * @param isPriority the isPriority to set
	 */
	public void setIsPriority(Boolean isPriority) {
		this.isPriority = isPriority;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the isCompleted
	 */
	public Boolean getIsCompleted() {
		return isCompleted;
	}

	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	/**
	 * @return the isMissed
	 */
	public Boolean getIsMissed() {
		return isMissed;
	}

	/**
	 * @param isMissed the isMissed to set
	 */
	public void setIsMissed(Boolean isMissed) {
		this.isMissed = isMissed;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
}
