package application.model;

import java.util.ArrayList;

public class TodoList{
  
	private ArrayList<Todo> tasks;
	
	/**
	 * Class constructor creating new ArrayList to hold Todos.
	 */
	public TodoList() {
		this.tasks = new ArrayList<Todo>();
	}
	
	/**
	 * Creates the new Todo using the constructor and adds it to the end of the tasks ArrayList.
	 * @param desc, a String that describes what needs to be done.
	 */
	public void addTodo(String desc) {
		tasks.add(new Todo(desc));
	}
	
	/**
	 * Searches the tasks Arraylist for the todo that needs to be removed and removes it.
	 * @param id, an int representing the Todo to be deleted.
	 */
	public void removeTodo(int id) {
		tasks.remove(id);
	}
	
	/**
	 * Searches the tasks Arraylist for the todo that needs to be updated and updates it using the Todo's setDesc method.
	 * @param id, an int representing the Todo to be updated.
	 * @param desc, a String that describes what needs to be done.
	 */
	public void updateTodo(int id, String desc) {
		tasks.get(id).setDesc(desc);
	}
	
	/**
	 * @param id, an int representing the Todo to be grabbed.
	 * @return A Todo.
	 */
	public Todo getTodo(int id) {
		return tasks.get(id);
	}

	/**
	 * @return An ArrayList of Todos.
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
	 * @return size, an int representing the size of the tasks list.
	 */
	public int getListSize() {
		return tasks.size();
	}
}
