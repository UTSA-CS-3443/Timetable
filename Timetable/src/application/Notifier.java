package application;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import application.model.Event;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Notifier implements Runnable
{
	private Thread t;
	private Media media;
    private MediaPlayer mediaPlayer;
	
	@Override
	public void run() 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		LocalDateTime now;  
		String before = "";
		
		// TODO: Remove all missed events (dates), notify user.
		while (!Main.killThread)
		{
			now = LocalDateTime.now();
			if (!before.equals(dtf.format(now).toString())) // If the time has changed by a minute
			{
				Main.user.loadUser();
				// Get latest sound:
				media = new Media(new File("res/Notification/notification_alert.mp3").toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				
				ArrayList<Event> events = Main.user.getEvents();
				String date = "";
				String time = "";
				String[] curTime = dtf.format(now).toString().split(" ");
				for (int i = 0; i < events.size(); i++)
				{
					// Loop through event dates:
					ArrayList<String> curDates = events.get(i).getDates();
					for (int j = 0; j < curDates.size(); j++)
					{
						date = curDates.get(j).split("_")[0];
						time = curDates.get(j).split("_")[1];
						curTime[0] = curTime[0].replace("/", "-");
						// Get current time in minutes:
						int curTimeMinutes = 0;
						curTimeMinutes = Integer.valueOf(curTime[1].split(":")[0]) * 60;
						curTimeMinutes += Integer.valueOf(curTime[1].split(":")[1]);
						int dateTimeMinutes = 0;
						dateTimeMinutes = Integer.valueOf(time.split(":")[0]) * 60;
						dateTimeMinutes += Integer.valueOf(time.split(":")[1]);
						System.out.println("Current time (min): " + curTimeMinutes + " - Date time (min): " + dateTimeMinutes);
						System.out.println("Current date: " + curTime[0] + " - Event date: " + date);
						System.out.println("Current time: " + curTime[1] + " - Event time: " + time);
						System.out.println("Time to remind: " + (dateTimeMinutes - events.get(i).getTimeToRemind()));
						
						if (date.equals(curTime[0]) && time.equals(curTime[1])) // This event happens now:
						{
							makeDesktopNotification("Event Happening Now:\n" + events.get(i).getDesc(), events.get(i).getColor());
							events.get(i).setIsCompleted(true);
							events.get(i).removeDate(curDates.get(j)); // Remove this date from the event.
						}
						else if ((events.get(i).getTimeToRemind() != 0) && date.equals(curTime[0]) && curTimeMinutes == (dateTimeMinutes - events.get(i).getTimeToRemind())) // If event reminder time is now:
						{
							makeDesktopNotification("Event Happening in " + events.get(i).getTimeToRemind() + " minutes:\n" + events.get(i).getDesc(), events.get(i).getColor());
							if (events.get(i).getIsPriority())
							{
								events.get(i).setTimeToRemind(events.get(i).getTimeToRemind() - 5);
							}
						}
					}
					if (events.get(i).getDates().size() == 0) // If there are no more dates in this event, remove event.
					{
						events.remove(i);
					}
				}
				before = dtf.format(now).toString();
				
				Main.user.saveUser();
			}
		}
	}
	
	public void start()
	{
		if (t == null)
		{
			t = new Thread(this);
			t.start();
		}
	}
	
	private void makeDesktopNotification(String message, Color color)
	{
		if (Main.user.getSettings().getDesktopNotifi())
		{
			if (!Main.user.getSettings().getIsMuted())
			{
				mediaPlayer.play();
			}
			Platform.runLater(() -> {
		        Stage owner = new Stage(StageStyle.UTILITY);
		        StackPane root = new StackPane();
		        root.setStyle("-fx-background-color: WHITE");
		        Label mes = new Label();
		        mes.setText(message);
		        mes.setFont(new Font("Arial", 20));
		        mes.setWrapText(true);
		        mes.setTextFill(color);
		        root.getChildren().add(mes);
		        root.setAlignment(Pos.TOP_LEFT);
		        StackPane.setMargin(mes, new Insets(20, 0, 0, 30));
		        Scene scene = new Scene(root, 1, 1);
		        scene.setFill(Color.WHITE);
		        owner.setScene(scene);
		        owner.setWidth(500);
		        owner.setHeight(200);
		        owner.setX(100);
		        owner.setY(0);
		        owner.toFront();
		        owner.show();
			}
			);
		}
	}
}
