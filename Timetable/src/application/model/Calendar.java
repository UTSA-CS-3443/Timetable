package application.model;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	public void addEvent(Color color, String timeToRemind, Boolean isPriority, String desc, ArrayList<String> dates)
	{
		events.add(new Event(color, timeToRemind, isPriority, desc, dates));
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
	
	public void loadEvents()
	{
		addEvent(Color.RED, "1:0", false, "Test1", new ArrayList<String>( Arrays.asList("2021-11-3|12:00", "2021-11-5|12:00")));
		addEvent(Color.BLUE, "1:0", false, "Test2", new ArrayList<String>( Arrays.asList("2021-11-20|12:00", "2021-11-30|12:00")));
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
