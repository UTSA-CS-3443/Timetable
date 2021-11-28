package application.controller;

import java.util.ArrayList;

import application.model.Todo;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TodoListController {
	
	@FXML
	private TabPane tabPane;
	
	private ArrayList<Tab> tabs;
	
	public void addTab(Todo todo) {
		Tab tab = new Tab();
		
	}
	
}
