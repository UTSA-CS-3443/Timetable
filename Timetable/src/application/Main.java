package application;
	
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import application.model.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;


public class Main extends Application 
{
	public static Stage stage;
	public static Boolean killThread;
	public static User user;
	
	
	@Override
	/**
	 * Launches the calendar screen.
	 * 
	 * @param primaryStage The main window.
	 */
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
			stage = primaryStage;
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent t) {
			        Platform.exit();
			        System.exit(0);
			    }
			});
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		user = new User();
		
		Main.killThread = false;
		ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(new Notifier());
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() { // Tell the thread to kill itself when program closes.
	        public void run() {
	            killThread = true;
	        }
	    }, "Shutdown-thread")); 
		launch(args);
	}
  
	
	/**
	 * Brian Bissland Added this
	 * The sceneSwitcher method takes in the filename we need to switch to.
	 * Then handles the switching of the scenes.
	 * 
	 * @param switchTo The path to the .fxml file of the screen. Must start with 'view/'.
	 *
	 */
  
	public static void sceneSwitcher(String switchTo)
	{
		try 
		{
			Parent root = FXMLLoader.load(Main.class.getResource("view/" + switchTo));
			if(switchTo.equals("CalendarScreen.fxml") || switchTo.equals("Settings.fxml"))
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
