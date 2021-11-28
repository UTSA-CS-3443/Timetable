package application;
	
import application.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;


public class Main extends Application 
{
	public static User user;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			SplitPane root = new SplitPane();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("view/CalendarScreen.fxml") );
			root = (SplitPane) loader.load();
			Scene scene = new Scene (root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
