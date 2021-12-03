package application.model;

public class Todo{

	private String desc;
	private int index;
	
	/**
	 * Class constructor adding description.
	 */
	public Todo(String desc) {
		this.desc = desc;
	}
	
	/**
	 * @return the description of the Todo as a String.
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc, the description of the Todo.
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * @return the index of the todo as an int.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * @param index, an int representing the index of the todo.
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
