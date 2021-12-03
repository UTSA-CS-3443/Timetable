package application.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Event 
{
	private ArrayList<String> dates; // Format: YYYY-MM-DD_HH:MM (AM|PM)
	private Color color;
	private int timeToRemind;
	private boolean isPriority;
	private String desc;
	private boolean isCompleted;
	private String ID;
	
	/**
	 * Class constructor setting the color, timetoremind, ispriority, desc, iscompleted, and dates.
	 * 
	 * @param color, a color to set as the event color.
	 * @param timeToRemind, an int representing the time to remind the user.
	 * @param isPriority, a Boolean that states weather or not the event is a priority.
	 * @param desc, a String of the description of the event.
	 * @param isCompleted, a Boolean setting weather or not the even has been completed.
	 * @param dates, an ArrayList of dates that the event takes place over.
	 */
	public Event(Color color, int timeToRemind, Boolean isPriority, String desc, boolean isCompleted, ArrayList<String> dates)
	{
		this.color = color;
		this.timeToRemind = timeToRemind;
		this.isPriority = isPriority;
		this.desc = desc;
		this.dates = dates;
		this.isCompleted = isCompleted;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		this.ID = (String) dtf.format(now); // Generates an id which is the time of creation. 
	}
	
	/**
	 * @param date, a String version of the events date.
	 */
	public void addDate(String date)
	{
		dates.add(date);
	}
	
	/**
	 * @param date, a String version of the events date to be removed.
	 */
	public void removeDate(String date)
	{
		dates.remove(date);
	}

	/**
	 * @return an ArrayList of dates that the event spans.
	 */
	public ArrayList<String> getDates() {
		return dates;
	}

	/**
	 * @param dates, an ArrayList of dates that the event spans.
	 */
	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}

	/**
	 * @return the events Color.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color, what color the event will be.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return an int representing the time that the user will be reminded of the event.
	 */
	public int getTimeToRemind() {
		return timeToRemind;
	}

	/**
	 * @param timeToRemind, an int representing the time that the user will be reminded of the event.
	 */
	public void setTimeToRemind(int timeToRemind) {
		this.timeToRemind = timeToRemind;
	}

	/**
	 * @return the isPriority the Boolean telling whether or not the event is a priority.
	 */
	public Boolean getIsPriority() {
		return isPriority;
	}

	/**
	 * @param isPriority, the Boolean telling whether or not the event is a priority.
	 */
	public void setIsPriority(Boolean isPriority) {
		this.isPriority = isPriority;
	}

	/**
	 * @return a String description of the event.
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc, a String description of the event.
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return a Boolean telling whether or not the event was completed.
	 */
	public Boolean getIsCompleted() {
		return isCompleted;
	}

	/**
	 * @param isCompleted, a Boolean telling whether or not the event was completed.
	 */
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	/**
	 * @return a String representing the event ID.
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param ID, a String representing the event ID.
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
}
