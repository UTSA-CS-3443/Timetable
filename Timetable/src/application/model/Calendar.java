package application.model;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public abstract class Calendar
{
	private ArrayList<Event> events;
	
	public Calendar() 
	{
		events = new ArrayList<Event>();
	}
	
	public ArrayList<Event> getMissedEvents()
	{
		ArrayList<Event> missedEvents = new ArrayList<Event>();
		for (int i = 0; i < events.size(); i++)
		{
			if (events.get(i).getIsMissed())
			{
				missedEvents.add(events.get(i));
			}
		}
		return missedEvents;
	}
	
	public void addEvent(Color color, int timeToRemind, Boolean isPriority, String desc, boolean isCompleted, boolean isMissed, ArrayList<String> dates)
	{
		events.add(new Event(color, timeToRemind, isPriority, desc, isCompleted, isMissed, dates));
	}
	
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
	 * @return the events
	 */
	public ArrayList<Event> getEvents() 
	{
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(ArrayList<Event> events) 
	{
		this.events = events;
	}
}
