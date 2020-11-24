package data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import application.Main;

public class TimelineEvent {

	private String title, description, location, date;
	private List<File> files;
	
	public TimelineEvent(String eventTitle, String eventLocation, String eventDate, String eventDescription) {
		title = eventTitle;
		description = eventDescription;
		date = eventDate;
		location = eventLocation;
	}
	
	public TimelineEvent(String eventTitle, String eventLocation, String eventDate, String eventDescription, List<File> eventfiles) {
		title = eventTitle;
		description = eventDescription;
		date = eventDate;
		location = eventLocation;
		setFiles(eventfiles);
	}
	
	
	//creates file list from list of filenames
	private void initFiles(List<String> filenames) {
		ArrayList<File> newfiles = new ArrayList<File>();
		for(int i = 0; i < filenames.size(); i++) {
			File temp = new File(Main.PROJECT_PATH + "\\Pictures\\" + filenames.get(i));
			newfiles.add(temp);
		}
		files = newfiles;
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
	
	public String getPrettyDate() {
		String dateString;
		String oldDate = this.getDate();
		String year = oldDate.substring(0,4);
		String day = oldDate.substring(8);
		String month;
        switch (oldDate.substring(5,7)) {
            case "01":  month = "January";
                     break;
            case "02":  month = "February";
                     break;
            case "03":  month = "March";
                     break;
            case "04":  month = "April";
                     break;
            case "05":  month = "May";
                     break;
            case "06":  month = "June";
                     break;
            case "07":  month = "July";
                     break;
            case "08":  month = "August";
                     break;
            case "09":  month = "September";
                     break;
            case "10": month = "October";
                     break;
            case "11": month = "November";
                     break;
            case "12": month = "December";
                     break;
            default: month = "Invalid month";
                     break;
        }
        dateString = month + " " + day + ", " + year;
		
		return dateString;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	public boolean hasPictures() {
		if(files.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
}