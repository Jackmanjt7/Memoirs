package application;

import java.io.File;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import data.JsonWriter;
import data.TimelineEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddEventController {

	@FXML TextField EventTitleTextField;
	@FXML TextField EventLocationTextField;
	@FXML DatePicker EventDatePicker;
	@FXML TextArea EventDescriptionTextArea;
	@FXML ListView<File> FileList;
	@FXML Pane AddEventPane;
	
	@FXML
	private void createEvent() throws IOException, ParseException {
		//instantiate TimelineEvent Class
		TimelineEvent newEvent = new TimelineEvent(EventTitleTextField.getText(), 
				EventLocationTextField.getText(), 
				EventDatePicker.getValue().toString(), 
				EventDescriptionTextArea.getText());
		
		JsonWriter.writeEvent(newEvent);
		AddEventPane.setVisible(false);
		TimelineHomeController.closeSecondaryStage();
	}
	
	@FXML 
	private void cancel() {
		AddEventPane.setVisible(false);
		TimelineHomeController.closeSecondaryStage();
	}
	
	
	
	
	
}
