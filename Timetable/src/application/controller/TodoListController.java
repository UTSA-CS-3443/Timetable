package application.controller;

import application.Main;
import application.model.Todo;
import application.model.TodoList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class TodoListController{
	
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private GridPane gridPane;
	@FXML
	private Button addTodo;
	@FXML
	private TextField addText;
	
	/**
	 * Initializer that loads the user, creates the gridpane and then calls the updateTodo function to fill the gridpane.
	 */
	@FXML
	public void initialize() {
		Main.user.loadUser();
		gridPane = new GridPane();		
		addTodo = new Button();
		addText = new TextField();
		updateTodo(Main.user.getTodo());
	}
	
	/**
	 * Adds a todo to the users list of todos using the text in the textField as the todo description.
	 * Calls updateTodo to update the todo list.
	 * Resets the text field and save the user.
	 * @param e, a MouseEvent.
	 * 
	 */
	@FXML
	public void addTodoFromButton(MouseEvent e) {
		if (!addText.getText().isEmpty()) {
			Main.user.addTodo(addText.getText());
			updateTodo(Main.user.getTodo());
			addText.clear();
			Main.user.saveUser();
		}
	}
	
	/**
	 * Calls the scenSwitcher method in main to take the view back to the calendar.
	 * @param e, a MouseEvent.
	 */
	@FXML
	public void goBack(MouseEvent e) {
		Main.sceneSwitcher("CalendarScreen.fxml");
	}
	
	/**
	 * Creates a JavaFX element from a todo and assigns it an id to be addressed by and sets the evenhandler.
	 * Adds the button and the text to a row in the gridpane.
	 * @param index, an int representing which todo we are adding.
	 * @param todo, a todo to be added to the list.
	 */
	public void addTodoFromList(int index, Todo todo) {
		Label label = new Label("	" + todo.getDesc());
		Button button = new Button("To Done!");
		button.setId(String.valueOf(index));
		
		//Add the event handle to each new button created so that when they are clicked they will call the removeTodo function
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				removeTodo(e);
			}
		});
		
		//Finally add the new row to the gridpane
		gridPane.addRow(index, button, label);
	}
	
	/**
	 * Extracts the button object from the MouseEvent and then gets the id of that button.
	 * Uses the buttons id to find the correct todo in the users todo list and then removes it.
	 * Calls the updateTodo method to refresh the gridpane and then saves the user data.
	 * @param e, a MouseEvent.
	 */
	public void removeTodo(MouseEvent e) {
		Button button = (Button)e.getSource();
		Main.user.removeTodo(Integer.parseInt(button.getId()));
		updateTodo(Main.user.getTodo());
		
		//Save the user's new information
		Main.user.saveUser();
	}
	
	/**
	 * Clears the gridpane.
	 * Loops through the todolist, calling addTodoFromList on every single todo in the list.
	 * Sets the gridpane as the scrollpane content so that the new todo list will be displayed.
	 * @param tasks, a TodoList
	 */
	public void updateTodo(TodoList todoList) {
		gridPane.getChildren().clear();
		for (int i = 0; i < todoList.getListSize(); i++) {
			addTodoFromList(i, todoList.getTodo(i));
		}
		scrollPane.setContent(gridPane);
	}
}
