package application.model;

//import java.io.Serializable;   COMMENTED BY BRIAN

public class Todo{   // deleted implements serializable statement    COMMENTED BY BRIAN
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 176106504250255994L;   COMMENTED BY BRIAN
	private String desc;
	private boolean isDone;
	
	/**
	 * Class constructor adding description and setting isDone to false.
	 */
	public Todo(String desc) {
		this.desc = desc;
		isDone = false;
	}
	
	/**
	 * Class constructor adding description and setting isDone to false.
	 */
	public Todo(String desc, boolean isDone) {
		this.desc = desc;
		this.isDone = isDone;
	}
	
	/**
	 * Checks the Todo off as done by setting isDone to true.
	 */
	public void complete() {
		isDone = true;
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
	 * @return the boolean representing if the Todo is done or not.
	 */
	public boolean isDone() {
		return isDone;
	}

	/**
	 * @param isDone, the boolean representing if the Todo is done or not.
	 */
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
