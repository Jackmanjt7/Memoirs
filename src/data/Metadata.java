package data;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Metadata {

	//global static list for events (for runtime)
	public static ArrayList<TimelineEvent> EVENT_LIST = new ArrayList<TimelineEvent>();
	
	public static TimelineEvent getEvent(String eventTitle) {
		TimelineEvent temp;
		for(int i = 0; i < EVENT_LIST.size(); i++) {
			temp = EVENT_LIST.get(i);
			if(temp.getTitle().equals(eventTitle)) {
				return temp;
			}
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Personal Information");
		alert.setHeaderText("Personal Information");
		alert.setContentText(PersonalInfo.allInfoToString());
		alert.showAndWait();
		return null;
	}
	
	
}
