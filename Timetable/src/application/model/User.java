package application.model;

import java.io.*;

/**
 * The type User.
 */
public class User extends Calendar implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3284827858548718129L;
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

    /**
     * Gets serialize user.
     *
     * @return the serialize user
     */
    public static Object getSerializeUser() {
    	File fileOut = new File("User.txt");
    	if (fileOut.exists()) 
    	{
    		try 
        	{
    	        FileInputStream fileInputStream = new FileInputStream("User.txt");
    	        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    	        Object obj = objectInputStream.readObject();
    	        objectInputStream.close();
    	        return obj;
        	}
        	catch (Exception e)
        	{
    	       e.printStackTrace();
        	}
    	}
    	else
    	{
	    	try 
	    	{
	    		FileOutputStream fileOutputStream;
				fileOutputStream = new FileOutputStream(fileOut);
				fileOutputStream.close();
				return (Object) new User();
	    	}
	    	catch (Exception e)
	    	{
		        e.printStackTrace();
	    	}
    	}
    	return null;
    }

    /**
     * Sets serialize user.
     *
     * @param object the object
     */
    public static void setSerializeUser(Object object) {
    	try 
    	{
	        File fileOut = new File("User.txt");
	        FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        objectOutputStream.writeObject(object);
	        fileOutputStream.close();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
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
