package application.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class AddEventController implements EventHandler<ActionEvent>
{
	//This is the Add Event button
	@FXML
	private Button addEvent;
	@FXML
	private TextArea descOfEvent;
	@FXML
	private ColorPicker eventColor;
	@FXML
	private CheckBox eventPriority;
	@FXML
	private ComboBox<String> startTime;
	@FXML
	private ComboBox<String> remindHours;
	@FXML
	private ComboBox<String> remindMinutes;
	@FXML
	private DatePicker eventStartDate;
	@FXML
	private DatePicker eventEndDate;
	@FXML
	private Label eventDescLabel;
	@FXML
	private Label eventTimeLabel;
	@FXML
	private Label eventStartDateLabel;
	@FXML
	private Label eventEndDateLabel;
	@FXML
	private Label mandatoryFieldLabel;
	
	
	public void initialize()
	{
		remindHours.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"));
		remindMinutes.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"));
		startTime.setItems(FXCollections.observableArrayList("12:00 AM", "12:05 AM", "12:10 AM", "12:15 AM", "12:20 AM", "12:25 AM", "12:30 AM", "12:35 AM", "12:40 AM", "12:45 AM", "12:50 AM", "12:55 AM", "1:00 AM", "1:05 AM", "1:10 AM", "1:15 AM", "1:20 AM", "1:25 AM", "1:30 AM", "1:35 AM", "1:40 AM", "1:45 AM", "1:50 AM", "1:55 AM", "2:00 AM", "2:05 AM", "2:10 AM", "2:15 AM", "2:20 AM", "2:25 AM", "2:30 AM", "2:35 AM", "2:40 AM", "2:45 AM", "2:50 AM", "2:55 AM", "3:00 AM", "3:05 AM", "3:10 AM", "3:15 AM", "3:20 AM", "3:25 AM", "3:30 AM", "3:35 AM", "3:40 AM", "3:45 AM", "3:50 AM", "3:55 AM", "4:00 AM", "4:05 AM", "4:10 AM", "4:15 AM", "4:20 AM", "4:25 AM", "4:30 AM", "4:35 AM", "4:40 AM", "4:45 AM", "4:50 AM", "4:55 AM", "5:00 AM", "5:05 AM", "5:10 AM", "5:15 AM", "5:20 AM", "5:25 AM", "5:30 AM", "5:35 AM", "5:40 AM", "5:45 AM", "5:50 AM", "5:55 AM", "6:00 AM", "6:05 AM", "6:10 AM", "6:15 AM", "6:20 AM", "6:25 AM", "6:30 AM", "6:35 AM", "6:40 AM", "6:45 AM", "6:50 AM", "6:55 AM", "7:00 AM", "7:05 AM", "7:10 AM", "7:15 AM", "7:20 AM", "7:25 AM", "7:30 AM", "7:35 AM", "7:40 AM", "7:45 AM", "7:50 AM", "7:55 AM", "8:00 AM", "8:05 AM", "8:10 AM", "8:15 AM", "8:20 AM", "8:25 AM", "8:30 AM", "8:35 AM", "8:40 AM", "8:45 AM", "8:50 AM", "8:55 AM", "9:00 AM", "9:05 AM", "9:10 AM", "9:15 AM", "9:20 AM", "9:25 AM", "9:30 AM", "9:35 AM", "9:40 AM", "9:45 AM", "9:50 AM", "9:55 AM", "10:00 AM", "10:05 AM", "10:10 AM", "10:15 AM", "10:20 AM", "10:25 AM", "10:30 AM", "10:35 AM", "10:40 AM", "10:45 AM", "10:50 AM", "10:55 AM", "11:00 AM", "11:05 AM", "11:10 AM", "11:15 AM", "11:20 AM", "11:25 AM", "11:30 AM", "11:35 AM", "11:40 AM", "11:45 AM", "11:50 AM", "11:55 AM", "12:00 PM", "12:05 PM", "12:10 PM", "12:15 PM", "12:20 PM", "12:25 PM", "12:30 PM", "12:35 PM", "12:40 PM", "12:45 PM", "12:50 PM", "12:55 PM", "1:00 PM", "1:05 PM", "1:10 PM", "1:15 PM", "1:20 PM", "1:25 PM", "1:30 PM", "1:35 PM", "1:40 PM", "1:45 PM", "1:50 PM", "1:55 PM", "2:00 PM", "2:05 PM", "2:10 PM", "2:15 PM", "2:20 PM", "2:25 PM", "2:30 PM", "2:35 PM", "2:40 PM", "2:45 PM", "2:50 PM", "2:55 PM", "3:00 PM", "3:05 PM", "3:10 PM", "3:15 PM", "3:20 PM", "3:25 PM", "3:30 PM", "3:35 PM", "3:40 PM", "3:45 PM", "3:50 PM", "3:55 PM", "4:00 PM", "4:05 PM", "4:10 PM", "4:15 PM", "4:20 PM", "4:25 PM", "4:30 PM", "4:35 PM", "4:40 PM", "4:45 PM", "4:50 PM", "4:55 PM", "5:00 PM", "5:05 PM", "5:10 PM", "5:15 PM", "5:20 PM", "5:25 PM", "5:30 PM", "5:35 PM", "5:40 PM", "5:45 PM", "5:50 PM", "5:55 PM", "6:00 PM", "6:05 PM", "6:10 PM", "6:15 PM", "6:20 PM", "6:25 PM", "6:30 PM", "6:35 PM", "6:40 PM", "6:45 PM", "6:50 PM", "6:55 PM", "7:00 PM", "7:05 PM", "7:10 PM", "7:15 PM", "7:20 PM", "7:25 PM", "7:30 PM", "7:35 PM", "7:40 PM", "7:45 PM", "7:50 PM", "7:55 PM", "8:00 PM", "8:05 PM", "8:10 PM", "8:15 PM", "8:20 PM", "8:25 PM", "8:30 PM", "8:35 PM", "8:40 PM", "8:45 PM", "8:50 PM", "8:55 PM", "9:00 PM", "9:05 PM", "9:10 PM", "9:15 PM", "9:20 PM", "9:25 PM", "9:30 PM", "9:35 PM", "9:40 PM", "9:45 PM", "9:50 PM", "9:55 PM", "10:00 PM", "10:05 PM", "10:10 PM", "10:15 PM", "10:20 PM", "10:25 PM", "10:30 PM", "10:35 PM", "10:40 PM", "10:45 PM", "10:50 PM", "10:55 PM", "11:00 PM", "11:05 PM", "11:10 PM", "11:15 PM", "11:20 PM", "11:25 PM", "11:30 PM", "11:35 PM", "11:40 PM", "11:45 PM", "11:50 PM", "11:55 PM"));
	}
	
	public void handle(ActionEvent arg0) // Unused
	{
	}
	
	public void addEventClicked(MouseEvent event)
	{
		//This section checks all mandatory fields have been filled out. Throws label error if not.
		int mandatoryFields = 0;
		if(eventStartDate.getValue() == null){eventStartDateLabel.setTextFill(Color.RED); mandatoryFields++;}
		else{eventStartDateLabel.setTextFill(Color.BLACK);}
		if(eventEndDate.getValue() == null){eventEndDateLabel.setTextFill(Color.RED); mandatoryFields++;}
		else{eventEndDateLabel.setTextFill(Color.BLACK);}
		if(descOfEvent.getText().equals("")){eventDescLabel.setTextFill(Color.RED); mandatoryFields++;}
		else{eventDescLabel.setTextFill(Color.BLACK);}
		if(startTime.getValue() == null){eventTimeLabel.setTextFill(Color.RED); mandatoryFields++;}
		else{eventTimeLabel.setTextFill(Color.BLACK);}
		
		if(mandatoryFields > 0) {mandatoryFieldLabel.setText("Please fill in all mandatory fields.");	return;}
		
		
		
		//Sets default value of remind before ComboBox's to 0, if not selected.
		if(remindHours.getValue() == null){remindHours.setValue("0");}
		if(remindMinutes.getValue() == null){remindMinutes.setValue("0");}
		
		//Calculates the time to remind before the event starts.
		int timeToRemind = Integer.parseInt(remindHours.getValue()) * 60 + Integer.parseInt(remindMinutes.getValue());
			
		
		//This section calculates the days between the start and end provided, then fills an ArrayList with the appropriate day format.
		//It also throws in the Event Time the user enters.
		ArrayList<String> days = new ArrayList<String>();
		
		LocalDate start = eventStartDate.getValue();
		LocalDate end = eventEndDate.getValue();
		
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
		    totalDates.add(start);
		    start = start.plusDays(1);
		}
		
		for(LocalDate day: totalDates)
		{
			days.add(day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_")) + startTime.getValue());   //Adds in the time to the days.
		}
		
		
		//Passes this forms data into a new event. Then switches the back to the Calendar screen.
		Main.user.addEvent(eventColor.getValue(), timeToRemind, eventPriority.isSelected(), descOfEvent.getText(), days);
		Main.sceneSwitcher("CalendarScreen.fxml");
	}
	
	public void backClicked(MouseEvent event)
	{
		
		
	}

}
