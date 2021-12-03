package application.model;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public abstract class Calendar
{
	private ArrayList<Event> events;
	
	/**
	 * Class constructor that creates an arrayList of Events.
	 */
	public Calendar() 
	{
		events = new ArrayList<Event>();
	}
	
	/**
	 * @param color, a color to set as the event color.
	 * @param timeToRemind, an int representing the time to remind the user.
	 * @param isPriority, a Boolean that states weather or not the event is a priority.
	 * @param desc, a String of the description of the event.
	 * @param isCompleted, a Boolean setting weather or not the even has been completed.
	 * @param dates, an ArrayList of dates that the event takes place over.
	 */
	public void addEvent(Color color, int timeToRemind, Boolean isPriority, String desc, boolean isCompleted, ArrayList<String> dates)
	{
		events.add(new Event(color, timeToRemind, isPriority, desc, isCompleted, dates));
	}
	
	/**
	 * @param ID, a String which is the ID of the event to be removed.
	 */
	public void removeEvent(String ID)
	{
		for (int i = 0; i < events.size(); i++)
		{
			if (events.get(i).getID().equals(ID))
			{
				events.remove(i);
				return;
			}
		}
	}
	
	/**
	 * @param ID, a String which is the ID of the event to be removed.
	 * @return The event that was asked to be returned.
	 */
	public Event getEvent(String ID)
	{
		for (int i = 0; i < events.size(); i++)
		{
			if (events.get(i).getID().equals(ID))
			{
				return events.get(i);
			}
		}
		return null;
	}

	/**
	 * @return An ArrayList of events.
	 */
	public ArrayList<Event> getEvents() 
	{
		return events;
	}

	/**
	 * @param ArrayList of Events, an ArrayList of events that theuser has created.
	 */
	public void setEvents(ArrayList<Event> events) 
	{
		this.events = events;
	}
}
