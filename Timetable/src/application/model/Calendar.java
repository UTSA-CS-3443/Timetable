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
	
	public void addEvent(Color color, int timeToRemind, Boolean isPriority, String desc, ArrayList<String> dates)
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
		addEvent(Color.RED, 60, false, "Feed the Dog.", new ArrayList<String>( Arrays.asList("2021-11-27_12:00", "2021-11-15_12:00")));
		addEvent(Color.BLUE, 60, false, "Make sure to turn in homework.", new ArrayList<String>( Arrays.asList("2021-11-21_12:00", "2021-11-15_12:00")));
		addEvent(Color.GREEN, 60, false, "Test3", new ArrayList<String>( Arrays.asList("2021-10-1_12:00", "2021-11-15_12:00")));
		addEvent(Color.PURPLE, 60, false, "Test4", new ArrayList<String>( Arrays.asList("2021-11-15_12:00", "2021-08-7_12:00", "2021-08-29_12:00")));
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
