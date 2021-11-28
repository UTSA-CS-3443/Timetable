package application.controller;

import application.Main;
import application.model.Event;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;


public class CalendarScreenController implements EventHandler<ActionEvent>
{
	private final double CAL_EVENT_REC_HEIGHT = 6.0;
	private final double TIME_LABEL_START_X = 0.0;
	private final double TIME_LABEL_START_Y = 45.0;
	private final double TIME_DESC_GAP = 5.0;
	private final double DESC_GAP = 30.0;
	
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
	@FXML
	private Rectangle sidePanelTop;
	
	private String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private int[] monthDayNums = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private ArrayList<ArrayList<Label>> dateLabels;
	private ArrayList<ArrayList<Circle>> dateCircles;
	private ArrayList<Rectangle> curCalEvents;
	private ArrayList<Label> curPanelEvents;
	private int selectedDay;     // NOTE: Base 1
	private int firstDayOfMonth; // NOTE: Base 1
	private int selectedMonth;   // NOTE: Base 1
	private int selectedYear;
	private User user;
	
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
		resetCalDates();
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
		curPanelEvents = new ArrayList<Label>();
		displayDayPanelEvents();
	}
	
	public void handle(ActionEvent arg0) // Unused
	{
	}
	
	public void handleSettings(MouseEvent event)
	{
		Main.sceneSwitcher("Settings.fxml");
	}
	
	public void handleTodo(MouseEvent event)
	{
		Main.sceneSwitcher("TodoList.fxml");
	}
	
	public void handleAdd(MouseEvent event)
	{
		Main.sceneSwitcher("AddEvent.fxml");
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
		selectedDay = 1;
		dateCircles.get(0).get(firstDayOfMonth - 1).setStrokeWidth(2);
		dateCircles.get(0).get(firstDayOfMonth - 1).setStroke(Color.RED);
		displayCalEvents();
		displayDayPanelEvents();
	}
	
	public void handleDateSelection(MouseEvent event)
	{
		
		int row = -1;
		int column = -1;
		for (int i = 0; i < dateCircles.size(); i++) // Check to see if the object calling this is a circle and get pos:
		{
			if (column != -1)
			{
				break;
			}
			for (int j = 0; j < dateCircles.get(i).size(); j++)
			{
				if (dateCircles.get(i).get(j).equals(event.getSource()))
				{
					column = j;
				}
			}
			row++;
		}
		if (column == -1)
		{
			row = -1;
			for (int i = 0; i < dateLabels.size(); i++) // Check to see if the object calling this is a label and get pos:
			{
				if (column != -1)
				{
					break;
				}
				for (int j = 0; j < dateLabels.get(i).size(); j++)
				{
					if (dateLabels.get(i).get(j).equals(event.getSource()))
					{
						column = j;
					}
				}
				row++;
			}
		}
		
		String newSelectedDay = dateLabels.get(row).get(column).getText();
		if (newSelectedDay != "") // If this is a valid date,
		{
			// Revert currently selected date:
			int selectedColPos = (this.firstDayOfMonth + ((selectedDay % 7) - 1)) % 7;
			if (selectedColPos == 0)
			{
				selectedColPos = 7;
			}
			dateCircles.get(((selectedDay + (this.firstDayOfMonth - 2)) / 7)).get(selectedColPos - 1).setStrokeWidth(0);
			
			selectedDay = Integer.valueOf(newSelectedDay);
			dateCircles.get(row).get(column).setStrokeWidth(2);
			dateCircles.get(row).get(column).setStroke(Color.RED);
			displayDayPanelEvents();
		}
	}
	
	private void resetCalDates()
	{
		for (int i = 0; i < dateLabels.size(); i++)
		{
			for (int j = 0; j < dateLabels.get(i).size(); j++)
			{
				dateLabels.get(i).get(j).setText("");
				dateCircles.get(i).get(j).setStrokeWidth(0);
			}
		}
		// Select selected day:
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
		for (int i = 0; i < sidePanel.getChildren().size(); i++)
		{
			for (int j = 0; j < this.curPanelEvents.size(); j++)
			{
				if (sidePanel.getChildren().get(i).equals(this.curPanelEvents.get(j)))
				{
					sidePanel.getChildren().remove(i--);
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
		resetCalDates();
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
					
					double[] pos = {dateCircles.get(dateWeek).get(dateDOW - 1).getLayoutX(), dateCircles.get(dateWeek).get(dateDOW - 1).getLayoutY() + 4.0};
					eventBar.setX(pos[0]);
					eventBar.setY(pos[1] + (numEventsPerDate.get(date[0])[1] * this.CAL_EVENT_REC_HEIGHT));
					calendarPane.getChildren().add(0, eventBar);
					curCalEvents.add(eventBar);
					
					numEventsPerDate.get(date[0])[1]++;
				}
			}
		}
	}
	
	private void displayDayPanelEvents()
	{
		resetSidePanelEvents();
		// Get the events that occur on selectedDay:
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
					curEvents.add(user.getEvents().get(i));
				}
			}
		}
		
		// Create Labels and place them in the side Panel:
		double curPosition = TIME_LABEL_START_Y;
		for (int i = 0; i < curEvents.size(); i++)
		{
			// Get the description label correctly formatted:
			Label curEventDesc = new Label();
			curEventDesc.setText(curEvents.get(i).getDesc());
			curEventDesc.setFont(new Font("Arial", 10));
			curEventDesc.setTextFill(curEvents.get(i).getColor());
			
			// Get time label correctly formatted:
			Label curEventTime = new Label();
			String time = curEvents.get(i).getDates().get(0).split("_")[1];
			String hour;
			if (Integer.valueOf(time.split(":")[0]) % 12 == 1) // If it's PM,
			{
				if (Integer.valueOf(time.split(":")[0]) > 12)
				{
					hour = String.valueOf(Integer.valueOf(time.split(":")[0]) % 12);
				}
				else
				{
					hour = time.split(":")[0];
				}
				curEventTime.setText(hour + curEvents.get(i).getDates().get(0).split("_")[1].split(":")[1] + "PM");				
			}
			else
			{
				curEventTime.setText(curEvents.get(i).getDates().get(0).split("_")[1] + "AM");		
			}
			curEventTime.setFont(new Font("Arial", 10));
			curEventTime.setTextFill(curEvents.get(i).getColor());
			
			// Position labels:
			curEventTime.setLayoutX(TIME_LABEL_START_X);
			curEventTime.setLayoutY(curPosition);
			
			Text theText = new Text(curEventTime.getText());
			theText.setFont(curEventTime.getFont());
			double width = theText.getBoundsInLocal().getWidth();
			curEventDesc.setLayoutX(TIME_LABEL_START_X + width + TIME_DESC_GAP);
			curEventDesc.setLayoutY(curPosition);
			
			sidePanel.getChildren().add(curEventTime);
			sidePanel.getChildren().add(curEventDesc);
			
			curPanelEvents.add(curEventTime);
			curPanelEvents.add(curEventDesc);
			
			curPosition += curEventDesc.getHeight() + DESC_GAP;
		}
	}

}
