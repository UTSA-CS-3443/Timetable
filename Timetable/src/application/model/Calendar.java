package application.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * The type Calendar.
 */
public abstract class Calendar {
    private ArrayList<Event> events;

    /**
     * Class constructor that creates an arrayList of Events.
     */
    public Calendar() {
        events = new ArrayList<Event>();
    }

    /**
     * Add event.
     *
     * @param color        the color
     * @param timeToRemind the time to remind
     * @param isPriority   the is priority
     * @param desc         the desc
     * @param isCompleted  the is completed
     * @param dates        the dates
     */
    public void addEvent(Color color, int timeToRemind, Boolean isPriority, String desc, boolean isCompleted, ArrayList<String> dates) {
        events.add(new Event(color, timeToRemind, isPriority, desc, isCompleted, dates));
    }


    /**
     * Gets events.
     *
     * @return An ArrayList of events.
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
