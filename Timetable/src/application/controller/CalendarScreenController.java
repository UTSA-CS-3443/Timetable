package application.controller;

import application.model.Event;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;


public class CalendarScreenController implements EventHandler<ActionEvent>
{
	private final double CAL_EVENT_REC_HEIGHT = 6.0;
	
	// These are the circles behind the date numbers:
	@FXML
	private Circle w1d1Circ;
	@FXML
	private Circle w1d2Circ;
	@FXML
	private Circle w1d3Circ;
	@FXML
	private Circle w1d4Circ;
	@FXML
	private Circle w1d5Circ;
	@FXML
	private Circle w1d6Circ;
	@FXML
	private Circle w1d7Circ;
	@FXML
	private Circle w2d1Circ;
	@FXML
	private Circle w2d2Circ;
	@FXML
	private Circle w2d3Circ;
	@FXML
	private Circle w2d4Circ;
	@FXML
	private Circle w2d5Circ;
	@FXML
	private Circle w2d6Circ;
	@FXML
	private Circle w2d7Circ;
	@FXML
	private Circle w3d1Circ;
	@FXML
	private Circle w3d2Circ;
	@FXML
	private Circle w3d3Circ;
	@FXML
	private Circle w3d4Circ;
	@FXML
	private Circle w3d5Circ;
	@FXML
	private Circle w3d6Circ;
	@FXML
	private Circle w3d7Circ;
	@FXML
	private Circle w4d1Circ;
	@FXML
	private Circle w4d2Circ;
	@FXML
	private Circle w4d3Circ;
	@FXML
	private Circle w4d4Circ;
	@FXML
	private Circle w4d5Circ;
	@FXML
	private Circle w4d6Circ;
	@FXML
	private Circle w4d7Circ;
	@FXML
	private Circle w5d1Circ;
	@FXML
	private Circle w5d2Circ;
	@FXML
	private Circle w5d3Circ;
	@FXML
	private Circle w5d4Circ;
	@FXML
	private Circle w5d5Circ;
	@FXML
	private Circle w5d6Circ;
	@FXML
	private Circle w5d7Circ;
	@FXML
	private Circle w6d1Circ;
	@FXML
	private Circle w6d2Circ;
	
	// These are the date labels themselves:
	@FXML
	private Label w1d1;
	@FXML
	private Label w1d2;
	@FXML
	private Label w1d3;
	@FXML
	private Label w1d4;
	@FXML
	private Label w1d5;
	@FXML
	private Label w1d6;
	@FXML
	private Label w1d7;
	@FXML
	private Label w2d1;
	@FXML
	private Label w2d2;
	@FXML
	private Label w2d3;
	@FXML
	private Label w2d4;
	@FXML
	private Label w2d5;
	@FXML
	private Label w2d6;
	@FXML
	private Label w2d7;
	@FXML
	private Label w3d1;
	@FXML
	private Label w3d2;
	@FXML
	private Label w3d3;
	@FXML
	private Label w3d4;
	@FXML
	private Label w3d5;
	@FXML
	private Label w3d6;
	@FXML
	private Label w3d7;
	@FXML
	private Label w4d1;
	@FXML
	private Label w4d2;
	@FXML
	private Label w4d3;
	@FXML
	private Label w4d4;
	@FXML
	private Label w4d5;
	@FXML
	private Label w4d6;
	@FXML
	private Label w4d7;
	@FXML
	private Label w5d1;
	@FXML
	private Label w5d2;
	@FXML
	private Label w5d3;
	@FXML
	private Label w5d4;
	@FXML
	private Label w5d5;
	@FXML
	private Label w5d6;
	@FXML
	private Label w5d7;
	@FXML
	private Label w6d1;
	@FXML
	private Label w6d2;
	
	@FXML
	private Label monthLabel;
	@FXML
	private Label yearLabel;
	@FXML
	private Rectangle rightArrow;
	@FXML
	private Rectangle leftArrow;
	
	@FXML
	private AnchorPane calendarPane;
	@FXML
	private AnchorPane sidePanel;
	
	private ArrayList<ArrayList<Label>> dateLabels;
	private ArrayList<ArrayList<Circle>> dateCircles;
	private int selectedDay;  // NOTE: Base 1
	private int firstDayOfMonth; // NOTE: Base 1
	private int selectedMonth; // NOTE: Base 1
	private int selectedYear;
	private String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private int[] monthDayNums = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private User user;
	private ArrayList<Rectangle> curCalEvents;
	private ArrayList<Label> curPanelEvents;
	
	public void initialize()
	{
		// Organize date labels:
		dateLabels = new ArrayList<ArrayList<Label>>();
		dateLabels.add(new ArrayList<Label>(Arrays.asList(w1d1, w1d2, w1d3, w1d4, w1d5, w1d6, w1d7)));
		dateLabels.add(new ArrayList<Label>(Arrays.asList(w2d1, w2d2, w2d3, w2d4, w2d5, w2d6, w2d7)));
		dateLabels.add(new ArrayList<Label>(Arrays.asList(w3d1, w3d2, w3d3, w3d4, w3d5, w3d6, w3d7)));
		dateLabels.add(new ArrayList<Label>(Arrays.asList(w4d1, w4d2, w4d3, w4d4, w4d5, w4d6, w4d7)));
		dateLabels.add(new ArrayList<Label>(Arrays.asList(w5d1, w5d2, w5d3, w5d4, w5d5, w5d6, w5d7)));
		dateLabels.add(new ArrayList<Label>(Arrays.asList(w6d1, w6d2)));
		
		dateCircles = new ArrayList<ArrayList<Circle>>();
		dateCircles.add(new ArrayList<Circle>(Arrays.asList(w1d1Circ, w1d2Circ, w1d3Circ, w1d4Circ, w1d5Circ, w1d6Circ, w1d7Circ)));
		dateCircles.add(new ArrayList<Circle>(Arrays.asList(w2d1Circ, w2d2Circ, w2d3Circ, w2d4Circ, w2d5Circ, w2d6Circ, w2d7Circ)));
		dateCircles.add(new ArrayList<Circle>(Arrays.asList(w3d1Circ, w3d2Circ, w3d3Circ, w3d4Circ, w3d5Circ, w3d6Circ, w3d7Circ)));
		dateCircles.add(new ArrayList<Circle>(Arrays.asList(w4d1Circ, w4d2Circ, w4d3Circ, w4d4Circ, w4d5Circ, w4d6Circ, w4d7Circ)));
		dateCircles.add(new ArrayList<Circle>(Arrays.asList(w5d1Circ, w5d2Circ, w5d3Circ, w5d4Circ, w5d5Circ, w5d6Circ, w5d7Circ)));
		dateCircles.add(new ArrayList<Circle>(Arrays.asList(w6d1Circ, w6d2Circ)));
		
		// Set Calendar to current month+year:
		String[] date = new String[3];
		date = java.time.LocalDate.now().toString().split("-");
		selectedMonth = Integer.valueOf(date[1]);
		selectedYear = Integer.valueOf(date[0]);
		monthLabel.setText(monthNames[selectedMonth - 1]);
		yearLabel.setText(date[0]);
		
		// Set date labels correctly:
		
		// Set calendar to this month:
		resetLabels();
		this.setCalendarMonth(selectedMonth, selectedYear);
		
		// Select currentDate:
		selectedDay = Integer.valueOf(date[2]);
		dateCircles.get((selectedDay / 7)).get((selectedDay) % 7).setStrokeWidth(2);
		dateCircles.get((selectedDay / 7)).get((selectedDay) % 7).setStroke(Color.RED);
		
		// Load and display events:
		user = new User();
		curCalEvents = new ArrayList<Rectangle>();
		user.loadEvents();
		displayCalEvents();
		
		// Load day panel:
		displayDayPanel();
	}
	
	public void handle(ActionEvent arg0) // Unused
	{
	}
	
	public void handleArrow(MouseEvent event)
	{
		if (event.getSource() == leftArrow)
		{
			selectedMonth--;
			if (selectedMonth == 0)
			{
				selectedYear--;
				selectedMonth = 12;
			}
			setCalendarMonth(selectedMonth, selectedYear);
		}
		else
		{
			selectedMonth++;
			if (selectedMonth == 13)
			{
				selectedYear++;
				selectedMonth = 1;
			}
			setCalendarMonth(selectedMonth, selectedYear);
		}
		displayCalEvents();
	}
	
	public void handleDateSelection(MouseEvent event)
	{
		
	}
	
	private void resetLabels()
	{
		for (int i = 0; i < dateLabels.size(); i++)
		{
			for (int j = 0; j < dateLabels.get(i).size(); j++)
			{
				dateLabels.get(i).get(j).setText("");
				dateCircles.get(i).get(j).setStrokeWidth(0);
			}
		}
	}
	
	private void resetEvents()
	{
		for (int i = 0; i < calendarPane.getChildren().size(); i++)
		{
			for (int j = 0; j < this.curCalEvents.size(); j++)
			{
				if (calendarPane.getChildren().get(i).equals(this.curCalEvents.get(j)))
				{
					calendarPane.getChildren().remove(i--);
					this.curCalEvents.remove(j--);
				}
			}
		}
		return;
	}
	
	private void resetSidePanelEvents()
	{
		for (int i = 0; i < calendarPane.getChildren().size(); i++)
		{
			for (int j = 0; j < this.curPanelEvents.size(); j++)
			{
				if (calendarPane.getChildren().get(i).equals(this.curPanelEvents.get(j)))
				{
					calendarPane.getChildren().remove(i--);
					this.curPanelEvents.remove(j--);
				}
			}
		}
		return;
	}
	
	private void setCalendarMonth(int month, int year)
	{
		monthLabel.setText(monthNames[month - 1]);
		yearLabel.setText(String.valueOf(year));
		
		Calendar cal = new GregorianCalendar(year, month - 1, 1);
		resetLabels();
		int numDayOfMonth = monthDayNums[month - 1]; // TODO check for leapyear
		int _DOW = cal.get(Calendar.DAY_OF_WEEK);
		firstDayOfMonth = _DOW;
		int weekCount = 1;
		for (int i = 0; i < numDayOfMonth; i++)
		{
			if ((_DOW - 1) == 7)
			{
				weekCount++;
				_DOW = 1;
			}
			dateLabels.get(weekCount - 1).get(_DOW - 1).setText("" + (i+1));
			_DOW++;
		}
	}
	
	private void displayCalEvents()
	{
		resetEvents();
		// Get the number of events per date this month:
		HashMap<String, Integer[]> numEventsPerDate = new HashMap<String, Integer[]>(); // Integer[0] is total events this date, Integer[1] is how many have been shown thus far.
		for (int i = 0; i < user.getEvents().size(); i++)
		{
			int datesForCurEvent = user.getEvents().get(i).getDates().size();
			for (int dateNum = 0; dateNum < datesForCurEvent; dateNum++)
			{
				String curDate = user.getEvents().get(i).getDates().get(dateNum).split("_")[0];
				if (numEventsPerDate.containsKey(curDate))
				{
					numEventsPerDate.get(curDate)[0]++;
				}
				else
				{
					numEventsPerDate.put(curDate, new Integer[]{1, 0});
				}
			}
		}
		
		// Display rectangles on calendar to mark events:
		for (int i = 0; i < user.getEvents().size(); i++)
		{
			int datesForCurEvent = user.getEvents().get(i).getDates().size();
			for (int curDate = 0; curDate < datesForCurEvent; curDate++)
			{
				String[] date = user.getEvents().get(i).getDates().get(curDate).split("_");
				String[] yearMonthDay = date[0].split("-");
				if (Integer.valueOf(yearMonthDay[1]) == selectedMonth && Integer.valueOf(yearMonthDay[0]) == selectedYear) // If this event happens this month, this year:
				{
					Rectangle eventBar = new Rectangle();
					eventBar.setFill(user.getEvents().get(i).getColor());
					eventBar.setHeight(this.CAL_EVENT_REC_HEIGHT);
					eventBar.setWidth(45.0);
					eventBar.setOpacity(1.0);
					// Calculate position in calendar:
					int dateDOW = (this.firstDayOfMonth + ((Integer.valueOf(yearMonthDay[2]) % 7) - 1)) % 7;
					if (dateDOW == 0)
					{
						dateDOW = 7;
					}
					int dateWeek = ((Integer.valueOf(yearMonthDay[2]) + (this.firstDayOfMonth - 2)) / 7);
					
					double[] pos = {dateCircles.get(dateWeek).get(dateDOW - 1).getLayoutX(), dateCircles.get(dateWeek).get(Integer.valueOf(dateDOW - 1)).getLayoutY() + 4.0};
					eventBar.setX(pos[0]);
					eventBar.setY(pos[1] + (numEventsPerDate.get(date[0])[1] * this.CAL_EVENT_REC_HEIGHT));
					calendarPane.getChildren().add(0, eventBar);
					curCalEvents.add(eventBar);
					
					numEventsPerDate.get(date[0])[1]++;
				}
			}
		}
	}
	
	private void displayDayPanel()
	{
		resetSidePanelEvents();
		// Get the number of events per date this month:
		ArrayList<Event> curEvents = new ArrayList<Event>();
		for (int i = 0; i < user.getEvents().size(); i++)
		{
			int datesForCurEvent = user.getEvents().get(i).getDates().size();
			for (int dateNum = 0; dateNum < datesForCurEvent; dateNum++)
			{
				String curDate = user.getEvents().get(i).getDates().get(dateNum).split("_")[0];
				String[] yearMonthDay = curDate.split("-");
				if (Integer.valueOf(yearMonthDay[0]) == selectedYear && Integer.valueOf(yearMonthDay[1]) == selectedMonth && Integer.valueOf(yearMonthDay[2]) == selectedDay)
				{
					numEventsPerDate.get(curDate)[0]++;
				}
			}
		}
		
		
	}
}
