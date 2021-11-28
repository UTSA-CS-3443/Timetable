package application;
	
import application.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	public static Stage stage; //This was added for the sceneSwitcher method.
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			stage = primaryStage;
			SplitPane root = new SplitPane();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("view/CalendarScreen.fxml") );
			root = (SplitPane) loader.load();
			Scene scene = new Scene (root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			stage = primaryStage;
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
  
  /**
	public static User user;
  
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			AnchorPane root = new AnchorPane();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("view/TodoList.fxml") );
			root = (AnchorPane)loader.load();
			Scene scene = new Scene (root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	**/
	
	/**
	 * Brian Bissland Added this
	 * The sceneSwitcher method takes in the filename we need to switch to.
	 * Then handles the switching of the scenes.
	 * 
	 * @param switchTo, as a String.
	 *
	 */
  
	public static void sceneSwitcher(String switchTo)
	{
		try 
		{
			Parent root = FXMLLoader.load(Main.class.getResource("view/" + switchTo));
			if(switchTo.equals("CalendarScreen.fxml"))
			{
				stage.setScene(new Scene(root, 800, 500));
			}
			else
			{
				stage.setScene(new Scene(root, 800, 800));
			}
			
			stage.show();

		} catch(Exception e) 
			{
				e.printStackTrace();
			}
	}
}
