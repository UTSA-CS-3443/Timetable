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
	private Button addTodo = new Button();
	@FXML
	private TextField addText = new TextField();
	
	@FXML
	public void initialize() {
		Main.user.loadUser();
		gridPane = new GridPane();		
		updateTodo(Main.user.getTodo());
	}
	
	@FXML
	public void addTodoFromButton(MouseEvent e) {
		Main.user.addTodo(addText.getText() + "	");
		updateTodo(Main.user.getTodo());
		addText.clear();
		Main.user.saveUser();
	}
	
	@FXML
	public void goBack(MouseEvent e) {
		Main.sceneSwitcher("CalendarScreen.fxml");
	}
	
	public void addTodoFromList(int index, Todo todo) {
		Label label = new Label(todo.getDesc() + "	");
		Button button = new Button("Mark As Done!");
		button.setId(String.valueOf(index));
		
		//Add the event handle to each new button created so that when they are clicked they will call the removeTodo function
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				removeTodo(e);
			}
		});
		
		//Finally add the new row to the gridpane
		gridPane.addRow(index, label, button);
	}
	
	public void removeTodo(MouseEvent e) {
		Button button = (Button)e.getSource();
		Main.user.removeTodo(Integer.parseInt(button.getId()));
		updateTodo(Main.user.getTodo());
		
		//Save the user's new information
		Main.user.saveUser();
	}
	
	public void updateTodo(TodoList tasks) {
		gridPane.getChildren().clear();
		for (int i = 0; i < tasks.getListSize(); i++) {
			addTodoFromList(i, tasks.getTodo(i));
		}
		scrollPane.setContent(gridPane);
	}
}
