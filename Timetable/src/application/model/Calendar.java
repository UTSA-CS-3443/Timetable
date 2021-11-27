package application.model;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public abstract class Calendar 
{
	private ArrayList<Event> events;
	
	public Calendar() {}
	
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
	
	public void addEvent(Color color, String timeToRemind, Boolean isPriority, String desc)
	{
		events.add(new Event(color, timeToRemind, isPriority, desc));
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
		
	}

	/**
	 * @return the events
	 */
	public ArrayList<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
}
