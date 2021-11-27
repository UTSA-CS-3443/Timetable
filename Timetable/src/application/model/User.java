package application.model;

public class User 
{
	private String name;
	private Settings settings;
	private TodoList todo;
	
	public User(String name)
	{
		this.name = name;
		this.settings = new Settings();
		this.todo = new TodoList();
	}
	
	public void addTodo(String desc)
	{
		todo.addTodo(desc);
	}
	
	public void removeTodo(int id)
	{
		todo.removeTodo(id);
	}
	
	public void updateTodo(int id, String desc)
	{
		todo.updateTodo(id, desc);
	}
	
	public void updateSettings(String option, String value)
	{
		switch (option)
		{
			case "start":
				this.settings.setIsStartUp(Boolean.valueOf(value));
				break;
			case "alarm":
				this.settings.setAlarmSound(value);
				break;
			case "desktop":
				this.settings.setDesktopNotifi(Boolean.valueOf(value));
				break;
			case "muted":
				this.settings.setIsMuted(Boolean.valueOf(value));
				break;
			case "interval":
				this.settings.setPriorityInterval(Integer.valueOf(value));
				break;
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the settings
	 */
	public Settings getSettings() {
		return settings;
	}

	/**
	 * @param settings the settings to set
	 */
	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	/**
	 * @return the todo
	 */
	public TodoList getTodo() {
		return todo;
	}

	/**
	 * @param todo the todo to set
	 */
	public void setTodo(TodoList todo) {
		this.todo = todo;
	}
}
