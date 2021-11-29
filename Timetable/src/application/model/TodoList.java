package application.model;


//import java.io.Serializable;  COMMENTED BY BRIAN
import java.util.ArrayList;


public class TodoList{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -2157984073652890059L;     COMMENTED BY BRIAN
	private ArrayList<Todo> tasks;
	private int taskID; //taskID is used as an internal variable for indexing tasks.
	
	/**
	 * Class constructor creating new ArrayList to hold Todos.
	 */
	
	public TodoList() {
		this.tasks = new ArrayList<Todo>();
	}
	
	/**
	 * @param desc, a String that describes what needs to be done.
	 * Creates the new Todo using the constructor and adds it to the end of the tasks ArrayList.
	 */
	public void addTodo(String desc) {
		tasks.add(new Todo(desc));
	}
	
	/**
	 * @param id, an int representing the Todo to be deleted.
	 * Searches the tasks Arraylist for the todo that needs to be removed and removes it.
	 */
	public void removeTodo(int id) {
		tasks.remove(id);
	}
	
	/**
	 * @param id, an int representing the Todo to be updated.
	 * @param desc, a String that describes what needs to be done.
	 * Searches the tasks Arraylist for the todo that needs to be updated and updates it using the Todo's setDesc method.
	 */
	public void updateTodo(int id, String desc) {
		tasks.get(id).setDesc(desc);
	}
	
	public Todo getTodo(int id) {
		return tasks.get(id);
	}

	/**
	 * @return tasks, an ArrayList of Todos.
	 */
	public ArrayList<Todo> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks, an ArrayList of Todos to set as the tasks ArrayList.
	 */
	public void setTasks(ArrayList<Todo> tasks) {
		this.tasks = tasks;
	}

	/**
	 * @return taskID, the taskID as an integer.
	 */
	public int getCurId() {
		return taskID;
	}

	/**
	 * @param taskID, int to set as the taskID.
	 */
	public void setCurId(int curId) {
		this.taskID = curId;
	}
	
	public int getListSize() {
		return tasks.size();
	}

}
