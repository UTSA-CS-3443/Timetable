package application.controller;

import application.Main;
import application.model.Todo;
import application.model.TodoList;
import application.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	
	private User user;
	
	@FXML
	public void initialize() {
		user = (User) User.getSerializeUser();
		gridPane = new GridPane();		
		updateTodo(user.getTodo());
	}
	
	@FXML
	public void addTodoFromButton(MouseEvent e) {
		user.addTodo(addText.getText());
		updateTodo(user.getTodo());
		addText.clear();
	}
	
	public void addTodoFromList(int index, Todo todo) {
		Label label = new Label(todo.getDesc());
		CheckBox checkBox = new CheckBox();
		gridPane.addRow(index, label, checkBox);
	}
	
	public void removeTodo(int index) {
		
	}
	
	public void updateTodo(TodoList tasks) {
		gridPane.getChildren().clear();
		for (int i = 0; i < tasks.getListSize(); i++) {
			addTodoFromList(i, tasks.getTodo(i));
		}
		scrollPane.setContent(gridPane);
	}
}
