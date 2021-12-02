package application.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import application.Main;
import javafx.scene.paint.Color;

/**
 * The type User.
 */
public class User extends Calendar{ 
    /**
	 * 
	 */
	private String name;
    private Settings settings;
    private TodoList todo;

    /**
     * Instantiates a new User.
     */
    public User() {
        super();
        this.settings = new Settings();
        this.todo = new TodoList();
    }
    
    public void saveUser()
    {
    	//---------------------------------------------------------------------------------------------
    	//TodoList Related-----------------------------------------------------------------------------
    	//---------------------------------------------------------------------------------------------
    	try {
		      File todoListObject = new File("TodoList.txt");
		      if (todoListObject.createNewFile()) {
		        System.out.println("TodoList File created: " + todoListObject.getName());
		      } else {
		        System.out.println("TodoList File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred while attempting to create the TodoList file.");
		      e.printStackTrace();
		    }
		
		try {
		      FileWriter todoWriter = new FileWriter("TodoList.txt");
		    //Saving data part
		      for(Todo task: todo.getTasks())
		      {
		    	  todoWriter.write(task.getDesc() + "\n");
		      } 
		    //End of saving data part
		      todoWriter.close();
		      System.out.println("Successfully wrote to TodoList the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred while attempting to write to the TodoList file.");
		      e.printStackTrace();
		    }
		
		
		//---------------------------------------------------------------------------------------------
		//Settings Related-----------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------
    	try {
		      File settingsObject = new File("Settings.txt");
		      if (settingsObject.createNewFile()) {
		        System.out.println("Settings File created: " + settingsObject.getName());
		      } else {
		        System.out.println("Settings File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred while attempting to create the Settings file.");
		      e.printStackTrace();
		    }
		
		try {
		      FileWriter settingsWriter = new FileWriter("Settings.txt");
		    //Saving data part
		      settingsWriter.write(settings.getDesktopNotifi() + "," + settings.getIsMuted() + "," + settings.getAlarmSound() + "\n");
		    //End of saving data part
		      settingsWriter.close();
		      System.out.println("Successfully wrote to the Settings file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred while attempting to write to the Settings file.");
		      e.printStackTrace();
		    }
		
		
		//---------------------------------------------------------------------------------------------
		//Events Related-----------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------
    	try {
		      File eventsObject = new File("Events.txt");
		      if (eventsObject.createNewFile()) {
		        System.out.println("Events File created: " + eventsObject.getName());
		      } else {
		        System.out.println("Events File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred while attempting to create the Events file.");
		      e.printStackTrace();
		    }
    	
		
		try {
		      FileWriter eventsWriter = new FileWriter("Events.txt");

		      String dateConcat = "";
		      for(Event event: this.getEvents())
		      {
		    	  for(String date: event.getDates())
		    	  {
		    		  dateConcat += date + "-->";
		    	  }
		    	  eventsWriter.write(event.getColor() + "," + event.getTimeToRemind() + "," + event.getIsPriority() + "," + event.getDesc() + "," + event.getIsCompleted() + "," + event.getIsMissed() + "," + dateConcat + "\n");
		    	  dateConcat = "";
		      }
	      
		      eventsWriter.close();
		      System.out.println("Successfully wrote to the Events file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred while attempting to write to the Events file.");
		      e.printStackTrace();
		    }
		//---------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------
		//---------------------------------------------------------------------------------------------
    }
    
    public void loadUser()
    {
    	
    	//---------------------------------------------------------------------------------------------
    	//TodoList Related-----------------------------------------------------------------------------
    	//---------------------------------------------------------------------------------------------
    	if(new File("TodoList.txt").exists())
    	{    	
    	try {
		      File myObj = new File("TodoList.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      ArrayList<Todo> tempTodoList = new ArrayList<Todo>();
		      
		      while (myReader.hasNextLine()) {
		        Todo task = new Todo(myReader.nextLine());
		        tempTodoList.add(task);

		      }
		      todo.setTasks(tempTodoList);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("TodoList File Not Found while trying to load it.");
		    }
    	}
    	
    	
    	//---------------------------------------------------------------------------------------------
    	//Settings Related-----------------------------------------------------------------------------
    	//---------------------------------------------------------------------------------------------
    	try {
		      File myObj = new File("Settings.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String settingsData = myReader.nextLine();
		        String[] splitSettingsData = settingsData.split(",");
		        
		        boolean desktopNot = (splitSettingsData[0].equals("true")) ? true:false;
		        boolean muted = (splitSettingsData[1].equals("true")) ? true:false;
		        if (splitSettingsData.length == 3) // If there is an alarm sound saved
	        	{
		        	String alarmSound = splitSettingsData[2];
		        	settings.setAlarmSound(alarmSound);
	        	}
		        settings.setDesktopNotifi(desktopNot);
		        settings.setIsMuted(muted);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Settings File Not Found while trying to load it.");
		    }
    	
    	
    	//---------------------------------------------------------------------------------------------
    	//Events Related-------------------------------------------------------------------------------
    	//---------------------------------------------------------------------------------------------
    	try {
		      File myObj = new File("Events.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      ArrayList<Event> events = new ArrayList<Event>();
		      
		      while (myReader.hasNextLine()) {
		        String eventData = myReader.nextLine();
		        String[] eventDataTokens = eventData.split(",");
		        
		        //Tokens: 0 = Color, 1 = timeToRemind, 2 = priority, 3 = description, 4 = completed, 5 = missed, 6 = dates
		        
		        Color tempColor = Color.web(eventDataTokens[0]);                //Token 0
		        int tempRemindTime = Integer.valueOf(eventDataTokens[1]);       //Token 1
		        boolean tempPriority = Boolean.valueOf(eventDataTokens[2]);     //Token 2
		        String tempDesc = eventDataTokens[3];                           //Token 3
		        boolean tempCompleted = Boolean.valueOf(eventDataTokens[4]);    //Token 4
		        boolean tempMissed = Boolean.valueOf(eventDataTokens[5]);       //Token 5

		        String dates = eventDataTokens[6];                              //Token 6
		        String[] splitDates = dates.split("-->");
		        ArrayList<String> eventDates = new ArrayList<String>();
		        for(String date: splitDates)
		        {
		        	eventDates.add(date);
		        }
	        		
		        Event tempEvent = new Event(tempColor, tempRemindTime, tempPriority, tempDesc, tempCompleted, tempMissed, eventDates);
		        events.add(tempEvent);
		      }
		      Main.user.setEvents(events);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Events File Not Found while trying to load it.");
		      
		    }
    	//---------------------------------------------------------------------------------------------
    	//---------------------------------------------------------------------------------------------
    	//---------------------------------------------------------------------------------------------
    }
   

    /**
     * Add todo.
     *
     * @param desc the desc
     */
    public void addTodo(String desc) {
        todo.addTodo(desc);
    }

    /**
     * Remove todo.
     *
     * @param id the id
     */
    public void removeTodo(int id) {
        todo.removeTodo(id);
    }

    /**
     * Update todo.
     *
     * @param id   the id
     * @param desc the desc
     */
    public void updateTodo(int id, String desc) {
        todo.updateTodo(id, desc);
    }

    /**
     * Update settings.
     *
     * @param option the option
     * @param value  the value
     */
    public void updateSettings(String option, String value) {
        switch (option) {
            case "alarm":
                //this.settings.setAlarmSound(value);
                break;
            case "desktop":
                this.settings.setDesktopNotifi(Boolean.valueOf(value));
                break;
            case "muted":
                this.settings.setIsMuted(Boolean.valueOf(value));
                break;
            case "interval":
                //this.settings.setPriorityInterval(Integer.valueOf(value));
                break;
        }
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets settings.
     *
     * @return the settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * Sets settings.
     *
     * @param settings the settings to set
     */
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    /**
     * Gets todo.
     *
     * @return the todo
     */
    public TodoList getTodo() {
        return todo;
    }

    /**
     * Sets todo.
     *
     * @param todo the todo to set
     */
    public void setTodo(TodoList todo) {
        this.todo = todo;
    }
}
