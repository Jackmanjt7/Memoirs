package data;

import java.io.File;
import java.util.ArrayList;

public class TimelineEvent {

	private String title, description, location, date;
	private ArrayList<File> files;
	
	public TimelineEvent(String eventTitle, String eventLocation, String eventDate, String eventDescription) {
		title = eventTitle;
		description = eventDescription;
		date = eventDate;
		location = eventLocation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}